package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.example.model.Root;

public class Main {

  static final Path resourcePath =
      Paths.get("./src/main/resources/test.xml").toAbsolutePath().normalize();

  public static void main(String[] args) throws IOException {

    String xmlContent = Files.readString(resourcePath);

    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    Root root = xmlMapper.readValue(xmlContent, Root.class);

    System.out.println(xmlMapper.writeValueAsString(root));
  }
}
