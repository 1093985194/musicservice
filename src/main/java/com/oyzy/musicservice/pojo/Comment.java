package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//哪个用户在哪首歌做了哪一个评论
public class Comment {
    private Integer commentId;

    private Integer good;

    private Integer userId;

    private Integer songId;

    private String content;

    private String username;

    private String songname;
}