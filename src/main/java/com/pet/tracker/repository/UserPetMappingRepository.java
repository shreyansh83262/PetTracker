package com.pet.tracker.repository;

import com.pet.tracker.Model.UserPetLocationDetails;
import com.pet.tracker.Model.UserPetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPetMappingRepository extends JpaRepository<UserPetMapping,Long> {
    @Query(nativeQuery=true,value="select pettagid from UserPetMapping where userid = :userid LIMIT 1")
    Long findUserById(@Param("userid") Long userid);

}
