@echo off
setlocal enableextensions

set folder=%ProgramFiles%\svetovid-lib
set variable=CLASSPATH

rem Check if administrator
net session >nul 2>&1
if errorLevel 1 (
  echo Please run as administrator
  exit /b
)

rem Remove the folder
rmdir /s /q "%folder%" >nul 2>&1

rem UnsSet the class path
REG delete "HKLM\SYSTEM\CurrentControlSet\Control\Session Manager\Environment" /F /V "%variable%" >nul 2>&1

