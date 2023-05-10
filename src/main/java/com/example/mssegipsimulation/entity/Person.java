package com.example.mssegipsimulation.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "person",
    uniqueConstraints =
        @UniqueConstraint(
            name = "person_unique_identification_constraint",
            columnNames = {"identification"}))
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 100)
  private String lastname;

  @Column(nullable = false)
  private LocalDateTime dateofbirth;

  @Column(nullable = false, length = 50)
  private String gender;

  @Column(nullable = false, unique = true, length = 20)
  private String identification;

  @Column(nullable = false, length = 200)
  private String address;

  @Column(nullable = false, length = 20)
  private String phone;

  @Column(name = "photo", nullable = false, columnDefinition = "bytea")
  private byte[] photo;
}
