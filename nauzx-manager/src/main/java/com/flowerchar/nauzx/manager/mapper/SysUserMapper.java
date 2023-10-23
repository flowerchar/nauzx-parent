package com.flowerchar.nauzx.manager.mapper;

import com.flowerchar.nauzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {

    @Select("select id, username, password, name, phone, avatar, description, status, create_time, update_time, is_deleted from sys_user where username=#{username}")
    SysUser selectUserInfoByUserName(String userName);
}
