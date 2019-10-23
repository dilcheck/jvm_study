#!/bin/bash
# resolve links - $0 may be a softlink
if [ -z "$PROJECT_HOME" ];then
  PRG="$0"
  while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
      PRG="$link"
    else
      PRG=`dirname "$PRG"`/"$link"
    fi
  done
  
  cd $(dirname $PRG)
  export PROJECT_HOME=`pwd`
  cd -&>/dev/null
fi

################################################################################
VERSION=$(grep version $PROJECT_HOME/build.gradle | cut -d"'" -f2)
BUILD_WORKSPACE=$PROJECT_HOME/build
APP_NAME=jvm-receiver
APP_FULLNAME="$APP_NAME-server-$VERSION"
INSTALLER_NAME="$APP_FULLNAME-installer.bin"

################################################################################
echo "Building java modules..."
cd $PROJECT_HOME
$PROJECT_HOME/gradlew clean build || exit 1

echo "Unarchiving assembly..."
cd $PROJECT_HOME/assembly/build/distributions
unzip -q "$PROJECT_HOME/assembly/build/distributions/$APP_FULLNAME.zip"
mv "$PROJECT_HOME/assembly/build/distributions/$APP_FULLNAME" "$PROJECT_HOME/assembly/build/distributions/$APP_NAME" 

# echo "Reassembling..."
rm -rf $BUILD_WORKSPACE
mkdir $BUILD_WORKSPACE
cd $PROJECT_HOME/assembly/build/distributions
unzip -q $APP_FULLNAME.zip -d $BUILD_WORKSPACE