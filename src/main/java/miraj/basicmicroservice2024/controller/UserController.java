package miraj.basicmicroservice2024.controller;

import lombok.extern.slf4j.Slf4j;
import miraj.basicmicroservice2024.request.AddUserRequest;
import miraj.basicmicroservice2024.response.UserDetail;
import miraj.basicmicroservice2024.response.UserDetailsResponse;
import miraj.basicmicroservice2024.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static miraj.basicmicroservice2024.util.Constants.RequestMappings.USER;

@RestController
@RequestMapping(path = USER)
@Slf4j
public class UserController {
    
    UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> getUserDetails(@PathVariable String id,
                                                              @RequestParam(value = "something", required = false) String some) {

        log.info("request received userid: {} something: {}", id, some);
        UserDetailsResponse response = userService.getUser(Integer.parseInt(id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value1");

        return ResponseEntity.status(200).headers(headers).body(response);
    }

    @GetMapping(value = "all-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> getUserDetails(@RequestParam(value = "sort", required = false) String sort) {

        log.info("request received get all users sort: {}", sort);
        UserDetailsResponse response = userService.getAllUsers();

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value2");

        return ResponseEntity.status(200).headers(headers).body(response);
    }

    @PostMapping(value = "add-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> addUser(@RequestBody AddUserRequest addUserRequest) {

        log.info("request received to add user");
        UserDetailsResponse response = userService.addUser(addUserRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value2");

        return ResponseEntity.status(201).headers(headers).body(response);
    }

}
