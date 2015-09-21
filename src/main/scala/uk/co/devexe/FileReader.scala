package uk.co.devexe

import scala.collection.mutable.ListBuffer

/**
 * Created by WALPOLRX on 18/09/2015.
 */
class FileReader(file: String) {

  def read(): List[String] = {
    var urls = new ListBuffer[String]
    val bufferedSource = io.Source.fromFile(file)
    for (line <- bufferedSource.getLines) {
      urls += line
    }
    bufferedSource.close
    urls.toList
  }
}
