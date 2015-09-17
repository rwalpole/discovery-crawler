package uk.co.devexe

import java.io.{FileWriter, File, PrintWriter}

/**
 * Created by walpolrx on 17/09/2015.
 */
object CrawlLogger {

  def log(url: String) = {
    val fw = new FileWriter("test.txt", true)
    try {
      fw.write(url + "\n")
    }
    finally fw.close()
  }

}
