package org.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author Lager.Tang create: 2022-04-30 11:17
 **/
public abstract class GsonUtil {

  private static final Gson defaultGson = new GsonBuilder()
      .serializeNulls()
      .setPrettyPrinting()
      .create();

  public Gson genGson() {
    return defaultGson;
  }

  public static <T> T fromJson(String json, Class<T> classOfT) {
    return defaultGson.fromJson(json, classOfT);
  }


  public static <T> T fromJson(String json, Type type) {
    return defaultGson.fromJson(json, type);
  }


  public static <T> T fromJson(String json, Class<T> classOfT, GsonBuilder gson) {

    return gson.create().fromJson(json, classOfT);
  }

  public static String toJson(Object obj) {
    return defaultGson.toJson(obj);
  }

  public static String toJson(Object obj, GsonBuilder gson) {
    return gson.create().toJson(obj);
  }


  public static Map<String, Object> toMap(String json) {
    return defaultGson.fromJson(json, new TypeToken<Map<String, Object>>() {
    }.getType());
  }

  public static Map<String, Object> toMap(Object obj) {
    String json = defaultGson.toJson(obj);
    return toMap(json);
  }
}
