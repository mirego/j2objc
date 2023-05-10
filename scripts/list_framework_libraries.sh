#!/usr/bin/env bash
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# Lists which static libraries were built that should be included in
# an XCFramework. This list depends upon what architectures were built,
# and whether XCFramework requires a fat or single-arch library.
#
# Usage:
#   list_framework_libraries.sh <library-name>

if [ $# -eq 0 ]; then
  echo "usage: list_framework_libraries.sh <library-name>"
  exit 1
fi

if [ -z "$J2OBJC_ARCHS" ]; then
  echo "J2OBJC_ARCHS environment variable must be set"
  exit 1
fi

function exists_in_list() {
    [[ "$1" =~ ( |^)$2( |$) ]]
}

function platforms_to_include() {
  if exists_in_list "$J2OBJC_ARCHS" "iphone64" ||
     exists_in_list "$J2OBJC_ARCHS" "iphone64e"; then
    result+=("iphone");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "simulator" ||
     exists_in_list "$J2OBJC_ARCHS" "simulator64"; then
    result+=("simulator");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "macosx" ||
     exists_in_list "$J2OBJC_ARCHS" "macosx64"; then
    result+=("macosx");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "maccatalyst" ||
     exists_in_list "$J2OBJC_ARCHS" "maccatalyst64"; then
    result+=("maccatalyst");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "watchos64" ||
     exists_in_list "$J2OBJC_ARCHS" "watchosv7k"; then
    result+=("watchos");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "watchsimulator" ||
     exists_in_list "$J2OBJC_ARCHS" "watchsimulator64"; then
    result+=("watchsimulator");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "appletvos"; then
    result+=("appletvos");
  fi
  if exists_in_list "$J2OBJC_ARCHS" "appletvsimulator" ||
     exists_in_list "$J2OBJC_ARCHS" "appletvsimulator64"; then
    result+=("appletvsimulator");
  fi
  echo "${result[@]}"
}

function array_intersection() {
  list1=($1)
  list2=($2)
  l2=" ${list2[*]} "
  for item in "${list1[@]}"; do
    if [[ $l2 =~ " $item " ]] ; then
      result+=($item)
    fi
  done
  echo "${result[@]}"
}

readonly LIBRARY_NAME=$1

# The list of platforms we want to include in the framework as defined by J2OBJC_ARCH
PLATFORMS="$(platforms_to_include)"

# The list of architectures where XCFramework expects a fat library.
FAT_PLATFORMS="$(array_intersection "iphone simulator macosx maccatalyst watchos watchsimulator appletvsimulator" "$PLATFORMS")"

# The list of architectures were XCFramework only accepts single-arch libraries.
SINGLE_PLATFORMS="$(array_intersection "appletvos" "$PLATFORMS")"

for platform in $FAT_PLATFORMS
do
  library="build_result/$platform/lib${LIBRARY_NAME}.a"
  if [ -f $library ]; then
    echo $library
  fi
done

for platform in $SINGLE_PLATFORMS
do
  library="build_result/objs-$platform/lib${LIBRARY_NAME}.a"
  if [ -f $library ]; then
    echo $library
  fi
done
