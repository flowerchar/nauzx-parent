package com.flowerchar.nauzx.manager.controller;

import com.flowerchar.nauzx.manager.service.SysUserService;
import com.flowerchar.nauzx.manager.service.impl.ValidateCodeServiceImpl;
import com.flowerchar.nauzx.model.dto.system.LoginDto;
import com.flowerchar.nauzx.model.vo.common.Result;
import com.flowerchar.nauzx.model.vo.common.ResultCodeEnum;
import com.flowerchar.nauzx.model.vo.system.LoginVo;
import com.flowerchar.nauzx.model.vo.system.ValidateCodeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ValidateCodeServiceImpl validateCodeServiceImpl;

    @Operation(summary = "登陆的方法")
    @PostMapping("login")
    public Result login(@RequestBody LoginDto loginDto){
        LoginVo loginVo = sysUserService.login(loginDto);
        return Result.build(loginVo, ResultCodeEnum.SUCCESS);
    }

    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeServiceImpl.generateValidateCode();
        return Result.build(validateCodeVo , ResultCodeEnum.SUCCESS) ;
    }
}
