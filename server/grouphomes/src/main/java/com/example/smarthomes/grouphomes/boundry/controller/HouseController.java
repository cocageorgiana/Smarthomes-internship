package com.example.smarthomes.grouphomes.boundry.controller;

import com.example.smarthomes.grouphomes.boundry.exceptions.BadRequestException;
import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.mapper.ObjectMapper;
import com.example.smarthomes.grouphomes.boundry.transferobject.HouseDTO;
import com.example.smarthomes.grouphomes.entity.embeddable.CurrentLoggedUser;
import com.example.smarthomes.grouphomes.entity.embeddable.HouseEmbeddable;
import com.example.smarthomes.grouphomes.entity.model.House;
import com.example.smarthomes.grouphomes.service.HouseService;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HouseController {

    private final static Logger logger = Logger.getLogger(HouseController.class);

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @RequestMapping(value = "save-house")
    @PostMapping
    @CrossOrigin(origins = "*")
    public String saveHouse(@RequestBody HouseDTO house) throws BadRequestException, JSONException {

        if (house == null) {
            logger.error(new BadRequestException("You can't send null data, exit status = 500"));
            throw new BadRequestException("You can't send null data");
        }
        return houseService.saveHouse(house);
    }

    @RequestMapping(value = "delete-house", method = RequestMethod.POST)
    @CrossOrigin
    public String deleteHouse(@RequestBody HouseEmbeddable houseEmbeddable) throws JSONException, BadRequestException {

        if(houseEmbeddable == null) {
            logger.error(new BadRequestException("You need to specify the house name you want to delete"));
            throw new BadRequestException("You need to specify the house name you want to delete");
        }
        return houseService.deleteHouse(houseEmbeddable.getHouseName());
    }

    @PutMapping(value = "update-house")
    @CrossOrigin
    public String updateHouse(@RequestBody HouseDTO house) throws NotFoundException, JSONException {

        return houseService.updateHouse(house);
    }

    @GetMapping(value = "get-houses")
    @CrossOrigin
    public String getAllHouses() throws JSONException {
        return houseService.getAllHomes();
    }

    @PostMapping(value = "houses-user")
    @CrossOrigin
    public String housesUser(@RequestBody HouseEmbeddable houseEmbeddable) throws JSONException {

        return houseService.getUsersPerHouse(houseEmbeddable.getHouseName());
    }

    @PostMapping(value = "user-houses")
    @CrossOrigin
    public String userHouses(@RequestBody CurrentLoggedUser currentLoggedUser) throws JSONException {

        return houseService.getHousesPerUser(currentLoggedUser.getUserNameCurrent());
    }
}
