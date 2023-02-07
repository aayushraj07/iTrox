package com.example.iTrox.entity;

import com.example.commons.dto.Auditable;
import jakarta.persistence.*;
import java.util.UUID;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "advertisement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Advertisement extends Auditable {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;
}
