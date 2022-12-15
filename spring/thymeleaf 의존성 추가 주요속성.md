- src > main > resources > [static] 폴더에 정적 리소스들을
- src > main > resources > [templates] 폴더에는 템플릿 파일들을

- Thymeleaf 확장자는 .html을 쓰고 tmplates 폴더에는 관련된 파일만 동작한다.

- thymleaf 경로 설정

```java
//default
spring.thymeleaf.prefix = classpath:/templates/
spring.thymeleaf.suffix = .html
```

- thymleaf 템플릿에 대한 캐시를 남기지 않음. cache = false 설정하고 개발하다가 운영시는 true로 변경

```java
spring.thymeleaf.cache = false
```
 
- 템플릿 위치 존재 확인 - templates 디렉토리에 파일이 있는지 없는지 체크, 없으면 에러를 발생.

```java
spring.thymeleaf.check-template-location = true
```
