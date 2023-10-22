package miraj.basicmicroservice2024.service;

import miraj.basicmicroservice2024.request.AddUserRequest;
import miraj.basicmicroservice2024.response.UserDetailsResponse;

public interface UserService {

    public UserDetailsResponse getUser(int id);
    public UserDetailsResponse getAllUsers();
    public UserDetailsResponse addUser(AddUserRequest userRequest);
}
