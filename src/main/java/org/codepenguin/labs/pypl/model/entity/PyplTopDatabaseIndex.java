package org.codepenguin.labs.pypl.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
public class PyplTopDatabaseIndex extends AbstractPyplTopIndex {

    @Serial
    private static final long serialVersionUID = -2376764517897893915L;

    private String database;

    public PyplTopDatabaseIndex() {
        super();
    }

    public PyplTopDatabaseIndex(Integer rank, Double share, Double trend, String database) {
        super(rank, share, trend);
        this.database = database;
    }
}
