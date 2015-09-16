package uk.co.devexe

import edu.uci.ics.crawler4j.crawler.{Page, WebCrawler}
import edu.uci.ics.crawler4j.parser.{HtmlParseData, ParseData}
import edu.uci.ics.crawler4j.url.WebURL
import java.util.regex.Pattern

/**
 * Created by walpolrx on 16/09/2015.
 */
class DiscoveryCrawler extends WebCrawler {

  val IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$")

  override def shouldVisit(referringPage: Page, url: WebURL): Boolean = {
    val href = url.getURL.toLowerCase

    // Ignore the url if it has an extension that matches our defined set of image extensions.
    if (IMAGE_EXTENSIONS.matcher(href).matches()) {
      return false;
    }

    // Only accept the url if it is in the "www.ics.uci.edu" domain and protocol is "http".
    return href.startsWith("http://discovery.nationalarchives.gov.uk/");
  }

  /**
   * This function is called when a page is fetched and ready
   * to be processed by your program.
   */
  override def visit(page: Page) = {
    val url = page.getWebURL.getURL
    System.out.println("URL: " + url)
    process(page.getParseData)
  }

  def process(parseData: ParseData) = parseData match {
    case htmlParseData: HtmlParseData => {
      val text = htmlParseData.getText
      val html = htmlParseData.getHtml
      val links = htmlParseData.getOutgoingUrls

      System.out.println("Text length: " + text.length)
      System.out.println("Html length: " + html.length)
      System.out.println("Number of outgoing links: " + links.size)
    }
    case _ => System.out.println(parseData.getClass)
  }
}
