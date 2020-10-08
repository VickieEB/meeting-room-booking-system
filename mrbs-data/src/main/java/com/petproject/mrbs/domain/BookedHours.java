package com.petproject.mrbs.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booked_hours")
@EqualsAndHashCode(exclude = {"booking"})
public class BookedHours  extends BaseEntity {



    @Column(name = "from_time")
    private String fromTime;

    @Column(name = "to_time")
    private String toTime;

    @ManyToOne
    private Booking booking;

    public BookedHours(String fromTime, String toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

}
