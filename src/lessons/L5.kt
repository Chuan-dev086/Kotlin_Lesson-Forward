package lessons

fun main() {
    val sampleScores = listOf(88, 60, 45)
    evaluateBatchScores(sampleScores)

    //for loop
    for (number in 1..5) {
        println("Current number is $number")     // will print Current number is 1 until 5
    }

    //while loop
    var count = 1
    while (count <= 3) {
        println("while loop count: $count")
        count ++
    }
    println("Loop finished, final count: $count")

    //Do- While Loop  (only run 1 loop)
    var attempts = 5
    val keepGoing = false
    do {
        attempts++
        println("do-while executed attempt #$attempts")
    } while (keepGoing)
    println("Loop finished, total attempts: $attempts")

    //Do-While Loop (run multiple time loops)
    var loopCount = 0
    do{
        println("Round $loopCount")
        loopCount++
    } while (loopCount <= 3)
    println("Stopped! Final Count is $loopCount")
}

fun evaluateBatchScores(scores: List<Int>) {
    var passedCount = 0

    // Nested (local) function: only used inside evaluateBatchScores to classify one score.
    fun classifyScore(score: Int): String {
        return when {
            score !in 0..100 -> "Invalid"
            score >= 80 -> "Distinction"
            score in 60..79 -> "Pass"
            else -> "Fail"
        }
    }

    // 1. `for` loop: iterate through every score in the list.
    for (score in scores) {
        val grade = classifyScore(score)
        println("Score $score -> $grade")
        if (grade == "Distinction" || grade == "Pass") {
            passedCount++
        }
    }

    // 2. `while` loop: countdown only while remaining checks are greater than 0.
    var remainingAlerts = 2
    while (remainingAlerts > 0) {
        println("Summary check remaining: $remainingAlerts")
        remainingAlerts--
    }

    // 3. `do-while` loop: runs at least once even if `retryOnce` starts as false.
    val retryOnce = false
    var attempts = 0
    do {
        attempts++
        println("Batch log attempt #$attempts (passed total: $passedCount)")
    } while (retryOnce)
}

