package uk.co.devexe

import org.junit.Test

/**
 * Created by walpolrx on 27/10/2015.
 */
class ControllerTest {

  @Test
  def testRun() = {
    val controller = new Controller
    val seedUri = "http://discovery.nationalarchives.gov.uk/browse"
    val xpath = "//*[@class='item-title']"
    val result = controller.run(seedUri,xpath)
  }

}
