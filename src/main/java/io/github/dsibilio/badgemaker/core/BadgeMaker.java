package io.github.dsibilio.badgemaker.core;

import static io.github.dsibilio.badgemaker.core.BadgeRenderer.*;

import java.util.Set;

import io.github.dsibilio.badgemaker.model.BadgeFormat;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

/**
 * @author Domenico Sibilio
 */
public class BadgeMaker {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
  
  private BadgeMaker() {
    throw new IllegalStateException("Do not instantiate this class");
  }

  /**
   * Given a badge format, generate an SVG badge
   * @param badgeFormat the requested badge format
   * @return the SVG string representation of the requested badge
   * @throws ConstraintViolationException if badgeFormat is malformed
   */
  public static String makeBadge(BadgeFormat badgeFormat) {
    validate(badgeFormat);
    return stripXmlWhitespace(render(badgeFormat));
  }

  private static void validate(BadgeFormat badgeFormat) {
    Set<ConstraintViolation<BadgeFormat>> validationResult = validator.validate(badgeFormat);

    if(validationResult != null && !validationResult.isEmpty()) {
      throw new ConstraintViolationException(validationResult);
    }
  }

  private static String stripXmlWhitespace(String xml) {
    return xml.replaceAll(">\\s+", ">").replaceAll("<\\s+",  "<");
  }

}
