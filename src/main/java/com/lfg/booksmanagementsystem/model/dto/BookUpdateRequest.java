package com.lfg.booksmanagementsystem.model.dto;

import lombok.Data;

@Data
public class BookUpdateRequest {
    /**
     * 书名
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版时间
     */
    private int year;
}
