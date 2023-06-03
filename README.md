# JsbServer
## About
JsbServer stands for Java Spring Boot. This is a simple Rest API project using Java Spring Boot and also Gradle as project management, and MySQL as data storage. Unlike other Java projects, this is only built and developed through the Android Terminal Emulator (Termux) but you can still use it on your favorite PC/Laptop and any Operating System.

## Requirements
Before you try it, please pay attention to the availability of the resources needed to avoid errors:
* openjdk-17-jdk or later
* openjdk-17-jre or later
* gradle-7 or later
* mariadb

## Installation
* First of all you download the zip file from this repository or you can also clone this repository
* Then run your MySQL server and import database `mysql.sql` to your database server machine
* If everything goes well without any error please go to project main directory then run file `gradlew` or `gradlew.bat` with argument task `bootRun` e.g `./gradlew bootRun` then this will open localhost connection with port 8080

## Licence
All JsbServer source code is licensed under the GNU General Public License v3. Please [see](https://www.gnu.org/licenses) the original document for more details.
