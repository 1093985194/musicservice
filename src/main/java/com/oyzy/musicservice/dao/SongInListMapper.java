package com.oyzy.musicservice.dao;

import com.oyzy.musicservice.pojo.SongInList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongInListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song_list
     *
     * @mbg.generated
     */
    int insert(SongInList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song_list
     *
     * @mbg.generated
     */
    int insertSelective(SongInList record);

    int deleteBySongid(Integer songid);

    int deleteBySongListid(Integer songListid);

    List<Integer> selectBySongListId(int SongListId);
}