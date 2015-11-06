package uk.co.devexe.ner

import uk.co.devexe.Endpoint

/**
 * Created by walpolrx on 06/11/2015.
 */
class StanbolController {

  // TODO load file and iterate - one line at a time to Stanbol

  def enhance(text: String) = {
    val client = new StanbolClient
    val inputStream = client.openConnection
//    model.read(inputStream, null, "TURTLE")
//    val town = extractValue("town", model);
//    val country = extractValue("country", model);
//    if(town.isEmpty) {
//      "Sorry, no town of birth found.";
//    } else if(country.isEmpty) {
//      "Place of birth is " + town.get + " but country unknown.";
//    } else{
//      town.get + ", " + country.get;
//    }
  }

}
