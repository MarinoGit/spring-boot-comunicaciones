package com.marino.model;

/**
 * Esta clase representa la respuesta a la creación de un mensaje
 *
 * @author marinovilchez
 * @fecha 9/5/17
 */
public class CreateMessageResponse {
    private Long id;
    private String resultado;


    //Para que jackson no falle
    public CreateMessageResponse() {
    }
    /**
     * Solo para tests
     * @param id
     * @param resultado
     */
    public CreateMessageResponse(final Long id, final String resultado) {
        this.id = id;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
