package org.codepenguin.labs.pypl.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractPyplTopIndex implements Serializable {

    @Serial
    private static final long serialVersionUID = 1161015509513831063L;

    private Integer rank;
    private Double share;
    private Double trend;
}
