package io.github.dsibilio.badgemaker.core;

import static io.github.dsibilio.badgemaker.core.BadgeRenderer.*;

import io.github.dsibilio.badgemaker.model.BadgeFormat;

/**
 * @author Domenico Sibilio
 */
public class BadgeMaker {

  private BadgeMaker() {
    throw new IllegalStateException("Do not instantiate this class");
  }

  /**
   * Given a badge format, generate an SVG badge
   * @param badgeFormat the requested badge format
   * @return the SVG string representation of the requested badge
   * @throws IllegalArgumentException if badgeFormat is malformed
   */
  public static String makeBadge(BadgeFormat badgeFormat) {
    validate(badgeFormat);
    return stripXmlWhitespace(render(badgeFormat));
  }

  private static void validate(BadgeFormat badgeFormat) {
    if(badgeFormat.getMessage() == null || badgeFormat.getMessage().trim().isEmpty()) {
      throw new IllegalArgumentException("'message' cannot be null or empty");
    }
  }

  private static String stripXmlWhitespace(String xml) {
    return xml.replaceAll(">\\s+", ">").replaceAll("<\\s+",  "<");
  }

}
