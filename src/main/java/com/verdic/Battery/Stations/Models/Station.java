package com.verdic.Battery.Stations.Models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

@Data
@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer stationId;

    public String stationName;

    @NotNull
    public String stationImageUrl;

    public double stationPrice;

    public String stationAddress;
}
