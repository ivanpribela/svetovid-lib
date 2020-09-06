#!/bin/sh

url="http://svetovid.org/lib/svetovid-lib.jar"
folder='/opt/svetovid-lib'
file='svetovid-lib.jar'
config='/etc/environment'
variable='CLASSPATH'

# Check if administrator
if [ $(id -u) -ne 0 ]; then
  echo "Please run as administrator/super user"
  exit
fi

# Check if curl is available
curl -V >/dev/null 2>&1
if [ $? -ne 0 ]; then
    echo "Curl is not available, can not download svetovid-lib.jar"
    if [ -f "./$file" ]; then
	echo "Found $file in current folder, will use that"
	localfile=1
    else
	echo "You can either install curl, or put $file in this folder."
	exit
    fi
fi

# Check if sed is available
sed --version >/dev/null 2>&1
if [ $? -ne 0 ]; then
  echo "Sed is not available, CLASSPATH will be just appended. This may cause problems if installed multiple times."
  nosed=1
fi

# Create the folder
mkdir -p "$folder"

if [ -z $localfile ]; then
    # Download the library
    echo "Downloading library from $url"
    curl -fsL "$url" -o "$folder/$file"
    if [ $? -ne 0 ]; then
	echo "Failed to download Svetovid library"
	exit
    fi
else
    # move local file
    mv "./$file" "$folder/$file"
    echo "Moved local file $file to $folder"
fi

# Set the class path
value="$folder/$file:."
if [ -z $nosed ] && grep -q "$variable" "$config" 2>/dev/null; then
  sed -i "s|$variable=.*|$variable=\"$value\"|" "$config"
else
  echo "$variable=\"$value\"" >> "$config"
fi

echo "CLASSPATH set to use svetovid-lib; please re-login for the changes to be applied"
