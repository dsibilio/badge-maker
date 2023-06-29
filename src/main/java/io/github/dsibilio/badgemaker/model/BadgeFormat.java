package io.github.dsibilio.badgemaker.model;

import io.github.dsibilio.badgemaker.core.BadgeFormatBuilder;

/**
 * It is recommended to use the {@link BadgeFormatBuilder}
 * to create instances of this class
 * @author Domenico Sibilio
 */
public class BadgeFormat {

  /**
   * The minimum allowed scale value.
   */
  public static final int SCALE_MULTI_LOWER_BOUND = 1;
  /**
   * The maximum allowed scale value.
   */
  public static final int SCALE_MULTI_UPPER_BOUND = 10000;
  private String label;
  private String message;
  private HexColor labelColor;
  private HexColor messageColor;
  private String logo;
  private int scaleMultiplier;

  /**
   * Please use the {@link BadgeFormatBuilder} API rather than invoking this constructor manually.
   * @param label the badge label
   * @param message the badge message
   * @param labelColor the badge label's color
   * @param messageColor the badge message's color
   * @param logo the badge logo
   * @param scaleMultiplier the badge scale multiplier
   */
  public BadgeFormat(String label, String message, HexColor labelColor, HexColor messageColor, String logo, int scaleMultiplier) {
    this.label = label;
    this.message = message;
    this.labelColor = labelColor;
    this.messageColor = messageColor;
    this.logo = logo;
    this.setScaleMultiplier(scaleMultiplier);
  }

  private static boolean isWithinBounds(int scaleMultiplier) {
    return scaleMultiplier >= SCALE_MULTI_LOWER_BOUND && scaleMultiplier <= SCALE_MULTI_UPPER_BOUND;
  }

  /**
   * Gets the label
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the label
   * @param label the label to set
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Gets the message
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Gets the label color
   * @return the label color
   */
  public HexColor getLabelColor() {
    return labelColor;
  }

  /**
   * Sets the label color
   * @param labelColor the label color to set
   */
  public void setLabelColor(HexColor labelColor) {
    this.labelColor = labelColor;
  }

  /**
   * Gets the message color
   * @return the message color
   */
  public HexColor getMessageColor() {
    return messageColor;
  }

  /**
   * Sets the message color
   * @param messageColor the message color to set
   */
  public void setMessageColor(HexColor messageColor) {
    this.messageColor = messageColor;
  }

  /**
   * Gets the logo
   * @return the logo
   */
  public String getLogo() {
    return logo;
  }

  /**
   * Sets the logo
   * @param logo the logo to set
   */
  public void setLogo(String logo) {
    this.logo = logo;
  }

  /**
   * Gets the scale multiplier
   * @return the scale multiplier
   */
  public int getScaleMultiplier() {
    return scaleMultiplier;
  }

  /**
   * Sets the scale multiplier
   * @param scaleMultiplier the scale multiplier to set
   */
  public void setScaleMultiplier(int scaleMultiplier) {
    this.scaleMultiplier = isWithinBounds(scaleMultiplier) ? scaleMultiplier : 1;
  }

  @Override
  public String toString() {
    return "BadgeFormat [label=" + label + ", labelColor=" + labelColor + ", logo=" + logo + ", message=" + message
        + ", messageColor=" + messageColor + ", scaleMultiplier=" + scaleMultiplier + "]";
  }

}
