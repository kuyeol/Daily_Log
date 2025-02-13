# Flow에서 단일 아이템 소비하기

## 첫 번째 아이템만 소비하기

```kotlin
// first()를 사용하여 첫 번째 아이템 가져오기
suspend fun <T> Flow<T>.consumeFirst(): T {
    return first()
}

// 사용 예시
val flow = flowOf(1, 2, 3)
val firstItem = flow.consumeFirst() // 1
```

## 마지막 아이템 소비하기

```kotlin
// last()를 사용하여 마지막 아이템 가져오기
suspend fun <T> Flow<T>.consumeLast(): T {
    return last()
}

// 사용 예시
val flow = flowOf(1, 2, 3)
val lastItem = flow.consumeLast() // 3
```

## 단일 아이템 Flow 소비하기

```kotlin
// single()을 사용하여 단일 아이템 가져오기
suspend fun <T> Flow<T>.consumeSingle(): T {
    return single()
}

// 사용 예시
val flow = flowOf(1)
val item = flow.consumeSingle() // 1
// 주의: 여러 아이템이 있으면 예외 발생
```

## 주의사항

- 위 메서드들은 모두 suspend 함수입니다.
- Flow가 비어있으면 NoSuchElementException이 발생합니다.
- single()은 Flow에 둘 이상의 요소가 있으면 IllegalArgumentException이 발생합니다.
- 이러한 연산들은 Flow를 완전히 소비합니다.
