package org.example.domain.aggregate.user.repository

import org.example.domain.aggregate.user.model.UserRoot

/**
 * ${description}
 *
 * @author Lager.Tang
 *         create: 2022-04-10 13:48
 * */
trait UserRepository {

  def save(user: UserRoot): Void

  def delete(): Boolean

  def insert(): Long
}
