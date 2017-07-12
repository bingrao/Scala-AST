package org.ucf.spark.ScalaAST
import scala.reflect.runtime.universe._


object TranverseTree extends Traverser {
  var applies = List[Apply]()
  override def traverse(tree: Tree): Unit = tree match {
    case app @ Apply(fun,args) => {
       applies = app :: applies
       super.traverse(fun)
       super.traverseTrees(args)
    }
    case _ => super.traverse(tree)
  }
}