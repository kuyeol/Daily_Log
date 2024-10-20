# 자바 람다란?

> 람다 표현식은 자바 코드가 한 줄 또는 블록 단위로 이루어져 있으며 
0개 이상의 매개변수를 갖고 값을 반환할 수 있습니다. 
간단히 말해 람다는 다음 예시와 같이 어떠한 객체에도 속하지 않는 
익명 메서드와 비슷합니다

```java
() -> System.out.println("Hello, lambda!")
```




# 람다 문법

자바에서 람다 문법 Lambda syntax은 1장에서 배운 람다 대수 Lambda calculus의 수학적 표기와 매우 유사합니다.
```java

( < parameters > ) -> { < body > }

```
이 문법은 세 가지 부분으로 구성됩니다.

# 1. 매개변수
---

> 람다 문법의 매개변수는 메서드의 인수 argument와 마찬가지로 쉼표 ( , )로 구분합니다. 
그러나 메서드의 인수와는 다르게 컴파일러가 매개변수의 타입을 추론할 수 있는 경우 매개변수의 타입을 생략할 수 있습니다.
묵시적으로 타입이 지정된 매개변수와 명시적으로 타입이 지정된 매개변수를 혼용하는 것은 허용되지 않습니다. 
또한 매개변수가 하나인 경우에는 괄호를 생략할 수 있지만 매개변수가 없거나 둘 이상인 경우에는 괄호를 사용해야 합니다



# 2. 화살표 `->`
---

> -> (화살표 )는 람다의 매개변수와 람다 바디를 구분하기 위해 사용합니다. 이는 람다 대수의 "λ" 와 동일합니다.


# 3. 바디
---

> 람다 바디는 단일 표현식 또는 코드 블록으로 구성됩니다. 한 줄의 코드로만 작성된 표현식은 중괄호를 사용하지 않아도 되며 
계산된 결과는 암시적으로 return문 없이 반환 됩니다. 
하나 이상의 표현식으로 작성되는 경우에는 일반적인 자바 코드 블록을 사용합니다. 
이때 중괄호로 감싸져 있으며 값을 반환할 경우 명시적으로 return 문을 사용 해야 합니다



# 동일한 결과의 여러 작성 방법

> 1. 기본 타입
>>  (String in) -> { return in != null;  }

> 2. 타입 추론 / 명시적 타입 생략
>>  in - > { return in  != null; }

> 3. 명시적 타입 매개변수 사용
> >  (String in) -> in != null
>  
> 4. 단일 표현식
> >  in -> in !=- null


> [!TIP]
> 
> - 타입이 생략되어도 빠르게 타입을 유추할 수 있지만 사람은 컴파일러처럼 최단 코드를 이해하는 데 능숙하지 않습니다
>
> - 개발자는 항상 깔끔하고 더 간결한 코드를 추구해야 합니다. 그렇다고 해서 가장 짧은 코드를 작성해야 한다는 의미는 아닙니다