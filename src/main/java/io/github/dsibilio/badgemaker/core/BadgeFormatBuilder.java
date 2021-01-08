package io.github.dsibilio.badgemaker.core;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;

/**
 * A builder for {@link BadgeFormat} instances
 * @author Domenico Sibilio
 */
public class BadgeFormatBuilder {

  private final String message;
  private String label;
  private NamedColor labelColor;
  private NamedColor messageColor;
  private String logo;

  /**
   * It is recommended to use this builder to
   * create {@link BadgeFormat} instances.
   * @param message the badge message
   */
  public BadgeFormatBuilder(String message) {
    this.message = message.trim();
  }

  /**
   * @param label the badge label
   * @return the builder
   */
  public BadgeFormatBuilder withLabel(String label) {
    this.label = label.trim();
    return this;
  }

  /**
   * @param labelColor the badge label's color
   * @return the builder
   */
  public BadgeFormatBuilder withLabelColor(NamedColor labelColor) {
    this.labelColor = labelColor;
    return this;
  }

  /**
   * @param messageColor the badge message color
   * @return the builder
   */
  public BadgeFormatBuilder withMessageColor(NamedColor messageColor) {
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
    this.logo = logo.trim();
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
