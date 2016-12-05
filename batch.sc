



import java.io._
import scala.io.Source
val lines = SOurce.fromFile().getLines.toVector

var count = 0
for (ln <- lines) {
count = count + 1
println("Writing batch " + count)
val doc = new File("batch" + count + ".txt")
val pw = new PrintWriter(doc)
pw.write(ln)
pw.close
}
