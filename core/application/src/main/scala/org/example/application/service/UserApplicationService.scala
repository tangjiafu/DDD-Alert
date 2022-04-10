package org.example.application.service

import org.example.application.cmd.UserCreateCmd
import org.springframework.stereotype.Service

/**
 * ${description}
 *
 * @author Lager.Tang
 *         create: 2022-04-10 20:59
 * */
@Service
trait UserApplicationService {


  def createUser(cmd: UserCreateCmd): Unit
}
