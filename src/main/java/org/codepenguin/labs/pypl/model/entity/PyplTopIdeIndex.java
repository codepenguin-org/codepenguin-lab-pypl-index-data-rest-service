package org.codepenguin.labs.pypl.model.entity;

import java.io.Serial;
import java.io.Serializable;

public record PyplTopIdeIndex(Integer rank, String ide, Double share, Double trend) implements Serializable {
    
    @Serial
    private static final long serialVersionUID = -7112312392330870701L;
}
