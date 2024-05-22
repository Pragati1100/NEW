package com.charan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charan.entity.Leave;

import java.util.Optional;

@Repository
public interface LeaveRepo extends JpaRepository<Leave, Integer> {
	
	Optional<Leave> findByLid(String lid);

}
