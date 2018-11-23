/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.enums;

/**
 *
 * @author nishant.vibhute
 */
public enum TranscationType {

    Buy(1, "Buy"),
    Sell(2, "Sell"),
    Short(3, "Short"),
    Cover(4, "Cover"),
    Neutral(5, "Neutral");

    int id;
    String name;

    private TranscationType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
