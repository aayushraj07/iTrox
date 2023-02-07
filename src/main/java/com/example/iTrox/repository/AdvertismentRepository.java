package com.example.iTrox.repository;

import com.example.iTrox.entity.Advertisement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertismentRepository extends JpaRepository<Advertisement, UUID> {}
