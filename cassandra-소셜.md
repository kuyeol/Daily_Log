# 스키마

테이블
---
- 포스트
  - 개별 게시물 저장
- 피드
  - 사용자의 게물 집계
- 커넥션
  - 관계 저장


```sql
CREATE  TABLE posts ( 
  post_id UUID PRIMARY KEY, 
  user_id UUID, 
  content TEXT, 
  timestamp  TIMESTAMP
 ); 

CREATE  TABLE feeds ( 
  feed_owner_id UUID, 
  post_id UUID, 
  user_id UUID, 
  content TEXT, 
  timestamp  TIMESTAMP , 
  PRIMARY KEY (feed_owner_id, timestamp , post_id) 
) WITH CLUSTERING ORDER  BY ( timestamp  DESC ); 

CREATE  TABLE connections ( 
  user_id UUID, 
  connected_user_id UUID, 
  connection_type TEXT, 
  timestamp  TIMESTAMP , 
  PRIMARY KEY (user_id, connected_user_id) 
);
```

1. 개별 테이블에 저장 로직 생성


2.커넥션 서비스

- 커넥션 레포 주입
- uuid를 set으로 담아 파라미터로 유저아이디 전달
```java

@Service 
public  class  ConnectionService { 
@Autowired 
  private  ConnectionRepository connectionRepository; 
  public  Set < UUID > getConnectedUserIds ( UUID userId ) { 
    // ... 구현 ...
   } 
  // ... 기타 연결 관련 메서드 ...
 }

```

3. 피드 서비스
- 포스트&피드 레포지토리 / 커넥션 서비스 주입
- 포스트 생성은  유저아이디와 문자열을 전달받음
- 피드 가져오기 피드를 리스트에 담에 반환하고 피드생성유저와 페이지요청을 파라미터로 전달
- 포스트를 팔로워에게 전달하기 포스트 인스턴스와 uuid를 셋으로 담아 팔로워 전달
```java
@Service 
public  class  FeedService { 

@Autowired 
  private  PostRepository postRepository; 
  @Autowired 
  private  FeedRepository feedRepository; 
  @Autowired 
  private  ConnectionService connectionService; 
  public  Post  createPost ( UUID userId, String content ) { 
    // ... 구현 ...
   } 
  public  List < Feed > getFeed ( UUID feedOwnerId, PageRequest pageRequest ) { 
    // ... 구현 ...
   } 
  private  void  propagatePostToFollowers ( Post post, Set <UUID> followerIds ) { 
    // ... 구현 ...
   } 
}
```

4.피드서비스
 Fan-Out on Write
- 새로운 게시물이 생성 시 모든 팔로워의 피드에 전달하는 피드 집계 및 페이지 매김

  피드를 리스트에 담에 uuid 와 페이지요청 파라미터로 전달
  피드레포지토리에서 파라미터로 쿼리 조회

> 단순 집계
```java
public  List < Feed > getFeed ( UUID feedOwnerId, PageRequest pageRequest ) { 
  return feedRepository.findAllByFeedOwnerId (feedOwnerId, pageRequest );
```
> 로직 추가
> - 연결된 사용자의 게시물과 추천 게시물을 포함
```java
public List<Feed> getFeed(UUID feedOwnerId, PageRequest pageRequest) {
  // Get connected users' posts
  Set<UUID> connectedUserIds = connectionService.getConnectedUserIds(feedOwnerId);
  List<Feed> connectedUsersFeed = feedRepository.findAllByFeedOwnerIds(connectedUserIds, pageRequest);
  // Get recommended posts (assuming a method to fetch recommendations)
  List<Feed> recommendedPosts = getRecommendedPosts(feedOwnerId, pageRequest);
  // Combine and sort the posts
  List<Feed> combinedFeed = new ArrayList<>();
  combinedFeed.addAll(connectedUsersFeed);
  combinedFeed.addAll(recommendedPosts);
  combinedFeed.sort(Comparator.comparing(Feed::getTimestamp).reversed());
  // Return the paginated feed
  int start = pageRequest.getOffset();
  int end = Math.min(start + pageRequest.getPageSize(), combinedFeed.size());
  return combinedFeed.subList(start, end);
}
}
```
인터페이스 레포지토리에 쿼리 메서드 정의
- 확장 CassandraRepository<Feed, FeedKey>
- UUID feedOwnerId, Pageable pageable
  
```java
public interface FeedRepository extends CassandraRepository<Feed, FeedKey> {
  List<Feed> findAllByFeedOwnerId(UUID feedOwnerId, Pageable pageable);
}

```






