package com.example.seminar6;

public class Oras {

    private String denumire;
    private Integer populatie;
    private String descriere;

    public Oras() {
    }

    public Oras(String denumire, Integer populatie, String descriere) {
        this.denumire = denumire;
        this.populatie = populatie;
        this.descriere = descriere;
    }

    public String getDenumire() {
        return denumire;
    }

    public Integer getPopulatie() {
        return populatie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setPopulatie(Integer populatie) {
        this.populatie = populatie;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oras{");
        sb.append("denumire='").append(denumire).append('\'');
        sb.append(", populatie=").append(populatie);
        sb.append(", descriere='").append(descriere).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
