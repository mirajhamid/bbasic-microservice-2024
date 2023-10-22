package miraj.basicmicroservice2024.controller;

import lombok.extern.slf4j.Slf4j;
import miraj.basicmicroservice2024.response.UserDetailResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static miraj.basicmicroservice2024.util.Constants.RequestMappings.USER;

@RestController
@RequestMapping(path = USER)
@Slf4j
public class UserController {

    @GetMapping(value = "details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailResponse> getUserDetails() {

        UserDetailResponse response = new UserDetailResponse();
        response.setFristName("miraj").setLastName("hamid");

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value1");

        return ResponseEntity.status(200).headers(headers).body(response);
    }

}
