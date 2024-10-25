package com.fkereki.mvpproject.client;

public class Html {

  /*
   * Do minimal changes (as in
   * www.php.net/manual/en/function.htmlspecialchars.php) so the output XML
   * won't include wrong characters.
   */
  public static String htmlSpecialChars(final String inp) {
    String aux = inp;
    aux = aux.replace("&", "&amp;");
    aux = aux.replace("\"", "&quot;");
    aux = aux.replace("'", "&apos;");
    aux = aux.replace("<", "&lt;");
    aux = aux.replace(">", "&gt;");
    return aux;
  }
}