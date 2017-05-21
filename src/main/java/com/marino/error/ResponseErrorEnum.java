package com.marino.error;

/**
 * Enum con los posibles errores.
 *
 * @author marinovilchez
 * @fecha 11/5/17
 */
public enum ResponseErrorEnum implements IResponseErrorEnum {

    /**
     * Errores
     */
    E001(ResponseErrorCode.E001), E002(ResponseErrorCode.E002), E003(ResponseErrorCode.E003), E004(
            ResponseErrorCode.E004), E005(ResponseErrorCode.E005), E006(ResponseErrorCode.E006);

    /**
     * Nombre del campo.
     */
    private String value;

    /**
     * Constructor por defecto.
     *
     * @param value Texto asociado al error.
     */
    ResponseErrorEnum(final String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    @Override
    public final String getValue() {
        return value;
    }
}