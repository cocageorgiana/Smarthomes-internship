package com.example.smarthomes.grouphomes.entity.repository;

import com.example.smarthomes.grouphomes.entity.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query(value = "SELECT g.id_user FROM USER_HOUSES g WHERE g.id_house = :id", nativeQuery = true)
    List<Integer> findUserByHouseId(@Param("id") Integer houseId);


    @Query(value = "SELECT u.id_user FROM USERS u WHERE u.id_user = :id", nativeQuery = true)
    Integer findUserInGroupById(@Param("id") Integer userId);

    @Query(value = "SELECT h.id_house FROM HOUSES h where h.id_house = :id", nativeQuery = true)
    Integer findHouseInGroupById(@Param("id") Integer houseId);

    /**
     * Querry to actually add a user to a group in the database regarding the fact that we make use of the Embedded and the Embeddable annotations
     * @param id_user the id of the user to be inserted in the pivot table
     * @param id_house the id of the house
     */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_HOUSES(id_user, id_house) VALUES (:ID_USER, :ID_HOUSE)", nativeQuery = true)
    void actuallySaveGroup(@Param("ID_USER")Integer id_user,  @Param("ID_HOUSE")Integer id_house);


    /**
     * Querry to delete an user from a group
     * @param id_user the id of the user that we want to delete
     * @param id_house the id of the house for which we want to remove the user
     */

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USER_HOUSES WHERE id_user = :id_user AND id_house = :id_house", nativeQuery = true)
    void actuallyDeleteGroup(@Param("id_user")Integer id_user, @Param("id_house")Integer id_house);

}
