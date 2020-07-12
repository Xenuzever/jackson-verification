package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.IntStream;
import org.example.model.Root;
import org.junit.Test;

public class MainTest {

  @Test
  public void test() {

    /**
     * Item のリストを static で保持しているため、
     * 連続実行しても内容が正確であることを確かめる。
     */
    IntStream.rangeClosed(1, 3)
        .peek(num -> System.out.println("Verify: " + num))
        .mapToObj(num -> verify())
        .peek(System.out::println)
        .forEachOrdered(str -> System.out.println("----------"));
  }

  static String verify() {

    try {

      String xmlContent = Files.readString(Main.resourcePath);

      XmlMapper xmlMapper = new XmlMapper();
      xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      Root root = xmlMapper.readValue(xmlContent, Root.class);

      return root.toString();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}