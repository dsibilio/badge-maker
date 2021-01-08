package io.github.dsibilio.badgemaker.core;

import org.javastack.fontmetrics.SimpleFontMetrics;

import io.github.dsibilio.badgemaker.model.BadgeFormat;

/**
 * @author Domenico Sibilio
 */
class BadgeRenderer {

  private BadgeRenderer() {
    throw new IllegalStateException("Do not instantiate this class");
  }

  public static String render(BadgeFormat badgeFormat) {
    return new BadgeRenderer.Template(badgeFormat).getTemplate();
  }

  static class Template {

    private static final String FORMAT = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"${width}\" height=\"${height}\">\r\n"
        + "    <linearGradient id=\"s\" x2=\"0\" y2=\"100%\">\r\n"
        + "        <stop offset=\"0\" stop-color=\"#bbb\" stop-opacity=\".1\"/>\r\n"
        + "        <stop offset=\"1\" stop-opacity=\".1\"/>\r\n"
        + "    </linearGradient>\r\n"
        + "    <clipPath id=\"r\">\r\n"
        + "        <rect width=\"${width}\" height=\"${height}\" rx=\"3\" fill=\"#fff\"/>\r\n"
        + "    </clipPath>\r\n"
        + "    <g clip-path=\"url(#r)\">\r\n"
        + "        <rect width=\"${leftWidth}\" height=\"${height}\" fill=\"${labelColor}\"/>\r\n"
        + "        <rect x=\"${leftWidth}\" width=\"${rightWidth}\" height=\"${height}\" fill=\"${messageColor}\"/>\r\n"
        + "        <rect width=\"${width}\" height=\"${height}\" fill=\"url(#s)\"/>\r\n"
        + "    </g>\r\n"
        + "    <g fill=\"#fff\" text-anchor=\"middle\" font-family=\"Verdana,Geneva,DejaVu Sans,sans-serif\" text-rendering=\"geometricPrecision\" font-size=\"110\">\r\n"
        + "        <image xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" visibility=\"${hasLogo}\" x=\"5\" y=\"3\" width=\"14\" height=\"14\" xlink:href=\"${logo}\"/>"
        + "        <text x=\"${leftX}\" y=\"${shadowMargin}\" fill=\"#010101\" fill-opacity=\".3\" transform=\"scale(.1)\" textLength=\"${leftLength}\">${leftText}</text>\r\n"
        + "        <text x=\"${leftX}\" y=\"${textMargin}\" transform=\"scale(.1)\" textLength=\"${leftLength}\">${leftText}</text>\r\n"
        + "        <text x=\"${rightX}\" y=\"${shadowMargin}\" fill=\"#010101\" fill-opacity=\".3\" transform=\"scale(.1)\" textLength=\"${rightLength}\">${rightText}</text>\r\n"
        + "        <text x=\"${rightX}\" y=\"${textMargin}\" transform=\"scale(.1)\" textLength=\"${rightLength}\">${rightText}</text>\r\n"
        + "    </g>\r\n"
        + "</svg>";

    private static final int HEIGHT = 20;
    private static final int VERTICAL_MARGIN = 0;
    private static final int SHADOW_MARGIN = 150 + VERTICAL_MARGIN;
    private static final int TEXT_MARGIN = 140 + VERTICAL_MARGIN;
    private static final int HORIZONTAL_PADDING = 5;
    private static final int LEFT_MARGIN = 1;
    private final int leftX;
    private final int leftWidth;
    private final int rightMargin;
    private final int rightX;
    private final int rightWidth;
    private final int width;
    private final String leftText;
    private final String rightText;
    private final String labelColor;
    private final String messageColor;
    private final String logo;
    private final boolean hasLogo;
    private int leftLength;
    private int rightLength;

    public Template(BadgeFormat badgeFormat) {
      logo = escapeXml(badgeFormat.getLogo());
      hasLogo = logo != null && !logo.isEmpty();
      int logoOffset = hasLogo ? 15 : 0;

      leftText = escapeXml(badgeFormat.getLabel());
      leftLength = getTextLength(leftText);
      leftX = (int) (10 * (LEFT_MARGIN + 0.5f * leftLength + HORIZONTAL_PADDING + logoOffset));
      leftWidth = leftLength + 2 * HORIZONTAL_PADDING + logoOffset;

      rightMargin = leftWidth - 1;
      rightText = escapeXml(badgeFormat.getMessage());
      rightLength = getTextLength(rightText);
      rightX = (int) (10 * (rightMargin + 0.5f * rightLength + HORIZONTAL_PADDING));
      rightWidth = rightLength + 2 * HORIZONTAL_PADDING;

      width = leftWidth + rightWidth;
      leftLength *= 10;
      rightLength *= 10;

      labelColor = badgeFormat.getLabelColor().getHexColor();
      messageColor = badgeFormat.getMessageColor().getHexColor();
    }

    public String getTemplate() {
      return FORMAT
          .replace(toPlaceholder("leftText"), leftText)
          .replace(toPlaceholder("rightText"), rightText)
          .replace(toPlaceholder("height"), str(HEIGHT))
          .replace(toPlaceholder("width"), str(width))
          .replace(toPlaceholder("leftWidth"), str(leftWidth))
          .replace(toPlaceholder("rightWidth"), str(rightWidth))
          .replace(toPlaceholder("shadowMargin"), str(SHADOW_MARGIN))
          .replace(toPlaceholder("textMargin"), str(TEXT_MARGIN))
          .replace(toPlaceholder("leftX"), str(leftX))
          .replace(toPlaceholder("rightX"), str(rightX))
          .replace(toPlaceholder("leftLength"), str(leftLength))
          .replace(toPlaceholder("rightLength"), str(rightLength))
          .replace(toPlaceholder("labelColor"), labelColor)
          .replace(toPlaceholder("messageColor"), messageColor)
          .replace(toPlaceholder("hasLogo"), hasLogo ? "visible" : "hidden")
          .replace(toPlaceholder("logo"), logo);
    }

    private static String toPlaceholder(String var) {
      return String.format("${%s}", var);
    }

    private static String str(int i) {
      return String.valueOf(i);
    }

    private static String escapeXml(String xml) {
      if(xml == null || xml.isEmpty())
        return "";

      return xml
          .replace("&", "&amp;")
          .replace("<", "&lt;")
          .replace(">", "&gt;")
          .replace("\"", "&quot;")
          .replace("'", "&apos;");
    }

    private static int getTextLength(String text) {
      SimpleFontMetrics metrics = SimpleFontMetrics.getInstance();
      int w = metrics.widthOf(text) / 10;
      return (w & 1) == 0 ? w + 1 : w;
    }

  }

}
