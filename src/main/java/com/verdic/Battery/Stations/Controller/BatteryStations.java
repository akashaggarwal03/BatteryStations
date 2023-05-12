package com.verdic.Battery.Stations.Controller;

import com.verdic.Battery.Stations.Models.Station;
import com.verdic.Battery.Stations.Service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/verdic")
public class BatteryStations {

    private final StationService stationService;

    public BatteryStations(StationService stationService) {
        this.stationService = stationService;
    }


    @GetMapping("/")
    List<Station> returnAllGasStations(){
        return stationService.getAllStations();
    }
    @GetMapping("/show/{stationId}")
    Station getStationDetails(@PathParam("stationid")Integer stationId) throws FileNotFoundException{

        Optional<Station> stationDetails = stationService.getStationById(stationId);

        if(stationDetails.isPresent())
            return stationDetails.get();

        throw new FileNotFoundException("Station Does not exist.");
    }

    @PostMapping("/should")
    void addChargingStationDetails(@RequestBody @Validated Station station){
        stationService.saveStation(station);
    }

    @PutMapping("/{stationId}/edit")
    void updateStationDetails(@PathParam("stationid")Integer stationId,Station station){
        try{
            stationService.updateStation(stationId,station);
        } catch(FileNotFoundException ex){
            Logger.getLogger("Not Found");
        }
    }

    @DeleteMapping("/delete/{stationId}")
    void deleteStaion(@PathParam("stationid")Integer stationId){
        stationService.deleteStation(stationId);
    }


}
