package org.codepenguin.labs.pypl.controller;

import org.codepenguin.labs.pypl.model.dto.PyplTopIndexResponse;
import org.codepenguin.labs.pypl.model.entity.PyplTopIdeIndex;
import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.codepenguin.labs.pypl.model.service.PyplTopIdeIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pypl/current/index")
public class PyPlIndexDataController {

    @Autowired
    private PyplTopIdeIndexService pyplTopIdeIndexService;

    @GetMapping("/ide")
    public ResponseEntity<PyplTopIndexResponse<PyplTopIdeIndex>> getCurrentIndices() throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIdeIndexService.getCurrentIndices());
    }
}
