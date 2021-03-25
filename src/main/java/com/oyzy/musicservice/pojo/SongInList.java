package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//在歌单的歌曲
public class SongInList {
    private Integer songId;

    private Integer songlistId;

}