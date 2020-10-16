package com.petproject.mrbs.domain;

import com.petproject.mrbs.domain.enums.RoomStatus;
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
    private String address;

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private RoomStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Booking> booking = new HashSet<>();

    @Builder
    public Room(Long id, String name, String description, Integer capacity, Double price, String address, Byte[] image, RoomStatus status, Set<Booking> booking) {
        super(id);
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.price = price;
        this.address = address;
        this.image = image;
        this.status = status;
        this.booking = booking;
    }

}
