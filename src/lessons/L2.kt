package lessons
// the function parameter/ argument and the return of function
fun main () {
    val name = "Chuan"
    val message = greeting(name)
    print(message)        // Welcome Chuan!

    val total = addTwoNumbers(10,220)
    println(total)   // 230
}

//this is a function that have parameter "name" which is string and must return a string value
//inside the () is the parameter and its data type
// outside the () is the returns String
fun greeting(name: String): String {
    return "Welcome $name!"
}

fun addTwoNumbers(a: Int , b:Int): Int {
    return a+b
}

