#!/bin/sh

folder='/opt/svetovid-lib'
config='/etc/environment'
variable='CLASSPATH'

# Check if administrator
if [ $(id -u) -ne 0 ]; then
  echo "Please run as administrator"
  exit
fi

# Check if sed is available
sed --version >/dev/null 2>&1
if [ $? -ne 0 ]; then
  echo "Sed is not available"
  exit
fi

# Remove the folder
rm -rf "$folder"

# Unset the class path
if grep -q "$variable" "$config" 2>/dev/null; then
  sed -i "/$variable=.*/d" "$config"
fi

