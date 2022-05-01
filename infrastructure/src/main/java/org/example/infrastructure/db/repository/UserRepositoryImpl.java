package org.example.infrastructure.db.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.aggregate.user.model.UserRoot;
import org.example.domain.aggregate.user.repository.UserRepository;
import org.example.infrastructure.db.mapper.UserMapper;
import org.example.infrastructure.db.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author Lager.Tang create: 2022-04-10 13:55
 **/
@Service
@Slf4j
public class UserRepositoryImpl implements UserRepository {


  @Resource
  UserMapper userMapper;

  /**
   * @param userRoot userRoot
   * @return
   */
  @Override
  public long save(UserRoot userRoot) {
    log.info(userRoot.toString());
    User user = new User();
    user.from(userRoot);
    LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
    userLambdaQueryWrapper.eq(User::getEmail, userRoot.getEmail());
    userMapper.delete(userLambdaQueryWrapper);
    userMapper.insert(user);
    return user.getId();
  }

  @Override
  public boolean delete(String email) {
    LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
    userLambdaQueryWrapper.eq(User::getEmail, email);
    userMapper.delete(userLambdaQueryWrapper);
    return true;
  }
}
