package com.mirego.interop.kotlin.test.function

import kotlin.js.JsName
import kotlin.jvm.JvmOverloads

public class ClassWithPublicFunctions() {

    companion object {
        public fun staticReturnString(): String {
            return "staticString"
        }
    }

    public fun returnUnit() {}

    public fun returnShort(): Short {
        return 1.toShort()
    }

    public fun returnString(): String {
        return "testString"
    }

    public fun returnInt(): Int {
        return 1
    }

    public fun returnLong(): Long {
        return 1
    }

    public fun returnBoolean(): Boolean {
        return false
    }

    public fun returnCharacter(): Char {
        return 'a'
    }

    public fun returnFloat(): Float {
        return 1.0f
    }

    public fun returnDouble(): Double {
        return 1.0
    }

    @JsName("withDefaultArguments")
    @JvmOverloads
    public fun withDefaultArguments(string1: String, string2: String = "argument"): String {
        return string1 + " " + string2
    }

    public fun singleExpression() = "single expression"

    public fun localFunction(): String {
        var testString = ""
        fun concatInput(input: String): String {
            return testString.plus(input)
        }
        testString = concatInput("local")
        return concatInput(" function")
    }

    @JsName("variableArgumentsSum")
    public fun variableArgumentsSum(vararg numbers: Int): Int {
        var result = 0
        for (number in numbers) {
            result += number
        }
        return result
    }

    @JsName("recursiveFunction")
    public fun recursiveFunction(number: Int): Long {
        if (number == 1) {
            return number.toLong()
        } else {
            return number * recursiveFunction(number - 1)
        }
    }

    @JsName("tailRecursiveFunction")
    public tailrec fun tailRecursiveFunction(n: Int, accum: Long): Long {
        val soFar = n.toLong() * accum
        return if (n <= 1) {
            soFar
        } else {
            tailRecursiveFunction(n - 1, soFar)
        }
    }

    val lambdaFunction = { number: Int -> number * number }

    public fun String.removeFirstChar(): String = this.substring(1, this.length)

    @JsName("extensionFunction")
    public fun extensionFunction(string: String): String {
        return string.removeFirstChar()
    }

    private inner class InnerClass {
        public fun sum(number1: Int, number2: Int): Int {
            return number1 + number2
        }
    }

    @JsName("innerClassFunction")
    public fun innerClassFunction(number1: Int, number2: Int): Int {
        return InnerClass().sum(number1, number2)
    }

    public fun overloadedFunction(number: Int): String {
        return overloadedFunction(number.toString())
    }

    public fun overloadedFunction(string: String): String {
        return string
    }
}
