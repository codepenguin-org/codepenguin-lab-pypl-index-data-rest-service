package org.codepenguin.labs.pypl.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
public class PyplTopProgrammingLanguageIndex extends AbstractPyplTopIndex {

    @Serial
    private static final long serialVersionUID = -2075413052211097178L;

    private String language;

    public PyplTopProgrammingLanguageIndex() {
        super();
    }

    public PyplTopProgrammingLanguageIndex(Integer rank, Double share, Double trend, String language) {
        super(rank, share, trend);
        this.language = language;
    }
}
