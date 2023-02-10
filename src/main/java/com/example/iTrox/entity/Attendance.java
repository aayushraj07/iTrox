package com.example.iTrox.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "attendance")
@NoArgsConstructor
@Getter
@Setter
public class Attendance extends AuditableBase {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "effective_dt")
  private LocalDate effectiveDt;

  @Column(name = "fl_present")
  private boolean present;
}
