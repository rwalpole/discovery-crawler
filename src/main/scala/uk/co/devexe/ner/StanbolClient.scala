package uk.co.devexe.ner

import java.io.InputStream
import java.net.{HttpURLConnection, URL}

/**
 * Created by walpolrx on 06/11/2015.
 */

object StanbolClient {
  val STANBOL_ENHANCER_URI = "http://localhost:8080/enhancer"
}

class StanbolClient {

  def openConnection: InputStream = {
    val url = new URL(StanbolClient.STANBOL_ENHANCER_URI)
    val connection = url.openConnection.asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("POST")
    connection.setRequestProperty("Accept","text/turtle")
    connection.setRequestProperty("Content-Type","text/plain")
    connection.setDoOutput(true)
    connection.getInputStream
  }

}
