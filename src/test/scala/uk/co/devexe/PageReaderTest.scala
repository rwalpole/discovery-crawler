package uk.co.devexe

import org.junit.Test

/**
 * Created by robkwalpole@gmail.com on 18/09/2015.
 */
class PageReaderTest {

  @Test
  def testRun() {
    val reader = new PageReader("test.txt")
    val result = reader.read()
  }
}
