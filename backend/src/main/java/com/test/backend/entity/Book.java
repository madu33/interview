package com.test.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookmarks")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String url;
    @Column(length = 65555)
    private String description;
    private String status;
    private String expiry_date;
    private Integer featured;
    private Integer user_id;
    private String image;
    private String created_at;

}
