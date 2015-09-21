package uk.co.devexe

import org.junit.Test

/**
 * Created by WALPOLRX on 18/09/2015.
 */
class FileReaderTest {

  @Test
  def testRead() = {
    val reader = new FileReader("test.txt")
    val result = reader.read()
    println(result.size)
  }
}
