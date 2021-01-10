package io.github.dsibilio.badgemaker.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import io.github.dsibilio.badgemaker.model.NamedColor;

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
  void makeBadgeWithLogoShouldWork() {
    String logo = "data:image/svg+xml;base64,PHN2ZyBmaWxsPSIjNEU5QkNEIiByb2xlPSJpbWciIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgdmlld0JveD0iMCAwIDI0IDI0Ij48dGl0bGU+U29uYXJRdWJlIGljb248L3RpdGxlPjxwYXRoIGQ9Ik0xNS42ODUuMzg2bC0uNDY1Ljc2NmMzLjQ3NyAyLjExMiA2LjMwNSA1LjI3IDcuOTY2IDguODlMMjQgOS42N0MyMi4yNjYgNS44ODcgMTkuMzEzIDIuNTkgMTUuNjg1LjM4NnpNOC40NjIuOTFsLS4zMDUgMS4wNzVjNi44OSAxLjk3NiAxMi4zODQgNy42NCAxMy45OTcgMTQuNDIxbDEuMDg1LS4yNThDMjEuNTM1IDguOTc3IDE1LjczNSAyLjk5NyA4LjQ2Mi45MDl6TTAgMi42Njd2MS4zNDJjMTAuOTYzIDAgMTkuODgzIDguNzk1IDE5Ljg4MyAxOS42MDVoMS4zNDJjMC0xMS41NS05LjUyMi0yMC45NDctMjEuMjI1LTIwLjk0N3oiLz48L3N2Zz4=";

    BadgeFormat badgeFormat = new BadgeFormatBuilder("coverage 98.7%")
        .withLabel("Sonar")
        .withLabelColor(NamedColor.GREY)
        .withMessageColor(NamedColor.BRIGHTGREEN)
        .withLogo(logo)
        .build();

    String badge = BadgeMaker.makeBadge(badgeFormat);
    assertFalse(badge.contains("$"), "The template should be fully parsed");
  }

  @Test
  void makeBadgeShouldThrowWithInvalidBadgeFormat() {
    BadgeFormat badgeFormat = new BadgeFormat(null, null, null, null, null);
    badgeFormat.setLabel("label");
    badgeFormat.setLabelColor(NamedColor.BRIGHTGREEN);
    badgeFormat.setMessageColor(NamedColor.BRIGHTGREEN);
    assertThrows(IllegalArgumentException.class, () -> BadgeMaker.makeBadge(badgeFormat));
  }

}
