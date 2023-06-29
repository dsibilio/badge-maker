package io.github.dsibilio.badgemaker.core;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeFormatBuilderTest {

  @Test
  void buildShouldBeAllowedWithValidMessage() {
    assertNotNull(new BadgeFormatBuilder("message").build());
  }

  @Test
  void defaultColorsShouldBeSet() {
    BadgeFormat badgeFormat = new BadgeFormatBuilder("message").build();
    assertEquals(NamedColor.GREY, badgeFormat.getLabelColor());
    assertEquals(NamedColor.BRIGHTGREEN, badgeFormat.getMessageColor());
  }

  @Test
  void customColorsShouldBeAllowed() {
    BadgeFormat badgeFormat = new BadgeFormatBuilder("message")
        .withLabelColor(() -> "#97ca00")
        .withMessageColor(() -> "#dfb317")
        .build();
    assertEquals(NamedColor.GREEN.getHexColor(), badgeFormat.getLabelColor().getHexColor());
    assertEquals(NamedColor.YELLOW.getHexColor(), badgeFormat.getMessageColor().getHexColor());
  }

  @Test
  void buildShouldNotBeAllowedWithNullMessage() {
    assertThrows(NullPointerException.class, () -> new BadgeFormatBuilder(null));
  }

  @Test
  void buildShouldNotBeAllowedWithNullLabelColor() {
    BadgeFormatBuilder builder = new BadgeFormatBuilder("message");
    assertThrows(NullPointerException.class, () -> builder.withLabelColor(null));
  }

  @Test
  void buildShouldNotBeAllowedWithNullMessageColor() {
    BadgeFormatBuilder builder = new BadgeFormatBuilder("message");
    assertThrows(NullPointerException.class, () -> builder.withMessageColor(null));
  }

  @Test
  void buildShouldNotBeAllowedWithInvalidScaleMultiplier() {
    BadgeFormatBuilder builder = new BadgeFormatBuilder("message");
    assertThrows(IllegalArgumentException.class, () -> builder.withScaleMultiplier(0));
    assertThrows(IllegalArgumentException.class, () -> builder.withScaleMultiplier(-1));
    assertThrows(IllegalArgumentException.class, () -> builder.withScaleMultiplier(10001));
  }

}
