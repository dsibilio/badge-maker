# badge-maker

A lightweight Java SVG badge/shield generation library.

![Badges Example](./examples/badges.png)

# Usage

```java
// logos can be embedded as base64 encoded SVGs (optional)
String logo = "data:image/svg+xml;base64,PHN2ZyBmaWxsPSIjNEU5QkNEIiByb2xlPSJpbWciIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgdmlld0JveD0iMCAwIDI0IDI0Ij48dGl0bGU+U29uYXJRdWJlIGljb248L3RpdGxlPjxwYXRoIGQ9Ik0xNS42ODUuMzg2bC0uNDY1Ljc2NmMzLjQ3NyAyLjExMiA2LjMwNSA1LjI3IDcuOTY2IDguODlMMjQgOS42N0MyMi4yNjYgNS44ODcgMTkuMzEzIDIuNTkgMTUuNjg1LjM4NnpNOC40NjIuOTFsLS4zMDUgMS4wNzVjNi44OSAxLjk3NiAxMi4zODQgNy42NCAxMy45OTcgMTQuNDIxbDEuMDg1LS4yNThDMjEuNTM1IDguOTc3IDE1LjczNSAyLjk5NyA4LjQ2Mi45MDl6TTAgMi42Njd2MS4zNDJjMTAuOTYzIDAgMTkuODgzIDguNzk1IDE5Ljg4MyAxOS42MDVoMS4zNDJjMC0xMS41NS05LjUyMi0yMC45NDctMjEuMjI1LTIwLjk0N3oiLz48L3N2Zz4=";

// build your badge specification via the BadgeFormatBuilder API
BadgeFormat badgeFormat = new BadgeFormatBuilder("coverage 98.7%") // right-side message (required)
    .withLabel("Sonar") // left-side message (optional)
    .withLabelColor(NamedColor.GREY) // left-side background color (default: GREY)
    .withMessageColor(NamedColor.BRIGHTGREEN) // right-side background color (default: BRIGHTGREEN)
    .withLogo(logo) // logos can be embedded as base64 encoded SVGs (optional)
    .withScaleMultiplier(2) // the scale factor of the rendered badge (default: 1, min: 1, max: 10000)
    .build();

// obtain the badge as image/svg+xml string representation
String badge = BadgeMaker.makeBadge(badgeFormat);

```

# Dependency

## Maven

```xml
<dependency>
  <groupId>io.github.dsibilio</groupId>
  <artifactId>badge-maker</artifactId>
  <version>1.0.4</version>
</dependency>
```

## Gradle
```groovy
compile group: 'io.github.dsibilio', name: 'badge-maker', version: '1.0.3'
```

# References

This project has been inspired by [shields.io](https://shields.io/) and [mavenbadges](https://github.com/ggrandes/mavenbadges).
