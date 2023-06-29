package io.github.dsibilio.badgemaker.model;

/**
 * Abstraction for a color in its hexadecimal representation.
 */
@FunctionalInterface
public interface HexColor {
  /**
   * @return the hexadecimal representation of the color
   */
  String getHexColor();
}
