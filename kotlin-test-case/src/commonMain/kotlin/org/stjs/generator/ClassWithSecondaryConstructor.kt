package org.stjs.generator

class ClassWithSecondaryConstructor(val name:String) {
    constructor() : this("ClassWithSecondaryConstructor")
}