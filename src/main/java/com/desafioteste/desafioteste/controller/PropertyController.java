package com.desafioteste.desafioteste.controller;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<?> postProperty(@RequestBody @Valid PropertyDto dto){
        return new ResponseEntity<>(PropertyDto.classToDto(propertyService.createNewProperty(PropertyDto.dtoToClass(dto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getDistricts(@RequestParam(required = false, defaultValue = "") String name){

        if(name.isEmpty()) {

            List<PropertyDto> properties = new ArrayList<>();

            propertyService.getAllProperties().forEach(x->properties.add(PropertyDto.classToDto(x)));

            return new ResponseEntity<>(properties, HttpStatus.ACCEPTED);

        }else {
            return new ResponseEntity<>(PropertyDto.classToDto(propertyService.getProperty(name)), HttpStatus.ACCEPTED);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable long id){
        return new ResponseEntity<>(PropertyDto.classToDto(propertyService.getProperty(id)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable long id){
        return new ResponseEntity<>(propertyService.deleteDistrict(id), HttpStatus.ACCEPTED);
    }

}