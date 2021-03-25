package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//歌单
public class Songlist {
    private Integer songlistId;

    private String title;

    private String style;

    private String img;

    private String introduction;

    private String username;

    private Integer userid;

}