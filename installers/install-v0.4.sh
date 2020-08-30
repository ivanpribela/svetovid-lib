#!/bin/sh

url='https://github.com/ivanpribela/svetovid-lib/releases/download/v0.4/svetovid-lib.jar'
folder='/opt/svetovid-lib'
file='svetovid-lib.jar'
config='/etc/environment'
variable='CLASSPATH'

# Check if administrator
if [ $(id -u) -ne 0 ]; then
  echo "Please run as administrator"
  exit
fi

# Check if curl is available
curl -V >/dev/null 2>&1
if [ $? -ne 0 ]; then
  echo "Curl is not available"
  exit
fi

# Check if sed is available
sed --version >/dev/null 2>&1
if [ $? -ne 0 ]; then
  echo "Sed is not available"
  exit
fi

# Create the folder
mkdir -p "$folder"

# Download the library
curl -fsL "$url" -o "$folder/$file"
if [ $? -ne 0 ]; then
  echo "Failed to download Svetovid library"
  exit
fi

# Set the class path
value="$folder/$file:."
if grep -q "$variable" "$config" 2>/dev/null; then
  sed -i "s|$variable=.*|$variable=\"$value\"|" "$config"
else
  echo "$variable=\"$value\"" >> "$config"
fi

