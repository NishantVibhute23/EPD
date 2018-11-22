/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.util;

import com.epd.bean.IndexData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author nishant.vibhute
 */
public class MovingAverage {

    private final Queue<Double> Dataset = new LinkedList<Double>();
    private int period;
    private double sum;

    // function to add new data in the
    // list and update the sum so that
    // we get the new mean
    public void addData(double num) {
        sum += num;
        Dataset.add(num);

        // Updating size so that length
        // of data set should be equal
        // to period as a normal mean has
        if (Dataset.size() > this.period) {
            sum -= Dataset.remove();
        }
    }

    // function to calculate mean
    public double getMean() {
        return sum / period;
    }

    public List<IndexData> getMovingAverage(List<IndexData> indexList, int period) {
        this.period = period;
        List<IndexData> indexListMA = new ArrayList<>();
        for (IndexData indexData : indexList) {
            addData(indexData.getLTP());
            indexData.setMA200(getMean());
            indexListMA.add(indexData);
        }
        return indexListMA;
    }
}
