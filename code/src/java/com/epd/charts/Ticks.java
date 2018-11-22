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
public class Ticks {

    private double stepSize;
    private String userCallback = "";
    private boolean beginAtZero;
    private double maxRotation;
    private double minRotation;

    public Ticks() {
        this.stepSize = 100000;
        this.beginAtZero = false;
    }

    public double getStepSize() {
        return stepSize;
    }

    public void setStepSize(double stepSize) {
        this.stepSize = stepSize;
    }

    public String getUserCallback() {
        return userCallback;
    }

    public void setUserCallback(String userCallback) {
        this.userCallback = userCallback;
    }

    public boolean isBeginAtZero() {
        return beginAtZero;
    }

    public void setBeginAtZero(boolean beginAtZero) {
        this.beginAtZero = beginAtZero;
    }

    public double getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(double maxRotation) {
        this.maxRotation = maxRotation;
    }

    public double getMinRotation() {
        return minRotation;
    }

    public void setMinRotation(double minRotation) {
        this.minRotation = minRotation;
    }

}
