package org.example.util;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class FileUtil {


  /**
   * find file in classpath
   *
   * @param filename
   * @return
   */
  public static Optional<File> findFile(String filename) {
    String classpath = System.getProperty("java.class.path");

    StringTokenizer tokenizer = new StringTokenizer(classpath, File.pathSeparator);
    while (tokenizer.hasMoreElements()) {
      String path = tokenizer.nextToken();
      File fileOrDir = new File(path).getAbsoluteFile();
      if (fileOrDir.isFile()) {
        File target = new File(fileOrDir.getParent(), filename);
        if (target.exists()) {
          return Optional.of(target);
        }
      } else {
        File target = new File(fileOrDir, filename);
        if (target.exists()) {
          return Optional.of(target);
        }
      }
    }
    return Optional.empty();
  }

  /**
   * 递归向上查找配置
   *
   * @param filename 文件相对jar路径名称
   * @param clazz    jar
   * @return
   */
  public static Optional<File> findFile(String filename, Class<?> clazz) {
    Optional<File> fileByResource = findFileByResource(filename, clazz);
    if (fileByResource.isPresent()) {
      return fileByResource;
    }
    Optional<File> fileByUserDir = findFileByUserDir();
    if (fileByUserDir.isPresent()) {
      return fileByUserDir;
    }
    Optional<File> fileByNewFile = fineFileByNewFile(filename);
    if (fileByNewFile.isPresent()) {
      return fileByNewFile;
    }
    return findFile(filename);
  }


  private static Optional<File> findFileByResource(String filename, Class<?> clazz) {
    URL resource = clazz.getResource("/");
    if (null == resource || null == filename) {
      return Optional.empty();
    }
    String path = resource.getPath();
    if (path.startsWith("file:")) {
      path = path.substring(5);
    }
    return findFile(path, filename);
  }

  private static Optional<File> findFileByUserDir() {
    String classpath = System.getProperty("user.dir");
    return findFile(classpath);
  }

  private static Optional<File> fineFileByNewFile(String filename) {
    File directory = new File("");
    return findFile(directory.getAbsolutePath(), filename);
  }


  /**
   * 逐层向上查找文件
   *
   * @param path     路径
   * @param filename 文件名
   * @return 文件
   */
  private static Optional<File> findFile(String path, String filename) {
    if (StringUtils.isAnyBlank(path, filename)) {
      return Optional.empty();
    }
    File file = new File(path);
    while (file != null) {
      String target = file.getPath() + (filename.startsWith("/") ? "" : "/") + filename;
      File resFile = new File(target);
      if (resFile.exists()) {
        return Optional.of(resFile);
      }
      file = file.getParentFile();
    }
    return Optional.empty();
  }
}
