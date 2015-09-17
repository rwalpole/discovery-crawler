package uk.co.devexe

import edu.uci.ics.crawler4j.crawler.{CrawlConfig, CrawlController}
import edu.uci.ics.crawler4j.fetcher.PageFetcher
import edu.uci.ics.crawler4j.robotstxt.{RobotstxtConfig, RobotstxtServer}

/**
 * Created by walpolrx on 16/09/2015.
 */
class DiscoveryCrawlController {

  def start() = {

    val config = new CrawlConfig
    config.setCrawlStorageFolder("C:\\Temp\\discovery-crawler")
    config.setMaxDepthOfCrawling(2);

    val pageFetcher = new PageFetcher(config)

    val robotstxtConfig = new RobotstxtConfig
    robotstxtConfig.setEnabled(false)
    val robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher)

    val controller = new CrawlController(config,pageFetcher, robotstxtServer)
    controller.addSeed("http://discovery.nationalarchives.gov.uk/browse")

    /*
     * Start the crawl. This is a blocking operation, meaning that your code
     * will reach the line after this only when crawling is finished.
     */
    controller.start(classOf[DiscoveryCrawler], 1)

  }

}