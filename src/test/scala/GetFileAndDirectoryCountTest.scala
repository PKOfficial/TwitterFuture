package com.knoldus

import org.scalatest.FunSuite
import com.twitter.util.{Future,Await}


class GetFileAndDirectoryCountTest extends FunSuite{
  val getFCount = new GetFileAndDirectoryCount
  test("Valid Directory"){
    val count = getFCount.getCount("/home/prabhat/count")
    val fCount = Await.result(count)
    assert(fCount == 8)
  }
  test("Location of File")
  {
    intercept[IllegalArgumentException]{
      getFCount.getCount("/home/prabhat/count/blah")
    }
  }
  test("Invalid Location")
  {
    intercept[IllegalArgumentException]{
      getFCount.getCount("ThisIsNoAddress")
    }
  }
}