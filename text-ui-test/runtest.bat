@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM for development testing
if exist ..\data\yeetman_test.txt del ..\data\yeetman_test.txt
echo. > ..\data\yeetman_test.txt

REM compile the code into the bin folder
dir /s /B ..\src\main\java\*.java > sources.txt
javac -cp ..\src\main\java -Xlint:none -d ..\bin @sources.txt
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    del sources.txt
    exit /b 1
)
del sources.txt
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin yeetman.YeetMan ..\data\yeetman_test.txt < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
