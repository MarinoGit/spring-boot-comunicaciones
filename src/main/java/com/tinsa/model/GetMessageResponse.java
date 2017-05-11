package com.tinsa.model;

import java.util.Date;

/**
 * @author marinovilchez
 * @fecha 11/5/17.
 */
public class GetMessageResponse {
    private Long id;
    private String tipo;
    private String mensaje;
    private String destinatario;
    private int reintentos;
    private int reintentosPendientes;
    private String estado;
    private String motivoError;
    private Date creationTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getReintentos() {
        return reintentos;
    }

    public void setReintentos(int reintentos) {
        this.reintentos = reintentos;
    }

    public int getReintentosPendientes() {
        return reintentosPendientes;
    }

    public void setReintentosPendientes(int reintentosPendientes) {
        this.reintentosPendientes = reintentosPendientes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoError() {
        return motivoError;
    }

    public void setMotivoError(String motivoError) {
        this.motivoError = motivoError;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}
