package com.tinsa.model;

/**
 * Esta clase representa la request de creación de un mensaje
 * <p>
 * @author marinovilchez
 * @fecha 9/5/17
 */
public class CreateMessageRequest {

    private String tipo;
    private String mensaje;
    private String destinatario;

    //Para que jackson no falle
    public CreateMessageRequest() {
    }

    /**
     * Constructor con todos los atributos
     *
     * @param tipo         tipo de envío
     * @param mensaje      mensaje
     * @param destinatario destino del mensaje
     */
    public CreateMessageRequest(final String tipo, final String mensaje, final String destinatario) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

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
