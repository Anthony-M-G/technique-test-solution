package com.cr.app.techniquetestsolution.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.cr.app.techniquetestsolution.Entities.Author}
 */

public record AuthorDto(@NotEmpty @NotBlank String firstName,
                        @NotEmpty @NotBlank String lastName) implements Serializable {
}