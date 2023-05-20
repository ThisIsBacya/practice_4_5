package org.example.dto.model;

import java.util.Arrays;
import java.util.Date;

public class Reader {
    private String FIO;
    private int bilet;
    private String department;
    private int year_of_birth;
    private String phone;

    public Reader(String FIO, int bilet, String department, int year_of_birth, String phone) {
        this.FIO = FIO;
        this.bilet = bilet;
        this.department = department;
        this.year_of_birth = year_of_birth;
        this.phone = phone;
    }

    public Reader() {

    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getBilet() {
        return bilet;
    }

    public void setBilet(int bilet) {
        this.bilet = bilet;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void takeBook(int bookNum) {
        System.out.println(this.FIO+ " взял " + bookNum + " книги");
    }

    public void takeBook(String[] bookNames) {
        StringBuilder str = new StringBuilder(this.FIO + " взял книги: " + bookNames[0]);
        int i = 1;
        while (i < bookNames.length) {
            str.append(", ").append(bookNames[i]);
            i++;
        }
        System.out.println(str);
    }

    public void takeBook(Book[] book) {
        StringBuilder str = new StringBuilder(this.FIO + " взял книги: " + book[0].getName());
        int i = 1;
        while (i < book.length) {
            str.append(", ").append(book[i]);
            i++;
        }
        System.out.println(str);
    }

    public void returnBook(int num) {
        System.out.println(this.FIO+ " взял " + num + " книги");
    }

    public void returnBook(String[] bookNames) {
        StringBuilder str = new StringBuilder(this.FIO + " взял книги: " + bookNames[0]);
        int i = 1;
        while (i < bookNames.length) {
            str.append(", ").append(bookNames[i]);
            i++;
        }
        System.out.println(str);
    }

    public void returnBook(Book[] book) {
        StringBuilder str = new StringBuilder(this.FIO + " взял книги: " + book[0].getName());
        int i = 1;
        while (i < book.length) {
            str.append(", ").append(book[i]);
            i++;
        }
        System.out.println(str);
    }
}
