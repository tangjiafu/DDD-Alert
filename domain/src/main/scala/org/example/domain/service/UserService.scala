package org.example.domain.service

import org.example.domain.aggregate.user.model.UserRoot
import org.example.domain.aggregate.user.repository.UserRepository
import org.springframework.stereotype.Component

/**
 * ${description}
 *
 * @author Lager.Tang
 *         create: 2022-04-17 17:41
 * */

@Component
class UserService(
                   _userRepository: UserRepository
                 ) {
  private val userRepository: UserRepository = _userRepository


  def createUser(userRoot: UserRoot): UserRoot = {
    val id = userRepository.save(userRoot)
    userRoot.setId(id)
    userRoot
  }
}
