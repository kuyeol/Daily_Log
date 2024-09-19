함수형 인터페이스

람다 표현식이 자바에서 일급 객체로 취급받기 위해서는 기존의 객체와 비슷한 표현 방식을 갖추어야 합니다
람다 표현식은 특화된 인터페이스의 하위 타입으로 표현됩니다

일반적인 인터페이스

메서드  시그니처
- 메서드(파라미터)
- 기본 메서드 default+메서드시그니처
	- 인터페이스 구현시 재정의 가능하지만 필수는 아님
- static 메서드 
	- 필수 구현 해야함
	- 상속 되지 않음
	- 오버라이딩 불가
- 상수
	- public 
	- static
	- final

함수형 인터페이스의 구성
- SAM 
	- Single
	- Abstract
	- Method
	
한 개의 추상 메서드가 필요하다
- 예시 : boolean test(T t);

단 하나의 추상 메서드를 가진 모든 인터페이스는 자동으로 함수형 인터페이스가 되며, 모두 람다로 표현할 수 있습니다

Final  키워드
final로 정의된 변수는 초기화 후 재할당이 불가

final String str="imuntably";

//가능힌것
String newstr = str;

//불가한것
str = "failed";

참조는 가능하나 할당을 불가


익명 클래스와 람다의 차이
 
 - 익명 클래스는 인스턴스를 생성
 - 람다는 생성 없이 invokedynamic사용해 jvm에 위임
 - 스코프의 차이

람다의 변환 타겟은 인터페이스

람다 정의 
인터페이스 변수명 = 파라미터명 -> 파라미터 표현식;


람다 호출
정의한 람다 변수를 호출할 수 있다

변수명.메서드();





# 메서드 참조 ( `::` ) 

4가지 방법

- 정적 메서드 참조
	-  클래스명 :: 정적메서드
	- `Function<Integer, String> asRef = Integer::toHexString;`

- 바운드 비정적 메서드 참조
	- `var now = LocalDate.now();` 객체 생성
	- `Predicate<LocalDate> isAfterNowAsRef = now::isAfter;` 참조
 
- 언바운드 비정적 메서드 참조
	- 클래스::캐스트
	- this::메서드
	- 서브클래스.super::메서드
	- 다른 메서드 호출 또는 필드 접근의 반환값을 직접` :: ` 연산자와 함께 결합할 수 있어서 중간 변수조차 필요하지 않습니다
	-  반환값 바인딩 `Predicate<LocalDate> isAfterNowAsRef = LocalDate.now()::isAfter;`
	- 정적 필드 바인딩 `Function<Object, String> castToStr = String.class::cast;`
	- 특정 객체에 바운딩되지 않습니다
	- 타입의 인스턴스 메서드를 참조합니다
	- `public class String implements ... {  public String toLowerCase() {  } } ` 참조 클래스와 메서드
	- `Function<String, String> toLowerCaseRef = String::toLowerCase;` 스트링클래스에 메서드를 참조

- 생성자 참조
	- 클래스명::new
	- `Function<String, Locale> newLocaleRef = Locale::new`
	- 메서드는 실제 메서드가 아닌 new 키워드를 통해 생성자를 참조합니다
	