![[Pasted image 20240917212734.png]]![[Pasted image 20240917212759.png]]


![[Pasted image 20240917203208.png]]


## 마이크로서비스 지속성 설계

데이터 모델링 프로세스의 마지막 단계는 물리적 데이터 모델을 만드는 것으로 구성됩니다. 이는 데이터베이스 선택 및 데이터베이스 스키마 생성과 같은 데이터베이스 관련 디자인 선택을 포함하여 서비스를 설계하는 아키텍처 작업에 해당합니다.

### Polyglot persistence

마이크로서비스 아키텍처의 이점 중 하나는 각 서비스가 독립적으로 배포될 수 있다는 것입니다. 이를 통해 각 마이크로서비스에 대해 다른 데이터베이스를 선택할 수 있는 기능을 제공하며, 이를 _폴리글롯 지속성_ 이라고 합니다 .


| 서비스       | 데이터 특성                                       | 데이터베이스 옵션                                                            |
| --------- | -------------------------------------------- | -------------------------------------------------------------------- |
| 호텔 서비스    | 호텔 및 편의 시설에 대한 설명 텍스트, 변경 빈도가 낮음             | 전체 텍스트 검색을 위한 문서 데이터베이스(예: MongoDB), Cassandra 또는 Elasticsearch/Solr |
| 관심 지점 서비스 | 지리적 위치 및 관심 지점에 대한 설명                        | DataStax Enterprise와 같은 지리공간 인덱스를 지원하는 Cassandra 또는 기타 테이블형 데이터베이스   |
| 재고 서비스    | 날짜별 사용 가능한 객실 수, 대량의 읽기 및 쓰기                 | Cassandra 또는 기타 테이블형 데이터베이스                                          |
| 예약 서비스    | 게스트를 대신하여 예약된 객실은 인벤토리보다 읽기 및 쓰기 볼륨이 낮습니다.   | Cassandra 또는 기타 테이블형 데이터베이스                                          |
| 고객 서비스    | 고객 신원 및 연락처 정보, 고객 및 사기 분석 시스템을 위한 가능한 확장 지점 | Cassandra, 그래프 데이터베이스                                                |

## 2차 인덱스

기본 키에 속하지 않는 Cassandra 테이블의 열에 대해 쿼리를 시도하면 이것이 허용되지 않는다는 것을 곧 깨닫게 될 것입니다. 예를 들어, 기본 키로 `hotels`를 사용하는 테이블을 고려해 보겠습니다 `id`. 다음 출력에서 ​​호텔의 `name`결과로 쿼리를 시도합니다.

호텔 이름을 기본 키로 사용하여 추가 테이블을 추가하지 않고 이 상황을 해결하는 한 가지 방법은 열에 대한 _보조 인덱스를_`name` 만드는 것입니다 . 보조 인덱스는 기본 키의 일부가 아닌 열에 대한 인덱스입니다.

> 
![[Pasted image 20240917213714.png]]



#### 보조 인덱스와 관련된 쿼리 더 많은 노드를 포함 비용이 훨씬 더 많이

Cassandra는 여러 노드에 데이터를 분할하기 때문에 각 노드는 자신이 소유한 파티션에 저장된 데이터에 따라 보조 인덱스의 자체 사본을 유지 관리해야 합니다. 이러한 이유로 보조 인덱스와 관련된 쿼리는 일반적으로 더 많은 노드를 포함하므로 비용이 훨씬 더 많이 듭니다.

### 2차 인덱스는 다음과 같은 몇 가지 특정한 경우에는 권장되지 않습니다.

- 높은 기수성을 가진 열. 예를 들어, `hotel.address`열에 대한 인덱싱은 매우 비쌀 수 있는데, 주소의 대부분이 고유하기 때문입니다.
    
- 데이터 기수가 매우 낮은 열. 예를 들어, 테이블 의 모든 "Mrs."에 대한 쿼리를 지원하기 위해 `user.title`열( [4장의](https://learning.oreilly.com/library/view/cassandra-the-definitive/9781492097136/ch04.html#the_cassandra_query_language)`user` 테이블에서 ) 에 인덱싱하는 것은 별 의미가 없습니다 . 인덱스에 거대한 행이 생기기 때문입니다.[](https://learning.oreilly.com/library/view/cassandra-the-definitive/9781492097136/ch04.html#the_cassandra_query_language)`user`
    
- 자주 업데이트되거나 삭제되는 열. 이러한 열에 구축된 인덱스는 삭제된 데이터(tombstone)의 양이 압축 프로세스가 처리할 수 있는 것보다 더 빨리 쌓이면 오류를 생성할 수 있습니다.

> 그림 7-9. 개정된 예약 물리적 모델
![[Pasted image 20240917214002.png]]



## Java 마이크로서비스를 위한 디자인 선택

단일 서비스인 Reservation Service의 설계
- 키스페이스의 테이블을 사용하여 데이터를 읽고 쓰는 일을 담당
- 

> 그림 7-10. 예약 서비스 Java 디자인
![[Pasted image 20240917214236.png]]


# 배포 및 통합 고려 사항

구현을 진행하면서 서비스를 배포하고 다른 서비스 및 지원 인프라와 통합하는 방법과 관련하여 고려해야 할 몇 가지 요소가 있습니다.

## 서비스, ​​키스페이스 및 클러스터

 서비스와 키스페이스의 관계
 - 캡슐화를 촉진하기 위해 서비스당 키스페이스를 사용하는 것이 좋습니다.
 - Cassandra의 액세스 제어 기능
 - 키스페이스당 데이터베이스 사용자
 - 각 서비스는 연관된 키스페이스의 모든 테이블에 대한 독점적인 읽기 및 쓰기 액세스 권한을 갖도록 구성할 수 있다.
 
 > 7-11. 클러스터에 대한 서비스 매핑
 > ![[Pasted image 20240917214545.png]]
 



# Netflix
와 같이 마이크로서비스 아키텍처와 Cassandra를 대규모로 사용하는 회사는 서비스당 전용 클러스터를 사용하는 것으로 알려져 있습니다
> - 수요가 낮은 서비스는 클러스터를 공유
> - 수요가 높은 서비스는 자체 전용 클러스터로 배포



## 데이터 센터 및 부하 분산

두 번째 고려 사항은 각 서비스가 배포될 데이터 센터를 선택하는 것입니다

![[Pasted image 20240917214945.png]]


## 마이크로서비스 간의 상호 작용

관련 유형을 관리하는 마이크로서비스를 개발할 때 발생하는 한 가지 질문은 서로 다른 유형 간에 데이터 일관성을 유지하는 방법입니다. 서로 다른 마이크로서비스에서 데이터의 엄격한 소유권을 유지하려면 서로 다른 서비스가 소유한 데이터 유형에 대한 일관성 관계를 어떻게 유지할 수 있을까요? Cassandra는 테이블 또는 키스페이스 경계를 ​​넘나드는 트랜잭션을 시행하는 메커니즘을 제공하지 않습니다. 하지만 이 문제는 Cassandra에만 국한되지 않습니다. 백업 저장소와 관계없이 서로 다른 서비스에서 관리하는 데이터 유형 간에 일관성이 필요할 때마다 비슷한 설계 과제가 발생하기 때문입니다

---

### 서비스 통합 패턴

재고와 예약 데이터를 관리하는 별도의 서비스     
고객이 예약을 할 때 재고 레코드가 업데이트되도록 어떻게 보장합니까?

![[Pasted image 20240917215019.png]]


#### 왼쪽의 
접근 방식은 예약 및 재고 데이터의 변경을 조정하는 데 도움이 되는 예약 서비스를 만드는 것입니다..이는 오케스트레이션 이라고 알려진 기술의 한 예이며 ,  
CRUD 서비스
(특정 데이터 유형을 생성, 읽기, 업데이트, 삭제하는 역할을 함)와
비즈니스 프로세스를 구현하는 서비스를 구별하는 아키텍처에서 자주 볼 수 있습니다
.이 예에서 예약 및 재고 서비스는 CRUD 서비스에 가깝고, 예약 서비스는 예약, 재고 확보, 고객 및 호텔에 알리는 것과 같은 다른 활동과 같은 비즈니스 프로세스를 구현합니다.   

---

#### 오른쪽
에는 Apache Kafka와 같은 메시지 큐 또는 스트리밍 플랫폼을 사용하여 다른 서비스와 애플리케이션에서
비동기적으로 사용할 수 있는 데이터 변경 이벤트 스트림을 만드는 대체 접근 방식이 나와 있습니다.
예를 들어, 인벤토리 서비스는 인벤토리에 해당하는 조정을 하기 위해 예약 서비스에서 게시한 예약과 관련된
이벤트를 구독하기로 선택할 수 있습니다.이러한 변화를 조율하는
중앙 기관이 없기 때문에 이 접근 방식은 대신 _안무 라고 불립니다._ [15장](https://learning.oreilly.com/library/view/cassandra-the-definitive/9781492097136/ch15.html#migrating_and_integrating) 에서 Cassandra를 Kafka 및 기타보완 기술과 통합하는 방법을 더 자세히 살펴보겠습니다 

# TRADE 

> 일관성, 가용성, 파티션 허용 범위 간의 상충 관계
> 