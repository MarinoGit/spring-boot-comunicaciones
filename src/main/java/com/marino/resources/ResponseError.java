package com.marino.resources;


import com.marino.error.IResponseErrorEnum;

/**
 * Representa un mensaje de error para las respuetas de los servicios REST, ya que los códigos de error estándar de HTTP
 * se quedan cortos para representar determinadas situaciones.
 *
 * @author marinovilchez
 * @fecha 11/5/17
 */
public class ResponseError {

    /**
     * El código de error interno, para asociar a un texto, según idioma, de cara al front.
     */
    private String code;

    /**
     * El mensaje de error, en un sólo idioma para que alguien que no disponga del listado de códigos pueda entenderlos.
     */
    private String message;

    /**
     * Constructor al que se pasa el error correspondiente.
     */
    public ResponseError(IResponseErrorEnum error) {
        this.code = error.name();
        this.message = error.getValue();
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
