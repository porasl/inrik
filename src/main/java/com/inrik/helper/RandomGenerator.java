package com.inrik.helper;

import java.security.SecureRandom;
import java.math.BigInteger;

public final class RandomGenerator {
  private SecureRandom random = new SecureRandom();

  public String nextRandom() {
    return new BigInteger(130, random).toString(20);
  }
}