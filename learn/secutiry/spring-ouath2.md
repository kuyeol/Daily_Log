# OAuth2
 _스프링 시큐리티 OAuth2_ 

## Overview

- Spring Security 기반 구현
- Spring Authorization Server는 OAuth 2.1 및 OpenID Connect 1.0 사양과 기타 관련 사양 의 구현을 제공

## Prerequisites

- JDK17
- Gradle
- Plugin
  - `org.springframework.boot' version '3.3.4'`
- Dependencies 
  - `org.springframework.boot:spring-boot-starter-security`
  - `org.springframework.boot:spring-boot-starter-web`
  - `org.springframework.boot:spring-boot-starter-oauth2-authorization-server`


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




Contents
---
- [[1]](#간단한-구성으로-시작하기) YML 제공하여 간단한 구현
- [[2]](#사용자-정의-기능-구현) 인증 서버의 구성을 구현해 개발

## 간단한 구성으로 시작하기

- Spring Boot가 필요한 @Bean정의를 YML로 작성하여 제공한다 
```yml
server:
  port: 9000

logging:
  level:
    org.springframework.security: trace

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

## 사용자 정의 기능 구현

























































































