package org.codepenguin.labs.pypl.model.service;

import org.codepenguin.labs.pypl.model.dto.PyplTopIndexResponse;
import org.codepenguin.labs.pypl.model.entity.AbstractPyplTopIndex;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.codepenguin.labs.pypl.model.repository.PyplTopIndexRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PyplTopIndexService {

    private final PyplTopIndexRepositoryFacade pyplTopIndexRepositoryFacade;

    @Autowired
    public PyplTopIndexService(PyplTopIndexRepositoryFacade pyplTopIndexRepositoryFacade) {
        this.pyplTopIndexRepositoryFacade = pyplTopIndexRepositoryFacade;
    }


    public <T extends AbstractPyplTopIndex> PyplTopIndexResponse<T> getCurrentIndices(final Class<T> type)
            throws PyplTopIndexException {
        return new PyplTopIndexResponse<T>(LocalDate.now(), pyplTopIndexRepositoryFacade.getCurrentIndices(type));
    }
}
