package exercise

fun main() {
    val weight = 23.0
    checkInBaggage(weight)
}

fun checkBaggage(weight: Double): Boolean {
    return if (weight <= 20.0) {
        true
    } else {
         false
    }
}

fun checkInBaggage(weight: Double): Boolean {
    val isAccepted = checkBaggage(weight)
    if (isAccepted) {
        println("Accepted")
        return true
    } else {
        println("Overweight")
        return false
    }
}