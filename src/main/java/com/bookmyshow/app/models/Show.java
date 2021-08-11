package com.bookmyshow.app.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Show extends Auditable {
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private Hall hall;
}
