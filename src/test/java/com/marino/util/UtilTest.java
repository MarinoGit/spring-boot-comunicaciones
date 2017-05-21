package com.marino.util;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author marinovilchez
 * @soundtrack Tronco - Pez En Bicicleta
 * @fecha 9/5/17
 */
@RunWith(Theories.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UtilTest {

    /* Teléfonos válidos en España generados a partir http://www.generatedata.com/?lang=es */
    @DataPoints("telefonos")
    public static String[] telefonos = new String[]{"857728141", "846486330", "902929995", "741908433", "740398539", "832446635", "666115711", "667222832", "608275283", "821123751", "958574059", "900903663", "655816487", "749218444", "867195355", "629265069", "936484739", "875903125", "975867942", "737306972", "974614893", "621689961", "968507739", "784494529", "608851294", "962654315", "971579220", "698026502", "607112177", "725974763", "690896590", "945501215", "646463354", "851651046", "985393208", "711187175", "969952663", "864721266", "901499469", "979199440", "980774439"};


    @Theory
    public void checkPhoneNumber(@FromDataPoints("telefonos") final String telefono) {
        Assert.assertTrue(Util.checkPhone(telefono));
    }
}
