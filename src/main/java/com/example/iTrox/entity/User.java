package com.example.iTrox.entity;

import com.example.commons.dto.Auditable;
import com.example.iTrox.enums.Gender;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User extends Auditable<String> implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Long age;

  @Column(name = "gender")
  private Gender gender;
}
