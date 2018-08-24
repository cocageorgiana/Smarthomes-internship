package com.example.smarthomes.grouphomes.boundry.controller;

import com.example.smarthomes.grouphomes.boundry.exceptions.BadRequestException;
import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.transferobject.ItemDTO;
import com.example.smarthomes.grouphomes.entity.embeddable.HouseEmbeddable;
import com.example.smarthomes.grouphomes.entity.embeddable.ItemEmbeddable;
import com.example.smarthomes.grouphomes.service.HouseHoldItemService;
import com.example.smarthomes.grouphomes.service.HouseService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ItemController {

    private final HouseHoldItemService houseHoldItemService;
    private final HouseService houseService;

    @Autowired
    public ItemController(HouseHoldItemService houseHoldItemService, HouseService houseService) {
        this.houseHoldItemService = houseHoldItemService;
        this.houseService = houseService;
    }

    @RequestMapping(value = "save-item")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveItem(@RequestBody ItemDTO houseHoldItem) throws BadRequestException, JSONException {

        if(houseHoldItem.getHouseName() == null) {
            throw new BadRequestException("You need to specify the house for this item");
        }
        return houseHoldItemService.saveItem(houseHoldItem);
    }


    @RequestMapping(value = "items-house", method = RequestMethod.POST)
    public String getItemsFromHouse(@RequestBody HouseEmbeddable houseEmbeddable) throws BadRequestException, JSONException {

        if(houseEmbeddable == null) {
            throw new BadRequestException("You need to specify the name of the house for which you want the items");
        }
        return houseHoldItemService.getItemsFromHouse(houseEmbeddable.getHouseName());
    }

    @RequestMapping(value = "delete-item", method = RequestMethod.POST)
    public String deleteItem(@RequestBody ItemEmbeddable itemEmbeddable) throws JSONException {

        return houseHoldItemService.deleteItem(itemEmbeddable.getName());
    }

    @RequestMapping(value = "update-item", method = RequestMethod.PUT)
    public String updateItem(@RequestBody ItemDTO houseHoldItem) throws NotFoundException, JSONException {

        return  houseHoldItemService.updateItem(houseHoldItem);
    }

    @RequestMapping(value = "item-details", method = RequestMethod.POST)
    public String getItemDetailsByItemName(@RequestBody ItemEmbeddable itemEmbeddable) throws JSONException {

        return houseHoldItemService.getItemDetailsByItemName(itemEmbeddable.getName());
    }

}
