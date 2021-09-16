package com.Task.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoI extends JpaRepository<User, Integer> {

}
