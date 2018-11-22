/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.charts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhushan.koli
 */
public class Scales {

    private List<XAxes> xAxes;
    private List<YAxes> yAxes;

    public Scales() {
        this.xAxes = new ArrayList<>();
        this.yAxes = new ArrayList<>();
    }

    public List<XAxes> getxAxes() {
        return xAxes;
    }

    public void setxAxes(List<XAxes> xAxes) {
        this.xAxes = xAxes;
    }

    public List<YAxes> getyAxes() {
        return yAxes;
    }

    public void setyAxes(List<YAxes> yAxes) {
        this.yAxes = yAxes;
    }

}
