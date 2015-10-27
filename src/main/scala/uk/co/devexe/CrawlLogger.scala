package uk.co.devexe

import java.io.FileWriter

/**
 * Created by robkwalpole@gmail.com on 17/09/2015.
 */
object CrawlLogger {

  def log(text: String, fileName: String) = {
    val fw = new FileWriter(fileName, true)
    try {
      fw.write(text + "\n")
    }
    finally fw.close()
  }

}
