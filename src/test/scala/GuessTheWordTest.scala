package com.suraj.leetcode

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable

class GuessTheWordTest extends AnyFunSuite {
    test("Test Case 1") {
        val inPutMap = mutable.HashMap[String, Array[String]]("abcczz" -> Array("poiuhv", "rtghjk", "qazwsx",
            "bnmkjh", "abopcz", "wcckzz", "acckzz", "ghjczz",
            "ccbazz", "eiowzz", "jhkbnm", "abcczz"))
        assert(execute(inPutMap))
    }

    test("Test Case 2") {
        val inPutMap = mutable.HashMap("ccoyyo" -> Array("wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm",
            "dqefpt", "kmjmxr", "ihkovg", "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc",
            "kodlta", "ckfzjh", "phuepp", "rokoro", "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix",
            "fnugyu", "lkxwru", "mhtrvb", "xxonmg", "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda",
            "vyuica", "mbnagm", "uinqur", "pikenp", "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow",
            "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl",
            "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty",
            "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg",
            "ooxarg", "vcvfry", "thaawc", "bssybb", "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda",
            "kaefne", "swcrkh", "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm",
            "fgtuki", "zcffuv", "srxuus", "pydgmq"))

        assert(execute(inPutMap))
    }

    def execute(inPutMap: mutable.HashMap[String, Array[String]]): Boolean = {
        var flag = false
        inPutMap.foreach(item => {
            val master = new Master(item._1, 10)
            new GuessTheWord().findSecretWord(item._2, master)
            flag = master.foundWord
        })
        flag
    }
}
