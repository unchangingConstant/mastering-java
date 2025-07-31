:: Note: run build.bat from project's root directory
@echo off
:: JVM looks for referenced packages in root directory of command.
:: So, we must navigate to src beforehand, where all of the packages reside
cd src
javac -d ..\target app\SQLCLI.java
cd ..\target
:: What does -cp ".;lib\*" do, you ask? This adds both "." and "lib\*" to the class path!
java -cp ".;lib\*" app.SQLCLI
