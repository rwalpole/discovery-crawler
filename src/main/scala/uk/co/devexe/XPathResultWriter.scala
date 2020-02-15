package uk.co.devexe

import java.io.File

/**
 * Created by rob.walpole@gmail.com on 27/10/2015.
 */
object XPathResultWriter {
  def apply(reader: XPathReader, outFileName: String): XPathResultWriter = {
    new XPathResultWriter(reader, outFileName)
  }
}

class XPathResultWriter(reader: XPathReader, outFileName: String) {

  def write(): Unit = {
    reader.read() match {
      case Some(nodes) =>
        for (a <- 0 until nodes.getLength) {
          val text = nodes.item(a).getTextContent
          val outFile = new File(outFileName)
          outFile.getParentFile.mkdirs()
          outFile.createNewFile()
          CrawlLogger.log(TextCleaner.clean(text) + ";", outFile.getAbsolutePath)
        }
      case None => println("No XPath matches..")
    }
  }

}
