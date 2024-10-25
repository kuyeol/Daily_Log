package com.fkereki.mvpproject.client.i18n;

import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;

@DefaultLocale("en")
public interface MyMessages
    extends Messages {

  @DefaultMessage("You got {0} things")
  @PluralText( { "one", "You got a single thing." })
  String howMany(@PluralCount int count);

  @DefaultMessage("I was born in {0} so now I''m {1} years old.")
  String sayAge(int year, int age);

  @DefaultMessage("I was born in {0} so now I''m {1} years old.")
  @PluralText( { "one",
      "I was born in {0} so now I''m just one year old." })
  String sayAge2(int year, @PluralCount int age);

  @DefaultMessage("Good- bye, {0}")
  String sayGoodbye(String whom);
}
