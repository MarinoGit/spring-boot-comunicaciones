package com.tinsa.model;

import java.time.LocalDateTime;

/**
 * Interface para añadir creationTimestamp a cualquier modelo
 *
 * Created by marinovilchez on 9/5/17.
 */
public interface IObjectWithCreationTimestamp {
    void setCreationTimestamp(final LocalDateTime creationTimestamp);
    LocalDateTime getCreationTimestamp();
}
