package org.example.domain.aggregate.user.model

import scala.beans.BeanProperty


/**
 * 用户聚合根
 *
 * @author Lager.Tang
 *         create: 2022-04-10 10:46
 * */
class UserRoot {

  @BeanProperty
  var id: Long = _
  @BeanProperty
  var email: String = _
  @BeanProperty
  var name: String = _
  @BeanProperty
  var phone: String = _
}
