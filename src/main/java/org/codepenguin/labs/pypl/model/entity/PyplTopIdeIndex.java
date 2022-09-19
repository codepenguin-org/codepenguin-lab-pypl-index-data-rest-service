package org.codepenguin.labs.pypl.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
public class PyplTopIdeIndex extends AbstractPyplTopIndex {

    @Serial
    private static final long serialVersionUID = -7112312392330870701L;

    private String ide;

    public PyplTopIdeIndex() {
        super();
    }

    public PyplTopIdeIndex(Integer rank, Double share, Double trend, String ide) {
        super(rank, share, trend);
        this.ide = ide;
    }
}
