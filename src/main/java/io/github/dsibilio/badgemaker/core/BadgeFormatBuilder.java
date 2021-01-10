package io.github.dsibilio.badgemaker.core;

import java.util.Objects;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;

/**
 * A builder for {@link BadgeFormat} instances
 * @author Domenico Sibilio
 */
public class BadgeFormatBuilder {

  private final String message;
  private String label;
  private NamedColor labelColor = NamedColor.GREY;
  private NamedColor messageColor = NamedColor.BRIGHTGREEN;
  private String logo;

  /**
   * It is recommended to use this builder to
   * create {@link BadgeFormat} instances.
   * @param message the badge message
   */
  public BadgeFormatBuilder(String message) {
    Objects.requireNonNull(message, "'message' cannot be null");
    this.message = message.trim();
  }

  /**
   * @param label the badge label
   * @return the builder
   */
  public BadgeFormatBuilder withLabel(String label) {
    this.label = label;
    return this;
  }

  /**
   * @param labelColor the badge label's color
   * @return the builder
   */
  public BadgeFormatBuilder withLabelColor(NamedColor labelColor) {
    Objects.requireNonNull(labelColor, "'labelColor' cannot be null");
    this.labelColor = labelColor;
    return this;
  }

  /**
   * @param messageColor the badge message color
   * @return the builder
   */
  public BadgeFormatBuilder withMessageColor(NamedColor messageColor) {
    Objects.requireNonNull(messageColor, "'messageColor' cannot be null");
    this.messageColor = messageColor;
    return this;
  }

  /**
   * The logo, must be SVG converted with Base64 encoding.<br>
   * E.g.: data:image/svg+xml;base64,PHN2b...
   * @param logo the badge logo
   * @return the builder
   */
  public BadgeFormatBuilder withLogo(String logo) {
    this.logo = logo;
    return this;
  }

  /**
   * 
   * @return the build {@link BadgeFormat}
   */
  public BadgeFormat build() {
    return new BadgeFormat(label, message, labelColor, messageColor, logo);
  }

}
