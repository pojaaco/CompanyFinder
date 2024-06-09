package org.example.model;

public class Company {
    private int id;
    private String name;
    private String foundationDate;
    private double capital;
    private String country;
    private boolean isHeadQuarter;

    public Company(int id, String name, String foundationDate, double capital, String country, boolean isHeadQuarter) {
        this.id = id;
        this.name = name;
        this.foundationDate = foundationDate;
        this.capital = capital;
        this.country = country;
        this.isHeadQuarter = isHeadQuarter;
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

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isHeadQuarter() {
        return isHeadQuarter;
    }

    public void setHeadQuarter(boolean isHeadQuarter) {
        this.isHeadQuarter = isHeadQuarter;
    }
}
