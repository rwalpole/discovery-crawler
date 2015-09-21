package uk.co.devexe

import java.util.concurrent.atomic.AtomicInteger

import edu.uci.ics.crawler4j.crawler.{Page, WebCrawler}
import edu.uci.ics.crawler4j.parser.{HtmlParseData, ParseData}
import edu.uci.ics.crawler4j.url.WebURL
import java.util.regex.Pattern

import org.slf4j.LoggerFactory

/**
 * Created by walpolrx on 16/09/2015.
 */
class DiscoveryCrawler extends WebCrawler {

  val LOG = LoggerFactory.getLogger(classOf[DiscoveryCrawlController]);
  val IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$")
  val BROWSE_PATTERN = Pattern.compile("http://.*\\.*/browse/r/h/.*")

  val counter = new AtomicInteger(0)

  override def shouldVisit(referringPage: Page, url: WebURL): Boolean = {
    val href = url.getURL.toLowerCase

    // Ignore the url if it has an extension that matches our defined set of image extensions.
    if(IMAGE_EXTENSIONS.matcher(href).matches()) {
      return false;
    }

    if(!BROWSE_PATTERN.matcher(href).matches()) {
      return false
    }

    href.startsWith("http://discovery.nationalarchives.gov.uk/")

  }

  /**
   * This function is called when a page is fetched and ready
   * to be processed by your program.
   */
  override def visit(page: Page) = {
    val url = page.getWebURL.getURL
    //counter = counter + 1;
    LOG.info("URL: " + url + " Count=" + counter.incrementAndGet())
    if(!url.contains('?') && url.contains("r/h/C")) {
      CrawlLogger.log(url) // We only want to log files without query params and where the reference starts with 'C'
    }
    //process(page.getParseData)
  }

  def process(parseData: ParseData) = parseData match {
    case htmlParseData: HtmlParseData => {
      val text = htmlParseData.getText
      val html = htmlParseData.getHtml
      val links = htmlParseData.getOutgoingUrls

      //LOG.info("Text length: " + text.length)
      //LOG.info("Html length: " + html.length)
      //LOG.info("Number of outgoing links: " + links.size)
    }
    case _ => System.out.println(parseData.getClass)
  }
}
