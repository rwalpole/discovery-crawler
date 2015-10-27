package uk.co.devexe

import org.junit.Test

/**
 * Created by walpolrx on 05/10/2015.
 */
class XPathReaderTest {

  @Test
  def testRun() {
    val reader = new XPathReader("tna.xml")
    val writer = new XPathResultWriter(reader, "output.txt")
    writer.write()
  }
}
