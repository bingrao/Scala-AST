package org.ucf.spark.ScalaAST 

import com.github.mlangc.brackets.DefaultBeautifier
import io._
import scala.io.Source
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox
import com.google.common.io.Files
import java.nio.charset.Charset
import java.io.File

object TreePrinter extends App {
  val sourcePath = "data/TrivialObject.scala"
  val rawAst = CompilerTree.parseWithMirror(sourcePath)
  TranverseTree.traverse(rawAst)
  val res = TranverseTree.applies
  
  println(DefaultBeautifier.format(showRaw(rawAst)))
  
  //res.foreach { x => println(x.toString()) }
}