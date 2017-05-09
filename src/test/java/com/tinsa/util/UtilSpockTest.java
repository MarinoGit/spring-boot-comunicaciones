package com.tinsa.util;

import spock.lang.Specification;

/**
 * Created by
 *
 * @author marinovilchez
 * @soundtrack Radio Tarifa - Ronda De Sanabria
 * @since 9/5/17
 */

class UtilSpockTest extends Specification {


    void 'invertir una cadena de texto'()

    {            // 2
        given:
        'una cadena de text'                    // 3
        def miCadena = 'Hola Genbetadev'

        when:
        'la invertimos'                          // 4
        def cadenaInvertida = miCadena.reverse()

        then:
        'se invierte correctamente'              // 5
        cadenaInvertida == 'vedatebneG aloH'
    }
}
}
