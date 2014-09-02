Svetovid Lib
============

This is a supplement Library for Introductory Programming Courses in Java

The library is focused on easing input/output operations in Java, which can be
quite hard for novice programmers.

How to install
--------------

The easiest way to use the library is to copy the jar file to the `lib/ext/`
folder of the installed JRE or JDK. Another way is to add all the files to the
working folder or to the classpath.

What's inside
-------------

The library provides `org.svetovid.io.Svetovid` class that acts as an entry
point to various functionalities of the library. As a convinience, the library
also adds a `Svetovid` class to the default package so that these
functionalities can be accessed without any imports, as easy as the `System`
class.

Similar to the standard `System` class, the `Svetovid` class provides fields
`in`, `out` and `err` to access standard input, standard output and standard
error output.

How to use
----------

Take a look at the `org.svetovid.demo` package for usage examples.
