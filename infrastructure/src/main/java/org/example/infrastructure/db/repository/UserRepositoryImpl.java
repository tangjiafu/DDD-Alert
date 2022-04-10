package org.example.infrastructure.db.repository;

import javax.annotation.Resource;
import org.example.domain.aggregate.user.model.UserRoot;
import org.example.domain.aggregate.user.repository.UserRepository;
import org.example.infrastructure.db.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author Lager.Tang create: 2022-04-10 13:55
 **/
@Service
public class UserRepositoryImpl implements UserRepository {

  @Resource
  UserMapper userMapper;

  @Override
  public Void save(UserRoot user) {
    return null;
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
