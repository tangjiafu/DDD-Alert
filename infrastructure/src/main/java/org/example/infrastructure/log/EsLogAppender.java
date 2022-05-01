package org.example.infrastructure.log;

import java.io.Serializable;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.example.util.GsonUtil;

/**
 * @author Lager.Tang create: 2022-04-30 21:14
 **/
@Plugin(name = "EsLogAppender", category = "Core", elementType = "appender", printObject = true)
public class EsLogAppender extends AbstractAppender {

  public EsLogAppender(String name, Filter filter,
      Layout<? extends Serializable> layout, boolean ignoreExceptions,
      Property[] properties) {
    super(name, filter, layout, ignoreExceptions, properties);
  }

  /**
   *  factory to construct this
   * @param name
   * @param filter
   * @param layout
   * @param ignoreExceptions
   * @return
   */
  @PluginFactory
  public static EsLogAppender create(@PluginAttribute("name") String name,
      @PluginElement("Filter") final Filter filter,
      @PluginElement("Layout") Layout<? extends Serializable> layout,
      @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
    return new EsLogAppender(name, filter, layout, ignoreExceptions, null);
  }


  @Override
  public void append(LogEvent logEvent) {
    System.out.println(GsonUtil.toJson(logEvent));
  }
}
