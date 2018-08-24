package com.example.smarthomes.loginservice.entity.repository;

import com.example.smarthomes.loginservice.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Query to find if user with those login credentials exists or not in the database
     * @param user_name The username of the user that wants to log in
     * @param password The password of the user that wants to log in
     * @return Id of the user with that username and password or null otherwise
     */

    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.user_name = :user_name AND u.password = :password", nativeQuery = true)
    Integer findUserByUser_nameAndPassword(@Param("user_name") String user_name,  @Param("password") String password);

    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    Integer findUserByUser_name(@Param("user_name") String user_name);

    /**
     * Querry to select all the details about a user with a specific username. Used in order to give to client-side all the informations for the user that is logged-in
     * @param user_name The username of the logged in username
     * @return A string containing all the informations from the database for the logged-in user
     */

    @Query(value = "SELECT u.email, u.first_name, u.last_name, u.user_name FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    String returnUserLogin(@Param("user_name") String user_name);

    @Query(value = "SELECT u.email FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    String returnUserEmailLogin(@Param("user_name") String userName);

    @Query(value = "SELECT u.first_name FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    String returnUserFirstNameLogin(@Param("user_name") String userName);

    @Query(value = "SELECT u.last_name FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    String returnLastNameLogin(@Param("user_name") String userName);

    @Query(value = "SELECT u.user_name FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    String returmUserNameLogin(@Param("user_name") String userName);
}
