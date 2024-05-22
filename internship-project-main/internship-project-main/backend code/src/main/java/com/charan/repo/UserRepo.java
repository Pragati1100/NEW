package com.charan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.charan.entity.User;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
  Optional<User> findByUidAndPswrd(String uid , String password);
  Optional<User>findByUid(String uid);

}
