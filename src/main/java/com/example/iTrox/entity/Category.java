package com.example.iTrox.entity;

import com.example.commons.dto.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category extends Schedule {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;
}
