# REST API - <u>REST</u> 아키텍처 스타일을 따르는 API
## <u>REST</u> - 분산 하이퍼 미디어 시스템(예: 웹)을 위한 <u>아키텍쳐</u> 스타일
### 아키텍쳐 스타일 - 제약조건의 집합


오늘날 대부분의 "REST API"는 사실 REST를 따르지 않고 있다.
REST의 제약조건 중에서 특히 Self=descriptive와 HATEOAS를 잘 만족하지 못한다.
REST는 긴 시간에 걸쳐(수십년) 진화하는 웹 애플리케이션을 위한 것이다.
REST를 따를 것인지는 API를 설계하는 이들이 스스로 판단하여 결정해야한다.
REST를 따르겠다면, Self-decriptive와 HATEOAS를 만족시켜야한다.
Self-decriptive는 custom media type이나 profile link relation 등으로 만족시킬 수 있다.
HATEOAS는 HTTP 헤더나 본문에 링크를 담아 만족시킬 수 있다.
