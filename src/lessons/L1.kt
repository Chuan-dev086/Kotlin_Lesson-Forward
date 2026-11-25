package lessons

import kotlin.reflect.typeOf

//data type(var and val) and basic function
fun main(){
    sayHello()    // output: Hello World !!
    var name = "Chuan"
    name = "Han Chuan"
    println(name)         // output:Han Chuan     var value can be reasign its value
    println(name::class.simpleName)  // String
    val studentName = "HAN CHUAN"
    val age = 25
    println(studentName) // output: HAN CHUAN
    println(age)   // 25
    // use this to know the data type of variables
    println(age::class.simpleName)    // Int
    println(age::class.qualifiedName)  // kotlin.Int
//    studentName = "CHUAN"
//    println(studentName)    // will have error cause the val is read-only value

    var city = "Penang"
    println("Hi my name is $name and my city is $city")      // output: Hi my name is Han Chuan and my city is Penang
    city = "New York"
    println(city)    // New York
}
fun sayHello(){
    println("Hello World !!")
}