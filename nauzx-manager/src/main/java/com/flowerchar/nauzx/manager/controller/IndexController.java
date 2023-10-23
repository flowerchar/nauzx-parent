package com.flowerchar.nauzx.manager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apiguardian.api.API;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {
}
