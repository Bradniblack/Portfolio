import scala.io.Source
val txt = Source.fromFile("shakespeare.txt").getLines.mkString
val scenes = txt.split("SCENE")

val indexedScenes = scenes.zipWithIndex
val reff = indexedScenes.map(_._2)

val stopwords = "before ever down er Hen S OF Or away ACT Who cannot any Now who been other again where By 1 We Let i When o tis Is Exit doth Which Exeunt K never men It think day So With No Of st Why This How how up can In these some too t yet SCENE such when out must He had should As did upon If may than were let My which then come there hath us an one here Enter For or 11 am would now if them they their more she O What good A was from at But what our we no That shall on are by do To all but her The so as will him have this for be it with And s not d is that in a of to and the  d my in Aaron The Abott of Westminster Lord Abergavenny Abhorson Abraham Slender Achilles Adam Adrian Adriana Don Adiano De Armado Aemilium Aeneas Antonio Mark Anthony Artemidorus Bassanio Barnardo Barnardine Basset Beatrice Bianca Romeo Juliet romeo juliet caius corin Corin Duchess Duke Emilia Ferdinand Banquo Julius Caesar Old Hamlet Earl Rivers Juliet Juno a me be at which did the and goes ah took yes E hel Des n e oft em edw Pol pr f ha Tro hair At Q Re I".split(" ")
def stripStopWords(s: String, stops: Array[String]) = {
  val wdlist = s.split("\\W").filterNot(_.isEmpty)
  wdlist.filterNot(stopwords.contains(_)).mkString(" ")
}



val noStopWords = scenes.map( stripStopWords(_, stopwords))
val filteredAndIndexed = reff.zip(noStopWords)

  for (pair <- filteredAndIndexed) {
    println(pair._1 + "\t" + pair._2)
  }
