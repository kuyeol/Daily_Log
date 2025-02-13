# ArrayList 초기화와 사용법

## 초기화 방법들

```kotlin
// 1. 빈 ArrayList 생성
var strList1: ArrayList<String> = ArrayList()
var strList2 = ArrayList<String>()
var strList3 = arrayListOf<String>()

// 2. 초기 요소와 함께 생성
var strList4 = ArrayList<String>().apply {
    add("첫 번째")
    add("두 번째")
}

var strList5 = arrayListOf("첫 번째", "두 번째")

// 3. 초기 크기 지정
var strList6 = ArrayList<String>(5)
```

## 기본 사용법

```kotlin
val list = ArrayList<String>()

// 요소 추가
list.add("첫 번째")
list.add("두 번째")

// 특정 위치에 추가
list.add(0, "시작")

// 요소 접근
val firstItem = list[0]

// 요소 수정
list[1] = "수정된 항목"

// 요소 제거
list.removeAt(0)
list.remove("두 번째")

// 크기 확인
val size = list.size

// 리스트가 비었는지 확인
val isEmpty = list.isEmpty()
```

## 유용한 팁
- ArrayList는 크기가 동적으로 조절됩니다
- 초기 크기를 알고 있다면 성능을 위해 초기 크기를 지정하는 것이 좋습니다
- `arrayListOf()`는 불변 리스트를 만들지 않는 편리한 팩토리 함수입니다
