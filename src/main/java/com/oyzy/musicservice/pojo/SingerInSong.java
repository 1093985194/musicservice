package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//用户创作或收藏歌曲
public class SingerInSong {
    private Integer userId;

    private Integer songId;

    private Integer creator;


}