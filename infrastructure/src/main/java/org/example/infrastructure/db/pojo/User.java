package org.example.infrastructure.db.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.domain.aggregate.user.model.UserRoot;
import org.springframework.beans.BeanUtils;

/**
 * @author Lager.Tang create: 2022-04-10 13:53
 **/


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "user")
public class User {

  @TableId(type = IdType.AUTO)
  private Long id;

  private String name;

  private String email;

  private String phone;

  /**
   * 更多信息
   */
  @TableField
  private String moreInfo;


  public void from(UserRoot userRoot) {
    BeanUtils.copyProperties(userRoot, this);
  }
}
