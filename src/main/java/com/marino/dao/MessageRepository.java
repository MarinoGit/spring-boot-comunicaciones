package com.marino.dao;

import com.marino.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Clase de tipo repository. Spring data hace la implentación
 *
 * @author marinovilchez
 * @soundtrack Nudozurdo - La Ruta de los Balcanes
 * @since 11/5/17
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByTipo(String tipo);

    List<Message> findByDestinatario(String destinatario);

    List<Message> findByCreationTimestamp(Date creationTimestamp);
}
