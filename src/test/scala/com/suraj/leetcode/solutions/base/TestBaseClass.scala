package com.suraj.leetcode.solutions.base

import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite

class TestBaseClass extends AnyFunSuite with BeforeAndAfterAll {
    override def beforeAll(): Unit = {
        println(s"Starting Test For ${this.getClass.getSimpleName} ${System.lineSeparator()}")
    }

    override def afterAll(): Unit = {
        println(s"Done Testing For ${this.getClass.getSimpleName} ${System.lineSeparator()}")
    }
}
