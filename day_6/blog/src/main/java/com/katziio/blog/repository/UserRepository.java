package com.katziio.blog.repository;

import com.katziio.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User findUserByEmailPassword(@Param("email") String email, @Param("password") String password);
}
