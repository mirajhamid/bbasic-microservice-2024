package miraj.basicmicroservice2024.repository;


import miraj.basicmicroservice2024.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity,Integer> {

    UserDetailsEntity findByUserId(final int userid);

    //List<UserDetailsEntity> findALL();

    @Query("SELECT r FROM UserDetailsEntity r WHERE r.age = ?1")
    List<UserDetailsEntity> getUsersOverAge(final int age);
}
