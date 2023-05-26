package org.example.dto.model;

public class User {
    private int id;
    private String fam;
    private String name;
    private int group;
    private int year_of_birth;
    private int age;
    private String kategoria;
    private double rating;

    public User(int id, String fam, String name, int group, int year_of_birth, int age, String kategoria, double rating) {
        this.id = id;
        this.fam = fam;
        this.name = name;
        this.group = group;
        this.year_of_birth = year_of_birth;
        this.age = age;
        this.kategoria = kategoria;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id" + id + '\'' +
                ", fam " + fam + '\'' +
                ", name " + name + '\'' +
                ", group " + group + '\'' +
                ", year_of_birth " + year_of_birth + '\'' +
                ", age " + age + '\'' +
                ", kategoria " + kategoria + '\'' +
                ", rating " + rating + '\'' +
                "}";

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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
