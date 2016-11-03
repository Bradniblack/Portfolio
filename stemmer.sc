
import $ivy.`com.github.rholder:snowball-stemmer:1.3.0.581.1`


import scala.io.Source
import org.tartarus.snowball.SnowballStemmer
import org.tartarus.snowball.ext.englishStemmer
val stemmer = new englishStemmer ()
stemmer.setCurrent ("Cats")
stemmer.stem()
val stemmed = stemmer.getCurrent ()
def stem (stemmer: org.tartarus.snowball.ext.englishStemmer,
  s: String) = {
  stemmer.setCurrent (s)
  stemmer.stem ()
  stemmer.getCurrent.toLowerCase
}


@main
def stemWords(fileName : String) {
  val txt = Source.fromFile(fileName).getLines.mkString(" ")
  val wds = txt.split("\\W")
  for (wd <- wds) {
    println (wd + "\t" + stem(stemmer, wd))  
  }

}
