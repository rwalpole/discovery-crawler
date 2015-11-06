package uk.co.devexe

import uk.co.devexe.discovery.CrawlController

/**
 * Main entry point for the  Discover Crawler application
 *
 * Created by robkwalpole@gmail.com on 27/10/2015.
 */
class Controller {

  def run() = {
    val crawlController = CrawlController("C:\\Temp\\discovery-crawler")
    val pageReader = PageReader("urls.txt") // this needs to be configurable
    crawlController.start(1, 1, Some(1000)) // blocks until crawl complete
    pageReader.read map { page =>
      val xPathReader = XPathReader("xml/" + page + ".xml")
      val writer = XPathResultWriter(xPathReader, "out/" + page + ".txt")
      writer.write()
    }
  }

  /* TODO - create a map of phrases to matched terms for review */

}
