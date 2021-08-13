package com.suraj.leetcode

import scala.collection.mutable.ListBuffer

/*
    https://leetcode.com/problems/guess-the-word/
 */
class GuessTheWord {
    def findSecretWord(wordlist: Array[String], master: Master): Unit = {
        println(s"oList  ${wordlist.mkString("Array(", ", ", ")")}")
        var oList: ListBuffer[String] = wordlist.to(ListBuffer)
        var zeroMatches: ListBuffer[String] = new ListBuffer[String]
        var chances = 10
        while (chances > 0) {
            var nList: ListBuffer[String] = new ListBuffer[String]
            var word = oList.head
            var matchCount = master.guess(word)
            chances -= 1
            if (matchCount == 6) return
            else if (matchCount == 0) {
                println(s"Before Zero ops $oList")
                zeroMatches += word
                var t_zeroMatches: ListBuffer[String] = new ListBuffer[String]
                for (i <- 1 until oList.length) {
                    if (isBelongToZeroMatches(zeroMatches, oList(i))) t_zeroMatches += oList(i)
                }
                oList --= t_zeroMatches.toList
                println(s"After Zero ops $oList")
            }
            for (i <- 1 until oList.length) {
                var str = oList(i)
                var n_matchCount = countMatches(word, str)
                if ((n_matchCount >= matchCount && matchCount != 0) ||
                    (n_matchCount == matchCount && matchCount == 0)) {
                    nList += str
                }
            }
            oList = nList
            println(s"Chance $chances , oList  $oList")
        }
        println(oList.toString())
    }

    def isBelongToZeroMatches(zeroMatches: ListBuffer[String], str: String): Boolean = {
        for (l <- zeroMatches) {
            if (countMatches(l, str) > 0) return true
        }
        false
    }

    def countMatches(s: String, l: String): Int = {
        var matches = 0
        val sChar = s.toCharArray
        val lChar = l.toCharArray
        for (i <- 0 until sChar.length) {
            if (sChar(i).equals(lChar(i))) matches += 1
        }
        println(s"$s -> $l = $matches")
        matches
    }
}

class Master(secretWord: String, guessCounter: Int) {
    var secretWordArr: Array[Char] = secretWord.toCharArray
    var guessCounterInc: Int = 0
    var foundWord = false
    def guess(word: String): Int = {
        guessCounterInc += 1
        println(s"____ Master guess counter : $guessCounterInc ___")
        if (guessCounterInc > guessCounter) {
            println("You maxed out")
            throw new Exception("Failed")
        }
        var counter = 0
        if (word.equals(secretWord)) {
            println("*** You guessed the secret word correctly  ***")
            println("..")
            foundWord = true
        }
        for (i <- secretWordArr.indices) {
            if (word.charAt(i).equals(secretWordArr(i))) counter += 1
        }
        counter
    }
}
