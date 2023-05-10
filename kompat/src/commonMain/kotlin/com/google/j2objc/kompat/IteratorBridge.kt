package com.google.j2objc.kompat

class ConcreteIterator<T>(delegate: Iterator<T>) : Iterator<T> by delegate

class ConcreteMutableIterator<T>(delegate: MutableIterator<T>) : MutableIterator<T> by delegate

class ConcreteMutableListIterator<T>(delegate: MutableListIterator<T>) : MutableListIterator<T> by delegate
