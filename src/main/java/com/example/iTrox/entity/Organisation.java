package com.example.iTrox.entity;

import com.example.commons.dto.Auditable;
import com.example.iTrox.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "organisation")
public class Organisation extends Auditable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "organisation_id")
    private String organisationId;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String  email;

    @Column(name = "type", nullable = false)
    private Type type;

    @OneToOne private ActivityMapping activityMapping;

}
