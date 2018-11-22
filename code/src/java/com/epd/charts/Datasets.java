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
public class Datasets {

    private String label;
    private List<Double> data;
    private String borderColor;
    private int borderWidth;
    private boolean hidden;
    private boolean fill;
    private int lineTension;
    private int pointRadius;

    public Datasets() {
        this.label = "";
        this.data = new ArrayList<>();
        this.borderColor = "";
        this.borderWidth = 1;
        this.hidden = true;
        this.fill = false;
        this.lineTension = 0;
        pointRadius = 3;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int getLineTension() {
        return lineTension;
    }

    public void setLineTension(int lineTension) {
        this.lineTension = lineTension;
    }

    public int getPointRadius() {
        return pointRadius;
    }

    public void setPointRadius(int pointRadius) {
        this.pointRadius = pointRadius;
    }

}
