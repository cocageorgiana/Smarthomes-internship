package com.example.smarthomes.grouphomes.entity.repository;

import com.example.smarthomes.grouphomes.entity.model.HouseHoldItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HouseHoldItemRepository extends JpaRepository<HouseHoldItem, Integer> {

    /**
     * Querry to find the item by his name
     * @param name The name of the item that we want to find out the id
     * @return The id of the item with the mentioned name
     */
    @Query(value = "SELECT i.id FROM HOUSEHOLD_ITEMS i WHERE i.name = :name", nativeQuery = true)
    Integer findHouseHoldItemByName(@Param("name") String name);

    /**
     * Querry to find the item by his id
     * @param id The id of the item that we want to find out the name
     * @return The name of the item with the mentioned id
     */
    @Query(value = "SELECT i.name FROM HOUSEHOLD_ITEMS i WHERE i.id = :id", nativeQuery = true)
    String findHouseHoldItemById(@Param("id") Integer id);


    /**
     * A querry to actually insert in the database a newly created item
     * @param name The name of the item
     * @param description An optional description for that item
     * @param quantity An optional quantity for the item
     * @param id_house The house id in which the item will be
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO HOUSEHOLD_ITEMS(name, description, quantity, id_house) VALUES (:NAME, :DESCRIPTION, :QUANTITY, :ID_HOUSE)", nativeQuery = true)
    void actuallySaveItem(@Param("NAME")String name, @Param("DESCRIPTION")String description, @Param("QUANTITY")Integer quantity, @Param("ID_HOUSE")Integer id_house);


    /**
     * Get the name of the item by the id of the house, will be used when we want to find out all the items in a specific house
     * @param id The id of the house for which we want to find out the name
     * @return The name of the item
     */
    @Query(value = "SELECT i.name FROM HOUSEHOLD_ITEMS i WHERE i.id_house = :id", nativeQuery = true)
    List<String> getItemNameByHouseId(@Param("id")Integer id);


    /**
     * Get the description of the item by the id of the house, will be used when we want to find out all the items in a specific house
     * @param id The id of the house for which we want to find out the name
     * @return The description of the item
     */
    @Query(value = "SELECT i.description FROM HOUSEHOLD_ITEMS i WHERE i.id_house = :id", nativeQuery = true)
    List<String> getItemDescriptionByHouseId(@Param("id")Integer id);

    /**
     * Get the quantity of the item by the id of the house, will be used when we want to find out all the items in a specific house
     * @param id The id of the house for which we want to find out the name
     * @return The quantity of the item
     */
    @Query(value = "SELECT i.quantity FROM HOUSEHOLD_ITEMS i WHERE i.id_house = :id", nativeQuery = true)
    List<Integer> getItemQuantityByHouseId(@Param("id")Integer id);


    /**
     * Querry to actually delete an item in the database, because we combine the Embedded and Embeddable annotations with normal Entities
     * @param id The id of the record we want to delete
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM HOUSEHOLD_ITEMS WHERE id = :id", nativeQuery = true)
    void actuallyDeleteItem(@Param("id") Integer id);

    /**
     * Querry to actually update an item in the database, because we combine the Embedded and Embeddable annotations with normal Entities
     * @param name The updated or not name of the item
     * @param description The updated or not description of the item
     * @param quantity The updated or not quantity of the item
     * @param id_house The updated or not house , in case we want move an item from a house to another
     * @param id The id of the item for which we want to make the update
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE HOUSEHOLD_ITEMS i SET i.name = :name, i.description = :description, i.quantity = :quantity, i.id_house = :id_house WHERE i.id = :id", nativeQuery = true)
    void actuallyUpdateItem(@Param("name")String name, @Param("description")String description, @Param("quantity")Integer quantity, @Param("id_house")Integer id_house, @Param("id")Integer id);

    /**
     * Get the description of the item by the item name, used when we want to find out more informations about a specific item and eventually update it
     * @param name The name of the item for which we want to find out the description
     * @return The item name
     */

    @Query(value = "SELECT i.description FROM HOUSEHOLD_ITEMS i WHERE i.name = :name", nativeQuery = true)
    String getItemDescriptionByItemName(@Param("name")String name);

    /**
     * Get the quantity of the item by the item name, used when we want to find out more informations about a specific item and eventually update it
     * @param name The name of the item for which we want to find out the description
     * @return The item description
     */
    @Query(value = "SELECT i.quantity FROM HOUSEHOLD_ITEMS i WHERE i.name = :name", nativeQuery = true)
    Integer getItemQuantityByItemName(@Param("name")String name);

    /**
     * Get the id of the house of the item by the item name, used when we want to find out more informations about a specific item and eventually update it
     * @param name The name of the item for which we want to find out the description
     * @return The house id in which the item is
     */
    @Query(value = "SELECT i.id_house FROM HOUSEHOLD_ITEMS i WHERE i.name = :name", nativeQuery = true)
    Integer getItemHouseIdByItemName(@Param("name")String name);



}
