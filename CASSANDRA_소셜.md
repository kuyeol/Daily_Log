# 스키마

## IDEA#1
- 전달은 서버센트메세지로 받는다
- 카산드라에 저장은 시간별로 정렬
- 구독중인 유저에 레코드 수집 + 한번에 가져오는 데이터 제한


## ConcurrentHashMap을 사용하여 데이터 탐색

- 캐시나 빈번한 읽기/쓰기 작업
```JAVA
ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
cache.put("userId123", "userData");
String userData = cache.get("userId123");}
```
ConcurrentLinkedQueue를 사용하여 이벤트 처리
 - FIFO 이벤트 처리 
```JAVA
ConcurrentLinkedQueue<String> eventQueue = new ConcurrentLinkedQueue<>();
eventQueue.offer("신규 사용자 가입 이벤트");
String event = eventQueue.poll();
```



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
  post_제
```sql
CREATE KEYSPACE reservation
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

CREATE TYPE reservation.address (
    street text, city text,
    state_or_province text,
    postal_code text,
    country text
);

CREATE TABLE reservation.reservations_by_confirmation (
    confirm_number text,
    hotel_id text,
    start_date date,
    end_date date,
    room_number smallint,
    guest_id uuid,
    PRIMARY KEY (confirm_number)
) WITH comment = 'Q6. Find reservations by confirmation number';

CREATE TABLE reservation.reservations_by_hotel_date (
    hotel_id text,
    start_date date,
    room_number smallint,
    end_date date,
    confirm_number text,
    guest_id uuid,
    PRIMARY KEY ((hotel_id, start_date), room_number)
) WITH comment = 'Q7. Find reservations by hotel and date';

CREATE TABLE reservation.reservations_by_guest (
    guest_last_name text,
    guest_id uuid,
    confirm_number text,
    hotel_id text,
    start_date date,
    end_date date,
    room_number smallint,
    PRIMARY KEY ((guest_last_name), guest_id, confirm_number)
) WITH comment = 'Q8. Find reservations by guest name';

CREATE TABLE reservation.guests (
    guest_id uuid PRIMARY KEY,
    first_name text,
    last_name text,
    title text,
    emails set<text>,
    phone_numbers list<text>,
    addresses map<text, frozen<address>>
) WITH comment = 'Q9. Find guest by ID';
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






