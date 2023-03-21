package com.example.iTrox.entity;

import com.example.commons.dto.Auditable;
import com.example.iTrox.enums.Activity;
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
@Table(name = "activity_mapping")
public class ActivityMapping extends Auditable {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    private Advertisement advertisement;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Organisation organisation;

    @Column(name = "activity", nullable = false)
    @Enumerated(EnumType.STRING)
    private Activity activity = Activity.NONE;
}
