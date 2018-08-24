package com.example.smarthomes.grouphomes.entity.repository;

import com.example.smarthomes.grouphomes.entity.model.HousesAdmins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HousesAdminsRepository extends JpaRepository<HousesAdmins, Integer> {

    @Query(value = "SELECT a.id_user FROM USER_PRIVILEGIES_ADMIN a WHERE a.id_house = :id_house", nativeQuery = true)
    Integer checkHouseAdmin(@Param("id_house")Integer id_house);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_PRIVILEGIES_ADMIN(id_user, id_house) VALUES (:ID_USER, :ID_HOUSE)", nativeQuery = true)
    void actuallySaveAdmin(@Param("ID_USER")Integer id_user, @Param("ID_HOUSE")Integer id_house);

    @Query(value = "SELECT a.id FROM USER_PRIVILEGIES_ADMIN a WHERE a.id_house =: id_house", nativeQuery = true)
    Integer checkHouseExistsAdmin(@Param("id_house")Integer id_house);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USER_PRIVILEGIES_ADMIN WHERE id_user = :id_user AND id_house = :id_house", nativeQuery = true)
    void actuallyDeleteAdmin(@Param("id_user")Integer id_user, @Param("id_house")Integer id_house);
}
