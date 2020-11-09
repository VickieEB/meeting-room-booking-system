package com.petproject.mrbs.domain;

import lombok.*;

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


    @Builder
    public DurationHours(Long id, String fromTime, String toTime, DurationType durationType) {
        super(id);
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.durationType = durationType;
    }
}
