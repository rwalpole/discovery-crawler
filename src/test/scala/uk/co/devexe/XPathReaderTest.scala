package uk.co.devexe

import org.junit.Test

/**
 * Created by robkwalpole@gmail.com on 05/10/2015.
 */
class XPathReaderTest {

  @Test
  def testRun() {
    val reader = new XPathReader("tna.xml","//*[@class='item-title']")
    val writer = new XPathResultWriter(reader, "output.txt")
    writer.write()
  }
}
