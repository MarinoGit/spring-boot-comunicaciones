package com.tinsa.comm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tinsa.model.CreateMessageRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pruebas integradas de modulo de comunicaciones por SMS y fax
 *
 * @author marinovilchez
 * @fecha 8/5/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommControllerTest {
    @Autowired
    private MockMvc mvc;

    Gson gson = new Gson();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void send() throws Exception {
        String tipo = "sms";
        String mensaje = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce nec urna molestie, lacinia massa a, gravida lectus. In lacinia mi vel tincidunt volutpat";
        String destino = "666778899";
        CreateMessageRequest peticionCorrecta = new CreateMessageRequest(tipo, mensaje, destino);
        mvc.perform(MockMvcRequestBuilders.post("/tinsa/").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(peticionCorrecta)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.id")).isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.id")).isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.resultado")).value("Ok"));
    }

    @Test
    public void checkMensajes() throws Exception {
        String tipo = "sms";
        String mensajeErroneo = "Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.";
        String destino = "666778899";
        CreateMessageRequest peticionErroneaMessage = new CreateMessageRequest(tipo, mensajeErroneo, destino);
        mvc.perform(MockMvcRequestBuilders.post("/tinsa/").contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(peticionErroneaMessage)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.id")).isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.resultado")).value("El mensaje es demasiado largo. No se ha podido enviar!"));
    }

    @Test
    public void checkTipos() throws Exception {
        String tipoSinTerminar = "push";
        String mensaje = "Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.Este mensaje es superior a 160 caracteres.";
        String destino = "666778899";
        CreateMessageRequest peticionErroneaTipo = new CreateMessageRequest(tipoSinTerminar, mensaje, destino);
        mvc.perform(MockMvcRequestBuilders.post("/tinsa/").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(peticionErroneaTipo)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.id")).isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.data.resultado")).value("No se puede enviar el mensaje por un medio desconocido!"));
    }
}
