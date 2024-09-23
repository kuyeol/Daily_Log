
# 유저 생성 및 인증 JPA with Postgres



1. 엔터티
- @NamedQueries `(` `{` @NamedQuery`(name="credentialByUser", query="select cred from CredentialEntity cred where cred.user = :user order by cred.priority")`  `}` `)`
  - 쿼리를 정의 후 메서드 네임을 붙여 메서드를 사용한다    

2. 모델
- 해당 엔터티의 인터페이스 정의

3. JpaUserProvider & JpaUserCredentialStore

- private final JpaUserCredentialStore `credentialStore`;
  
-  CredentialModel createCredential(RealmModel realm, UserModel user, CredentialModel cred)
    - CredentialEntity entity = `credentialStore`.createCredentialEntity(realm, user, cred);
- 프로바이더에서 스토어 인스턴스 생성해 인스턴스 메서드 호출하여 암호 생성
