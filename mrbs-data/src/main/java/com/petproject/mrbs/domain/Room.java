package com.petproject.mrbs.domain;

import com.petproject.mrbs.domain.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
@Entity
public class Room extends BaseEntity{

    @Column(name = "room_name")
    private String name;

    @Lob
    private String description;

    @Column(name = "capacity")
    private Integer capacity;

    private Double price;
    private String location;

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Booking> booking = new HashSet<>();
}
