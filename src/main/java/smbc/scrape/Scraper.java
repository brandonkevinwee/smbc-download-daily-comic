package smbc.scrape;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scraper {

  private static Document getHTMLDoc() throws Exception {
    return Jsoup.connect("http://www.smbc-comics.com/").get();
  }

  public static URL getComicURL() throws Exception {
    Document document = getHTMLDoc();
    return new URL(document.getElementById("cc-comic").attr("src").replace(" ", "%20"));
  }
}
