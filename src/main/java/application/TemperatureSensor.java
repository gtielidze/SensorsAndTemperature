/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author gio
 */
public class TemperatureSensor implements Sensor {

    private boolean onOff;

    public TemperatureSensor() {
        this.onOff = false;
    }

    @Override
    public boolean isOn() {
        return this.onOff;
    }

    @Override
    public void setOn() {
        this.onOff = true;
    }

    @Override
    public void setOff() {
        this.onOff = false;
    }

    @Override
    public int read() {
        this.isOn();
        if (this.onOff == false) {
            throw new IllegalStateException();
        }
        return new Random().nextInt(61) - 30;
    }
}
