package com.example.iTrox.repository;

import com.example.iTrox.entity.Organisation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, UUID> {

  @Query(
      value =
          "SELECT u.organisationId\n"
              + "  FROM Organisation u\n"
              + "  ORDER BY createdAt DESC\n"
              + "  LIMIT 1\n")
  String findByLastUSerId();
}
