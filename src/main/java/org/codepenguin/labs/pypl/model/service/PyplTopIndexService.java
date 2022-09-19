package org.codepenguin.labs.pypl.model.service;

import org.codepenguin.labs.pypl.model.dto.PyplTopIndexResponse;
import org.codepenguin.labs.pypl.model.entity.PyplTopIdeIndex;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;

public interface PyplTopIndexService<T> {
    PyplTopIndexResponse<T> getCurrentIndices() throws PyplTopIndexException;
}
