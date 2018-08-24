package com.example.smarthomes.grouphomes.boundry.mapper;

import com.example.smarthomes.grouphomes.boundry.transferobject.HouseDTO;
import com.example.smarthomes.grouphomes.entity.model.Group;
import com.example.smarthomes.grouphomes.entity.model.House;
import com.example.smarthomes.grouphomes.entity.model.HouseHoldItem;

public class ObjectMapper {


    public static void map2House(House house1, HouseDTO house2) {
        house1.setHouseName(house2.getHouseName());
        house1.setHouseAdress(house2.getHouseAddress());
    }

    public static void map2Item(HouseHoldItem item1, HouseHoldItem item2) {
        item1.setName(item2.getName());
        item1.setDescription(item2.getDescription());
        item1.setQuantity(item2.getQuantity());
        item1.setHouseEmbeddable(item2.getHouseEmbeddable());
    }

    public static void map2Group(Group group1, Group group2) {
        group1.setCurrentLoggedUser(group2.getCurrentLoggedUser());
        group1.setHouseEmbeddable(group2.getHouseEmbeddable());
    }
}
