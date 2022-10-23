package com.test.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private Integer id;
    private String name;
    private String url;
    private String description;
    private String status;
    private String expiry_date;
    private Integer featured;
    private Integer user_id;
    private String image;
    private String created_at;
}
