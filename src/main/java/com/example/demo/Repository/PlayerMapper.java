package com.example.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.Player;

@Mapper
public interface PlayerMapper {
    @Select("select * from players")
    List<Player> findAll();

    @Select("select * from players where id = #{id}")
    Player findOne(Long id);

    @Insert("insert into players (name, team, position) values (#{name}, #{team}, #{position})")
    @Options(useGeneratedKeys = true)
    void save(Player player);

    @Update("update players set name = #{name}, team = #{team}, position = #{position} where id = #{id}")
    void update(Player player);

    @Delete("delete from players where id = #{id}")
    void delete(Long id);
}