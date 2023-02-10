package com.example.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Data
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class Auditable {
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd HH:mm:ss.SSS",
      timezone = "UTC")
  @CreatedDate
  private Timestamp createdAt;

  @CreatedBy private String createdBy;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd HH:mm:ss.SSS",
      timezone = "UTC")
  @LastModifiedDate
  private Timestamp updatedAt;

  @LastModifiedBy private String updatedBy;

  @Column(name = "is_active")
  private Boolean isActive = Boolean.TRUE;
}
