package com.note.app.mykotlinproject

import kotlin.math.pow

fun main() {
//  While Loop
/*        var count = 1
        while (count <= 5) {
            println("awais khan")
            count++
        }
    var number=3
    var value=1
    while (value<=10){
        println("3 x "+value+ "= ${number*value}")
        value++
    }
    println("Table 4")
    val digit =4
    for (i in 1..10){
        println("$digit x $i = ${digit*i}")
    }
    var i = 1
    var j: Int

    while (i <= 3) {
        j = 1
        while (j <= 2) {
            print("Souvanik\n")
            j++
        }
        print("\n")
        i++
    }
        var large = 2345;
         var small = 3;

        while (large > small){
            println("Large = $large and Small = $small");
            large /= 2;
            small *= 2;
        }*/
//    For Loop
 /*   val table = 5
    for(i in 1..10){
        println("$table x $i = ${table*i}")
    }*/
  /*  for (i in 1 until 3){
        println(i)
    }*/
/*
   println(evenOrOdd(4))
   println(evenOrOdd(7))

sub(8,4)
   
}
fun sub(value1: Int, value2: Int) {

    var result=value1 - value2
    println(result)
}
fun evenOrOdd(int: Int): String {
    return if (int % 2 == 0) "even" else "odd"*/
//    function overLoading

/*   println(subtract(8.0 ,4.0))
    println(subtract(8,4))

val fn =::power
    println(fn(3.0,3.0))

    printMessage()
//array
    var arr = arrayOf("one","two","Three")
    for (i in arr){

        println(i)
    }
    println(arr[0])
    println(arr.size)
}
fun subtract(a:Int,b:Int):Int{
    return a-b
}
fun subtract(a:Double,b:Double):Double{
    return a-b
}
fun power(a:Double,b:Double):Double{
    return a.pow(b)
}
//default argument
fun printMessage(count:Int = 3){
    for (i in 1 until count){
        println("HOW ARE YOU")
    }*/
// classes and object
 val store  = Bike("125","Honda",356)
    println(store.distance)
    println(store.name)
    store.applyBrake()
    store.driveBike()
    val p1=Vote("SAMI",24,true)
    val p2=Vote("Hassan",16,false)
    p1.canVote()
    p2.canVote()
    p1.mVote

   }
class Bike(val name:String,val type:String,var distance:Int){
    fun driveBike(){
        println("BIke Driving")
    }
    fun applyBrake(){
        println("break Aplly")
    }
}
class Vote(val name:String,var age:Int,  vote:Boolean){
    val mVote=vote
    fun canVote(){
        if (age >18){
            println("$name You are eligible for Vote ")
        }else{
            println("$name you are not eligible for vote")
        }
    }
}