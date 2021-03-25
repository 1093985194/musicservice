package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//歌曲
public class Song {
    private Integer songId;

    private String name;

    private String img;

    private String url;

    private Integer userId;

    private String username;


}