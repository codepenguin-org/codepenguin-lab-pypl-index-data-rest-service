package org.codepenguin.labs.pypl.model.service;

import org.codepenguin.labs.pypl.model.dto.PyplTopIndexResponse;
import org.codepenguin.labs.pypl.model.entity.PyplTopIdeIndex;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.codepenguin.labs.pypl.model.repository.PyplTopIdeIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PyplTopIdeIndexService implements PyplTopIndexService<PyplTopIdeIndex> {

    private final PyplTopIdeIndexRepository pyplTopIdeIndexRepository;

    @Autowired
    public PyplTopIdeIndexService(PyplTopIdeIndexRepository pyplTopIdeIndexRepository) {
        this.pyplTopIdeIndexRepository = pyplTopIdeIndexRepository;
    }

    @Override
    public PyplTopIndexResponse<PyplTopIdeIndex> getCurrentIndices() throws PyplTopIndexException {
        return new PyplTopIndexResponse<>(LocalDate.now(), pyplTopIdeIndexRepository.getCurrentIndices());
    }
}
