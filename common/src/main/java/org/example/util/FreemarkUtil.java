package org.example.util;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author Lager.Tang create: 2022-05-01 13:16
 **/
public abstract class FreemarkUtil {

  private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

  static {
    cfg.setDefaultEncoding("UTF-8");
    cfg.unsetLocale();
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setClassicCompatible(true);
  }


  public static String resolve(String templateName, String content, Map<String, Object> param) {
    StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
    stringTemplateLoader.putTemplate(templateName, content);
    cfg.setTemplateLoader(stringTemplateLoader);
    try {
      Template tpl = cfg.getTemplate(templateName, "utf-8");
      StringWriter stringWriter = new StringWriter();
      tpl.process(param, stringWriter);
      stringWriter.flush();
      return stringWriter.toString();
    } catch (IOException | TemplateException e) {
      throw new IllegalArgumentException("freemarker template error:", e);
    }
  }

}
