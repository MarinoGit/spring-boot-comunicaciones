package com.marino.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador del que extenderán el resto.
 *
 * @author marinovilchez
 * @soundtrack Nudozurdo - Genocida Bilingüe
 * @fecha 11/5/17
 */

@RestController
public abstract class Controller {

    protected ResponseEntity<?> processResponse(Response<?> response) {
        if (HttpStatus.OK.equals(response.getHttpStatus())) {
            return new ResponseEntity<>(response.getData(), response.getHttpStatus());
        } else {
            return new ResponseEntity<>(response.getResponseError(), response.getHttpStatus());
        }
    }
}