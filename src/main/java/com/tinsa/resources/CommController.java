package com.tinsa.resources;

import com.tinsa.dao.MessageRepository;
import com.tinsa.model.CreateMessageRequest;
import com.tinsa.model.CreateMessageResponse;
import com.tinsa.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Servicio para enviar mensajes
 *
 * @author marinovilchez
 * @soundtrack Nudozurdo - Úrsula Hay Nieve en Casa
 * @fecha 11/5/17
 */
@RestController
public class CommController extends Controller {

    public static final String SMS = "sms";
    public static final String FAX = "fax";
    public static final int SMS_MESSAGE_MAX_SIZE = 160;
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(value = "/tinsa", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public Response<?> send(@RequestBody final CreateMessageRequest request) {
        CreateMessageResponse createMessageResponse;

        if (!request.getTipo().equalsIgnoreCase(SMS) && !request.getTipo().equalsIgnoreCase(FAX)) {
            createMessageResponse = new CreateMessageResponse(null, "No se puede enviar el mensaje por un medio desconocido!");
        } else if (request.getTipo().equalsIgnoreCase(SMS) && request.getMensaje().length() > SMS_MESSAGE_MAX_SIZE) {
            createMessageResponse = new CreateMessageResponse(null, "El mensaje es demasiado largo. No se ha podido enviar!");
        } else {
            Message message = new Message();
            message.setMensaje(request.getMensaje());
            message.setTipo(request.getTipo());
            message.setDestinatario(request.getDestinatario());
            messageRepository.save(message);
            if (message.getId() != null && messageRepository.exists(message.getId())) {
                createMessageResponse = new CreateMessageResponse(message.getId(), "Ok");
            } else {
                createMessageResponse = new CreateMessageResponse(null, "Ko");
            }
        }

        Response<?> resultado;
        resultado = new Response<>(createMessageResponse);
        return resultado;
    }
}
