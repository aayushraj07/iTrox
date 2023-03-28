package com.example.iTrox.repository;

import com.example.iTrox.entity.Advertisement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, UUID> {}
