package org.example.dto.model;

public class Avtor {
    private int id;
    private String fam;
    private String name;
    private int god_r;
    private String pol;

    public Avtor(int id, String fam, String name, int god_r, String pol) {
        this.id = id;
        this.fam = fam;
        this.name = name;
        this.god_r = god_r;
        this.pol = pol;
    }

    public Avtor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGod_r() {
        return god_r;
    }

    public void setGod_r(int god_r) {
        this.god_r = god_r;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }
}
