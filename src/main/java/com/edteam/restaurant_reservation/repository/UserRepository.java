package com.edteam.restaurant_reservation.repository;

import com.edteam.restaurant_reservation.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
    boolean existsByEmail(String email);
}

