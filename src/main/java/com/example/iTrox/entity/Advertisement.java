package com.example.iTrox.entity;

import com.example.commons.dto.Auditable;
import com.example.iTrox.enums.Type;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "advertisement")
@Getter
@Setter
@NoArgsConstructor
public class Advertisement extends Auditable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "type")
  private Type type;

  @Column(name = "userId")
  private String userId;

  @Column(name = "organisationId")
  private String organisationId;

  @Column(name = "email")
  private String email;

  @Lob
  @Column(name = "imagedata", length = 1000)
  private byte[] imageData;

  @OneToOne private ActivityMapping activityMapping;
}
