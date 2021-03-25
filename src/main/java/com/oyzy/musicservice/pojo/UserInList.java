package com.oyzy.musicservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//用户创建或收藏的歌单
public class UserInList {
    private Integer userId;

    private Integer songlistId;

    private Integer creator;

}