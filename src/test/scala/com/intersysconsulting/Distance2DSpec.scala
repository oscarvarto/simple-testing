package com.intersysconsulting

import org.scalatest.{FlatSpec, Matchers}

class Distance2DSpec extends FlatSpec with Matchers {
  "The euclidean distance for 2D vectors v1 and v2" should "5.0" in {
    Distance2D.d1 shouldBe Right(5.0)
  }

  "The maximum distance for 2D vectors v1 and v2" should "4.0" in {
    Distance2D.d2 shouldBe Right(4.0)
  }
}
