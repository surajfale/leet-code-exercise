package com.suraj.leetcode

import scala.collection.mutable.ListBuffer
import scala.util.Random

/*
    https://leetcode.com/problems/guess-the-word/
 */
object GuessTheWord {
    def findSecretWord(wordlist: Array[String], master: Master): Unit = {
        var chances = 0
        var oList: ListBuffer[String] = Random.shuffle(wordlist.toList).to(ListBuffer)
        while (chances < 10) {
            // println(s"*** B: Chance $chances , oList  $oList -> ${oList.length} ***")
            var nList: ListBuffer[String] = new ListBuffer[String]
            var (word: String, matchCount: Int) = guessWord(master, oList)
            chances += 1
            if (matchCount == 6) return
            if (matchCount == 0) oList --= matchingZeroCountMembers(oList, word).toList
            for (i <- 1 until oList.length) {
                var str = oList(i)
                var n_matchCount = countMatches(word, str)
                if (n_matchCount == matchCount) {
                    //println(s"$word - $str, $n_matchCount")
                    nList += str
                }
            }
            oList = Random.shuffle(nList)
            // println(s"*** A: Chance $chances , oList  $oList -> ${oList.length} *** ${System.lineSeparator()}")
        }
    }

    private def guessWord(master: Master, oList: ListBuffer[String]) = {
        var word = oList.head
        var matchCount = master.guess(word)
        (word, matchCount)
    }

    private def matchingZeroCountMembers(oList: ListBuffer[String], word: String): ListBuffer[String] = {
        var t_zeroMatches: ListBuffer[String] = new ListBuffer[String]
        for (i <- 1 until oList.length) {
            if (countMatches(word, oList(i)) > 0) t_zeroMatches += oList(i)
        }
        t_zeroMatches
    }

    def countMatches(s: String, l: String): Int = {
        var matches = 0
        val sChar = s.toCharArray
        val lChar = l.toCharArray
        for (i <- 0 until sChar.length) {
            if (sChar(i).equals(lChar(i))) matches += 1
        }
        matches
    }
}

class Master(secretWord: String, guessCounter: Int) {
    var secretWordArr: Array[Char] = secretWord.toCharArray
    var guessCounterInc: Int = 0
    var foundWord = false

    def guess(word: String): Int = {
        guessCounterInc += 1
//        println(s"_Master guess counter : $guessCounterInc _")
        if (guessCounterInc > guessCounter) {
            //println("You maxed out")
            throw new Exception("Failed")
        }
        var counter = 0
        if (word.equals(secretWord)) {
//            println("*** You guessed the secret word correctly  ***")
            foundWord = true
        }
        for (i <- secretWordArr.indices) {
            if (word.charAt(i).equals(secretWordArr(i))) counter += 1
        }
        counter
    }
}
