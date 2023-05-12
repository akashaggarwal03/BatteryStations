package com.verdic.Battery.Stations.Service;

import com.verdic.Battery.Stations.Models.Station;
import com.verdic.Battery.Stations.Repo.StationRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void saveStation(Station station) {
        stationRepository.save(station);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStationById(Integer stationId) {
        return stationRepository.findById(stationId);
    }

    public void updateStation(Integer stationId,Station station) throws FileNotFoundException{
        Optional<Station> stationOld = getStationById(stationId);

        if(stationOld.isEmpty())
            throw new FileNotFoundException("Station not found");

        deleteStation(stationOld.get().stationId);
        stationRepository.save(station);
    }

    public void deleteStation(Integer stationId) {
        stationRepository.deleteById(stationId);
    }
}
