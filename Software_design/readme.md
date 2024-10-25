# 디자인 패턴
> [!Note]
> 
> 1. `객체생성`
> 2.  `객체조합`
> 3. `객체상호작용`


## 객체의 생성
- 객체 생성 디자인 패턴
  - Singleton:
    - Makes sure there is just one instance.
    - private static 필드를 본인으로 정의
    - 정의된 필드가 NULL인 경우 생성
    - static으로 선언되어 인스터스화없이 호출과 객체 유지
    - 동일한 객체 사용을 보장 
    - 제한적인 사용이 필요한 경우에만
    - 데이터베이스 연결을 만들고 관리
    - 전역 설정에 액세스
    - 제어를 중앙 집중화
      
  - Factory Method:
    - Assigns subclasses the task of instantiating objects.
    - 객체 생성 프로세스가 복잡하거나 조건에 따라 달라지는 경우
    - 인터페이스나 추상 클래스를 통해 객체를 생성하여 구현을 캡슐화
    - 팩토리 메서드에 매개변수나 옵션을 제공하여 객체 생성 프로세스를 사용자 정의
    - 패턴 구조 :
    - interface VehicleFactory
      - class TwoWheelerFactory implements VehicleFactory
      - class FourWheelerFactory implements VehicleFactory
        - abstract class Vehicle
          -  class TwoWheeler extends Vehicle
      - 사용 :
      - 필드에 생성할 객체의 추상클래스 선언
      - 생성자에 구현된팩토리 클래스를 파라미터 정의
      - 생성자 바디 필드멤버에 팩토리메서드 할당
      - 겟 필드 메서드 생성
      - 위와 같이 정의된 클래스를 호출하여 세부 구현이 다른 객체 생성
      - 하나의 인터페이스를 정의한 후 해당 인터페이스를 사용하는 클래스
      - 인터페이스를 구현하는 클래스는 해당 인터페이스로 정의된 클래스 생성자를 사용해 객체 인스턴스화 할수 있다
      - 사용할 구현팩토리 인스턴스화
      - 인터페이스와 추상팩토리 정의된 클래스에 파리미터로 구현팩토리정의 인스턴스화
      - 생성할 제품을 위 인스턴스로 메서드 호출하여 할당
      - 제품에 생성된 메서드 사용할수 있다
      - 구현팩토리 메서드에 반환을 new 생성한      


  - Abstract Factory:
    - Constructs related object families without defining their concrete classes.
  - Prototype:
    -  Clones objects to provide a template example.
  - Builder:
    -  Helps in building the complex objects step by step.

## 객체의 조합
- 구조적 설계 패턴
  - Adapter:
    - Acts as a bridge between two incompatible interfaces
  - Bridge:
    - Separates the abstraction from the implementation.
  - Composite:
    - Handles single and composite objects equally.
  - Decorator:
    - Adds behaviors to objects dynamically.
  - Facade:
    - Helps in Simplifying the complex system interfaces.
  - Flyweight:
    - Shares common parts of state between multiple objects to reduce memory.
  - Proxy:
    - Controls the access to an object.
## 객체의 상호 작용
- 행동 디자인 패턴
  - Observer:
    - Observes and notifies changes in multiple objects.
  - Strategy:
    - Encapsulates the interchangeable algorithms.
  - Command:
    - Encapsulates requests as objects for decoupled execution.
  - State:
    - It Changes the behavior of object with internal state.
  - Visitor:
    - It separates algorithms from objects.
  - Memento:
    - Pattern to manage object state and actions.
  - Iterator:
    - It Sequentially accesses the elements of a collection.
  - Mediator:
    - Central controller managing communication between objects.
  - Chain of Responsibility:
    - Pass request through handlers until one handles it.
  - Template Method:
    - Defines the skeleton of an algorithm.














