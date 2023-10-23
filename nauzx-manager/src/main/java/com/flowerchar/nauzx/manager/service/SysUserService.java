package com.flowerchar.nauzx.manager.service;


import com.flowerchar.nauzx.model.dto.system.LoginDto;
import com.flowerchar.nauzx.model.vo.system.LoginVo;

public interface SysUserService {
    LoginVo login(LoginDto loginDto);
}
