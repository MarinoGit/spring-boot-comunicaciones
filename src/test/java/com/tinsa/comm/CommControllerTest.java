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
    @DataPoint("mensajes")
    public static String[] mensajes = new String[]{"", "", ""};

    @Theory
    public void send(@FromDataPoints("mensajes") final String mensaje, @FromDataPoints("tipos") final String tipo) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/send/" + tipo + "/").accept(MediaType.APPLICATION_JSON)
                .param("mensaje", mensaje))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Send Ok!")));
    }
}
