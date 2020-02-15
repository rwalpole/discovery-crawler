package uk.co.devexe

import org.junit.Test
import uk.co.devexe.discovery.CrawlManager

/**
 * Created by robkwalpole@gmail.com on 16/09/2015.
 */
class CrawlManagerTest {

  @Test
  def testRun(): Unit = {
    val manager = new CrawlManager("/Users/rob/tmp/discovery-crawler", "http://discovery.nationalarchives.gov.uk/browse")
    manager.start(1,1, Some(1000))
  }


}
