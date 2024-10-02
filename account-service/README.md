

# 키클록 소스경로 참고 gpt
 <details>
 <summary> 
   인증 서버와 자격 저장 서버
</summary>
  # Keycloak 인증 서버 및 자격 증명 서버 관련 소스 코드 경로

Keycloak은 오픈 소스 인증 및 권한 부여 서버로, 인증 서버와 자격 증명 서버의 기능을 제공합니다. 아래는 각 기능을 담당하는 주요 소스 코드 경로입니다.

## 1. 인증 및 권한 부여 서버 (Authentication and Authorization Server)
Keycloak에서 OAuth2, OpenID Connect, JWT 발급, 권한 부여 등의 기능을 처리하는 경로입니다.

### 주요 경로
- **OAuth2/OpenID Connect 구현**
  - **경로**: `services/src/main/java/org/keycloak/protocol/oidc`
    - 주요 클래스:
      - `TokenEndpoint.java`: 액세스 토큰 발급.
      - `AuthorizationEndpoint.java`: 권한 부여 요청 처리.

- **JWT 생성 및 서명**
  - **경로**: `core/src/main/java/org/keycloak/jose/jws`
    - 주요 클래스:
      - `JWSBuilder.java`: JWT 생성 및 서명.
      - `JWSTokenVerifier.java`: JWT 검증.

- **권한 부여 처리 (Authorization)**
  - **경로**: `services/src/main/java/org/keycloak/authorization`
    - 주요 클래스:
      - `AuthorizationProvider.java`: 권한 부여 처리.
      - `PolicyEvaluator.java`: 정책 기반 권한 부여.

- **세션 관리**
  - **경로**: `core/src/main/java/org/keycloak/models`
    - 주요 클래스:
      - `UserSessionModel.java`: 사용자 세션 정의.
      - `UserSessionProvider.java`: 세션 관리.

- **API 보안 및 CORS 정책**
  - **경로**: `services/src/main/java/org/keycloak/services/filters`
    - 주요 클래스:
      - `CorsFilter.java`: CORS 정책 적용.
      - `KeycloakSecurityHeadersFilter.java`: 보안 헤더 필터.

---

## 2. 자격 증명 저장 서버 (Credential Storage Server)
Keycloak에서 사용자 자격 증명(비밀번호 등)을 저장하고 관리하는 기능을 처리하는 경로입니다.

### 주요 경로
- **비밀번호 저장 및 검증**
  - **경로**: `core/src/main/java/org/keycloak/credential`
    - 주요 클래스:
      - `PasswordCredentialProvider.java`: 비밀번호 처리.
      - `CredentialInputUpdater.java`: 자격 증명 업데이트.

- **사용자 계정 관리**
  - **경로**: `services/src/main/java/org/keycloak/services/resources/account`
    - 주요 클래스:
      - `AccountRestService.java`: 사용자 계정 관련 API.
      - `AccountCredentialResource.java`: 자격 증명 요청 처리.

- **자격 증명 암호화**
  - **경로**: `core/src/main/java/org/keycloak/hash`
    - 주요 클래스:
      - `PasswordHashProvider.java`: 비밀번호 해싱.
      - `BCryptPasswordHashProvider.java`: BCrypt 해시 구현.

- **토큰 저장 및 관리**
  - **경로**: `core/src/main/java/org/keycloak/models`
    - 주요 클래스:
      - `RealmModel.java`: Realm에서 토큰 설정 관리.
      - `ClientModel.java`: 클라이언트 토큰 설정 관리.

---

## 3. 공통 보안 요소
Keycloak에서 보안 강화를 위한 암호화 및 로그 기록 관련 소스 경로입니다.

### 주요 경로
- **TLS/SSL 암호화 통신**
  - Keycloak은 주로 외부 Reverse Proxy(Nginx, Apache) 서버를 통해 SSL 설정.

- **감사 및 모니터링**
  - **경로**: `services/src/main/java/org/keycloak/events`
    - 주요 클래스:
      - `EventListenerProvider.java`: 인증 이벤트 기록.
      - `EventStoreProvider.java`: 이벤트 저장소 관리.

- **정책 기반 접근 제어**
  - **경로**: `services/src/main/java/org/keycloak/authorization/policy`
    - 주요 클래스:
      - `PolicyProvider.java`: 정책 평가 인터페이스.
      - `DefaultPolicyEvaluator.java`: 정책 평가 및 결과 반환.

---

### 결론
Keycloak의 인증 서버와 자격 증명 서버는 각각 **인증/권한 부여 처리**, **자격 증명 저장/검증**, **보안 관리**로 나뉘어 있으며, 관련 기능은 각 패키지 안에 구현되어 있습니다.
</details>




---
# 리소스에서 사용자 등록 요청 

- A. 반환 값은 Response 인스턴스에 created(유저.겟아이디 ) 메서드를 호출해 생성

- B. 유저명을 문자열객체로 생성해 파라미터.get유저명으로 할당
- C. 유저프로필프로바이더 객체생성 = 세션 객체 메서드 겟프로바이더 호출해 (유저프로파일프로바이더) 전달 할당
- D. 유저프로필 객체 생성 =  프로파일프로바이더 객체 메서드 크리에이트 호출해 파라미터로 (유저API ,유저리프리젠테이션.겟로우어트리뷰트) 전달
  - 유저명,이메일,퍼스트,라스트 네임 정보를 담는다
```java
   @JsonDeserialize(using = StringListMapDeserializer.class)
    protected Map<String, List<String>> attributes;

   public void setAttributes(Map<String, List<String>> attributes) {
        this.attributes = attributes;
    }
   
  public Map<String, List<String>> getAttributes() {
        return attributes;
    }
```

```JAVA
public Map<String, List<String>> getRawAttributes()
{
    // 프로필 속성 겍체 초기화
     Map<String, List<String>> attrs = new HashMap<>(Optional.ofNullable(attributes).orElse(new HashMap<>()));

       if (username != null)
            attrs.put(USERNAME, Collections.singletonList(getUsername()));
        else
            attrs.remove(USERNAME);

        if (email != null)
            attrs.put(EMAIL, Collections.singletonList(getEmail()));
        else
            attrs.remove(EMAIL);

        if (lastName != null)
            attrs.put(LAST_NAME, Collections.singletonList(getLastName()));

        if (firstName != null)
            attrs.put(FIRST_NAME, Collections.singletonList(getFirstName()));

        return attrs;

}
```

- E. 프로필 검증 메서드 호출해 유효성 검사 검증 메서드는 문제가 없다면 널을 반환하고 유효성검사 메서드 분기에서 널이 아니라면 리스폰을 반환하여 재시도 URI 생성
- F. 유저모델 객체를 생성 = 프로필.크리에이트 메서드 할당
- G. 스테틱메서드 RepresentationToModel.createCredentials(rep, session, realm, user, true); 호출하여 유저 생성
  - 파라미터 ( 유저리프리젠테이션 객체, 세션 객체 렐를 객체 , 유저모델 객체, true )
  - 
- ___return___ 리스폰 객체에 유저아이디를 추가해 uri 생성 반환

정리 :




# 유저 생성 및 인증 JPA with Postgres

- [`CredentialEntity`](CredentialEntity.java)  
- [`CredentialEntity`](CredentialEntity.java)

1. 엔터티
- @NamedQueries `(` `{` @NamedQuery`(name="credentialByUser", query="select cred from CredentialEntity cred where cred.user = :user order by cred.priority")`  `}` `)`
  - 쿼리를 정의 후 메서드 네임을 붙여 메서드를 사용한다    

2. 모델
- 해당 엔터티의 인터페이스 정의

3. JpaUserProvider & JpaUserCredentialStore

- private final `JpaUserCredentialStore` `credentialStore`;
-  CredentialModel createCredential(RealmModel realm, UserModel user, `CredentialModel` cred)
    - CredentialEntity entity = `credentialStore`.createCredentialEntity(realm, user, cred);
- 프로바이더에서 자격증명생성 인스턴스를 생성해 인스턴스 메서드 호출하여 암호 생성
- 자격증명생성 클래스 내부  자격증명 생성 메서드에는  자젹증명모델을 파라미터로 받아 자격증명엔터티를 생성해 저장
-  CredentialModel ,  CredentialEntity , UserEntity
-  public class `CredentialModel` implements Serializable
  - CredentialModel 에는 비밀번호 암호화 로직과 비밀번호 교차 검증 로직이 포함 되어있다
    - private Map<String, Object> readMapFromJson(boolean secret)
      - String jsonStr = secret ? secretData : credentialData;
    - private void writeMapAsJson(Map<String, Object> map, boolean secret)
       - 암호화데이터 생성 메서드   
       - this.credentialData = jsonStr;
       - this.secretData = jsonStr;

    
   ```JAVA
private Map<String, Object> readMapFromJson(boolean secret) {
        String jsonStr = secret ? secretData : credentialData;
        if (jsonStr == null) {
            return new HashMap<>();
        }

        try {
            return JsonSerialization.readValue(jsonStr, Map.class);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private void writeMapAsJson(Map<String, Object> map, boolean secret) {
        try {
            String jsonStr = JsonSerialization.writeValueAsString(map);
            if (secret) {
                this.secretData = jsonStr;
            } else {
                this.credentialData = jsonStr;
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

  ```

 # JpaUserCredentialStore
- 암호화 ㅓ로직 생성 메서드
- 크레덴셜 엔터티에 포함된 알고리즘 적용 메서드 호출
```JAVA
    CredentialModel toModel(CredentialEntity entity) {
        CredentialModel model = new CredentialModel();
        model.setId(entity.getId());
        model.setType(entity.getType());
        model.setCreatedDate(entity.getCreatedDate());
        model.setUserLabel(entity.getUserLabel());

        // Backwards compatibility - users from previous version still have "salt" in the DB filled.
        // We migrate it to new secretData format on-the-fly
        if (entity.getSalt() != null) {
            String newSecretData = entity.getSecretData().replace("__SALT__", Base64.encodeBytes(entity.getSalt()));
            entity.setSecretData(newSecretData);
            entity.setSalt(null);
        }

        model.setSecretData(entity.getSecretData());
        model.setCredentialData(entity.getCredentialData());
        return model;
    }
```

---

### GPT EXPLAIN

이 코드의 목적은 JSON 문자열을 Map<String, Object> 형식의 Java 객체로 변환하거나, Java 객체를 JSON 문자열로 변환하는 기능을 제공하는 것입니다. 이를 통해 secretData와 credentialData라는 두 가지 데이터 소스의 JSON 데이터를 처리할 수 있습니다.

코드는 두 개의 메서드로 구성되어 있습니다:
```JAVA
readMapFromJson(boolean secret)
```
> 이 메서드는 JSON 문자열을 읽고 이를 Map<String, Object> 형식으로 변환합니다.
- 매개변수:
secret: 이 플래그가 true이면 secretData에서 JSON을 읽고, false이면 credentialData에서 JSON을 읽습니다.
- 동작:
secret 값에 따라 jsonStr 변수가 secretData 또는 credentialData 값을 받습니다.
만약 jsonStr이 null이면 빈 HashMap을 반환합니다.
그렇지 않으면, JsonSerialization.readValue()를 사용하여 JSON 문자열을 Map<String, Object>로 변환합니다.
JSON 변환 중 문제가 발생하면 IOException을 캐치하고, 이를 RuntimeException으로 래핑해 던집니다.

```JAVA
writeMapAsJson(Map<String, Object> map, boolean secret)
```
> 이 메서드는 Map<String, Object>를 JSON 문자열로 변환하여 저장합니다.
- 매개변수:
map: JSON으로 변환할 Map<String, Object> 객체.
secret: 이 값에 따라 변환된 JSON 문자열을 secretData에 저장할지, credentialData에 저장할지를 결정합니다.
- 동작:
JsonSerialization.writeValueAsString()을 사용해 주어진 map을 JSON 문자열로 변환합니다.
secret 값에 따라 변환된 JSON 문자열을 secretData 또는 credentialData에 저장합니다.
변환 중 오류가 발생하면 IOException을 캐치하고, 이를 RuntimeException으로 래핑해 던집니다.
- 주요 사용 예:
JSON 문자열을 Java의 Map<String, Object> 형태로 읽거나, 그 반대로 변환할 때 사용됩니다.
보안 데이터와 비보안 데이터를 구분하여 저장하거나 불러오는 상황에서 사용될 수 있습니다.
이 코드에서 중요한 점은 오류 처리 부분에서 IOException을 RuntimeException으로 변환하고 있다는 점인데, 이는 체크 예외를 언체크 예외로 처리해 코드가 더 단순해지도록 도와줍니다.
