package org.example.webconfig;

import lombok.Data;

/**
 * @author Lager.Tang create: 2022-04-17 13:51
 **/
@Data
public class Response<T> {

  /**
   * code 返回code
   */
  private Integer code;
  /**
   * 返回提示语
   */
  private String msg;
  /**
   * 返回结果
   */
  private T result;
  /**
   * reqId,日志索引
   */
  private String reqId;
  /**
   * 请求耗费时间
   */
  private Integer cost;


  public Response(Integer code, String msg, T result) {
    this.code = code;
    this.msg = msg;
    this.result = result;
  }

  public static <T> Response<T> success(T result) {
    return new Response<>(0, "success", result);
  }

}
