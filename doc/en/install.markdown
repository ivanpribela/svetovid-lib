# Svetovid-lib Installation

Since the library is not a part of the standard Java Virtual Machine
it is necessary to direct the compiler to use it. Following are
several ways to use the library directly with a java compiler, notes
about it's usage in some editors, as well as a simple way to test if
the installation was successful.

### Install scripts

The library archive should come with scripts for the installations.
They are also available in the source tree on github. These should
enable the library system-wide, using the `CLASSPATH` method described
below.

### Adding the `jar` explicitly to the compilation

It is possible to add `jar` files to be used during compilation as a
command line parameter, or setting it up in most development
environments.

For instance, if the `jar` is in the current folder, the appropriate
line for compilation would be:

`javac -cp svetovid-lib.jar Example.java`

This is also applicable without administrative privileges if the jar
is put into the current folder.


### Unpacking into the current directory

The simplest way to enable the usage of Svetovid in programs is to
extract all the class files into the current directory. This is also
very convenient since it doesn't need any administrative or elevated
privileges on the computer and it therefore always applicable.


### Adding the `jar` to the `CLASSPATH`

Java uses an environmental variable called `CLASSPATH` to look for
classes and packages. It can be customised for the current user or
system-wide. Adding the `jar` into this variable means that any
compilation and running of a Java program will use the library as
necessary. This is equivalent to using the `-cp` option as explained
before, or in other words, it is like the parameter is being passed
every time.

It is recommended for the user to look up the instructions for
changing environmental variables for their operating system.

Also note that the `jar` file need to be kept in the place that is
listed in the `CLASSPATH`, so it is recommended that it is kept in a
logical place, such as the user home, or a dedicated `lib` folder.


### Using the library with the *Eclipse* IDE

Using the library in Eclipse should work without additional
konfiguration if the library was already added to the adequate
JDK/JRE. Alternatively the library can be added to the classpath of a
specific project.

However, sometimes there is a need for additional interventions, since
the IDE will be reporting errors that the class Svetovid (or some
other from the library) can not be found, or can not be used.

The root of the problem seems to be that Eclipse is caching the list
of libraries when detecting Java Virtual Machines. This can lead to a
confusing situation where the library is listed in the side panel in
the classpath, while not being actually used by the internal compiler.

There are several methods that can help with this problem, listed
below from the simplest.

- open `project->properties->java build path->libraries` and
explicitly add the jar for the library. This is of course a project
specific setting.

- in the same menu there is an option to remove the currently used JRE,
which should then be added back with "Add library"->"Add system JRE".
This is a project specific option as well, but it can also refresh
the main list of libraries.

- open `Winow->preferences->java->installed JREs`, find the
problematic JRE, remember it's location, remove it from the list, add
it back again with the "Search" options using the previously
remembered location. This should be a reliable method of refreshing
the libraries for a JRE/JDK.


## Testing the installation

To simplify the testing whether the installation was successful, the
main method of the class `Svetovid` will print out the version of
the currently installed of the library. 

Running

`java Svetovid`

will either display the version if the current JVM sees the library,
or will report an error otherwise.

## Deprecated instructions

### Adding the library system-wide to all JVM (version 8 and earlier)

*This option was deprecated in Java version 9.*

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



### Using the library in *DrJava* editor

*This editor can compile programs successfully only with Java versions
8 and earlier, and is therefore not recommended anymore.*

To be able to use the library to run programs in the Interactions
panel of DrJava, the jar file must be added to the editors classpath.

The simplest way to achieve this is to obrain a modified version of
the editor that has *svetovid/lib* already integrated in it. Jar
files with the latest stable version of the library are available
on [the official website](http://svetovid.org/lib).

Of course it is possible to use an unmodified editor and to configure
it adequately by hand.

The settings can be found here:

 - Edit->Preferences->ResourceLocations->Extra Classpath->Add

Alternatively the following line can be added to the `.drjava` file in the
users home directory to achieve the same effect:

 ```
 extra.classpath=path/svetovid-lib.jar
 ```

To use this method administrative privileges are not needed since the
jar file can located at any directory.

If the library is added system-wide, programs will compile
successfully in DrJava, but the interactions panel will report an
error, since DrJava doesn't seem to use this ext directory.
