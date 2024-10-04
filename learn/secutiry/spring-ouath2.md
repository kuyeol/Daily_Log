# OAuth2
 _스프링 시큐리티 OAuth2_ 



- [Section 1](#간단한-구성으로-시작하기)
- [Section 2: Example](#section-2-example)

## Section 1

이곳은 첫 번째 섹션입니다.

## Section 2: Example

이곳은 두 번째 섹션입니다.

```yml
spring:
  security:
    user:
      name: user
      password: password
    oauth2:
      authorizationserver:
        client:
          oidc-client:
            registration:
              client-id: "oidc-client"
              client-secret: "{noop}secret"
              client-authentication-methods:
                - "client_secret_basic"
              authorization-grant-types:
                - "authorization_code"
                - "refresh_token"
              redirect-uris:
                - "http://127.0.0.1:8080/login/oauth2/code/oidc-client"
              post-logout-redirect-uris:
                - "http://127.0.0.1:8080/"
              scopes:
                - "openid"
                - "profile"
            require-authorization-consent: true
```
```yml
spring:
  security:
    user:
      name: user
      password: password
    oauth2:
      authorizationserver:
        client:
          oidc-client:
            registration:
              client-id: "oidc-client"
              client-secret: "{noop}secret"
              client-authentication-methods:
                - "client_secret_basic"
              authorization-grant-types:
                - "authorization_code"
                - "refresh_token"
              redirect-uris:
                - "http://127.0.0.1:8080/login/oauth2/code/oidc-client"
              post-logout-redirect-uris:
                - "http://127.0.0.1:8080/"
              scopes:
                - "openid"
                - "profile"
            require-authorization-consent: true
```
```yml
spring:
  security:
    user:
      name: user
      password: password
    oauth2:
      authorizationserver:
        client:
          oidc-client:
            registration:
              client-id: "oidc-client"
              client-secret: "{noop}secret"
              client-authentication-methods:
                - "client_secret_basic"
              authorization-grant-types:
                - "authorization_code"
                - "refresh_token"
              redirect-uris:
                - "http://127.0.0.1:8080/login/oauth2/code/oidc-client"
              post-logout-redirect-uris:
                - "http://127.0.0.1:8080/"
              scopes:
                - "openid"
                - "profile"
            require-authorization-consent: true
```

## 간단한 구성으로 시작하기

- yml 정의로 간단한 구현 방식
```yml
spring:
  security:
    user:
      name: user
      password: password
    oauth2:
      authorizationserver:
        client:
          oidc-client:
            registration:
              client-id: "oidc-client"
              client-secret: "{noop}secret"
              client-authentication-methods:
                - "client_secret_basic"
              authorization-grant-types:
                - "authorization_code"
                - "refresh_token"
              redirect-uris:
                - "http://127.0.0.1:8080/login/oauth2/code/oidc-client"
              post-logout-redirect-uris:
                - "http://127.0.0.1:8080/"
              scopes:
                - "openid"
                - "profile"
            require-authorization-consent: true
```


