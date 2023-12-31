package com.jalin.jalinappbackend.module.gamification.point.repository;

import com.jalin.jalinappbackend.module.gamification.point.entity.PointSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PointSourceRepository extends JpaRepository<PointSource, UUID> {
}
