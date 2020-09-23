package com.petproject.mrbs.domain;

import com.petproject.mrbs.domain.enums.Status;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "rooms")
@Entity
public class Room extends BaseEntity{

    private String name;

    @Lob
    private String description;
    private Integer capacity;
    private Double price;
    private String location;

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
