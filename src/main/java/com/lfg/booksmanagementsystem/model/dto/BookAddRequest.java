package com.lfg.booksmanagementsystem.model.dto;

import lombok.Data;

@Data
public class BookAddRequest {
    private String title;
    private String author;
    private int year;
}
