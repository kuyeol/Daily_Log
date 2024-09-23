
# 유저 생성 및 인증 JPA with Postgres



1. 엔터티
- @NamedQueries `(` `{` @NamedQuery`(name="credentialByUser", query="select cred from CredentialEntity cred where cred.user = :user order by cred.priority")`  `}` `)`
  - 쿼리를 정의 후 메서드 네임을 붙여 메서드를 사용한다    

2. 모델
- 
