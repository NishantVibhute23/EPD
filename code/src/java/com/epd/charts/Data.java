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

    private List<String> labels;
    private List<Datasets> datasets;

    public Data() {
        this.labels = new ArrayList<>();
        this.datasets = new ArrayList<>();
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Datasets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Datasets> datasets) {
        this.datasets = datasets;
    }

}
