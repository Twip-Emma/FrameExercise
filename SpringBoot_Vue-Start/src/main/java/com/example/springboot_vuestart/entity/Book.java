package com.example.springboot_vuestart.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String name;
    private String author;

//    @JsonIgnore//字段忽略
//    private Float price;

    protected Float price;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
}
