package io.github.dsibilio.badgemaker.model;

/**
 * @author Domenico Sibilio
 */
public enum NamedColor {
  BRIGHTGREEN("#4c1"),
  GREEN("#97ca00"),
  YELLOW("#dfb317"),
  YELLOWGREEN("#a4a61d"),
  ORANGE("#fe7d37"),
  RED("#e05d44"),
  BLUE("#007ec6"),
  GREY("#555"),
  LIGHTGREY("#9f9f9f");

  private String hexColor;

  NamedColor(String hexColor) {
    this.hexColor = hexColor;
  }

  public String getHexColor() {
    return hexColor;
  }
}
