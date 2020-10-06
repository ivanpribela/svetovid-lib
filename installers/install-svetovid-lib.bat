@echo off
setlocal enableextensions

set url=https://github.com/ivanpribela/svetovid-lib/releases/download/v0.4/svetovid-lib.jar
set folder=%ProgramFiles%\svetovid-lib
set file=svetovid-lib.jar
set variable=CLASSPATH

rem Check if administrator
net session >nul 2>&1
if errorLevel 1 (
  echo Please run as administrator
  exit /b
)

rem Create the folder
mkdir "%folder%" >nul 2>&1

rem Copy the library
copy "%~dp0%file%" "%folder%\%file%" >nul 2>&1

rem Set the class path
setx "%variable%" "%folder%\%file%;." /m >nul 2>&1

