package com.petproject.mrbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DurationHours extends BaseEntity {

    @Column(name = "from_time")
    private String fromTime;

    @Column(name = "to_time")
    private String toTime;

    @OneToOne
    private DurationType durationType;
}
