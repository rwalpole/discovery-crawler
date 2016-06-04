package uk.co.devexe.discovery

import edu.uci.ics.crawler4j.crawler.{CrawlConfig, CrawlController}
import edu.uci.ics.crawler4j.fetcher.PageFetcher
import edu.uci.ics.crawler4j.robotstxt.{RobotstxtConfig, RobotstxtServer}

/**
 * Created by robkwalpole@gmail on 16/09/2015.
 */
object CrawlManager {
  def apply(crawlStorageDir: String, seedUri: String) = {
    new CrawlManager(crawlStorageDir, seedUri)
  }
}

class CrawlManager(crawlStorageDir: String, seedUri: String) {

  /**
    * Initiates a crawl to the specified depth with the specified number of crawlers at the
    * specified politeness interval
    *
    * @param depth
    * @param crawlers
    * @param politenessMillisOpt
    */
  def start(depth: Int, crawlers: Int, politenessMillisOpt: Option[Int]) = {

    val config = new CrawlConfig
    config.setCrawlStorageFolder(crawlStorageDir)
    config.setMaxDepthOfCrawling(depth);
    config.setPolitenessDelay(politenessMillisOpt.getOrElse(200));

    val pageFetcher = new PageFetcher(config)

    val robotstxtConfig = new RobotstxtConfig
    robotstxtConfig.setEnabled(false)
    val robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher)

    val controller = new CrawlController(config, pageFetcher, robotstxtServer)
    controller.addSeed(seedUri)

    /*
     * Start the crawl. This is a blocking operation, meaning that your code
     * will reach the line after this only when crawling is finished.
     */
    controller.start(classOf[DiscoveryCrawler], crawlers)

  }

}