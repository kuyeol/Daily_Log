
구현: 동기 대 비동기

이와 같은 요청 및 응답 호출은 동기식 블로킹 방식이나 비동기식 논블로킹 방식으로 구현할 수 있다. 
동기식 호출을 사용하면 일반적으로 다운스트림 마이크로서비스와 네트워크 커넥션이 생성되며 이 커넥션을 따라 전송된다. 
업스트림 마이크로서비스가 응답할 때까지 대기하는 동안 커넥션은 열린 상태로 유지된다. 
이 경우 응답하는 마이크로서비스는 요청하는 마이크로서비스에 대해 전혀 알 필요가 없다.
단지 인바운드 커넥션을 통해 다시 돌려보내는 것뿐이다. 따라서 업스트림 또는 다운스트림 마이크로서비스 인스턴스가 종료돼 해당 커넥션이 끊어지면 문제가 발생할 수 있다. 비동기식 요청 및 응답 방식을 사용하면 덜 간단하다. 재고 예약과 관련된 프로세스를 다시 살펴보자. [그림 4-10]에서 재고 예약 요청은 일종의 메시지 브로커를 통해 메시지로 전송된다 (이 장의 뒷부분에서 메시지 브로커를 설명한다 ).
 메시지가 주문 처리기에서 창고(Warehouse) 마이크로서비스로 바로 이동하는 대신 큐에 보관된다. 
 창고 서비스는 가용한 상황에서 이 큐의 메시지를 사용한다. 요청을 읽고 관련 재고 예약 작업을 수행한 다음, 주문 처리기가 읽고 있는 큐로 응답을 다시 보낸다. 
 또한 응답을 어디로 라우팅할지도 알아야 한다. 이 예에서 창고 서비스는 이 응답을 주문 처리기가 사용하는 다른 큐를 통해 다시 전송한다


동기식 통신
단점 : 인스턴스 장애 시 문제 발생 통신이 유지되어 있어야 한다 
이유 : 동기식 통신은 커넥션이 열린상태로 유지되어 요청 응답 한다

비동시 통신
단점 : 구성이 복잡
컨트랙트 : 메세지를 브로커를 통해 전달하고 메세지가 다른 서비스로 바로 이동하지 않고 
큐에 전달 되어 다른서비스에서 수신 요청 시 큐를 통해 수신 받는다


원래 요청과 관련된 모든 상태를 데이터베이스에 저장하고 응답이 올 때 수신한 인스턴스가 관련된 상태를 다시 로드해서 적절히 동작할 수 있게 하는 것이다

요청 및 응답의 상호작용 형태에서는 절대 발생하지 않을 일을 기다리면서 블로킹되는 문제를 피하고자 일종의 타임아웃 처리가 필요하다

이벤트는 발생한 일에 대한 statement이다. 이벤트를 발행하는 마이크로서비스의 세계 내부에서 발생한 일이 거의 언제나 대부분이다. 
이벤트를 발행하는 마이크로서비스는 이벤트를 사용하려는 다른 마이크로서비스가 존재한다는 사실조차 인식하지 못할 수 있다. 
필요할 때 이벤트를 발행하면 그 책임을 다한 것이다.



# 미들웨어는 멍청하게, 엔드포인트는 똑똑하게 유지해야 한다 


마이크로서비스가 다른 마이크로서비스와 통신하는 방법에는 다양한 선택지가 있다. 하지만 SOAP, XML-RPC, REST, gRPC 중 어느 것이 적합할까? 항상 새로운 선택지는 등장한다. 따라서 특정 기술을 논의하기 전에 우리가 선택한 기술에서 무엇을 원하는지 생각해보자


하위 호환성을 쉽게 하라

마이크로서비스를 변경할 때는 이 서비스를 소비하는 마이크로서비스와의 호환성이 깨지지 않도록 해야 한다. 따라서 어떤 기술을 선택하든 하위 호환되는 변경을 쉽게 할 수 있길 원한다. 새 필드를 추가하는 등의 간단한 작업으로 클라이언트가 중단되면 안 된다

인터페이스를 명시적으로 만들라

API를 기술 중립적으로 유지하라를 기술 중립적으로 유지하라

사용될 기술 스택의 의존성이 강제되는 통합은 피해야 한다는 것을 의미한다




소비자를 위해 서비스를 단순하게 만들라 소비자를 위해 서비스를 단순하게 만들라

내부 구현 세부 사항을 숨겨라

내부에서 무언가를 변경하려는 경우 소비자에게도 변경을 요구해 소비자를 불편하게 만들 수 있다
이는 변경 비용을 증가시키는데, 모두가 원치 않는 결과다. 
또한 소비자를 업그레이드해야 한다는 두려움 때문에 변경을 꺼리는 경향도 있음을 의미하며, 이는 서비스 내부의 기술 부채를 증가시키곤 한다. 
따라서 내부 표현의 상세 정보를 노출하도록 강요하는 기술은 피해야 한다

원격 프로시저 호출
원격 프로세스에서 로컬 메서드를 호출할 수 있는 프레임워크다. 일반적으로 SOAP와 gRPC 중에서 선택한다

REST
공통의 동사 (GET, POST 등 )들을 사용해 액세스 가능한 리소스 (고객, 주문 등)를 노출하는 
아키텍처 방식이다. REST는 이보다 더 많은 것을 포함한다


그래프QL
소비자가 여러 하위 마이크로서비스에서 정보를 가져올 수 있는 사용자 지정 쿼리를 정의하고 필요한 결과만 반환하기 위해 필터링할 수 있으며, 상대적으로 새로운 프로토콜이다

메시지 브로커
큐나 토픽을 통해 비동기 통신을 허용하는 미들웨어다




원격 프로시저 호출
이 분야의 기술 대부분은 SOAP나 gRPC와 같은 명시적 스키마를 필요로 한다
SOAP 인터페이스를 노출하는 자바 서버와 그 인터페이스에 대한 동일한 WSDL 정의를 사용해 생성된 .NET 클라이언트를 만들 수 있다
자바 RMI를 비롯한 다른 기술은 클라이언트와 서버 간의 더 강한 결합을 요구하며, 둘 다 동일한 하부 기술을 사용하지만 명시적인 서비스 정의는 필요 없다
서비스 정의가 자바의 타입 정의에 의해 암묵적으로 제공되기 때문이다
원격 호출을 로컬 호출처럼 보이게 하는 동일한 핵심 특성이 있다

직렬화 프로토콜에 투자한다는 의미 
RPC 프레임워크는 데이터가 직렬화되거나 역직렬화되는 방법을 정의한다. 예를 들어 gRPC는 이를 위해 프로토콜 버퍼protocol buffer 직렬화 형식을 사용한다 
예를 들어 TCP는 전달을 보장하는 반면에 UDP는 전달을 보장하지 못하지만 훨씬 낮은 오버헤드를 제공한다
이런 점에서 아브로Avro RPC는 페이로드에 전체 스키마를 전송해 클라이언트가 동적으로 스키마를 해석할 수 있게 하는 흥미롭고 독특한 사례다

단점

기술 결합 technology coupling이 발생
사용될 수 있는 기술을 제한 , 특정 플랫폼에 강력히 묶여 있다.
상호 운용성에 대한 제약이 따른다는 점을 유의


로컬 호출은 원격 호출과 같지 않다
RPC의 핵심 개념은 원격 호출의 복잡성을 숨기는 것
RPC를 사용하면 네트워크를 통해 전송하는 데 걸리는 시간은 말할 것도 없고 페이로드를 마샬링marshaling하고 역마샬링unmarshaling하는 데 상당한 비용이 든다


네트워크 자체를 생각해볼 필요가 있다 

분산 컴퓨팅의 첫 번째 오류는 그 유명한 ‘네트워크는 신뢰할 수 있다’는 생각이다 네트워크는 신뢰할 수 없다
네트워크는 실패할 수 있고 실패할 것이다. 네트워크는 빠르거나 느리게 실패할 수 있으며 패킷을 변조할 수 있다.
원격 서버가 느리게 응답하기 시작한다면 어떻게 할 것인가? 


회복 탄력성

견고성robustness
예상되는 변동을 흡수하는 능력

회복성rebound
충격적인 사건 이후 회복하는 능력

원만한 확장성graceful extensibility
예상치 못한 상황에 얼마나 잘 대처하는가?

지속적인 적응력sustained adaptability
변화하는 환경, 이해관계자, 요구 사항에 지속적으로 적응하는 능력


견고성

호스트가 고장 날 수 있고, 네트워크 연결이 시간 초과될 수 있으며, 마이크로서비스가 가용 상태가 아닐 수 있는 등 예상 가능한 많은 변동
하지만 교체 호스트를 자동으로 가동하거나, 재시도를 수행하거나, 해당 마이크로서비스의 오류를 적절한 방식으로 처리하는 등 다양한 방법으로 변동을 처리해 아키텍처의 견고성을 개선할 수 있다
문제는 애플리케이션의 견고성을 높일수록 시스템에 더 많은 복잡성이 추가돼 새로운 문제가 될 수 있다는 것이다


회복성

중단으로부터 얼마나 잘 복구되는가는 회복 탄력성이 있는 시스템을 구축하기 위한 핵심 부분이다.
사전에 준비하면 장애로부터 회복하는 능력이 향상된다

백업을 준비하면 데이터를 손실한 후 더 잘 복구할 수 있다
회복 능력을 향상하는 데는 시스템이 중단된 후 실행할 수 있는 플레이북playbook이 포함된다


 원만한 확장성원만한 확장성


책임이 집중되지 않고 조직 전체에 분산돼 있는 수평 조직은 종종 예기치 못한 상황에 더 잘 대처할 수 있다
예상치 못한 일이 발생했을 때 사람들이 해야 할 일에 제한을 받고 엄격한 규칙을 준수해야 한다면 당황할 때 대처하는 능력이 크게 약화될 것이다
종종 시스템을 최적화하려고 노력하는 과정에서 불행하게도 부작용이 발생해 시스템의 취약성이 증가할 수 있다.

자동화 예를 들어보자. 현재 인력으로 더 많은 일을 할 수 있지만, 자동화는 돌발 상황을 처리할 수 없다
시스템을 우아하게 확장하고 예상치 못한 상황에 대처하는 능력은 이러한 상황이 발생했을 때 대처할 수 있는 적절한 기술, 경험, 책임감을 갖춘 사람을 배치하는 데서 비롯되기 때문이다


지속적인 적응력


장애는 어디에서나 발생한다


모든 것은 실패할 수 있고 실패할 것이라는 가정이 굳어지면, 문제의 해결 방법을 달리 생각하게 된다
실패할 가능성이 있는 상황을 이해하는 것이 시스템의 견고성을 개선하는 핵심이다

불가피한 일을 막는 데는 시간을 조금 덜 쓰고, 이를 원만하게 처리하는 데 더 많은 시간을 할애할 수 있다

구글 시스템은 기계에 고장이 발생해도 서비스가 중단되지 않도록 구축돼 전체적으로 시스템의 견고성을 향상시킨다

예를 들면 데이터 센터가 정전되더라도 계속 작동할 수 있도록 각 서버에 자체 로컬 전원 공급 장치를 설치했다.
이러한 서버의 하드 드라이브는 나사못이 아닌 찍찍이 테이프로 고정돼 있어 쉽게 드라이브를 교체할 수 있었다

우리는 모놀리스를 마이크로서비스로 교체했다. 그리고 모든 장애가 마치 살인 사건을 다루는 추리극처럼 돼버렸다

대규모에서 아무리 좋은 구성품이나 아무리 비싼 하드웨어를 구입하더라도 실패할 수 있고 실패할 것이라는 사실을 피할 수는 없다
따라서 실패가 발생할 수 있다고 가정해야 한다

구글처럼 더 저렴한 머신(아마도 더 저렴한 구성품과 일부 찍찍이 테이프를 사용하는 머신 )을 더 많이 보유하는 것이 훨씬 더 합리적일 수 있다



얼마나 많아야 너무 많은 건가?


서비스 중 하나가 다운돼 전체 웹 페이지를 사용할 수 없게 되면, 한 서비스로 사용할 수 있는 시스템보다 회복 탄력성이 떨어지는 시스템을 만든 것이다
장바구니 마이크로서비스가 가용하지 못하다면 많은 문제가 생길 수 있지만, 여전히 제품 목록을 표시할 수 있을 것이다. 아마도 장바구니를 숨기거나 “곧 정상화됩니다!”라고 안내하는 아이콘으로 바꿀 수 있다



안정성 패턴

시스템이 느려지면느려지면 얼마 동안 기다리다가 포기하게 되는데, 이렇게 기다리는 과정에서 전체 시스템 속도가 느려지고 리소스 경합이 발생하며, 필자의 사례에서처럼 연쇄적인 장애를 초래한다

하지만 실패의 원인이 무엇이든 시스템 전체의 장애를 유발하는 다운스트림 문제에 취약한 시스템을 만들었다
몇 가지 문제를 발견했으며, 다운스트림 연결을 처리하기 위해 HTTP 커넥션 풀을 사용하고 있었다. 풀에 있는 스레드에는 다운스트림 HTTP 호출을 수행할 때 대기하는 시간에 대한 타임아웃이 설정돼 있었고 양호했다.
문제는 느린 다운스트림 서비스로 인해 워커worker가 모두 타임아웃까지 대기한다는 것이다
대기하는 동안 워커 스레드를 필요로 하는 더 많은 요청이 워커 풀로 유입됐다
가용한 워커가 없으니 요청 자체는 매달려 있었다.
알고 보니 사용 중이던 커넥션 풀 라이브러리에는 워커를 기다리는 타임아웃은 있었지만, 초기값이 비활성화돼 있었다
그 결과 블록된 스레드가 엄청나게 쌓이게 됐다.
애플리케이션에는 대략 한 번에 40개의 동시 커넥션이 있었다. 5분 동안 이 상황으로 인해 약 800개의 커넥션이 정점에 도달해 시스템이 다운됐다

요약 장애지점에서 워커를 전부 고립하여 다른호출 응답불능 상태가 됨

느리게 작동하는 시스템이 빠르게 실패하는 시스템보다 다루기 훨씬훨씬 어렵다는 것을 알게 됐다. 분산 시스템에서 지연 시간은 치명적이다
하나의 느린 다운스트림 서비스가 다른 모든 것이 정상인 경우에도 자체적으로 사용 가능한 워커 수를 소진할 수 있다는 것을 의미
잦은 타임아웃과 실패로 인해 문제의 다운스트림 서비스가 정상적이지 않다는 것이 분명했지만, 그럼에도 계속해서 트래픽을 그곳으로 전송했다

타임아웃 / 벌크헤드 / 회로차단기 
- timeout , bulkhead , circuit breaker
 타임아웃타임아웃을 올바르게 설정하고, 서로 다른 커넥션 풀을 구현하기 위해 벌크헤드벌크헤드를 구현하고, 애초에 비정상 시스템에 호출을 보내지 않도록 회로 차단기회로 차단기circuit breaker를 구현했다




타임아웃


호출을 포기하기 전에 얼마나 기다려야 하는가
호출이 실패했다고 결정하는 동안 너무 오래 기다리게 되면 전체 시스템 속도가 느려진다
또한 너무 빨리 시간이 초과되면 성공할 수 있는 호출을 실패로 간주하게 된다.
타임아웃이 없다면 다운스트림 서비스가 다운될 때 전체 시스템이 중단될 수 있다.

인바운드 요청에 대한  타임아웃을 추가한다

응답을 위해 30초를 기다려야 했다. 문제는 더 광범위한 맥락에서 호출 후 그렇게 오래 기다리는 것은 의미가 없다는 점이다.
사용자 중 한 명이 브라우저를 사용해 당사 웹 사이트를 볼 때 요청된다
 페이지가 로드될 때까지 30초를 기다리는 사람은 아무도 없다.
응답할 때까지 타임아웃 30초를 기다리게 돼 있지만, 그 훨씬 전에 사용자가 단지 새로 고침을 했으므로 원래 요청은 무효화되고 
추가적인 인바운드 요청이 발생 이로 인해 광고 시스템에 대한 또 다른 요청이 들어왔고, 그렇게 진행됐다.


재시도

아직 로드되지 않은 웹 페이지를 새로 고침했는데 두 번째 시도에서는 정상적으로 작동한 적이 얼마나 자주 있는가? 이것이 바로 재시도다

예를 들어 HTTP와 같은 프로토콜을 사용하는 경우 응답 코드에서 재시도가 필요한지 판단하는 데 도움이 되는 몇 가지 유용한 정보를 얻을 수 있다. 
404 Not Found가 반환되면 재시도가 도움이 되지 않을 것이다. 
503 Service Unavailable이나 504 Gateway Time-out이 발생한다면 일시적인 오류로 간주해 재시도하는 것이 적절하다.



벌크헤드

벌크헤드는 지금까지 패턴 중 가장 중요하다
선박에서 격벽은 선체의 다른 부분을 보호하기 위해 밀봉할 수 있는 선체의 일부분이다. 따라서 배에 물이 들어올 경우 격벽 문을 닫을 수 있다. 그럼 배의 일부 공간은 잃겠지만 나머지 공간은 무사하게 된다.


관심사의 분리도 벌크헤드를 구현하는 한 가지 방법이다
기능을 별도의 마이크로서비스로 분리하면, 한 영역에서 장애가 발생해 다른 영역에 영향을 미칠 가능성이 줄어든다

다운스트림 서비스별 커넥션 풀을 사용한 벌크헤드
최소한 각각의 다운스트림과 연결하기 위한 별도의 커넥션 풀을 두는 것부터 시작하는 것이 좋다 그리고 더 나아가 회로 차단기 사용을 고려할 수 있다. 

타임아웃과 회로 차단기는 자원이 제한될 때 자원을 확보하는 데 도움이 되지만, 벌크헤드는 처음부터 자원이 제한되는 것을 방지할 수 있다

로드 셰딩load shedding
또한 자원이 더 포화되지 않도록 특정 조건에서 요청을 거부할 수 있는 기능을 제공할 수 있는데, 이를 로드 셰딩load shedding이라고 한다. 때로는 요청을 거부하는 것이 중요한 시스템을 무너뜨리지 않고 여러 업스트림 서비스에 병목 현상이 발생하지 않도록 하는 가장 좋은 방법이다



회로 차단기

가정에는 전력이 급등할 때 전기 장치를 보호하는 회로 차단기가 존재한다. 전력이 급등하면 회로 차단기가 끊어져 고가의 가전 기기를 보호한다
또한 회로 차단기를 수동으로 비활성화해 집의 일부 전원을 차단하고 전기 시스템에서 안전하게 작업할 수 있다
연쇄적 실패의 위험을 감안하면, 모든 동기식 다운스트림 호출에 대해 회로 차단기를 의무화하는 것이 좋다

회로 차단기를 너무 일찍 끊거나 오래 걸려 끊는 것을 피하고 싶다. 마찬가지로 트래픽을 보내기 전에 다운스트림 서비스가 다시 정상인지 확인하고 싶을 것이다. 타임아웃과 마찬가지로, 필자는 합리적인 기본값을 선택해 모든 곳에서 적용한 다음 특정 경우에만 값을 수정한다
회로 차단기가 끊어진 동안 몇 가지 옵션이 있다. 하나는 요청을 큐에 넣고 나중에 재시도하는 것이다 특히 비동기 작업의 일부로 수행될 때 적합할 수 있다

호출이 동기 호출 체인의 일부로 수행되고 있다면 빨리 실패하는 것이 좋다 호출 체인에 따라 에러를 전파하거나 보다 미묘한 기능 저하로 나타날 수 있다

레거시 시스템에 대한 다운스트림 호출을 회로 차단기로 감쌌다.서비스에 문제가 발생하면  해당 회로 차단기가 열린다
이러한 회로 차단기가 끊어졌을 때는 프로그래밍 방식으로 웹 사이트를 업데이트해 순무에 대한 광고를 표시할 수 없다는 것을 보여주었다. 우리는 웹 사이트의 나머지 부분이 작동하도록 유지했고, 다른 요청은  영향을 받지 않는다 완전히 자동화된 방식으로 제품의 일부분에 제한된 문제가 있음을 고객에게 명확히 전달했다 

집에 있는 회로 차단기처럼 이러한 메커니즘을 갖추면 수동으로 사용해 작업을 더 안전하게 수행할 수 있다
예를 들어 일상적인 유지 보수 활동으로 마이크로서비스를 중단하려는 경우 업스트림 소비자의 모든 차단기를 수동으로 열어 마이크로서비스가 끊어진 상태일 때 빨리 실패하도록 할 수 있다

 빠르게 실패하는 것이 느리게 실패하는 것보다 항상 더 낫다 응답하길 기다리면서 귀중한 시간(그리고 자원 )을 낭비하기 전에 실패하게 된다


격리
한 마이크로서비스가 다른 마이크로서비스의 가용성에 더 많이 의존할수록 한 마이크로서비스의 상태가 다른 마이크로서비스의 작업 수행 능력에 더 많은 영향을 미친다

격리는 논리적인 것에서 물리적인 것으로 전환하는 방식에도 적용된다. 서로 완전히 격리된 것처럼 보이는 2개의 마이크로서비스를 생각해보라. 이 두 마이크로서비스는 어떤 방식으로도 서로 통신하지 않는다 따라서 그중 하나에 문제가 생겨도 다른 것에 영향을 끼치지 못할 것이다.


마이크로서비스를 배포하는 방법을 고려할 때, 이와 같은 문제를 방지하려면 어느 정도의 장애 격리를 보장하기 위해 노력해야 한다

미들웨어를 사용해 두 마이크로서비스 간을 시간적으로 분리할 수 있지만, 이 경우 브로커에 대해 고민해야 한다
따라서 다른 많은 것과 마찬가지로 격리와 비용 및 복잡성의 증가 사이에 수용 가능한 절충점을 찾는 것이 중요하다.

이중화

누군가가 퇴사하거나 휴가를 떠날 경우를 대비해 운영 환경의 데이터베이스가 작동하는 방식을 아는 사람이 두 명 이상 있는 것은 합리적으로 보인다
이와 마찬가지로, 2개 이상의 마이크로서비스 인스턴스가 있을 때 인스턴스 중 하나에 장애가 발생해도 필요한 기능을 계속 제공할 수 있기 때문에 합리적이다

단일 가용 영역의 가용성에 대한 보장도 없으므로 위험을 분산하기 위해 두 번째 인스턴스를 다른다른 가용 영역에 배치해야 한다

무언가의 복사본을 더 많이 보유하면 이중화를 구현하는 데 도움이 되지만 애플리케이션을 확장해 증가하는 부하를 처리하는 데도 도움이 될 수 있다




 미들웨어


대부분의 메시지 브로커가 지닌 유용한 특성 중 하나는 전달을 보장하는 기능이다
미들웨어를 사용해 다운스트림 순무 시스템과의 요청 및 응답 통신을 인위적으로 처리하는 것은 브로커에서 보류 중인 요청이 늘어나게 될 뿐 요청 중 상당수가 더 이상 유효하지 않은 요청과 연관될 수 있다는 점에서 더욱 나쁘다

따라서 메시지 브로커와 같은 미들웨어를 사용해 일부 견고성 문제를 해소하는 것이 유용할 수 있지만 모든 상황에 적용되지는 않는다



멱등성

연산에서는 첫 번째 적용 이후 연산을 여러 번 적용하더라도 결과가 변경되지 않는다. 연산에 멱등성이 있다면 부정적인 영향 없이 호출을 여러 번 반복할 수 있다. 이는 처리됐는지 확실하지 않은 메시지를 재연하고자 할 때 매우 유용하며, 에러에서 복구하는 일반적인 방법이다


계정에 포인트를 적립하는 예시

```

<credit>  
<amount>100</amount>  
<forAccount>1234</account>
</credit>
```


해당 호출은 여러번 요청할때 마다 포인트가 추가된다



```
<credit>  

<amount>100</amount>  
<forAccount>1234</account>  

<reason>    
<forPurchase>4567</forPurchase>  
</reason>

</credit>

```

적립금이 특정 주문 4567과 관련이 있다는 것을 알고 있다
특정 주문에 대해 하나의 적립금만 받을 수 있다고 가정하면 전체 포인트 수를 늘리지 않고도 이 적립금을 다시 적용할 수 있다
이 메커니즘은 이벤트 기반 협업 방식에서도 잘 동작하며 특히 이벤트를 구독하는 동일한 유형의 서비스 인스턴스가 여러 개 있는 경우에 유용하다
어떤 이벤트가 처리됐는지 저장하더라도 일부 형태의 비동기 메시지 전달을 사용하면 두 워커가 짧은 시간 동안 동일한 메시지를 볼 수 있다. 
따라서 이벤트를 멱등성 방식으로 처리해 이러한 문제가 발생하지 않도록 한다

이 개념에 사로잡혀 동일한 매개변수를 가진 연이은 호출이 아무런 영향을 미치지 않는다고 가정하는데, 
이로 인해 흥미로운 상황에 처하게 된다. 예를 들어 우리는 여전히 호출을 수신했다는 사실을 로그에 기록하길 원한다.
호출 응답 시간을 기록하고 모니터링을 위해 이 데이터를 수집하고 싶어 한다. 
여기서 핵심은 시스템의 전체 상태가 아니라 멱등성을 고려하는 것은 기본 비즈니스 작업이라는 사실이다
해당 동사를 멱등성이 없게 만들고 나서 호출자가 그 동사를 반복적으로 안전하게 실행할 수 있다고 생각하면 문제가 발생할 수 있다




위험 분산


회복 탄력성을 위해 확장하는 한 가지 방법은 모든 달걀을 한 바구니에 담지 않는 것이다



마이크로서비스 아키텍처 구축(전면 개정판)
https://learning.oreilly.com/library/view/maikeuroseobiseu-akitegceo-gucug-jeonmyeon/9791169211192/chapter-278.html







