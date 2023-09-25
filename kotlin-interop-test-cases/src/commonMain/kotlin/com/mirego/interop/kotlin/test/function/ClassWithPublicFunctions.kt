package com.mirego.interop.kotlin.test.function

import com.google.j2objc.kompat.KompatObjectiveCName
import kotlin.js.JsName
import kotlin.jvm.JvmOverloads
import kotlin.native.ObjCName

class ClassWithPublicFunctions {

    companion object {
        @Suppress("FunctionOnlyReturningConstant")
        fun staticReturnString(): String {
            return "staticString"
        }

        fun staticReturningCollection(): Collection<String> {
            return listOf("hello", "world")
        }
    }

    fun returnUnit() {
        // NO-OP
    }

    fun returnShort(): Short {
        return 1.toShort()
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnString(): String {
        return "testString"
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnInt(): Int {
        return 1
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnLong(): Long {
        return 1
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnBoolean(): Boolean {
        return false
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnCharacter(): Char {
        return 'a'
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnFloat(): Float {
        return 1.0f
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun returnDouble(): Double {
        return 1.0
    }

    fun returnList(): List<String> {
        return listOf("hello", "world")
    }

    fun returnArray(): Array<String> {
        return arrayOf("hello", "world")
    }

    fun returnSet(): Set<String> {
        return setOf("hello", "world")
    }

    fun returnCollection(): Collection<String> {
        return returnList()
    }

    fun returnMap(): Map<String, String> {
        return mapOf("hello" to "world")
    }

    @JsName("withDefaultArguments")
    @JvmOverloads
    fun withDefaultArguments(string1: String, string2: String = "argument"): String {
        return "$string1 $string2"
    }

    @Suppress("FunctionOnlyReturningConstant")
    fun singleExpression() =
        "single expression"

    fun localFunction(): String {
        var testString = ""
        fun concatInput(input: String): String {
            return testString.plus(input)
        }
        testString = concatInput("local")
        return concatInput(" function")
    }

    @JsName("recursiveFunction")
    fun recursiveFunction(number: Int): Long {
        return if (number == 1) {
            number.toLong()
        } else {
            number * recursiveFunction(number - 1)
        }
    }

    @JsName("tailRecursiveFunction")
    tailrec fun tailRecursiveFunction(n: Int, accum: Long): Long {
        val soFar = n.toLong() * accum
        return if (n <= 1) {
            soFar
        } else {
            tailRecursiveFunction(n - 1, soFar)
        }
    }

    val lambdaFunction = { number: Int -> number * number }

    private fun String.removeFirstChar(): String =
        this.substring(1, this.length)

    @JsName("extensionFunction")
    fun extensionFunction(string: String): String {
        return string.removeFirstChar()
    }

    private inner class InnerClass {
        fun sum(number1: Int, number2: Int): Int {
            return number1 + number2
        }
    }

    @JsName("innerClassFunction")
    fun innerClassFunction(number1: Int, number2: Int): Int {
        return InnerClass().sum(number1, number2)
    }

    fun overloadedFunction(number: Int): String {
        return overloadedFunction(number.toString())
    }

    fun overloadedFunction(string: String): String {
        return string
    }

    @KompatObjectiveCName("getWithString:")
    @ObjCName("get")
    fun methodWithObjCName(@ObjCName("withString") string: String): String {
        return "my name is getString $string)"
    }
}
