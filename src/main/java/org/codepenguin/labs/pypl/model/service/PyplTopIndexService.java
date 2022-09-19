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

package org.codepenguin.labs.pypl.model.service;

import org.codepenguin.labs.pypl.model.dto.PyplTopIndexResponse;
import org.codepenguin.labs.pypl.model.entity.AbstractPyplTopIndex;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.codepenguin.labs.pypl.model.repository.PyplTopIndexRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * The type Pypl top index service.
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
@Service
public class PyplTopIndexService {

    private final PyplTopIndexRepositoryFacade pyplTopIndexRepositoryFacade;

    /**
     * Instantiates a new Pypl top index service.
     *
     * @param pyplTopIndexRepositoryFacade the pypl top index repository facade
     */
    @Autowired
    public PyplTopIndexService(PyplTopIndexRepositoryFacade pyplTopIndexRepositoryFacade) {
        this.pyplTopIndexRepositoryFacade = pyplTopIndexRepositoryFacade;
    }


    /**
     * Gets current indices.
     *
     * @param <T>  the type parameter
     * @param type the type
     * @return the current indices
     * @throws PyplTopIndexException the pypl top index exception
     */
    public <T extends AbstractPyplTopIndex> PyplTopIndexResponse<T> getCurrentIndices(final Class<T> type)
            throws PyplTopIndexException {
        return new PyplTopIndexResponse<T>(LocalDate.now(), pyplTopIndexRepositoryFacade.getCurrentIndices(type));
    }
}
