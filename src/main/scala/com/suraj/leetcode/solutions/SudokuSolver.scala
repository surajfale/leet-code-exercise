package com.suraj.leetcode.solutions

class SudokuSolver {
    var outPutArray = new Array[Array[Char]](9)

    def solveSudoku(board: Array[Array[Char]]): Unit = {
        val printStr = formatBoard(board)
        println(s"Given Input: $printStr")
    }

    def formatBoard(board: Array[Array[Char]]): String = {
        val rowLength = board.length
        if board(0) == null then return ""
        val colLength = board(0).length
        val str: StringBuilder = new StringBuilder()
        str.append("[")
        for (i <- 0 until rowLength) {
            str.append("[")
            for (j <- 0 until colLength) {
                str.append(s"\"${board(i)(j)}\"")
                if j + 1 < colLength then str.append(",")
            }
            str.append("]")
            if i + 1 < rowLength then str.append(System.lineSeparator())
        }
        str.append("]").append(System.lineSeparator()).toString()
    }
}

object MasterSudokuSolver {
    def solveSudoku(inPutStr: String): Array[Array[Char]] = {
        val inputArray: Array[Array[Char]] = fillUpArray(inPutStr)
        val sudoSolver = new SudokuSolver()
        sudoSolver.solveSudoku(inputArray)
        sudoSolver.outPutArray
    }

    def fillUpArray(str: String): Array[Array[Char]] = {
        val formatted: Array[String] = str.replace("[", "").replace("]", "")
            .replace("\"", "").split(",")
        val s = new Array[Array[Char]](9)
        var k = 0
        for (i <- 0 until 9) {
            s(i) = new Array[Char](9)
            for (j <- 0 until 9) {
                s(i)(j) = formatted(k).charAt(0)
                k = k + 1
            }
        }
        s
    }
}