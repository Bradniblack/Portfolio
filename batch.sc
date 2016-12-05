



import java.io._
import scala.io.Source
val lines = Source.fromFile("stopwordoutput.txt").getLines.toVector
val columns = lines.map(_.split("\t"))
val chunks = columns.map(_(1))

var count = 0
for (ln <- chunks) {
count = count + 1
println("Writing batch " + count)
val doc = new File("batch" + count + ".txt")
val pw = new PrintWriter(doc)
pw.write(ln)
pw.close
}
