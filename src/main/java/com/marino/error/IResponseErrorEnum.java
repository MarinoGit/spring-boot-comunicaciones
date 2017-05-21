package com.marino.error;

/**
 * Interfaz que deben implementar los enums de error de respuesta.
 * 
 * @author marinovilchez
 * @soundtrack Nudozurdo - Estás Tan Perdida
 * @fecha 10-5-17
 *
 */
public interface IResponseErrorEnum {

    /**
     * Devuelve el código del error de respuesta del enum.
     * 
     * @return Código de error.
     */
    String name();

    /**
     * Devuelve el texto del error de respuesta del enum.
     * 
     * @return Texto de error.
     */
    String getValue();
}
