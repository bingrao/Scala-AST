class Trivial(y:Int) extends App {
  def add(x:Int) = x+y
  val textFile = sc.textFile("hdfs://...")
  val counts = textFile.flatMap(line => line.split(" "))
                 .map(word => (word, 1))
                 .reduceByKey(_ + _)
  counts.saveAsTextFile("hdfs://...")
}