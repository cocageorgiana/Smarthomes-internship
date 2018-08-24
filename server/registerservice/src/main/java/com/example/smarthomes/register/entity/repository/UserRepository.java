package com.example.smarthomes.register.entity.repository;

import com.example.smarthomes.register.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(value = "SELECT u.user_name FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    User findByUser_name(@Param("user_name") String userName);
}
