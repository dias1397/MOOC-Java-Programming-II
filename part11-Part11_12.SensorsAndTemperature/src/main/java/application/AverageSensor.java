/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dias97
 */
public class AverageSensor implements Sensor{
    
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        return sensors.stream().noneMatch((sensor) -> (!sensor.isOn()));
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn()) {
            throw new IllegalStateException("AverageSensor is off");
        }
        
        int reading = sensors.stream().map(s -> s.read()).reduce(0, Integer::sum) / sensors.size();
        readings.add(reading);
        return reading;
    }
    
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
}
