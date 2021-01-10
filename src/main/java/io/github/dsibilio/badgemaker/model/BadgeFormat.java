package io.github.dsibilio.badgemaker.model;

import io.github.dsibilio.badgemaker.core.BadgeFormatBuilder;

/**
 * It is recommended to use the {@link BadgeFormatBuilder}
 * to create instances of this class
 * @author Domenico Sibilio
 */
public class BadgeFormat {

  private String label;
  private String message;
  private NamedColor labelColor;
  private NamedColor messageColor;
  private String logo;

  public BadgeFormat(String label, String message, NamedColor labelColor, NamedColor messageColor, String logo) {
    this.label = label;
    this.message = message;
    this.labelColor = labelColor;
    this.messageColor = messageColor;
    this.logo = logo;
  }

  public String getLabel() {
    return label;
  }
  public void setLabel(String label) {
    this.label = label;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public NamedColor getLabelColor() {
    return labelColor;
  }
  public void setLabelColor(NamedColor labelColor) {
    this.labelColor = labelColor;
  }
  public NamedColor getMessageColor() {
    return messageColor;
  }
  public void setMessageColor(NamedColor messageColor) {
    this.messageColor = messageColor;
  }
  public String getLogo() {
    return logo;
  }
  public void setLogo(String logo) {
    this.logo = logo;
  }

  @Override
  public String toString() {
    return "BadgeFormat [label=" + label + ", message=" + message + ", labelColor=" + labelColor + ", messageColor="
        + messageColor + "]";
  }

}
