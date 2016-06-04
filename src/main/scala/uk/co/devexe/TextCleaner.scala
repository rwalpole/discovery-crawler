package uk.co.devexe

/**
 * Performs clean up of text such as phrase and carriage return removal
 *
 * Created by robkwalpole@gmail.com on 27/10/2015.
 */
object TextCleaner {

  def clean(text: String): String = {
    dropPhrases(text).replaceAll("[\n\r]"," ").trim
  }

  private def dropPhrases(text: String): String = {
    text.replace("Records created or inherited by the","")
      .replace("Records of the","")
      .replace("Records of","")
      .replace("and its predecessors","")
      .replace("and predecessors","")
      .replace("and successor","")
      .replace(", and of successor","")
      .replace("and related bodies","")
      .replace("and of related bodies","")

  }

}
