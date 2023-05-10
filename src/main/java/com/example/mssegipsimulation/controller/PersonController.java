package com.example.mssegipsimulation.controller;

import com.example.mssegipsimulation.component.response.ApiResponse;
import com.example.mssegipsimulation.component.response.ErrorApiResponseServiceInterface;
import com.example.mssegipsimulation.component.response.SuccessApiResponseServiceInterface;
import com.example.mssegipsimulation.constants.RestRequestMappingConstants;
import com.example.mssegipsimulation.dto.PersonDto;
import com.example.mssegipsimulation.entity.Person;
import com.example.mssegipsimulation.service.PersonService;
import java.io.IOException;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(RestRequestMappingConstants.PERSONS)
public class PersonController {

  private final SuccessApiResponseServiceInterface successApiResponseService;
  private final ErrorApiResponseServiceInterface errorApiResponseService;
  private final PersonService personService;

  @GetMapping("/{identification}")
  public ResponseEntity<ApiResponse> getPersonById(@PathVariable String identification) {
    PersonDto person = personService.getPersonByCi(identification);

    return ResponseEntity.ok(successApiResponseService.createSuccessResponse(person));
  }

  @CrossOrigin(origins = "*")
  @PostMapping(value = "/registrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ApiResponse> registrarPersona(
      @RequestParam("name") String name,
      @RequestParam("lastname") String lastname,
      @RequestParam("dateofbirth") String dateofbirth,
      @RequestParam("gender") String gender,
      @RequestParam("identification") String identification,
      @RequestParam("address") String address,
      @RequestParam("phone") String phone,
      @RequestParam("photo") MultipartFile photo)
      throws IOException {

    // Crear una nueva entidad Person
    Person person = new Person();
    person.setName(name);
    person.setLastname(lastname);
    person.setDateofbirth(LocalDateTime.now());
    person.setGender(gender);
    person.setIdentification(identification);
    person.setAddress(address);
    person.setPhone(phone);
    person.setPhoto(photo.getBytes());

    PersonDto savedPerson = personService.save(person);

    return ResponseEntity.ok(successApiResponseService.createSuccessResponse(savedPerson));
  }
}
