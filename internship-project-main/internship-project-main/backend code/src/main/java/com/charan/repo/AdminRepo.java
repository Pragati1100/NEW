package com.charan.repo;

import com.charan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.charan.entity.Admin;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByAdidAndPassword( Integer aid , String password);
}
