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

package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.*;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Pypl top index repository facade.
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
@Component
public class PyplTopIndexRepositoryFacade {

    private final PyplTopIndexRepository<PyplTopProgrammingLanguageIndex> pyplTopProgrammingLanguageIndexRepository;
    private final PyplTopIndexRepository<PyplTopIdeIndex> pyplTopIdeIndexRepository;
    private final PyplTopIndexRepository<PyplTopOdeIndex> pyplTopOdeIndexRepository;
    private final PyplTopIndexRepository<PyplTopDatabaseIndex> pyplTopDatabaseIndexRepository;

    /**
     * Instantiates a new Pypl top index repository facade.
     *
     * @param pyplTopProgrammingLanguageIndexRepository the pypl top programming language index repository
     * @param pyplTopIdeIndexRepository                 the pypl top ide index repository
     * @param pyplTopOdeIndexRepository                 the pypl top ode index repository
     * @param pyplTopDatabaseIndexRepository            the pypl top database index repository
     */
    @Autowired
    public PyplTopIndexRepositoryFacade(
            @Qualifier("pyplTopProgrammingLanguageIndexRepository")
            PyplTopIndexRepository<PyplTopProgrammingLanguageIndex> pyplTopProgrammingLanguageIndexRepository,
            @Qualifier("pyplTopIdeIndexRepository")
            PyplTopIndexRepository<PyplTopIdeIndex> pyplTopIdeIndexRepository,
            @Qualifier("pyplTopOdeIndexRepository")
            PyplTopIndexRepository<PyplTopOdeIndex> pyplTopOdeIndexRepository,
            @Qualifier("pyplTopDatabaseIndexRepository")
            PyplTopIndexRepository<PyplTopDatabaseIndex> pyplTopDatabaseIndexRepository) {
        this.pyplTopProgrammingLanguageIndexRepository = pyplTopProgrammingLanguageIndexRepository;
        this.pyplTopIdeIndexRepository = pyplTopIdeIndexRepository;
        this.pyplTopOdeIndexRepository = pyplTopOdeIndexRepository;
        this.pyplTopDatabaseIndexRepository = pyplTopDatabaseIndexRepository;
    }

    /**
     * Gets current indices.
     *
     * @param <T>  the type parameter
     * @param type the type
     * @return the current indices
     * @throws PyplTopIndexException the pypl top index exception
     */
    public <T extends AbstractPyplTopIndex> List<T> getCurrentIndices(final Class<T> type)
            throws PyplTopIndexException {
        return getRepository(type).getCurrentIndices();
    }

    @SuppressWarnings("unchecked")
    private <T extends AbstractPyplTopIndex> PyplTopIndexRepository<T> getRepository(final Class<T> type) {
        if (type.equals(PyplTopProgrammingLanguageIndex.class)) {
            return (PyplTopIndexRepository<T>) pyplTopProgrammingLanguageIndexRepository;
        }

        if (type.equals(PyplTopIdeIndex.class)) {
            return (PyplTopIndexRepository<T>) pyplTopIdeIndexRepository;
        }

        if (type.equals(PyplTopOdeIndex.class)) {
            return (PyplTopIndexRepository<T>) pyplTopOdeIndexRepository;
        }

        if (type.equals(PyplTopDatabaseIndex.class)) {
            return (PyplTopIndexRepository<T>) pyplTopDatabaseIndexRepository;
        }

        throw new IllegalArgumentException("Type is not supported: %s".formatted(type.getSimpleName()));
    }
}
