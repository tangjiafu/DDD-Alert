package org.example.domain.service

import org.example.domain.aggregate.user.model.UserRoot
import org.example.domain.aggregate.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * ${description}
 *
 * @author Lager.Tang
 *         create: 2022-04-17 17:41
 * */

@Component
class UserService(_userRepository: UserRepository) {

  private val log = LoggerFactory.getLogger(classOf[UserService])

  private val userRepository: UserRepository = _userRepository


  def createUser(userRoot: UserRoot): UserRoot = {
    log.info(s"${userRoot.getEmail},hello")
    val id = userRepository.save(userRoot)
    userRoot.setId(id)
    userRoot
  }

  def deleteUser(email: String): Unit = {
    userRepository.delete(email)
  }
}
