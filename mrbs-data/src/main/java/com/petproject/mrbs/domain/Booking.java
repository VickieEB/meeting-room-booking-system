package com.petproject.mrbs.domain;


import com.petproject.mrbs.domain.enums.Duration;
import com.petproject.mrbs.domain.enums.Status;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Booking extends BaseEntity{

    @Builder
    public Booking(Long id,Room room, LocalDate bookeddate, LocalDate transDate, Duration duration, Set<BookedHours> bookedHours,
                   Integer attendees, String note, String customerName, Double total, Status status) {
        super(id);
        this.room = room;
        this.bookeddate = bookeddate;
        this.transDate = transDate;
        this.duration = duration;

        if(bookedHours != null){
            this.bookedHours = bookedHours;
        }

        this.attendees = attendees;
        this.note = note;
        this.customerName = customerName;
        this.total = total;
        this.status = status;
    }

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
    private String customerName;

    private Double total;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Booking addBookedHours(BookedHours bookedHour){
        bookedHour.setBooking(this);
        this.bookedHours.add(bookedHour);
        return this;
    }



}
