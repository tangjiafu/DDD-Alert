package org.example.util;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author Lager.Tang create: 2022-03-17 15:20
 **/
public abstract class OkHttpUtils {

  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
  public static OkHttpClient client = new OkHttpClient().newBuilder()
      .connectTimeout(5, TimeUnit.SECONDS)
      .readTimeout(3, TimeUnit.MINUTES)
      .writeTimeout(3, TimeUnit.MINUTES)
      .connectionPool(new ConnectionPool(100,5L, TimeUnit.MINUTES))
      .build();

  /**
   * @param url url 包含http
   * @return 返回字符串
   */
  public static String get(String url, Map<String, String> headers) {
    Builder getBuilder = new Builder();
    getBuilder.get();
    getBuilder.url(url);
    headers.forEach(getBuilder::addHeader);
    Request request = getBuilder.build();
    try {
      Response execute = client.newCall(request).execute();
      return String.valueOf(execute.body());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String post(String url, Map<String, String> headers, String json) {
    RequestBody body = RequestBody.create(JSON, json);
    Builder postBuilder = new Builder();
    postBuilder.post(body);
    postBuilder.url(url);
    headers.forEach(postBuilder::addHeader);
    Request request = postBuilder.build();
    try (Response response = client.newCall(request).execute()) {
      if (response.isSuccessful()) {
        return String.valueOf(response.body());
      }
      throw new RuntimeException(GsonUtil.toJson(response));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
