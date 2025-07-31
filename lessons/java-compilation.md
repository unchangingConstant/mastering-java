## Java Packages and how to import them

At runtime, when the JVM executes a program with `java <filepath>`, it needs to find all of the imports found within the given `.java` file. To do this, it needs to know where to look. (NOTE: `java` command does NOT compile anything)
By default, at runtime the JVM looks in the current working directory for imports. Additionally, the JVM can only see `.class` files when looking for imported classes. So, say you have the following file structure:

```
project
- HelloWorld.java
- Helper.java
```

Say `HelloWorld.java` imports `Helper` and you run `java HelloWorld.java` in the `project` directory. `Helper` would fail to import because it is a `.java` file, not a `.class` file. So, how do you create `.class` files you can import?

### A simple guide to `javac`

The `javac` command can compile your `.java` files into importable `.class` files. Simply type `javac <javafilepath>` and it will create a `.class` file in a directory decided by the current working directory and package name. For example, if the package declaration in `Helper.java` file is `package app.tools;` and the current working directory is `project`, it will create a directory `project\app\tools` and place `Helper.class` inside of it.

#### `-d` parameter

`-d` allows you to specify a destination for all of your compiled `.class` files! The argument passed to `-d` will replace your current working directory for the purposes placing your generated `.class` file somewhere.

#### `-cp` parameter

You may pass an argument to the `-cp` (or `-classpath`) parameter when using either `java` or `javac`. (Though I will not cover its usage for (LOOK AT DEEPSEEK CHATS TO FINISH THIS!!!))

## Other stuff!

Imagine the project structure looks like this:

```
project
-   src
    -   app
        -   tools
            -   Wrench.java
        -   MyApp.java
```

And `Wrench.java`'s package declaration is `tools`

`MyApp.java` imports `tools.Wrench`

When the compiler reads the import statement, it searches for the `tools` folder in the current directory. In this case, if we run `javac MyApp.java` from `project\src\app`, it will look for `tools.Wrench` in the `project\src\app\tool` directory.

However, say you ran `javac app\MyApp.java` from the `project\src` directory. It would find `MyApp.java`, but since it can't find the `project\src\tools` directory (because it doesn't exist) it will fail to compile the package. Package names and file structure matter!

### `javac` options

TODO write about `-d`

## Running your Java program

## Using 3rd-party packages
