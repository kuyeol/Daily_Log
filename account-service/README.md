
# 유저 생성 및 인증 JPA with Postgres



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
