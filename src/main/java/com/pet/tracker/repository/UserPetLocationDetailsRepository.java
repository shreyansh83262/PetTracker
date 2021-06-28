package com.pet.tracker.repository;

import com.pet.tracker.Model.UserPetLocationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UserPetLocationDetailsRepository extends JpaRepository<UserPetLocationDetails,Long> {


    @Query(nativeQuery=true,value="select * from user_pet_location_details where petTagId = :pettagid and locationtimestamp > now() - interval 24 hour")
    List<UserPetLocationDetails> findAllWithLocationDetailsLast24Hours(
            @Param("pettagid") Long pettagid);

    @Query(nativeQuery=true,value="select * from UserPetLocationDetails where petTagId = :pettagid and locationtimestamp > now() - interval 30 day")
    List<UserPetLocationDetails> findAllWithLocationDetailsLast30days(
            @Param("pettagid") Long pettagid);

    /*@Query("SELECT pettagid, (3959 * acos (cos ( radians(:latitude))* cos( radians(lat))* cos( radians(lng) - radians(:Longitude))+ sin (radians(78.3232)) * sin( radians(lat)))) AS distance FROM UserPetLocationDetails HAVING distance < 5 ORDER BY distance ")
    List<UserPetLocationDetails> findAllWithin5miles(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
*//*
   @Query("select * from UserPetLocationDetails where petTagId = :pettagid and locationdatetime > now() - interval 30 day")
   List<UserPetLocationDetails> findAllWithin5miles(
           @Param("latitude") Double latitude, @Param("longitude") Double longitude);

    *//*@Query("select a.* from ( SELECT latitude,longitude FROM UserPetLocationDetails WHERE pettagid = :pettagid ORDER BY locationTimeStamp desc ) a LIMIT 1 ")
    Map<String, Object> findLatLon(@Param("pettagid") Long pettagid);*//*
    @Query("select * from UserPetLocationDetails where petTagId = :pettagid and locationdatetime > now() - interval 30 day")
    Map<String, Object> findLatLon(
            @Param("pettagid") Long pettagid);*/

}

