package miraj.basicmicroservice2024.controller;

import lombok.extern.slf4j.Slf4j;
import miraj.basicmicroservice2024.response.UserDetail;
import miraj.basicmicroservice2024.response.UserDetailsResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static miraj.basicmicroservice2024.util.Constants.RequestMappings.USER;

@RestController
@RequestMapping(path = USER)
@Slf4j
public class UserController {

    @GetMapping(value = "details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> getUserDetails(@PathVariable String id,
                                                              @RequestParam(value = "something", required = false) String some) {

        log.info("request received userid: {} something: {}", id, some);
        UserDetailsResponse response = new UserDetailsResponse();
        UserDetail user1 = new UserDetail().setUserId(Integer.parseInt(id)).setFristName("Mike");
        ArrayList userList = new ArrayList<>();
        userList.add(user1);
        response.setUserDetails(userList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value1");

        return ResponseEntity.status(200).headers(headers).body(response);
    }

    @GetMapping(value = "details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> getUserDetails(@RequestParam(value = "sort", required = false) String sort) {

        log.info("request received get all users sort: {}", sort);
        UserDetailsResponse response = new UserDetailsResponse();
        UserDetail user1 = new UserDetail().setUserId(1).setFristName("Mike");
        UserDetail user2 = new UserDetail().setUserId(2).setFristName("Silva");
        ArrayList userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        response.setUserDetails(userList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value2");

        return ResponseEntity.status(200).headers(headers).body(response);
    }

}
