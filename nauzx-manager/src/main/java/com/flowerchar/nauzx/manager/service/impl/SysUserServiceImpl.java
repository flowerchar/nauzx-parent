package com.flowerchar.nauzx.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.flowerchar.nauzx.manager.mapper.SysUserMapper;
import com.flowerchar.nauzx.manager.service.SysUserService;
import com.flowerchar.nauzx.model.dto.system.LoginDto;
import com.flowerchar.nauzx.model.entity.system.SysUser;
import com.flowerchar.nauzx.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public LoginVo login(LoginDto loginDto) {

        String userName = loginDto.getUserName();

        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);

        if (sysUser == null){
            throw new RuntimeException("用户名不存在");
        }

        String databasePassword = sysUser.getPassword();
        String inputPassword = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        if (!inputPassword.equals(databasePassword)){
            throw new RuntimeException("密码不正确");
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue()
                .set("user:login"+token,
                        JSON.toJSONString(sysUser),
                        7,
                        TimeUnit.DAYS);

        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }
}
