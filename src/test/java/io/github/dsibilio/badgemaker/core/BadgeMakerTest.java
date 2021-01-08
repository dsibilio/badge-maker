package io.github.dsibilio.badgemaker.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;
import jakarta.validation.ConstraintViolationException;

class BadgeMakerTest {

  @Test
  void makeBadgeShouldWork() {
    BadgeFormat badgeFormat = new BadgeFormatBuilder("coverage 98.7%")
        .withLabel("Sonar")
        .withLabelColor(NamedColor.BLUE)
        .withMessageColor(NamedColor.BRIGHTGREEN)
        .build();

    String badge = BadgeMaker.makeBadge(badgeFormat);

    assertFalse(badge.contains("$"), "The template should be fully parsed");
  }

  @Test
  void makeBadgeShouldThrowWithInvalidBadgeFormat() {
    BadgeFormat badgeFormat = new BadgeFormat(null, null, null, null);
    assertThrows(ConstraintViolationException.class, () -> BadgeMaker.makeBadge(badgeFormat));
  }

}
