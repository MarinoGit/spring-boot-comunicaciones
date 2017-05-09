package com.tinsa.model;

/**
 * Esta clase representa la respuesta a la creación de un mensaje
 *
 * Created by marinovilchez on 9/5/17.
 */
public class CreateMessageResponse {
    private Long id;
    private String resultado;

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
