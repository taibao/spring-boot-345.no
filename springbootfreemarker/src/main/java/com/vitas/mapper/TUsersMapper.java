package com.vitas.mapper;

import com.vitas.pojo.TUsers;
import com.vitas.pojo.TUsersExample;
import java.util.List;

import com.vitas.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface TUsersMapper {
    long countByExample(TUsersExample example);

    int deleteByExample(TUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUsers record);

    int insertSelective(TUsers record);

    List<TUsers> selectByExample(TUsersExample example);

    TUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUsers record, @Param("example") TUsersExample example);

    int updateByExample(@Param("record") TUsers record, @Param("example") TUsersExample example);

    int updateByPrimaryKeySelective(TUsers record);

    int updateByPrimaryKey(TUsers record);
}