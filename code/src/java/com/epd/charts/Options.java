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
public class Options {

    private Scales scales;
    private Title title;
    private boolean responsive;
    private String onClick;
    private Pan pan;
    private Zoom zoom;

    public Options() {
        this.scales = new Scales();
        this.title = new Title();
        this.responsive = true;
        this.onClick = "";
        this.pan = new Pan();
        this.zoom = new Zoom();

    }

    public Scales getScales() {
        return scales;
    }

    public void setScales(Scales scales) {
        this.scales = scales;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public boolean isResponsive() {
        return responsive;
    }

    public void setResponsive(boolean responsive) {
        this.responsive = responsive;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public Zoom getZoom() {
        return zoom;
    }

    public void setZoom(Zoom zoom) {
        this.zoom = zoom;
    }

}
