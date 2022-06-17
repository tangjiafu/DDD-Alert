package org.example.infrastructure.plugin;

import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.util.FreemarkUtil;
import org.example.util.GsonUtil;
import org.example.util.OkHttpUtils;
import org.springframework.http.HttpMethod;

/**
 * @author Lager.Tang create: 2022-05-01 14:37
 **/
@Slf4j
public class Plugin {

  private String name;

  private Integer id;

  /**
   * get or post
   */
  private String method;

  /**
   * url
   */
  private String url;

  /**
   * header
   */
  private String header;
  /**
   * body
   */
  private String body;


  public void send(Map<String, Object> param) {
    String realUrl = FreemarkUtil.resolve(StringUtils.join(name, id, url), url, param);
    String realHeader = FreemarkUtil.resolve(StringUtils.join(name, header, url), url, param);
    // 处理header
    Map<String, Object> headerMap = GsonUtil.toMap(realHeader);
    Map<String, String> headerTemp = headerMap.keySet().stream().collect(Collectors.toMap(k -> k, k -> headerMap.get(k).toString()));
    // 处理body
    String rsp;
    log.info("url={},realHeader={}", realUrl, realHeader);
    if (StringUtils.equalsIgnoreCase(method, HttpMethod.GET.name().toLowerCase())) {
      rsp = OkHttpUtils.get(realUrl, headerTemp);
    } else {
      String realBody = FreemarkUtil.resolve(StringUtils.join(name, header, url), url, param);
      rsp = OkHttpUtils.post(realUrl, headerTemp, realBody);
    }
//    log.info(rsp);
  }

}
