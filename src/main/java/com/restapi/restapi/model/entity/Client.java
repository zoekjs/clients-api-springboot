package com.restapi.restapi.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@Table(name="clients")
public class Client implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -5680099363246413575L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

  @Column
  private String name;

  @Column(name="last_name")
  private String lastName;

  @Column
  private String email;

  @Column(name="created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
}
