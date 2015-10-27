package uk.co.devexe

/**
 * Created by walpolrx on 27/10/2015.
 */
object XPathResultWriter {
  def apply(reader: XPathReader, outFileName: String) = {
    new XPathResultWriter(reader, outFileName)
  }
}

class XPathResultWriter(reader: XPathReader, outFileName: String) {

  def write() = {
    reader.read match {
      case Some(nodes) => {
        var a = 0;
        for (a <- 0 to nodes.getLength - 1) {
          val text = nodes.item(a).getTextContent
          CrawlLogger.log(TextCleaner.clean(text), outFileName)
        }
      }
      case None => println("No XPath matches..")
    }
  }

}
