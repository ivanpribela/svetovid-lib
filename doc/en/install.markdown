# Svetovid-lib Installation

Since the library is not a part of the standard Java Virtual Machine
it is necessary to direct the compiler to use it.

### Unpacking into the current directory

The simplest way to enable the usage of Svetovid in programs is to
extract all the class files into the current directory. This is also
very convenient since it doesn't need any administrative or elevated
privileges on the computer and it therefore always applicable.


### Adding the `jar` explicitly to the compilation

It is possible to add `jar` files to be used during compilation as a
command line parameter, or setting it up in most development
environments.

For instance, if the `jar` is in the current folder, the appropriate
line for compilation would be:

`javac -cp svetovid-lib.jar Example.java`

This is also applicable without administrative privileges if the jar
is put into the current folder.

### Adding the library system-wide to all JVM

Possibly the best solution is to expand the list of libraries used by
the Java Virtual Machine, since then it is usable in any directory
without additional effort. The only necessary step is to add
`svetovid-lib.jar` to the system-wide `lib/ext` folder. This of course
requires administrative privileges on a computer.

The target directory Under Windows is:
 `%SystemRoot%\Sun\Java\lib\ext`

while Linux machines use: 
  `/usr/java/packages/lib/ext`

[More details about the ext folder](http://docs.oracle.com/javase/tutorial/ext/basics/install.html)