package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;

import java.util.List;

public interface PyplTopIndexRepository<T> {
    List<T> getCurrentIndices() throws PyplTopIndexException;
}
