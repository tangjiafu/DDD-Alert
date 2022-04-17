package org.example.view;

import lombok.Data;
import org.example.domain.aggregate.user.model.UserRoot;
import org.springframework.beans.BeanUtils;

/**
 * @author Lager.Tang create: 2022-04-17 14:17
 **/
@Data
public class UserView {

  private Long userId;
  private String name;
  private String email;

  public UserView from(UserRoot userRoot) {
    this.setUserId(userRoot.getId());
    BeanUtils.copyProperties(userRoot, this);
    return this;
  }
}
