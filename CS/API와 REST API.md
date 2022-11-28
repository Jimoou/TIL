## API
APplication Programming Interface 의 줄임말
응용 프로그램에서 사용할 수 있도록 다른 응용 프로그램을 제어할 수 있게 만든 인터페이스를 뜻함
API를 사용하면 내부 구현 로직을 알지 못해도 정의되어 있는 기능을 쉽게 사용할 수 있음

## Interface
어떤 장치가 정보(data)를 교환하기 위한 수단이나 방법을 의미함
대표적인 인터페이스 예로는 마우스, 키보드 , 터치패드 등이 있음

*위에서 말하는 인터페이스는 소프트웨어적인 의미임.

## REST(Representational State Transfer)
자원의 이름으로 구분하여 해당 자원의 상태를 교환하는 것을 의미
REST는 서버와 클라이언트의 통신 방식 중 하나임
HTTP URI(Uniform Resource Identifier)를 통해 자원을 명시하고 HTTP Method를 통해 자원을 교환하는 것

*HTTP Method : Create, Read, Update, Delete

### REST 특징(규칙)
#### Server-Client 구조
자원이 있는 쪽이 Server, 요청하는 쪽이 Client
클라이언트와 서버가 독립적으로 분리되어 있어야 함

#### Stateless
요청 간에 클라이언트 정보가 서버에 저장되지 않음
서버는 각각의 요청을 완전히 별개의 것으로 인식하고 처리

#### Cacheable
HTTP 프로토콜을 그대로 사용하기 때문에 HTTP의 특징인 캐싱 기능을 적용
대략의 요청을 효율적으로 처리하기 위해 캐시를 사용

#### 계층화
클라이언트는 서버의 구성과 상관없이 REST API서버로 요청
서버는 다중 계층으로 구성될 수 있음 (로드밸런싱, 보안요소, 캐시 등)

#### Code on Demand(Optional)
요청을 받으면 서버에서 클라이언트로 코드 또는 스크립트(로직)을 전달하여 클라이언트 기능 확장

#### 인터페이스 일관성(Uniform Interface)
정보가 표준 형식으로 전송되기 위해 구성 요소간 통합 인터페이스를 제공 HTTP 프로토콜을 따르는 모든 플랫폼에서 사용 가능하게끔 설계

#### REST의 장점
HTTP 표준 프로토콜을 사용하는 모든 플랫폼에서 호환 가능
서버와 클라이언트의 역할을 명확하게 분리
여러 서비스 설계에서 생길 수 있는 문제를 최소화

### REST API
REST 아키텍처의 조건을 준수하는 어플리케이션 프로그래밍 인터페이스르 뜻함
최근 많은 API가 REST API로 제공되고 있음
일반적으로 REST 아키텍처를 구현하는 웹 서비스를 RESTful 하다고 표현한다.

#### REST API특징
REST 기반으로 시스템을 분산하여 확장성과 재사용성을 높임
HTTP 표준을 따르고 있어 여러 프로그래밍 언어로 구현할 수 있음

#### REST API 설계 규칙
웹 기반의 REST API 를 설계할 경우에는 URI를 통해 자원을 표현해야 함에

자원에 대한 조작은 HTTP Method(CRUD)를 통해 표현해야함 
  URI에 행위가 들어가면 안됨
  HEADER를 통해 CRUD를 표현하여 동작을 요청해야 함

메세지를 통한 리소스 조작
  HEADER를 통해 content-type을 지정하여 데이터를 전달
  대표적 형식으로는 HTML, XML, JSON, TEXT가 있음
