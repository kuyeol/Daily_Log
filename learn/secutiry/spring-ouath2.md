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
- [[2]](#GrantType-Authorization-Server) _GrantType_ 인증 서버 구현

## 간단한 구성으로 시작하기
- Spring Boot가 필요한 @Bean정의를 YML로 작성하여 제공한다 
<details>
	

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
 
</details>



## GrantType Authorization Server [link](https://docs.spring.io/spring-authorization-server/reference/guides/how-to-ext-grant-type.html)

> [!Note]
> 토큰엔드포인트에서 


### 1. AuthenticationConverter
- 토큰 요청 시 반환 작업
- Create Class 
    - GrantTypeAuthenticationConverter implements AuthenticationConverter
- Instance Variable
    - null
- Constructor
    - null
- methods
    - @Nullable @Override public Authentication convert(HttpServletRequest request)
    - private static MultiValueMap<String, String> getParameters(HttpServletRequest request)

		     
### 2. AuthenticationProvider
- 인증을 제공
	- 권한 부여의 유효성을 검사
	- 권한이 있는 경우 액세스 토큰을 발급
- Create Class 
     - `GrantTypeAuthenticationProvider` implements AuthenticationProvider
- Instance Variable
     -  private final `OAuth2AuthorizationService` authorizationService;
     - private final `OAuth2TokenGenerator` < `?` extends `OAuth2Token` > tokenGenerator;
- Constructor
     - OAuth2AuthorizationService
     - OAuth2TokenGenerator <? extends OAuth2Token>  
 - Methods
     - @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException
     - @Override public boolean supports(Class<?> authentication)


### 3. OAuth2 Token Endpoint

- 토큰 엔드포인트 생성
	-  AuthenticationConverterOAuth2 토큰 엔드포인트 구성에 추가 	
	-  AuthenticationProviderOAuth2 토큰 엔드포인트 구성에 추가	 	
- Create Class 
     - @Configuration @EnableWebSecurity
     - SecurityConfig.java
- Instance Variable
	- -
- Constructor
   	- -
 - Methods
     - @Bean SecurityFilterChain
     - authorizationServerSecurityFilterChain(HttpSecurity, OAuth2AuthorizationService, OAuth2TokenGenerator<?> ) throws Exception


### 4. Access Token
- 액세스 토큰 요청
- 클라이언트 --> OAuth2
  - 토큰 엔드포인트에 다음(인증된) 요청을 수행하여 액세스 토큰을 요청할 수 있습니다.
 
```shell

POST /oauth2/token HTTP/1.1
Authorization: Basic bWVzc2FnaW5nLWNsaWVudDpzZWNyZXQ=
Content-Type: application/x-www-form-urlencoded

grant_type=urn:ietf:params:oauth:grant-type:custom_code&code=7QR49T1W3

```





---

## 기본 구성 내용

### 필수 구성 요소

- 프로토콜 엔드포인트 호출
  - SecurityFilterChain

- 인증 필터 체인 
   - SecurityFilterChain

- 사용자 검색 인증 
  - UserDetailsService

- 클라이언트 관리 
  - RegisteredClientRepository
  - 
- JWKSource 서명에 사용 될 액세스 토큰 키쌍 생성
  - java.security.KeyPair
    
- 액세스 토큰 서명
  - com.nimbusds.jose.jwk.source.JWKSource.

- 서명된 액세스 토큰 디코딩
  - JwtDecoder

- Authorization Server 구성
  - AuthorizationServerSettings


## 세부 분휴

### Configuration_Model
- Configuration Model
- Default configuration
- Customizing the configuration
- Configuring Authorization Server Settings
- Configuring Client Authentication
  - Customizing Jwt Client Assertion Validation
  - Customizing Mutual-TLS Client Authentication

### Core_Model / Component

- RegisteredClient
- RegisteredClientRepository
- OAuth2Authorization
- OAuth2AuthorizationService
- OAuth2AuthorizationConsent
- OAuth2AuthorizationConsentService
- OAuth2TokenContext
- OAuth2TokenGenerator
- OAuth2TokenCustomizer
- SessionRegistry

### Protocol_EndPoints

- OAuth2 Authorization Endpoint
  - Customizing Authorization Request Validation
- OAuth2 Device Authorization Endpoint
- OAuth2 Device Verification Endpoint
- OAuth2 Token Endpoint
  - Customizing Client Credentials Grant Request Validation
- OAuth2 Token Introspection Endpoint
- OAuth2 Token Revocation Endpoint
- OAuth2 Authorization Server Metadata Endpoint
- JWK Set Endpoint
- OpenID Connect 1.0 Provider Configuration Endpoint
- OpenID Connect 1.0 Logout Endpoint
- OpenID Connect 1.0 UserInfo Endpoint
- OpenID Connect 1.0 Client Registration Endpoint

















































































