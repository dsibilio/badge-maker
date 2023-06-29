package io.github.dsibilio.badgemaker.core;

import static io.github.dsibilio.badgemaker.model.BadgeFormat.SCALE_MULTI_LOWER_BOUND;
import static io.github.dsibilio.badgemaker.model.BadgeFormat.SCALE_MULTI_UPPER_BOUND;

import java.util.Objects;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.HexColor;
import io.github.dsibilio.badgemaker.model.NamedColor;

/**
 * A builder for {@link BadgeFormat} instances
 * @author Domenico Sibilio
 */
public class BadgeFormatBuilder {

  private final String message;
  private String label;
  private HexColor labelColor = NamedColor.GREY;
  private HexColor messageColor = NamedColor.BRIGHTGREEN;
  private String logo;
  private int scaleMultiplier;

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
  public BadgeFormatBuilder withLabelColor(HexColor labelColor) {
    Objects.requireNonNull(labelColor, "'labelColor' cannot be null");
    this.labelColor = labelColor;
    return this;
  }

  /**
   * @param messageColor the badge message color
   * @return the builder
   */
  public BadgeFormatBuilder withMessageColor(HexColor messageColor) {
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
   * @param scaleMultiplier the scale multiplier to be applied to the badge, e.g. 2 = 2x the original size.
   * It must be within {@link BadgeFormat#SCALE_MULTI_LOWER_BOUND} and {@link BadgeFormat#SCALE_MULTI_UPPER_BOUND}.
   * @return the builder
   */
  public BadgeFormatBuilder withScaleMultiplier(int scaleMultiplier) {
    if (scaleMultiplier < SCALE_MULTI_LOWER_BOUND || scaleMultiplier > SCALE_MULTI_UPPER_BOUND) {
      throw new IllegalArgumentException(String.format("'scaleMultiplier' must be within %d and %d", SCALE_MULTI_LOWER_BOUND, SCALE_MULTI_UPPER_BOUND));
    }

    this.scaleMultiplier = scaleMultiplier;
    return this;
  }

  /**
   * 
   * @return the build {@link BadgeFormat}
   */
  public BadgeFormat build() {
    return new BadgeFormat(label, message, labelColor, messageColor, logo, scaleMultiplier);
  }

}
