package org.codepenguin.labs.pypl.controller;

import org.codepenguin.labs.pypl.model.dto.PyplTopIndexResponse;
import org.codepenguin.labs.pypl.model.entity.PyplTopDatabaseIndex;
import org.codepenguin.labs.pypl.model.entity.PyplTopIdeIndex;
import org.codepenguin.labs.pypl.model.entity.PyplTopOdeIndex;
import org.codepenguin.labs.pypl.model.entity.PyplTopProgrammingLanguageIndex;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.codepenguin.labs.pypl.model.service.PyplTopIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pypl/current/index")
public class PyPlIndexDataController {

    private final PyplTopIndexService pyplTopIndexService;

    @Autowired
    public PyPlIndexDataController(PyplTopIndexService pyplTopIndexService) {
        this.pyplTopIndexService = pyplTopIndexService;
    }

    @GetMapping("/language")
    public ResponseEntity<PyplTopIndexResponse<PyplTopProgrammingLanguageIndex>> getCurrentProgrammingLanguageIndices()
            throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopProgrammingLanguageIndex.class));
    }

    @GetMapping("/ide")
    public ResponseEntity<PyplTopIndexResponse<PyplTopIdeIndex>> getCurrentIdeIndices() throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopIdeIndex.class));
    }

    @GetMapping("/ode")
    public ResponseEntity<PyplTopIndexResponse<PyplTopOdeIndex>> getCurrentOdeIndices() throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopOdeIndex.class));
    }

    @GetMapping("/db")
    public ResponseEntity<PyplTopIndexResponse<PyplTopDatabaseIndex>> getCurrentDatabaseIndices()
            throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopDatabaseIndex.class));
    }
}
