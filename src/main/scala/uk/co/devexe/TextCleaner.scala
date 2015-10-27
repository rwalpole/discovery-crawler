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

  def dropPhrases(text: String): String = {
    text.replace("Records created or inherited by the","")
      .replace("Records of the","")
      .replace("Records of","")
  }

}
