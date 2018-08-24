package com.example.smarthomes.grouphomes.entity.repository;

import com.example.smarthomes.grouphomes.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u.user_name FROM USERS u WHERE u.id_user = :id_user", nativeQuery = true)
    String getUserById_user(@Param("id_user") Integer id_user);

    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    Integer getUserByUser_name(@Param("user_name") String userName);
}
