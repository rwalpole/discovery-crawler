package uk.co.devexe

import edu.uci.ics.crawler4j.crawler.Page
import edu.uci.ics.crawler4j.url.WebURL
import org.junit._
import uk.co.devexe.discovery.DiscoveryCrawler

class DiscoveryCrawlerTest {

  @Test
  def testVisit(): Unit = {
    val crawler = new DiscoveryCrawler
    val url = new WebURL()
    url.setURL("http://discovery.nationalarchives.gov.uk/browse/r/h/C1")
    val page = new Page(url)
    crawler.visit(page)
  }

}


