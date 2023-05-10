package com.example.mssegipsimulation.dto;

import java.io.InputStream;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
  private Long id;
  private String identification;
  private String name;
  private String lastname;
  private LocalDateTime dateOfBirth;
  private String gender;
  private String address;
  private String phone;
  private byte[] photo;
}
