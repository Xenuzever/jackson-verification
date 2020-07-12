package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.example.model.xml.RSS;

public class XmlMain {

  static final Path resourcePath =
      Paths.get("./src/main/resources/google-news-rss.xml").toAbsolutePath().normalize();

  public static void main(String[] args) throws IOException {
    String xmlContent = Files.readString(resourcePath);

    RSS rss = parse(xmlContent);

    System.out.println("Size: " + rss.getChannel().getItems().size());
    System.out.println(new XmlMapper().writeValueAsString(rss));
  }

  static RSS parse(String xmlContent) throws JsonProcessingException {

    // TODO descriptionからhtmlタグを取り除く
    xmlContent = xmlContent.replaceAll("&hl=ja&gl=JP&ceid=JP:ja", "")
        .replaceAll("&nbsp;", "")
        .replaceAll("&g=prt", "")
        .replaceAll("&g=bw", "")
        .replaceAll("<a(\"[^\"]*\"|'[^']*'|[^'\">])*>","")
        .replaceAll("<font(\"[^\"]*\"|'[^']*'|[^'\">])*>","")
        .replaceAll("</a(\"[^\"]*\"|'[^']*'|[^'\">])*>","")
        .replaceAll("</font(\"[^\"]*\"|'[^']*'|[^'\">])*>","");

    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return xmlMapper.readValue(xmlContent, RSS.class);
  }
}
