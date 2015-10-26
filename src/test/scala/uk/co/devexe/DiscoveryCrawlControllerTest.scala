package uk.co.devexe

import edu.uci.ics.crawler4j.crawler.Page
import edu.uci.ics.crawler4j.url.WebURL
import org.junit.Test

/**
 * Created by walpolrx on 16/09/2015.
 */
class DiscoveryCrawlControllerTest {

  @Test
  def testRun() = {
    val controller = new DiscoveryCrawlController("C:\\Temp\\discovery-crawler")
    controller.start(1,1, Some(1000))
  }


}
