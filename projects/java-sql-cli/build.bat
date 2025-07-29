@echo off
:: JVM looks for referenced packages in root directory of command.
:: So, we must navigate to src/main beforehand, where all of the packages reside
cd src\app
javac -d ..\..\target SQLCLI.java
