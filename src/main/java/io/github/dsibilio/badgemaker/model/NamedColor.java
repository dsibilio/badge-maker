package io.github.dsibilio.badgemaker.model;

/**
 * Precompiled translation of common color names to their hexadecimal representation.
 *
 * @author Domenico Sibilio
 */
public enum NamedColor implements HexColor {
  /**
   * Bright Green
   */
  BRIGHTGREEN("#4c1"),
  /**
   * Green
   */
  GREEN("#97ca00"),
  /**
   * Yellow
   */
  YELLOW("#dfb317"),
  /**
   * Yellow green
   */
  YELLOWGREEN("#a4a61d"),
  /**
   * Orange
   */
  ORANGE("#fe7d37"),
  /**
   * Red
   */
  RED("#e05d44"),
  /**
   * Blue
   */
  BLUE("#007ec6"),
  /**
   * Grey
   */
  GREY("#555"),
  /**
   * Light grey
   */
  LIGHTGREY("#9f9f9f");

  private final String hexColor;

  NamedColor(String hexColor) {
    this.hexColor = hexColor;
  }

  public String getHexColor() {
    return hexColor;
  }
}
