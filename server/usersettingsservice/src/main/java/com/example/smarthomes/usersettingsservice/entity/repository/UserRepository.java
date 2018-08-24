package com.example.smarthomes.usersettingsservice.entity.repository;

import com.example.smarthomes.usersettingsservice.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Querry to check if the user exists in the database
     * @param user_name The username for which we want to find out the id
     * @return The id of the user with that username or null otherwise
     */

    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    Integer findUserByUser_name(@Param("user_name") String user_name);

    /**
     * Aux query to get the username for the user with that id
     * @param id_user The id of the user for which we want to find out the username
     * @return
     */

    @Query(value = "SELECT u.user_name FROM USERS u WHERE u.id_user = :id_user", nativeQuery = true)
    String findUserById_user(@Param("id_user") Integer id_user);

    /**
     * Query to get the last entry in the database and fix the "inserted-twice" bug
     * @return The last entry in the database identified by the largest id
     */

    @Query(value = "SELECT MAX(id_user) FROM USERS u", nativeQuery = true)
    Integer getMaxIdUser();


    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.user_name = :user_name", nativeQuery = true)
    Integer getUserByUserName(@Param("user_name")String userName);

    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.user_name = :user_name AND u.password = :password", nativeQuery = true)
    Integer getUserByUserNameAndPassword(@Param("user_name")String userName, @Param("password")String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USERS set first_name = :first_name, last_name = :last_name, email = :email WHERE id_user = :id_user", nativeQuery = true)
    void actuallyUpdateUserInformation(@Param("first_name")String firstName, @Param("last_name")String lastName, @Param("email")String email, @Param("id_user")Integer idUser);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USERS SET password = :password WHERE id_user = :id_user", nativeQuery = true)
    void actuallyUpdateUserPassword(@Param("password")String password, @Param("id_user")Integer idUser);

}
