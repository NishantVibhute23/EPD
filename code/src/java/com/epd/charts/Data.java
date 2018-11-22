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
public class Data {

    private List<Double> labels;
    private List<Datasets> datasets;

    public Data() {
        this.labels = new ArrayList<>();
        this.datasets = new ArrayList<>();
    }

    public List<Double> getLabels() {
        return labels;
    }

    public void setLabels(List<Double> labels) {
        this.labels = labels;
    }

    public List<Datasets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Datasets> datasets) {
        this.datasets = datasets;
    }

}
