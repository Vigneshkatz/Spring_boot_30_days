package com.example.demo.repo;

import com.example.demo.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClass extends JpaRepository<UserDetails,Long> {
//   @Override
//    UserDetails findById(Long id);
//   void deleteById(Long id);
}
