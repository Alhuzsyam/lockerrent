package com.titip.model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.titip.model.Enetity.User;


public interface UserRepository extends JpaRepository<User,Long> {

}
