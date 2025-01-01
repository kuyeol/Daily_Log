

```JAVA
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        final String regex = "^[a-z0-9!#$%&'*+/=?^_`\\{|\\}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`\\{|\\}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+(?:[A-Z]{2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)\\b$";
        final String string = "";
        
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);
        
        if (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
```

```JAVA

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        final String regex = "(?:[A-Za-z0-9!#$%&'*+/=?.^_`\\{|\\}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`\\{|\\}~-]+)*|\\\"(?:[x01-x08x0bx0cx0e-x1fx21x23-x5bx5d-x7f]|[x01-x09x0bx0cx0e-x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])).){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[x01-x08x0bx0cx0e-x1fx21-x5ax53-x7f]|[x01-x09x0bx0cx0e-x7f])+)])";
        final String string = "\"Maximilian Milde\" <max.milde@freenet.de>,<Telefonkonferenz@telefonkonferenz.de>, \"Model Woman, Petra\" <muster114@googlemail.com>, 'Sample Lady, Eva' <eva.muda@gmx.net>, \"'Sample Man, Bernhard'\" <Mustermann.bernhard@t-online.de>, \"'Sample Woman, Ute'\" <utemusterfrau@gmail.com>, \"'Sample, Gisela'\" <Giselamuster50@gmx.de>, 'Mumann, Helmut' <hemumann@googlemail.com>, \"'Mustermann, Alexander'\" <AlexanderMustermann@web.de>, \"'Muster, Vera'\" <v.muster@web.de>, \"'sample woman, Sandra\"\" <sandra.Musterfrau@gmx.net>, \"'Schubert, Ina\"\" <inas31@gmx.de, Seitz, Irmtraud, Irmtraud.s.e@googlemail.com, Kutz, Holger, Claudia Krüger, Milde, F... Mannheim";
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
```

.

```java
public class PatternConstants {

    // 이메일 패턴
  // RFC 5322 기반, 더 엄격한 검사가 필요할 수 있음
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";


  // 아이디 패턴 (영문, 숫자, 특수 문자 조합, 최소 8자리에서 최대 20자리)
    public static final String ID_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}$";


    // 비밀번호 패턴 (영문, 숫자, 특수 문자 중 2종류 이상 조합, 최소 10자리)
    public static final String PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{10,}$";


    // 비밀번호 패턴 (영문, 숫자, 특수 문자 3종류 조합, 8자리 이상)
  public static final String PASSWORD_PATTERN_COMPLEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";


    // 연속된 문자 패턴 (3개 이상 연속 금지)
    public static final String CONSECUTIVE_CHARS_PATTERN = "(.)\\1{2,}"; // abcdefg123

  // 동일 문자 반복 패턴 (4개 이상 반복 금지)
    public static final String REPEATED_CHARS_PATTERN = "(.)(.*\\1){3,}";  //1111


    // 키보드 패턴 (qwerty, asdf 등) - 추가적인 로직 필요
    // public static final String KEYBOARD_PATTERN = ...;


  // 생년월일 패턴 (yyyyMMdd 형식)
    public static final String BIRTH_DATE_PATTERN = "^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$";


    // 전화번호 패턴
    public static final String PHONE_NUMBER_PATTERN = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";


}
```

**설명:**

* `EMAIL_PATTERN`: 이메일 주소의 기본적인 형식을 검사합니다.  RFC 5322 표준을 완벽하게 준수하지는 않으므로, 더 엄격한 검사가 필요할 수 있습니다.
* `ID_PATTERN`: 영문, 숫자, 특수 문자를 모두 포함하는 최소 8자리에서 최대 20자리의 아이디를 허용합니다.
* `PASSWORD_PATTERN`: 영문, 숫자, 특수 문자 중 2종류 이상을 조합한 최소 10자리의 비밀번호를 허용합니다.
* `PASSWORD_PATTERN_COMPLEX`: 영문 대소문자, 숫자, 특수 문자를 모두 포함하는 8자리 이상의 비밀번호를 허용합니다. (더 복잡한 조합)
* `CONSECUTIVE_CHARS_PATTERN`:  같은 문자가 3개 이상 연속되는 것을 금지합니다.
* `REPEATED_CHARS_PATTERN`:  같은 문자가 4개 이상 반복되는 것을 금지합니다. (문자 사이에 다른 문자가 있어도 4개 이상 반복되면 안됨)
* `BIRTH_DATE_PATTERN`: `yyyyMMdd` 형식의 생년월일을 검사합니다.
* `PHONE_NUMBER_PATTERN`:  `010-xxxx-xxxx`, `011-xxxx-xxxx`, `016-xxxx-xxxx` 등의 휴대폰 번호 형식을 검사합니다.


**사용 예시:**

```java
String password = "MyStrongPassword123!";
String email = "test@example.com";

if (password.matches(PatternConstants.PASSWORD_PATTERN)) {
  System.out.println("Valid password");
} else {
    System.out.println("Invalid password");
}


if (email.matches(PatternConstants.EMAIL_PATTERN)) {
    System.out.println("Valid email");
} else {
  System.out.println("Invalid email");
}
```

**참고:**
* 정규 표현식은 복잡하고 성능에 영향을 줄 수 있으므로, 신중하게 사용해야 합니다.
* 보안 강화를 위해, 패턴 검사 외에도 비밀번호 히스토리 관리, 딕셔너리 공격 방어 등 추가적인 보안 조치를 구현하는 것이 좋습니다.  

