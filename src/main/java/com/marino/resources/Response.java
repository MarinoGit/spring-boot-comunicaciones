package com.marino.resources;

import org.springframework.http.HttpStatus;

/**
 * Encapsula las posibles respuesta que devuelven los Service a los Controller.
 *
 * @param <T> El tipo de dato que se devuelve en caso de OK.
 * @author marinovilchez
 * @fecha 11/5/17
 */
public class Response<T> {

    /**
     * El código de estado HTTP.
     */
    private HttpStatus httpStatus;

    /**
     * El error en caso que exista.
     */
    private ResponseError responseError;

    /**
     * Los datos a devolver en caso que no haya errores.
     */
    private T data;

    /**
     * Constructor para errores.
     *
     * @param httpStatus    El código de error.
     * @param responseError El objeto con la información del error.
     */
    public Response(HttpStatus httpStatus, ResponseError responseError) {
        this.httpStatus = httpStatus;
        this.responseError = responseError;
    }


    /**
     * Constructor para OK y poder incluir datos.
     *
     * @param data Los datos a incluir en la respuesta.
     */
    public Response(T data) {
        this.httpStatus = HttpStatus.OK;
        this.data = data;
    }

    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus the httpStatus to set
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * @return the responseError
     */
    public ResponseError getResponseError() {
        return responseError;
    }

    /**
     * @param responseError the responseError to set
     */
    public void setResponseError(ResponseError responseError) {
        this.responseError = responseError;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

}
