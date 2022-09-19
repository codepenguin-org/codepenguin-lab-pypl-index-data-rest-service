package org.codepenguin.labs.pypl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Gets the current programming language indices.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets the indices.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PyplTopIndexResponse.class)
                            )
                    }
            ),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping("/language")
    public ResponseEntity<PyplTopIndexResponse<PyplTopProgrammingLanguageIndex>> getCurrentProgrammingLanguageIndices()
            throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopProgrammingLanguageIndex.class));
    }

    @Operation(summary = "Gets the current IDE indices.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets the indices.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PyplTopIndexResponse.class)
                            )
                    }
            ),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping("/ide")
    public ResponseEntity<PyplTopIndexResponse<PyplTopIdeIndex>> getCurrentIdeIndices() throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopIdeIndex.class));
    }

    @Operation(summary = "Gets the current ODE indices.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets the indices.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PyplTopIndexResponse.class)
                            )
                    }
            ),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping("/ode")
    public ResponseEntity<PyplTopIndexResponse<PyplTopOdeIndex>> getCurrentOdeIndices() throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopOdeIndex.class));
    }

    @Operation(summary = "Gets the current database indices.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets the indices.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PyplTopIndexResponse.class)
                            )
                    }
            ),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping("/db")
    public ResponseEntity<PyplTopIndexResponse<PyplTopDatabaseIndex>> getCurrentDatabaseIndices()
            throws PyplTopIndexException {
        return ResponseEntity.ok(pyplTopIndexService.getCurrentIndices(PyplTopDatabaseIndex.class));
    }
}
