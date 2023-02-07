package com.example.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

  @Column(name = "created_date", updatable = false)
  @Temporal(TIMESTAMP)
  @CreatedDate
  protected Date creationDate;


  @Column(name = "lastMod_date")
  @LastModifiedDate
  @Temporal(TIMESTAMP)
  protected Date lastModifiedDate;

  @CreatedBy
  @Column(name="created_by")
  protected T createdBy;

  @LastModifiedBy
  @Column(name="modified_by")
  protected T modifiedBy;

}