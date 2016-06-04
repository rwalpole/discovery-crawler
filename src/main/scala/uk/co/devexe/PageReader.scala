package uk.co.devexe

import java.io.File
import java.net.{HttpURLConnection, URL}

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

/**
 * Retrieves the list of URLs from the specified file and then makes a GET request to the page which
 * it then runs through the HTML Tidy command line tool to convert the content to valid XML
 *
 * Created by robkwalpole@gmail.com on 18/09/2015.
 */
object PageReader {
  def apply(urlListFileName: String) = new PageReader(urlListFileName)
}

class PageReader(urlListFileName: String) {

  /** returns a list of the files created */
  def read(): List[String] = {
    val reader = new FileReader(urlListFileName)
    var pages = new ListBuffer[String]
    for(urlStr <- reader.read) {
      val url = new URL(urlStr)
      val connection = url.openConnection.asInstanceOf[HttpURLConnection]
      connection.setRequestMethod("GET")
      //connection.setDoOutput() //true? false?
      val page = urlStr.substring(urlStr.lastIndexOf("/")+1,urlStr.length)
      pages += page
      val htmlDir = new File("html")
      if(!htmlDir.exists()) {
        htmlDir.mkdir()
      }
      inputToFile(connection.getInputStream, new File(htmlDir,page + ".html"))
      runTidy(page)
    }
    pages.toList
  }

  def inputToFile(is: java.io.InputStream, f: java.io.File) {
    val in = scala.io.Source.fromInputStream(is)
    val out = new java.io.PrintWriter(f)
    try { in.getLines().foreach(out.print(_)) }
    finally { out.close }
  }

  def runTidy(filename: String) {
    import scala.language.postfixOps
    import scala.sys.process._
    val xmlDir = new File("xml")
    if(!xmlDir.exists()) {
      xmlDir.mkdir()
    }
    val cmd = Seq("tidy","--output-xml","true","--quote-nbsp","false","-output","./xml/" + filename + ".xml", "./html/" + filename + ".html")
    cmd !
  }

}
