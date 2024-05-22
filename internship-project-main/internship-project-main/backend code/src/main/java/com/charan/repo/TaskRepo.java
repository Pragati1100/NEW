package com.charan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.charan.entity.Task;

import java.util.Optional;


@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    Optional<Task> findByTsid(String id);
}
