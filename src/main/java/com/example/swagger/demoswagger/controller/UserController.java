package com.example.swagger.demoswagger.controller;

import com.example.swagger.demoswagger.User;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Api(value = "User 처리 API", tags = "User apis")
@Controller
@RequestMapping(value = "/user")
public class UserController {

    Random random = new Random();

    @ApiOperation(value = "아이디로 User 찾기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "자용자아이디", required = true, dataTypeClass = Long.class, defaultValue = "")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(new User(id, String.valueOf(random.nextLong())));
    }

    @ApiOperation(value = "전체 User 조회")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(Lists.newArrayList(new User(random.nextLong(), String.valueOf(random.nextLong()))));
    }

    @ApiOperation(value = "User 생성")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<User> create(@RequestBody final User user) {
        return ResponseEntity.ok(user);
    }
}