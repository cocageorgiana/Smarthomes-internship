package com.example.smarthomes.grouphomes.entity.repository;

import com.example.smarthomes.grouphomes.entity.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    @Query(value = "SELECT h.id_house FROM HOUSES h WHERE h.name = :name", nativeQuery = true)
    Integer findHouseByHouseName(@Param("name") String name);

    @Query(value = "SELECT h.name FROM HOUSES h WHERE h.id_house = :id_house", nativeQuery = true)
    String findHouseById_house(@Param("id_house")Integer id_house);

    @Query(value = "SELECT MAX(id_house) FROM HOUSES h", nativeQuery = true)
    Integer getMaxIdHouse();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USER_HOUSES WHERE id_house = :id_house", nativeQuery = true)
    void deleteUserHouses(@Param("id_house")Integer id_house);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM HOUSEHOLD_ITEMS WHERE id_house = :id_house", nativeQuery = true)
    void deleteItemsInHouse(@Param("id_house")Integer id_house);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USER_PRIVILEGIES_ADMIN a WHERE a.id_house = :id_house", nativeQuery = true)
    void deleteAdminsHouses(@Param("id_house")Integer id_house);


    @Query(value = "SELECT h.name FROM HOUSES h", nativeQuery = true)
    List<String> getAllHousesName();

    @Query(value = "SELECT h.adress FROM HOUSES h", nativeQuery = true)
    List<String> getAllHousesAdress();

    @Query(value = "SELECT g.id_user FROM USER_HOUSES g WHERE g.id_house = :id_house", nativeQuery = true)
    List<Integer> getUsersOfHouse(@Param("id_house") Integer id_house);

    @Query(value = "SELECT DISTINCT u.user_name FROM USERS u WHERE u.id_user = :id_user", nativeQuery = true)
    List<String> getUserDetails(@Param("id_user") Integer id_user);

    @Query(value = "SELECT g.id_house FROM USER_HOUSES g WHERE g.id_user = :id_user", nativeQuery = true)
    List<Integer> getHousesOfUser(@Param("id_user") Integer id_user);

    @Query(value = "SELECT h.name FROM HOUSES h WHERE h.id_house = :id_house", nativeQuery = true)
    List<String> getHouseName(@Param("id_house") Integer id_house);

    @Query(value = "SELECT h.adress FROM HOUSES h WHERE h.id_house = :id_house", nativeQuery = true)
    List<String> getHouseAdress(@Param("id_house") Integer id_house);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO HOUSES(name, adress) VALUES (:name_house, :adress)",  nativeQuery = true)
    void actuallyInsertInHouse(@Param("name_house")String name, @Param("adress")String address);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_HOUSES(id_user, id_house) VALUES(:id_user, :id_house)", nativeQuery = true)
    void actuallyInsertInHousesUser(@Param("id_user")Integer id_user, @Param("id_house")Integer id_house);


    @Modifying
    @Transactional
    @Query(value = "UPDATE HOUSES SET name = :name, adress = :address WHERE id_house = :id_house", nativeQuery = true)
    void actuallyUpdateHouse(@Param("name")String houseName, @Param("address")String houseAddress, @Param("id_house")Integer id_house);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USER_HOUSES SET id_user = :id_user WHERE id_house = :id_house", nativeQuery = true)
    void actuallyUpdateInUserHouses(@Param("id_user")Integer idUser, @Param("id_house")Integer idHouse);
}
