package com.example.springbootjpql.repository;

import com.example.springbootjpql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
   //基于id查询user
   @Query("SELECT u FROM User u WHERE u.id=:id")
   User getUserById(@Param("id") int id);
}