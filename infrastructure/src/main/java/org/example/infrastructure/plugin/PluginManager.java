package org.example.infrastructure.plugin;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.example.util.FileUtil;
import org.example.util.GsonUtil;
import org.example.util.NotFoundException;

/**
 * @author Lager.Tang create: 2022-05-01 14:36
 **/
public class PluginManager {

  private static final Map<String, Plugin> pluginMap = new ConcurrentHashMap<>();

  private static final String conf_file = "plugin.conf";


  private static final String prefix = "plugin.";

  public void init() {
    File file = FileUtil.findFile(conf_file).orElseThrow(new NotFoundException(conf_file + "not found"));
    Config config = ConfigFactory.parseFile(file);
    Map<String, Object> confMap = config.root().unwrapped();
    confMap.forEach(
        (k, v) -> {
          if (k.startsWith(prefix)) {
            Plugin plugin = GsonUtil.fromJson(GsonUtil.toJson(v), Plugin.class);
            pluginMap.put(k, plugin);
          }
        }
    );
  }

}
