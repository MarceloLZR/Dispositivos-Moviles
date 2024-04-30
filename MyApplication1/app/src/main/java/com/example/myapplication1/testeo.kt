package com.example.myapplication1


class Persona(val nombre:String,var edad:Int){
    fun imprimir(){
        println(nombre+"tiene la edad de: "+edad)
    }

}
data class Employee(val nombre:String, var salary:Int)
{
    override fun toString(): String {
        return nombre + "tiene un salario de:" + salary
    }
}

fun main() {

    val emp = Employee("Mary", 20)
    println(emp)
    println("Ingrese su salario: ")
    var salario = readln()
    emp.salary = salario.toInt()
    println(emp)

















/*
    val persona = Persona ("Juan",20)
    persona.edad=21

    print(persona.imprimir())



 */


}