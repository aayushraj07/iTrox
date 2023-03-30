package com.example.iTrox.repository;

import com.example.iTrox.entity.Users;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

  @Query(
      value =
          "SELECT u.userId\n" + "  FROM Users u\n" + "  ORDER BY createdAt DESC\n" + "  LIMIT 1\n")
  String findByLastUSerId();
}
