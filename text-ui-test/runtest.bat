@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM for development testing
if exist ..\data\yeetman_test.txt del ..\data\yeetman_test.txt
echo. > ..\data\yeetman_test.txt

REM compile the code into the bin folder
for /f %%f in ('dir /s /b ..\src\main\java\*.java') do javac -Xlint:none -d ..\bin "%%f"
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin YeetMan < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
