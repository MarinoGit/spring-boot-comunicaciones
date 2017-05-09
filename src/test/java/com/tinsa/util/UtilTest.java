package com.tinsa.util;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by
 *
 * @author marinovilchez
 * @soundtrack Tronco - Pez En Bicicleta
 * @since 9/5/17
 */
@RunWith(Theories.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UtilTest {

    @DataPoint("telefonos")
    public static String[] telefonos = new String[]{"857-728141", "846486330", "902-929995", "870-502449", "741-908433", "740-398539", "832-446635", "666-115711", "667-222832", "608-275283", "909-813691", "766218117", "821-123751", "755686713", "797574059", "798903663", "655816487", "749-218444", "867195355", "629265069", "936484739", "875-903125", "775867942", "737306972", "974614893", "621-689961", "768-507739", "784-494529", "608-851294", "962-654315", "771-579220", "998-026502", "607-112177", "725-974763", "990896590", "945501215", "646-463354", "851651046", "985-393208", "711-187175", "769-952663", "864-721266", "804499469", "779199440", "980-774439", "970423774", "720-521082", "836372895", "649526080", "821-869433", "667-388874", "865-687383", "995-594939", "895-584455", "692681859", "871421419", "878-248375", "965347343", "768215157", "814581725", "784522091", "620787067", "831311486", "979171523", "606515645", "929-521134", "969828201", "746539376", "949-047449", "673648589", "749346785", "702-379029", "966433727", "701907130", "896517342", "735389824", "656871594", "860763074", "656-161594", "686359749", "943231005", "782687425", "915300919", "889-451982", "943753765", "867-821768", "804704559", "937210014", "715-764779", "969-838536", "995220661", "985306787", "962764611", "672629119", "680-337853", "792136426", "955-696977", "897-751916", "609158120", "926583253"};


    @Theory
    public void checkPhoneNumber(@FromDataPoints("telefonos") final String telefono) {
        Assert.assertTrue(Util.checkPhone(telefono));
    }
}
