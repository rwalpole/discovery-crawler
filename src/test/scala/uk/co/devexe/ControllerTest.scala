package uk.co.devexe

import org.junit.Test

/**
 * Created by robkalpole@gmail.com on 27/10/2015.
 */
class ControllerTest {

  @Test
  def testRun(): Unit = {
    val controller = new Controller
    val seedUri = "https://discovery.nationalarchives.gov.uk/browse"
    val xpath = "//*[@class='item-title']"
    controller.run(seedUri,xpath)
  }

}
