package com.petproject.mrbs.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DurationType extends BaseEntity{

    private String name;

    private String description;

    @Builder
    public DurationType(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;

    }
}
