package org.example.infrastructure.db.repository;

import javax.annotation.Resource;
import org.example.domain.aggregate.user.model.UserRoot;
import org.example.domain.aggregate.user.repository.UserRepository;
import org.example.infrastructure.db.mapper.UserMapper;
import org.example.infrastructure.db.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author Lager.Tang create: 2022-04-10 13:55
 **/
@Service
public class UserRepositoryImpl implements UserRepository {

  @Resource
  UserMapper userMapper;

  /**
   * @param userRoot userRoot
   * @return
   */
  @Override
  public long save(UserRoot userRoot) {
    User user = new User();
    user.from(userRoot);
    userMapper.insert(user);
    return user.getId();
  }

  @Override
  public boolean delete() {
    return false;
  }

  @Override
  public long insert() {
    return 0;
  }
}
