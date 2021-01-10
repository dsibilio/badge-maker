package io.github.dsibilio.badgemaker.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;

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

}
