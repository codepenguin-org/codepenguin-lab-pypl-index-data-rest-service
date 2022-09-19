/*
 * codepenguin-lab-pypl-index-data-rest-service 2022 CodePenguin.org - Jorge Alfonso Garcia Espinosa
 *
 * Creative Commons Attribution 3.0 Unported
 *
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). THE
 * WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW. ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS
 * LICENSE OR COPYRIGHT LAW IS PROHIBITED.
 *
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE
 * EXTENT THIS LICENSE MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED HERE IN
 * CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 */

package org.codepenguin.labs.pypl.model.exception;

import java.io.Serial;

/**
 * The type Pypl top index exception.
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
public class PyplTopIndexException extends Exception {

    @Serial
    private static final long serialVersionUID = -4416097194815444900L;

    /**
     * Instantiates a new Pypl top index exception.
     *
     * @param message the message
     */
    public PyplTopIndexException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Pypl top index exception.
     *
     * @param cause the cause
     */
    public PyplTopIndexException(final Throwable cause) {
        super(cause);
    }


}
