# MIT License

# Copyright (c) 2023 Dušan Simić <dusan.simic1810@gmail.com>

# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:

# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.

# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.

Function Test-EnvironmentVariableContainsValue {
  param (
    [String] $Variable,
    [String] $Value,
    [String] $Scope
  )

  $var = [System.Environment]::GetEnvironmentVariable($Variable, $Scope)
  If ($var -ne $null) {
    Return $var -split ";" -contains $Value
  }
  Return $false
}

$FileUrl = "https://svetovid.org/lib/svetovid-lib.jar"
$LocalAppDataDirectory = [System.Environment]::GetFolderPath([System.Environment+SpecialFolder]::LocalApplicationData)
$LibraryDirectory = "$LocalAppDataDirectory\Svetovid Library"
$LibraryFile = "svetovid-lib.jar"
$LibraryPath = "$LibraryDirectory\$LibraryFile"

If (-Not(Test-Path -Path $LibraryDirectory)) {
  New-Item -ItemType Directory -Path $LibraryDirectory
}

If (-Not(Test-Path -Path $LibraryPath)) {
  [Net.ServicePointManager]::SecurityProtocol = "Tls, Tls11, Tls12, Ssl3"
  Invoke-WebRequest $FileUrl -OutFile $LibraryPath
}

If (-Not(Test-EnvironmentVariableContainsValue "CLASSPATH" $LibraryPath "User")) {
  [System.Environment]::SetEnvironmentVariable("CLASSPATH", $Env:CLASSPATH + ";$LibraryPath", "User")
}
