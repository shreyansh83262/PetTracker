package com.pet.tracker.controller;

import com.pet.tracker.Model.UserDetails;
import com.pet.tracker.Model.UserPetLocationDetails;
import com.pet.tracker.repository.UserDetailsRepository;
import com.pet.tracker.repository.UserPetLocationDetailsRepository;
import com.pet.tracker.repository.UserPetMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PetController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserPetMappingRepository userPetMappingRepository;

    @Autowired
    UserPetLocationDetailsRepository userPetLocationDetailsRepository;

    @GetMapping("/postStoreLocation")
    public ResponseEntity<String> storeLocation() {

        return new ResponseEntity<String>("Hello", HttpStatus.OK);

    }

    @GetMapping("/getHistoricalLocationData/{id}")
    public UserPetLocationDetails getHistoricalLocationData(@PathVariable("id") Long id) {
        //@PathVariable("id") long id
        Optional<UserDetails> userDetailsData = userDetailsRepository.findById(id);
        Long userPetMappingId = userPetMappingRepository.findUserById(userDetailsData.get().getId());

        if (userDetailsData.isPresent()) {
            if(userDetailsData.get().getPremium().equals("1")){
                List<UserPetLocationDetails> userPetLocationDetails = userPetLocationDetailsRepository.findAllWithLocationDetailsLast30days(userPetMappingId);
                return (UserPetLocationDetails) userPetLocationDetails;
            }else{
                List<UserPetLocationDetails> userPetLocationDetails = userPetLocationDetailsRepository.findAllWithLocationDetailsLast24Hours(userPetMappingId);
                return  (UserPetLocationDetails) userPetLocationDetails;
            }
        } else {
            return null;
        }
    }

    @GetMapping("/getOtherPetOwnerDetails")
    public ResponseEntity getOtherPetOwnerDetails(@PathVariable("id") long userid, @PathVariable("petTagId") Long petTagId) {
        Optional<UserDetails> userDetailsData = userDetailsRepository.findById(userid);
        if (userDetailsData.isPresent()) {
            if(userDetailsData.get().getPremium().equals("1")){
                Optional<UserPetLocationDetails> userPetLocationDetailsWithLatLon =  userPetLocationDetailsRepository.findById(petTagId);
                //List<UserPetLocationDetails> userPetLocationDetails = userPetLocationDetailsRepository.findAllById(petTagId);
                return new ResponseEntity(userPetLocationDetailsWithLatLon, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        /*System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");
        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
        return new ResponseEntity("Hello", HttpStatus.OK);*/

    }

    private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
