package com.flowerchar.nauzx.manager.service;


import com.flowerchar.nauzx.model.dto.system.LoginDto;
import com.flowerchar.nauzx.model.entity.system.SysUser;
import com.flowerchar.nauzx.model.vo.system.LoginVo;

public interface SysUserService {
    LoginVo login(LoginDto loginDto);

    SysUser getUserInfo(String token);

    void logout(String token);
}
