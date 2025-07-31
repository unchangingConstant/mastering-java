## Java Package Compilation

When the JVM is compiling a file, it needs to compile all the imports found within a given `.java` file. To do this, it needs to know where to look.
By default, it looks in the current working directory for package names.
Here's an example of what the JVM would do.

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

## Using 3rd-party packages
