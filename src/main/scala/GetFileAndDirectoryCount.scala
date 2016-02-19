package com.knoldus

import java.io.File
import com.twitter.util.Future

class GetFileAndDirectoryCount {

  def inDirectoryFiles(inDir:List[File]):Int={
    if(inDir.exists(_.isDirectory)) {
      inDir.length + inDirectoryFiles(inDir.flatMap(_.listFiles.filter(_.isDirectory).toList))
    }
    else
      inDir.count(_.isFile)
  }

  def getCount(dir:String):Future[Int]={

    val file = new File(dir)
    
    require(file.exists() && file.isDirectory)

    val future:Future[Int]=Future {
      file.listFiles.filter(_.isFile).toList.length + inDirectoryFiles(file.listFiles.filter(_.isDirectory).toList)
    }
    future

  }

}
