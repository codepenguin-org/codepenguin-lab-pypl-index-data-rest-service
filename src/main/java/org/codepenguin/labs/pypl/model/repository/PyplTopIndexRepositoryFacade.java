package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.*;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PyplTopIndexRepositoryFacade {

    private final PyplTopIndexRepository<PyplTopProgrammingLanguageIndex> pyplTopProgrammingLanguageIndexRepository;
    private final PyplTopIndexRepository<PyplTopIdeIndex> pyplTopIdeIndexRepository;
    private final PyplTopIndexRepository<PyplTopOdeIndex> pyplTopOdeIndexRepository;
    private final PyplTopIndexRepository<PyplTopDatabaseIndex> pyplTopDatabaseIndexRepository;

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
