package miraj.basicmicroservice2024.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import miraj.basicmicroservice2024.entity.UserDetailsEntity;
import miraj.basicmicroservice2024.exception.UserException;
import miraj.basicmicroservice2024.repository.UserDetailsRepository;
import miraj.basicmicroservice2024.request.AddUserRequest;
import miraj.basicmicroservice2024.response.UserDetail;
import miraj.basicmicroservice2024.response.UserDetailsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserDetailsRepository userDetailsRepository;

    @Autowired
    void setUserDetailsRepository(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDetailsResponse getUser(int id) {
        UserDetailsResponse response = new UserDetailsResponse();
        UserDetailsEntity user;
        try {
            user = userDetailsRepository.getReferenceById(id);
            UserDetail userDetail = modelMapper.map(user, UserDetail.class);
            ArrayList userList = new ArrayList<UserDetail>();
            userList.add(userDetail);
            response.setUserDetails(userList);
        } catch (Exception e) {
            throw new UserException(777, "User not found");
        }

        return response;
    }

    @Override
    public UserDetailsResponse getAllUsers() {
        List<UserDetailsEntity> allUsers = userDetailsRepository.findAll();
        ArrayList userList = new ArrayList<UserDetail>();

        for (UserDetailsEntity user : allUsers) {
            UserDetail userDetail = modelMapper.map(user, UserDetail.class);
            userList.add(userDetail);
        }

        UserDetailsResponse response = new UserDetailsResponse();
        response.setUserDetails(userList);

        return response;
    }

    @Override
    public UserDetailsResponse addUser(AddUserRequest userRequest) {
        UserDetailsEntity userDetailsEntity = modelMapper.map(userRequest, UserDetailsEntity.class);
        UserDetailsEntity savedUser = userDetailsRepository.save(userDetailsEntity);
        UserDetailsEntity savedDetailsEntity = modelMapper.map(savedUser, UserDetailsEntity.class);
        UserDetailsResponse response = new UserDetailsResponse();
        UserDetail userDetail = modelMapper.map(savedDetailsEntity, UserDetail.class);
        ArrayList userList = new ArrayList<UserDetail>();
        userList.add(userDetail);
        response.setUserDetails(userList);
        return response;
    }
}
