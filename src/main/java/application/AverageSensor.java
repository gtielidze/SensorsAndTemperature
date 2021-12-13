/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gio
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> ints;

    public AverageSensor() {
        this.sensors = new ArrayList();
        this.ints = new ArrayList();
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (int i = 0; i < sensors.size(); i++) {
            sensors.get(i).setOn();
        }
    }

    @Override
    public void setOff() {
        for (int i = 0; i < sensors.size(); i++) {
            sensors.get(i).setOff();
        }
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public int read() {
        if (this.sensors.size() == 0 || !this.isOn()) {
            throw new IllegalStateException();
        }
        int sum = 0;
        for (int i = 0; i < sensors.size(); i++) {
            sum += sensors.get(i).read();
        }
        this.ints.add(sum / sensors.size());
        return sum / sensors.size();
    }

    public List<Integer> readings() {
        return this.ints;
    }
}
