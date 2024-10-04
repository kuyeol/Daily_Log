# OAuth2
 _스프링 시큐리티 OAuth2_ 

## Overview

- Spring Security 기반 구현
- Spring Authorization Server는 OAuth 2.1 및 OpenID Connect 1.0 사양과 기타 관련 사양 의 구현을 제공

## 지원 기능

- 권한 부여 흐름[link](#)
  -  인증 코드
  -  클라이언트 자격 증명
  -  토큰 갱신
  -  디바이스 코드
  -  토큰 교환
   
- 토큰 형식
  - JWT
  - Opaque
    
- 클라이언트 인증
  - client_secret_basic
  - client_secret_post
  - client_secret_jwt
  - private_key_jwt
  - tls_client_auth
  - self_signed_tls_client_auth
  - none (public clients)
    
- 프로토콜 엔드포인트
  - OAuth2 Authorization Endpoint
  - OAuth2 Device Authorization Endpoint
  - OAuth2 Token Endpoint
  - OAuth2 Device Verification Endpoint
  - OAuth2 Token Introspection Endpoint
  - OAuth2 Token Revocation Endpoint
  - OAuth2 Authorization Server Metadata Endpoint
  - JWK Set Endpoint
  - OpenID Connect 1.0 Provider Configuration Endpoint
  - OpenID Connect 1.0 Logout Endpoint
  - OpenID Connect 1.0 UserInfo Endpoint
  - OpenID Connect 1.0 Client Registration Endpoint




# Prerequisites

- JDK17
- Gradle
- Plugin
  - `org.springframework.boot' version '3.3.4'`
- Dependencies 
  - `org.springframework.boot:spring-boot-starter-security`
  - `org.springframework.boot:spring-boot-starter-web`
  - `org.springframework.boot:spring-boot-starter-oauth2-authorization-server`


Contents
---
1. [YML 구성으로 간단한 구현](#간단한-구성으로-시작하기)


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


