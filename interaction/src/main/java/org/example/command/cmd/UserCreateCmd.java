package org.example.command.cmd;

import lombok.Data;
import org.example.domain.aggregate.user.model.UserRoot;
import org.springframework.beans.BeanUtils;

/**
 * @author Lager.Tang create: 2022-04-16 18:29
 **/
@Data
public class UserCreateCmd {

  private String email;
  private String name;
  private String phone;

  public UserRoot toUserRoot() {
    UserRoot userRoot = new UserRoot();
    BeanUtils.copyProperties(this,userRoot);
    return userRoot;
  }

}
