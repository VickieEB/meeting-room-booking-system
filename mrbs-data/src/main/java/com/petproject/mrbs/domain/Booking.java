package com.petproject.mrbs.domain;


import com.petproject.mrbs.domain.enums.Duration;
import com.petproject.mrbs.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "booked_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookeddate;

    @Column(name = "transaction_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transDate;

    @Enumerated(value = EnumType.STRING)
    private Duration duration;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private Set<BookedHours> bookedHours = new HashSet<>();

    private Integer attendees;

    @Lob
    private String note;

    //Todo: Create entity for Customers and link this properly
    @Column(name = "customer_id")
    private String name;

    private Double total;

    @Enumerated(value = EnumType.STRING)
    private Status status;



}
