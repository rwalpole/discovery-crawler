package uk.co.devexe

import java.io.{FileInputStream, InputStreamReader}
import javax.xml.xpath.{XPathConstants, XPathFactory}

import org.w3c.dom.NodeList
import org.xml.sax.InputSource

/**
 * Reads the XML file output by HTML Tidy and uses XPath to extract the interesting information
 *
 * Created by robkwalpole@gmail.com on 05/10/2015.
 */
object XPathReader {
  def apply(page: String) = new XPathReader(page: String)
}

class XPathReader(page: String) {

  def read(): Option[NodeList] = {
    val xPathFactory = XPathFactory.newInstance()
    val xPath = xPathFactory.newXPath()
    val expr = xPath.compile("//*[@class='item-title']")
    val reader = new InputStreamReader(new FileInputStream(page))
    expr.evaluate(new InputSource(reader), XPathConstants.NODESET) match {
      case nodes: NodeList => Some(nodes)
      case _ => None
    }
  }

}
