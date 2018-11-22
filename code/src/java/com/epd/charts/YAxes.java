/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.charts;

/**
 *
 * @author bhushan.koli
 */
public class YAxes {

    private ScaleLabel scaleLabel;
    private Ticks ticks;

    public YAxes() {
        this.scaleLabel = new ScaleLabel();
        this.ticks = new Ticks();
    }

    public ScaleLabel getScaleLabel() {
        return scaleLabel;
    }

    public void setScaleLabel(ScaleLabel scaleLabel) {
        this.scaleLabel = scaleLabel;
    }

    public Ticks getTicks() {
        return ticks;
    }

    public void setTicks(Ticks ticks) {
        this.ticks = ticks;
    }

}
