package smbc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import smbc.scrape.Scraper;

public class Launcher {

  public static void main(String[] args) throws Exception {
    URL imageURL = Scraper.getComicURL();
    BufferedImage comic = ImageIO.read(imageURL);
    ImageIO.write(comic, "png", comicFile());
  }

  private static File comicFile() throws Exception {
    String imageFilePath =
        Launcher.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
    return new File(imageFilePath + dateFormat.format(new Date()) + ".png");
  }
}
