package com.tinsa.model;

/**
 * Esta clase representa la request de creación de un mensaje
 *
 * Created by marinovilchez on 9/5/17.
 */
public class CreateMessageRequest {

    private String tipo;
    private String mensaje;
    private String destinatario;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
