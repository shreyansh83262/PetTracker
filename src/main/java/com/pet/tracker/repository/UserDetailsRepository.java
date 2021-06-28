package com.pet.tracker.repository;

import com.pet.tracker.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

}
