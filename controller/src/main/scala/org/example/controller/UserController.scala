package org.example.controller

import org.example.application.cmd.UserCreateCmd
import org.example.application.service.UserApplicationService
import org.example.vo.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, RestController}

/**
 *
 *
 * @author Lager.Tang
 *         create: 2022-04-10 19:27
 * */
@RestController
class UserController(@Autowired userApplicationService: UserApplicationService) {


  @PostMapping(Array("/v1/user/create"))
  def create(@RequestBody cmd: UserCreateCmd): Response = {
    userApplicationService.createUser(cmd)
    Response.success("")
  }

}
