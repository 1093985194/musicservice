package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//用户
public class User {
    private Integer userId;

    private String name;

    private String password;

    private String gender;

    private String img;

    private String issinger;

    private String context;

}