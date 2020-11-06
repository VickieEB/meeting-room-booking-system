package com.petproject.mrbs.domain;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booked_hours")
@EqualsAndHashCode(exclude = {"booking"})
public class BookedHours  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Booking booking;

    @OneToOne
    private DurationHours durationHours;

}
