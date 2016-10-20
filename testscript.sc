import scala.io.Source
val lines = Source.fromFile("caesar.txt").getLines.toVector

println("Read" + lines.size + "sections")



val txt = lines.mkString

val words = txt.split("\\W+").filterNot(_.isEmpty)

println("Read" + words.size + "words.")
val grouped = words.groupBy(w => w)
println("Read" + grouped.size + "unique words.")

val freqs = grouped.map { case (k, v) => (k, v.size) }
val sorted = freqs.toSeq.sortBy(_._2)
for (wd <- sorted){
  println(wd)
}
