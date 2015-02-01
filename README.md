Svetovid Lib
============

This is a supplement Library for Introductory Programming Courses in Java

The library is focused on easing input/output operations in Java, which can be
quite hard for novice programmers.

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


How to install and use
----------------------

The easiest way to use the library is to copy the jar file to the `lib/ext/`
folder of the installed JRE or JDK. Another way is to add all the files to the
working folder or to the classpath. For more details take a look at the
[documentation folder](doc).

For usage information checkout the [documentation folder](doc). Some usage
examples are available in `org.svetovid.demo`.


Building from source
--------------------

There are convenient tasks defined in the ant build script
to build the sources, create distributable jar files,
converting the end user documentation from markdown
to HTML, generating the java-doc API, and packing up the
documentation in a zip archive for distribution.

The default task (which is run if you just start ant with
no parameters) lists the available options and offers to
build everything.


Build dependencies
------------------

* Java compiler version 7 and up
* ant
* ant-contrib for HTML documentation generation
* pandoc for HTML documentation generation

The library itself should compile successfully with any java
compiler version 7 and up, without any additional
dependencies. It was tested with openjdk7, as well as 
Oracle's JDK 8.

The ant build has an additional dependency on ant-contrib,
but only for the generation of the HTML documentation, all
the other task will perform as expected with a potential 
warning message.

The conversion of the user documentation from markdown to
HTML is done with the "pandoc" software, which should be
installed on the system and accessable from the system PATH.

[Pandoc website](http://johnmacfarlane.net/pandoc/index.html)
