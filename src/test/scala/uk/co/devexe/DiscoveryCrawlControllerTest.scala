package uk.co.devexe

import org.junit.Test
import uk.co.devexe.discovery.CrawlManager

/**
 * Created by robkwalpole@gmail.com on 16/09/2015.
 */
class DiscoveryCrawlManagerTest {

  @Test
  def testRun() = {
    val manager = new CrawlManager("/Users/rob/tmp/discovery-crawler")
    manager.start(1,1, Some(1000))
  }


}
