package uk.co.devexe

import org.junit.Test

/**
 * Created by walpolrx on 05/10/2015.
 */
class XMLReaderTest {

  @Test
  def testRun() {
    val reader = new XMLReader("tna.xml")
    reader.read match {
      case Some(nodes) => {
        var a=0;
        for(a <- 0 to nodes.getLength-1){
          println(nodes.item(a).getTextContent)
        }
      }
      case None => println("No XPath matches..")

    }

  }
}
