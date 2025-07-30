### `javac` Command

When the JVM is compiling a file, it needs to compile all the imports found within a given `.java` file. To do this, it needs to know where to look.
By default, it looks in the current working directory for package names. For example, if the project structure looks like this:

```
project
-   src
    -   app
        -   tools
            -   Wrench.java
        -   MyApp.java
```

And Wrench.java's package declaration is `tools`

Then you would need to run `javac MyApp.java` from the `project/src/app` directory to ensure the `project/src/app/tools` directory is found.

### Using 3rd-party packages
