import scala.io.Source
val txt = Source.fromFile("shakespeare.txt").getLines.mkString
val scenes = txt.split("SCENE")

val indexedScenes = scenes.zipWithIndex
val reff = indexedScenes.map(_._2)

val stopwords = "d my in Aaron The Abott of Westminster Lord Abergavenny Abhorson Abraham Slender Achilles Adam Adrian Adriana Don Adiano De Armado Aemilium Aeneas Antonio Mark Anthony Artemidorus Bassanio Barnardo Barnardine Basset Beatrice Bianca Romeo Juliet romeo juliet caius corin Corin Duchess Duke Emilia Ferdinand Banquo Julius Caesar Old Hamlet Earl Rivers Juliet Juno a me be at which did the and goes ah took yes E hel Des n e oft em edw Pol pr f ha Tro hair At Q Re I".split("")
def stripStopWords(s: String, stops: Array[String]) = {
  val wdlist = s.split("\\W").filterNot(_.isEmpty)
  wdlist.filterNot(stopwords.contains(_)).mkString(" ")
}



val noStopWords = scenes.map( stripStopWords(_, stopwords))
val filteredAndIndexed = reff.zip(noStopWords)

  for (pair <- filteredAndIndexed) {
    println(pair)
  }
