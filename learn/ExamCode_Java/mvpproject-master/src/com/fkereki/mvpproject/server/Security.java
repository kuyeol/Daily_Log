package com.fkereki.mvpproject.server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.RandomStringUtils;

public class Security {
  /**
   * Convert any String into an Hex equivalent; for example, "AtoZ" becomes
   * "41746f5a". This is intended to produce a legible, pure ASCII, equivalent
   * of the original string.
   * 
   * @param s
   *          String to be converted
   * @return Hex equivalent of the input string
   */
  public static String byteStringToHexString(final String s) {
    String r = "";
    for (int i = 0; i < s.length(); i++) {
      r += byteToHexChars(s.charAt(i));
    }
    return r;
  }

  /**
   * Convert a number (0..255) into its two-character equivalent. For example,
   * 15 returns "0F" and 100 returns "64".
   * 
   * @param i
   *          Number to be converted
   * @return Hex equivalent, in two characters.
   */
  public static String byteToHexChars(final int i) {
    final String s = "0" + Integer.toHexString(i);
    return s.substring(s.length() - 2);
  }

  /**
   * Revert the effect of byteStringToHexString(...); given an Hex equivalent
   * string such as "41746f5a", produce the original "AtoZ".
   * 
   * @param s
   *          Hex string to be converted
   * @return Original string
   */
  public static String hexStringToByteString(final String s) {
    String r = "";
    for (int i = 0; i < s.length(); i += 2) {
      r += (char) Integer.parseInt(s.substring(i, i + 2), 16);
    }
    return r;
  }

  public static String md5(final String text) {
    String hashword = null;
    try {
      final MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(text.getBytes());
      final BigInteger hash = new BigInteger(1, md5.digest());
      hashword = hash.toString(16);
    } catch (final NoSuchAlgorithmException nsae) {
    }

    while (hashword.length() < 32) {
      hashword = "0" + hashword;
    }
    return hashword;
  }

  /**
   * Generates a string of 32 letters (A to Z)
   * 
   * @return A string formed by 32 A-to-Z random letters.
   */
  public static String randomCharString() {
    return RandomStringUtils.randomAlphabetic(32);
  }

  private final byte sbox[] = new byte[256];
  private int i;

  private int j;

  /**
   * Assuming everything was set up earlier, encode plaintext. This can be done
   * in stream fashion; sequential calls to this routine will be the same as a
   * single call with a longer parameter. In other words, as Benny Hill had it,
   * codeDecode("THE")+codeDecode("RAPIST") equals codeDecode("THERAPIST")
   * 
   * @param plaintext
   *          Text to encode
   * @return Encoded equivalent
   */
  public String codeDecode(final String plaintext) {
    byte x;
    String r = "";
    final int pl = plaintext.length();
    for (int k = 0; k < pl; k++) {
      i = i + 1 & 0xff;
      j = j + sbox[i] & 0xff;

      x = sbox[i];
      sbox[i] = sbox[j];
      sbox[j] = x;

      r += (char) (plaintext.charAt(k) ^ sbox[sbox[i] + sbox[j] & 0xff] & 0xff);
    }
    return r;
  }

  /**
   * Set up the key, and use it to encode plaintext
   * 
   * @param key
   * @param plaintext
   * @return
   */
  public String codeDecode(final String key, final String plaintext) {

    setUp(key);
    return codeDecode(plaintext);
  }

  /**
   * Set up the internal parameters (sbox, i, j) so we can start decoding right
   * away
   * 
   * @param key
   */
  public void setUp(final String key) {
    int k;
    byte x;

    for (i = 0; i < 256; i++) {
      sbox[i] = (byte) i;
    }

    final int kl = key.length();
    for (i = 0, j = 0, k = 0; i < 256; i++) {
      j = j + sbox[i] + key.charAt(k) & 0xff;
      k = (k + 1) % kl;

      x = sbox[i];
      sbox[i] = sbox[j];
      sbox[j] = x;
    }

    // Set things up to start coding/decoding

    i = 0;
    j = 0;
  }
}
