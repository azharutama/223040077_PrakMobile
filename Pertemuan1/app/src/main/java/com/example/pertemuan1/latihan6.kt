package com.example.pertemuan1

fun main(){
    val greet={name : String -> greeting(name)}
    greet("kotlin")
}

fun greeting(name:String){
    println("hallo $name")
}
