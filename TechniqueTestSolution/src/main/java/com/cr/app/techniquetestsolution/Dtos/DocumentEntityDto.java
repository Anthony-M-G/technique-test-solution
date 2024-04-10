package com.cr.app.techniquetestsolution.Dtos;

import com.cr.app.techniquetestsolution.Entities.DocumentEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link DocumentEntity}
 */

public record DocumentEntityDto(@NotEmpty @NotBlank String title, @NotEmpty @NotBlank String body,
                                @NotNull Set<AuthorDto> authors) implements Serializable {
}