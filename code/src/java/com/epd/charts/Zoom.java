/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.charts;

/**
 *
 * @author nishant.vibhute
 */
public class Zoom {

    boolean enabled = true;
    boolean drag = false;
    String mode = "xy";
    Limits limits = new Limits();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDrag() {
        return drag;
    }

    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }
}
