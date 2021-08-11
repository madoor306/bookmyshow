package com.bookmyshow.app.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public abstract class Auditable {

    private Long   id;
    private Date createdOn;
    private Date   updatedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditable auditable = (Auditable) o;
        return Objects.equals(id, auditable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
