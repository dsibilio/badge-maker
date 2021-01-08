package io.github.dsibilio.badgemaker.model;

import io.github.dsibilio.badgemaker.core.BadgeFormatBuilder;
import jakarta.validation.constraints.NotBlank;

/**
 * It is recommended to use the {@link BadgeFormatBuilder}
 * to create instances of this class
 * @author Domenico Sibilio
 */
public class BadgeFormat {

  private String label;
  @NotBlank
  private String message;
  private NamedColor labelColor = NamedColor.GREY;
  private NamedColor messageColor = NamedColor.BRIGHTGREEN;

  public BadgeFormat(String label, String message, NamedColor labelColor, NamedColor messageColor) {
    this.label = label;
    this.message = message;
    this.labelColor = labelColor;
    this.messageColor = messageColor;
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

  @Override
  public String toString() {
    return "BadgeFormat [label=" + label + ", message=" + message + ", labelColor=" + labelColor + ", messageColor="
        + messageColor + "]";
  }

}
