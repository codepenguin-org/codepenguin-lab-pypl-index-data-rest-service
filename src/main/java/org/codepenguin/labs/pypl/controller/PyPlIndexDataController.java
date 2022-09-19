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

/**
 * REST controller for PyPl index data.
 *
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
@RestController
@RequestMapping("/pypl/current/index")
public class PyPlIndexDataController {

    private final PyplTopIndexService pyplTopIndexService;

    /**
     * Instantiates a new Py pl index data controller.
     *
     * @param pyplTopIndexService the pypl top index service
     */
    @Autowired
    public PyPlIndexDataController(PyplTopIndexService pyplTopIndexService) {
        this.pyplTopIndexService = pyplTopIndexService;
    }

    /**
     * Gets current programming language indices.
     *
     * @return the current programming language indices
     * @throws PyplTopIndexException the pypl top index exception
     */
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

    /**
     * Gets current ide indices.
     *
     * @return the current ide indices
     * @throws PyplTopIndexException the pypl top index exception
     */
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

    /**
     * Gets current ode indices.
     *
     * @return the current ode indices
     * @throws PyplTopIndexException the pypl top index exception
     */
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

    /**
     * Gets current database indices.
     *
     * @return the current database indices
     * @throws PyplTopIndexException the pypl top index exception
     */
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
