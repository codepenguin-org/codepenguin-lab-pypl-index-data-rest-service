package org.codepenguin.labs.pypl.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
public class PyplTopOdeIndex extends AbstractPyplTopIndex {

    @Serial
    private static final long serialVersionUID = 8204358573754077435L;

    private String ode;

    public PyplTopOdeIndex() {
        super();
    }

    public PyplTopOdeIndex(Integer rank, Double share, Double trend, String ode) {
        super(rank, share, trend);
        this.ode = ode;
    }
}
