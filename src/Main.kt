fun main() {
    // Test 1: Normal discounted payment (Q3 & Q5 flow)
    payment(2000.0, 800.0)
    println("------------------------------")
    // Test 2: Amount > 1000 requires approval (Q4 rule)
    payment(2000.0, 1500.0)
    println("------------------------------")
    // Test 3: Insufficient deposit after discount and service charge (Q1 & Q2 rule)
    payment(300.0, 500.0)
    println("------------------------------")
    // Test 4: Invalid amount <= 0 (Q4 & Q5 rule)
    payment(1000.0, 0.0)
}

fun payment(deposit: Double, amount: Double) {
    // Step 1: Validate payment amount first before doing any calculation (Q4 & Q5)
    val isValidPayment: Boolean = validatePayment(amount)
    if (!isValidPayment) {
        return
    }

    // Step 2: Calculate discounted price and discount amount (Q3 & Q5)
    val discountedPrice: Double = calculateDiscount(amount)
    val discountAmount: Double = amount - discountedPrice

    // Step 3: Get service/transaction charge and calculate final payable amount (Q2 & Q5)
    val serviceCharge: Double = calculateServiceCharge()
    val newAmount: Double = discountedPrice + serviceCharge

    // Step 4: Check whether deposit covers the final payable amount (Q1 - Q5)
    val canMakePayment: Boolean = checkDeposit(deposit, newAmount)
    var remainingBalance: Double = deposit

    if (canMakePayment) {
        // Step 5: Deduct final amount and display full receipt
        remainingBalance = makePayment(deposit, newAmount)
        println("Successful payment")
        println("Original Deposit: RM$deposit")
        println("Product Price: RM$amount")
        println("Discount: RM$discountAmount")
        println("Service Charge: RM$serviceCharge")
        println("Final Payment: RM$newAmount")
        println("Remaining Balance: RM$remainingBalance")
    } else {
        println("Failed payment")
        println("Original Deposit: RM$deposit")
        println("Final Payment: RM$newAmount")
        println("Insufficient balance")
    }
}

fun validatePayment(amount: Double): Boolean {
    // Check invalid amount (<= 0) and high-value approval limit (> 1000)
    if (amount <= 0.0) {
        println("Invalid payment amount")
        return false
    } else if (amount > 1000.0) {
        println("Payment requires approval")
        return false
    }
    return true
}

fun calculateDiscount(amount: Double): Double {
    // Default multiplier is 1.0 (0% discount) when amount < 300.0
    var discountMultiplier: Double = 1.0
    if (amount >= 500.0) {
        discountMultiplier = 0.8 // 20% discount
    } else if (amount in 300.0..<500.0) {
        discountMultiplier = 0.9 // 10% discount
    }
    val amountAfterDiscount: Double = amount * discountMultiplier
    return amountAfterDiscount
}

fun calculateServiceCharge(): Double {
    // Returns fixed service charge (RM20.0 per Q5 specification; change to 10.0 if using Q2 fee)
    return 20.0
}

fun checkDeposit(deposit: Double, amount: Double): Boolean {
    var canMakePayment: Boolean = false
    if (deposit >= amount) {
        canMakePayment = true
    }
    return canMakePayment
}

fun makePayment(deposit: Double, amount: Double): Double {
    return deposit - amount
}