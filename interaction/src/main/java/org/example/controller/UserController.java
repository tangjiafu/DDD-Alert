package org.example.controller;

import org.example.command.cmd.UserCreateCmd;
import org.example.domain.aggregate.user.model.UserRoot;
import org.example.domain.service.UserService;
import org.example.view.UserView;
import org.example.webconfig.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lager.Tang create: 2022-04-16 17:10
 **/
@RestController
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  UserService userService;


  @PostMapping("/create-user")
  public Response<?> createUser(@RequestBody UserCreateCmd cmd) {
    UserRoot userRoot = userService.createUser(cmd.toUserRoot());
    return Response.success(new UserView().from(userRoot));
  }

}
