package com.viran.ecom.repository;


import com.viran.ecom.entity.User;
import com.viran.ecom.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    User findByRole(UserRole userRole);
}
