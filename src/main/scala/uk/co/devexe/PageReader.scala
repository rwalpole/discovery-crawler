package uk.co.devexe

import java.net.{HttpURLConnection, URL}

import org.w3c.tidy.Tidy

/**
 * Created by WALPOLRX on 18/09/2015.
 */
class PageReader {

  def run() = {
    val reader = new FileReader("test.txt")
    for(urlStr <- reader.read) {
      val url = new URL(urlStr)
      val connection = url.openConnection.asInstanceOf[HttpURLConnection]
      connection.setRequestMethod("GET")
      //connection.setDoOutput() //true? false?
      connection.getInputStream // Jtidy here!
      val tidy = new Tidy() // obtain a new Tidy instance
      tidy.setXHTML(true) // set desired config options using tidy setters
      tidy.parse(connection.getInputStream, System.out); // run tidy, providing an input and output stream
      connection.disconnect()

    }
  }

}
