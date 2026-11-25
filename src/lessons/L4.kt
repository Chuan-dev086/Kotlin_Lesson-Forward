package lessons
// Entry point running a sample payment check.
fun main() {
    payment(100.0, 250.0)
}

// Coordinates balance check, payment deduction, and result printing.
fun payment(deposit: Double, amount: Double) {
    val canMakePayment = checkDeposit(deposit, amount)
    if (canMakePayment) {
        // Calculate remaining balance only when payment succeeds.
        val remainingBalance = makePayment(deposit, amount)
        println("Successful payment")
        println("Original Deposit: RM$deposit")
        println("Payment Amount: RM$amount")
        println("Remaining Balance: RM$remainingBalance")
    } else {
        println("Failed payment")
        println("Original Deposit: RM$deposit")
        println("Payment Amount: RM$amount")
        println("Insufficient balance")
    }
}

// Returns true if deposit is enough to cover the amount (including exact match).
fun checkDeposit(deposit: Double, amount: Double): Boolean {
    return deposit >= amount
}

// Returns remaining balance after deducting payment amount.
fun makePayment(deposit: Double, amount: Double): Double {
    return deposit - amount
}
