package com.taskMannagerTool.tasktoolservice.repository;

import com.taskMannagerTool.tasktoolservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
