package com.verdic.Battery.Stations.Repo;

import com.verdic.Battery.Stations.Models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
This repository interface extends Spring Data JPA's
JpaRepository interface and specifies the Station model as the entity type and Integer as the ID type.
 */
public interface StationRepository extends JpaRepository<Station, Integer> {
}
