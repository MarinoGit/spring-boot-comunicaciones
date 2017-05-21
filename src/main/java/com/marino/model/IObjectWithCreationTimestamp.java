package com.marino.model;

import java.util.Date;

/**
 * Interface para añadir creationTimestamp a cualquier modelo
 *
 * @author marinovilchez
 * @fecha 9/5/17
 */
public interface IObjectWithCreationTimestamp {
    void setCreationTimestamp(final Date creationTimestamp);

    Date getCreationTimestamp();
}
