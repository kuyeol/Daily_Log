



# Sender End Point
선언 개요와 이벤트를 처리 하는 코드

> - 각 인스턴스는 사용자가 코어 도메인을 통해 이벤트를 전송하는 동안 엔드포인트 역할을 한다
> - 시스템 내에서 사용자를 표현하는 유저 객체를 메서드로 전달한다

```JAVA

public class SenderEndPoint 
{

private final User user;

private final Twootr twootr;


SenderEndPoint(final User user, final Twootr twootr) 
{

Objects.requireNonNull(user, "user");

Objects.requireNonNull(twootr, "twootr");

this.user = user;

this.twootr = twootr;

}


public FollowStatus onFollow(final String userIdToFollow) 
{

Objects.requireNonNull(userIdToFollow, "userIdToFollow");

return twootr.onFollow(user, userIdToFollow);

}


}

```


> [!NOTE]
> 만약 위 클래스 인스턴스 사용을 하지 않는다면 
> 사용자 아이디를 모든 이벤트 메서드에 파라미터로 추가해 객체가 아이디를 찾는 작업을 매번 수행해야 한다






# 메세지 도착 알림
- 메서드 내부 트윗 모델을 새로 생성
- 파라미터로 받은 유저 아이디와 컨텐츠를 담아 팔로워중 로그인한 유저를 대상으로 반복해 전달하는 코드
```JAVA
void onSendTwoot(final String id, final User user, final String content)

{

final String userId = user.getId();

final Twoot twoot = new Twoot(id, userId, content);

user.followers()

.filter(User::isLoggedOn)

.forEach(follower -> follower.receiveTwoot(twoot));

}
```


# 메세지 수신 메서드

- 위치를 통해 확인 구간을 생성하고 확인 지점 이후 메세지를 수신한다

```JAVA

public class Position {

/**

* 최근 확인한 트웃의 위치

*/

public static final Position INITIAL_POSITION = new Position(-1);

private final int value;

public Position(final int value) {

this.value = value;

}

public int getValue() {

return value;

}

@Override

public String toString() {

return "Position{" +

"value=" + value +

'}';

}

@Override

public boolean equals(final Object o) {

if (this == o) return true;

if (o == null || getClass() != o.getClass()) return false;

final Position position = (Position) o;

return value == position.value;

}

@Override

public int hashCode() {

return value;

}

public Position next() {

return new Position(value + 1);

}
}

```

- 포지션에 사용 할 좌표를 나타낼 클래스
```JAVA 

class Point {

private final int x;

private final int y;

Point(final int x, final int y) {

this.x = x;

this.y = y;

}

int getX() {

return x;

}

int getY() {

return y;

}


@Override

public boolean equals(final Object o) {

if (this == o) return true;

if (o == null || getClass() != o.getClass()) return false;

final Point point = (Point) o;

if (x != point.x) return false;

return y == point.y;

}

@Override

public int hashCode() {

int result = x;

result = 31 * result + y;

return result;

}

```


# equals() & hashCode()
> [!Caution]
> Object에서 상속 받는 equals , hashcode 는 주소를 비교하여 값이 동일해도  다른 객체로 구별 된다 
```

final Point p1 = new Point(1, 2);

final Point p2 = new Point(1, 2);

System.out.println(p1 == p2); // false 출력

```
---
-  두 메서드는 커플링/컨트랙트 관계
- equals() 메서드의 결과와 hashcode() 메서드의 결과는 같아야 한다
---


`
# 적은 메서드로 쿼리 하기

쿼리 조건을 객체로 감싸서 쿼리를 수행한다

```
대상객체 {
	List<대상객체> 쿼리메서드(쿼리객체 쿼리);
}

```

```
쿼리객체{

// 속성에 사용되는 필드정의
Set<String> 유저; 
위치객체 객체;

//겟 메서드만 정의한다
//파라미터로 전달받은 내용을 반환하는 메서드드


}

```


---
# 쿼리 메서드 사용

> 쿼리 메서드 호출
```
twootRepository.query(

new TwootQuery()

.inUsers(user.getFollowing())

.lastSeenPosition(user.getLastSeenPosition()),

user::receiveTwoot);

```

> 쿼리 메서드
```
void query(TwootQuery twootQuery, Consumer<Twoot> callback);
```

---

# 람다 표현식

- 익명 함수를 람다 표현식으로 줄여서 정의한다.
### ReceiverEndPoint 인터페이스 생성(API)
```

public interface ReceiverEndPoint {

void onTwoot(Twoot twoot);

}
```


> ReceiverEndPoint 인터페이스 구현을 제공하는 새로운 객체를 만든다

## ReceiverEndPoint 구현
```

public class PrintingEndPoint implements ReceiverEndPoint {

@Override

public void onTwoot(final Twoot twoot) {

twoot.getSenderId() + ": " + twoot.getContent();

}

}

```

# 메서드 레퍼런스
- 파라미터로 메서드 호출
> [!NOTE]
> 클래명::동일타입메서드

1. 일반 호출 람다
> twoot -> twoot.getContent()


2. 메서드 퍼퍼런스 표현 방식
> Twoot::getContent

1. 람다 표현식
> (user, twootr) -> new SenderEndPoint(user, twootr)
2. 메서드 레퍼런스 표현식
> SenderEndPoint::new


> [!tip]
> 함수형 인터페이스를 갖춘다면 메서드 레퍼런스는 자동으로 여러 파라미터를 처리한다메서드 레퍼런스 덕분에 함수가 명시적으로 일급의 개념으로 취급된다. 마치 값처럼 동작을 전달하고 처리할 수 있어 두 개 이상의 함수를 조합할 수도 있다