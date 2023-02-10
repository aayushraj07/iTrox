package com.example.iTrox.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "advertisement")
@Getter
@Setter
@NoArgsConstructor
public class Advertisement extends AuditableBase implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;
}
