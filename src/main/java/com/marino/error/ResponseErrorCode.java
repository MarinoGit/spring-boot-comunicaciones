package com.marino.error;

/**
 * Textos de los correspondientes códigos de error.
 *
 * @author marinovilchez
 * @fecha 11/5/17
 */
class ResponseErrorCode {

    static final String E001 = "No se han informado todos los campos.";
    static final String E002 = "No encontrado";
    static final String E003 = "Petición incorrecta";
    static final String E004 = "No autorizado";
    static final String E005 = "Datos inconsistentes";
    static final String E006 = "Configuración errónea";


    private ResponseErrorCode() {
        throw new IllegalAccessError("Utility class");
    }

}
