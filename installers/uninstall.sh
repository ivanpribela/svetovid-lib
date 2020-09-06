#!/bin/sh

folder='/usr/local/lib'
file='svetovid-lib.jar'
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
  echo "Sed is not available, please remove the CLASSPATH entries manually from $config"
  exit
fi

# Remove the file
rm -rf "$folder/$file"

if [ $? -e 0 ]; then
    echo "File $file removed from system"
else
    echo "Problem with removing the file $folder/$file"
fi

echo "This will now remove the CLASSPATH entry from $config entirely."
echo "If you have additional modifications to this entry, they will be removed."
echo "If you want to keep those, stop this process and change CLASSPATH manually."
read -p "Continue? [Yn]" input

if [ -n $input ] && [ $input != "Y" ]; then
    exit
fi

# Unset the class path
if grep -q "$variable" "$config" 2>/dev/null; then
  sed -i "/$variable=.*/d" "$config"
fi

echo "CLASSPATH entry removed from $config"
