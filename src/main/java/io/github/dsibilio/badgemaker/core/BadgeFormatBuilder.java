package io.github.dsibilio.badgemaker.core;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;

public class BadgeFormatBuilder {

  private final String message;
  private String label;
  private NamedColor labelColor;
  private NamedColor messageColor;

  public BadgeFormatBuilder(String message) {
    this.message = message.trim();
  }

  public BadgeFormatBuilder withLabel(String label) {
    this.label = label.trim();
    return this;
  }

  public BadgeFormatBuilder withLabelColor(NamedColor labelColor) {
    this.labelColor = labelColor;
    return this;
  }

  public BadgeFormatBuilder withMessageColor(NamedColor messageColor) {
    this.messageColor = messageColor;
    return this;
  }

  public BadgeFormat build() {
    return new BadgeFormat(label, message, labelColor, messageColor);
  }

}
