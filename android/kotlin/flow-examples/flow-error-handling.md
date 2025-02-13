# Flow 에러 처리 예제 설명

## 코드 실행 결과
```
Received 1
Exception from the flow: java.lang.RuntimeException: Error on 2

Using catch operator:
Received 1
Caught exception: java.lang.RuntimeException: Error on 2
Received -1
```

## 주요 포인트
1. `try-catch` 블록 사용
   - Flow 수집 중 발생하는 모든 예외를 잡을 수 있음
   - 예외 발생 시 Flow 수집이 중단됨

2. `catch` 연산자 사용
   - Flow 내부에서 예외 처리 가능
   - 대체 값을 방출하여 Flow를 계속 진행할 수 있음
   - 상위로 예외를 전파하지 않음

3. `delay` 사용
   - Flow의 비동기적 특성을 시연
   - 실제 네트워크 요청이나 DB 작업을 시뮬레이션

## 에러 처리 후 계속 실행하기

1. `catch` 연산자와 `onCompletion` 사용
```
Processing 1
Error occurred: java.lang.RuntimeException: Error on 2
First flow completed
```

2. `retry` 연산자 사용
```
Received 1
Retrying after error: java.lang.RuntimeException: Error on 2
Received 1
Retrying after error: java.lang.RuntimeException: Error on 2
Received 1
Final error: java.lang.RuntimeException: Error on 2
```

## 주요 연산자 설명
- `onEach`: 각 값을 처리할 때 호출
- `catch`: 에러 처리
- `onCompletion`: Flow가 완료될 때 호출 (성공/실패 모두)
- `retry`: 지정된 횟수만큼 재시도
