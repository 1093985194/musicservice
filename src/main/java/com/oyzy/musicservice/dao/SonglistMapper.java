package com.oyzy.musicservice.dao;

import com.oyzy.musicservice.pojo.Songlist;
import com.oyzy.musicservice.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SonglistMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table songlist
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer songlistId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table songlist
     *
     * @mbg.generated
     */
    int insert(Songlist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table songlist
     *
     * @mbg.generated
     */
    int insertSelective(Songlist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table songlist
     *
     * @mbg.generated
     */
    Songlist selectByPrimaryKey(Integer songlistId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table songlist
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Songlist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table songlist
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Songlist record);


    List<Songlist> allSongList();

    List<Songlist> selectByName(String title);
    List<Songlist> SonglistStyle(String style);
}