package org.codepenguin.labs.pypl.model.dto;

import java.time.LocalDate;
import java.util.List;

public record PyplTopIndexResponse<T>(LocalDate date, List<T> data) {
}
