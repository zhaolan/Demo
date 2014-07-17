package com.thoughtworks.tb;

import java.util.ArrayList;

/**
 * Created by lanzhao on 7/16/14.
 */
public class EmployeeInfo {
    private String id;
    private String name;
    private int buddget;
    private int cost;
    private ArrayList<Borrow> borrow;
    private  ArrayList<Lend> lend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuddget() {
        return buddget;
    }

    public void setBuddget(int buddget) {
        this.buddget = buddget;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(ArrayList<Borrow> borrow) {
        this.borrow = borrow;
    }

    public ArrayList<Lend> getLend() {
        return lend;
    }

    public void setLend(ArrayList<Lend> lend) {
        this.lend = lend;
    }
}
