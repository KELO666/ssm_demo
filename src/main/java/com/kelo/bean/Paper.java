package com.kelo.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Paper {
    private Integer paperId;

    @NotEmpty(message = "书名不能为空！")
    @Pattern(regexp = "[\\u4e00-\\u9fa5a-zA-Z0-9]{4,12}",message = "书籍名称长度为4-12位中英文数字组合！")
    private String name;

    @NotEmpty(message = "库存不能为空或0！")
    @Pattern(regexp = "^\\d{1,4}$",message = "库存范围为1~9999！")
    private Integer number;

    @NotEmpty(message = "描述不能为空！")
    @Pattern(regexp = "[\\u4e00-\\u9fa5a-zA-Z0-9]{10,50}",message = "描述内容至少10字，不得超过50字!")
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