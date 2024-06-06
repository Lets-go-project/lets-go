package com.example.letsGo.dao.mybatis.mapper;

import com.example.letsGo.domain.member.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM Member WHERE id = #{id}")
    User findById(String id);
}
