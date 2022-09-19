package org.codepenguin.labs.pypl.model.exception;

import java.io.Serial;

public class PyplTopIndexException extends Exception {

    @Serial
    private static final long serialVersionUID = -4416097194815444900L;

    public PyplTopIndexException(String message) {
        super(message);
    }

    public PyplTopIndexException(final Throwable cause) {
        super(cause);
    }


}
