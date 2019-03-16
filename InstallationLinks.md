

## Getting the required software (MAC Environment)

### IDE
* Intellij Community Edition https://www.jetbrains.com/idea/download/#section=mac
* Eclipse Scala http://scala-ide.org/download/sdk.html 

### Scala
* Add Scala Plugin to Intellij  https://stackoverflow.com/questions/38973049/how-to-install-scala-plugin-for-intellij

### JDK 8 u192
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html



### Spark
a) Manual download
  a1) Go to https://spark.apache.org/downloads.html and download desired version
  a2) Set ENV variables https://oleweidner.com/blog/2015/getting-started-with-spark-on-osx/
b) Using BREW
  b1) Follow instructions here https://oleweidner.com/blog/2015/getting-started-with-spark-on-osx/
c) If you just need to run the Spark programs within


a) using SBT will download Spark for you (you need SBT of course)
b) you download Spark manually and then you add the libraries to your project. Otherwise your 

! This only allows you to run scala programs inside Intellij, if you want to run spark programs from
the command line, you need to install spark IN the system (spark-shell command)

### Environment Set ups
In the end, it doesn't matter how you configure your project.

A) Intellij with integrated Scala and Spark   
  1. Download & Install Intellij
  2. Download & Install Java 8
  3. Open Intellij and Install Scala Plugin
  4. Create SBT projects. SBT will take care of dependencies and will download desired libraries
     - https://es.hortonworks.com/tutorial/setting-up-a-spark-development-environment-with-scala/
     - https://stackoverflow.com/questions/47697141/intellij-cannot-import-sbt-project


B) Intellij with integrated Scala and separated Spark folder
  B1) Download & Install Intellij
  B2) Download & Install Java 8
  B3) Open Intellij and Install Scala Plugin
  B4) Download Spark and put it somewhere in disk
  B5) Create IDEA projects and manually add Spark libraries from folder
  B6) To run jobs from command line, set env paths to spark and scala home
  
C) No IDE
    C1) You must set the ENV variables to be able to compile and run your programs


