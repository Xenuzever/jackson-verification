package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.IntStream;
import org.example.model.xml.RSS;
import org.junit.Test;

public class XmlMainTest {

  @Test
  public void test() {

    IntStream.rangeClosed(1, 1)
        .peek(num -> System.out.println("Verify: " + num))
        .mapToObj(num -> verify())
        .peek(System.out::println)
        .forEachOrdered(str -> System.out.println("----------"));
  }

  static String verify() {

    try {

      String xmlContent = Files.readString(XmlMain.resourcePath);

      RSS rss = XmlMain.parse(xmlContent);

      return rss.toString();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}