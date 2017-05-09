package com.tinsa.comm;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pruebas integradas de modulo de comunicaciones por SMS y fax
 * <p>
 * Created by marinovilchez on 8/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommControllerTest {
    @Autowired
    private MockMvc mvc;

    @DataPoint("tipo")
    public static String[] tipos = new String[]{"sms", "fax"};
    @DataPoint("tiposSinTerminar")
    public static String[] tiposSinTerminar = new String[]{"push", "whacha"};
    @DataPoint("mensajes")
    public static String[] mensajes = new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce nec urna molestie, lacinia massa a, gravida lectus. In lacinia mi vel tincidunt volutpat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce nec urna molestie, lacinia massa a, gravida lectus. In lacinia mi vel tincidunt volutpat", "Suspendisse mattis nisl purus, ornare dictum nulla suscipit et. Duis eu lacus orci. In a diam quis tellus vehicula auctor. Suspendisse vehicula finibus consectetur."};
    @DataPoint("mensajesErroneos")
    public static String[] mensajesErroneos = new String[]{
            "Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres."};
    @DataPoint("destinos")
    public static String[] destinos = new String[]{"9100000202", "666778899"};

    @Test
    public void setupTest() {
    }

    @Theory
    public void send(@FromDataPoints("mensajes") final String mensaje, @FromDataPoints("tipos") final String tipo, @FromDataPoints("destinos") final String destino) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/send/" + tipo + "/").accept(MediaType.APPLICATION_JSON)
                .param("mensaje", mensaje).param("destino", destino))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Send Ok!")));
    }

    @Theory
    public void checkMensajes(@FromDataPoints("mensajesErroneos") final String mensajeErroneo, @FromDataPoints("tipos") final String tipo, @FromDataPoints("destinos") final String destino) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/send/" + tipo + "/").accept(MediaType.APPLICATION_JSON)
                .param("mensaje", mensajeErroneo).param("destino", destino))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(equalTo("El mensaje es erróneo. No se ha podido enviar!")));
    }

    @Theory
    public void checkTipos(@FromDataPoints("mensajes") final String mensaje, @FromDataPoints("tiposSinTerminar") final String tipoSinTerminar, @FromDataPoints("destinos") final String destino) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/send/" + tipoSinTerminar + "/").accept(MediaType.APPLICATION_JSON)
                .param("mensaje", mensaje).param("destino", destino))
                .andExpect(status().isNotFound())
                .andExpect(content().string(equalTo("No encontrado!")));
    }
}
