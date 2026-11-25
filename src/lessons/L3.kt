package lessons
//the if/else and Boolean

fun main() {
    val scoreA = 60.0
    val scoreB = 50.0

    printExamResult(scoreA)   //Score: 60.0: Passed
    printExamResult(scoreB)   //Score 50.0: Needs more practice

    // Case 1: meets attendance, 92 marks, income 4200 -> Full Scholarship
    println(checkScholarShip(92, 4200.0, 0.85))
    // Case 2: meets attendance, 80 marks, income 2500 -> Partial Scholarship
    println(checkScholarShip(80, 2500.0, 0.80))
    // Case 3: attendance below 0.8 even with high marks -> Not Eligible
    println(checkScholarShip(98, 1000.0, 0.75))
}

fun isPassed(score: Double): Boolean {
    return score >= 60.0
}

fun printExamResult(score: Double) {
    val passed = isPassed(score)
    if (passed) {
        println("Score: $score: Passed")
    } else {
        println("Score $score: Needs more practice")
    }
}


// Evaluates scholarship eligibility based on attendance, exam marks, and family income.
fun checkScholarShip(examMarks: Int, familyIncome: Double, attendance: Double): String {
    // Gate 1: attendance must be at least 0.8 (80%).
    if (attendance >= 0.8) {
        // Gate 2: evaluate exam marks from highest tier down to failing tier.
        if (examMarks >= 90) {
            if (familyIncome <= 5000.0) {
                return "Full Scholarship"
            } else {
                return "Partial Scholarship"
            }
        } else if (examMarks >= 75 && examMarks < 90) {
            if (familyIncome <= 3000.0) {
                return "Partial Scholarship"
            } else {
                return "Not Eligible"
            }
        } else if (examMarks >= 50 && examMarks < 75) {
            return "Not Eligible"
        } else {
            return "Failed"
        }
    } else {
        return "Not Eligible"
    }
}


