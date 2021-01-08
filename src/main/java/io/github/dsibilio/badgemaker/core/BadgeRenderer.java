package io.github.dsibilio.badgemaker.core;

import io.github.dsibilio.badgemaker.model.BadgeFormat;

/**
 * @author Domenico Sibilio
 */
class BadgeRenderer {

  public static String render(BadgeFormat badgeFormat) {
    return null;
  }

  private static String escapeXml(String xml) {
    return xml
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&apos;");
  }

}
