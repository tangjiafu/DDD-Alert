package org.example.application.impl

import org.example.application.cmd.UserCreateCmd
import org.example.application.service.UserApplicationService
import org.example.domain.aggregate.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * ${description}
 *
 * @author Lager.Tang
 *         create: 2022-04-10 21:45
 * */
@Service
class UserApplicationServiceImpl(
                                  @Autowired userRepository: UserRepository

                                ) extends UserApplicationService {


  override def createUser(cmd: UserCreateCmd): Unit = {
    userRepository.insert()
  }
}
