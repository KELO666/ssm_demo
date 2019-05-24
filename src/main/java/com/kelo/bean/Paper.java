package com.kelo.bean;

public class Paper {
    private Integer paperId;

    private String name;

    private Integer number;

    private String detail;

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Paper(Integer paperId, String name, Integer number, String detail) {
        this.paperId = paperId;
        this.name = name;
        this.number = number;
        this.detail = detail;
    }

    public Paper() {
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}