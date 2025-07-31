# java-sql-cli

I practice creating a CLI for a Java SQL database

## Contributing:

All you need to develop for this project is Java21 and SQLite installed on your machine. To run this project, follow the instructions below:

### Windows

- Run the `build.bat` to run the project

### Linux

- Any time you want to run this project, run the following series of commands starting from the `src` directory
  - `javac -d ..\target app\SQLCLI.java`
  - `cd ..\target`
  - `java -cp ".;lib\*" app.SQLCLI`

## Project Structure

The source code is found in the `src` directory. All packages for the project begin at `app`. The `target` directory is where all files should be compiled to. `target\lib` is where all 3rd-party `.jar` files will be stored.

The series of commands specified in the "contributing" section of the `README.md` essentially compile the project to the `target` directory then runs the project from the `target` directory. Additionally, both `lib` and `target` are set as the class path.

```
java-sql-cli
-   src\app
    -   cli
    -   controller
    -   dao
    SQLCLI.java
-   target
    -   app
    -   lib
```
