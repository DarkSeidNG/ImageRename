# ImageRename
A simple utility script for renaming files.

## Introduction
Image Rename Utility helps rename image files in a specified folder, it scans through the directory extracts the pins from the image which it uses to find the uniq_id field in a database and then perform the rename from the original name to [uniq_id].[Image Extension]

### Dependencies  
* **[Spring Boot](https://spring.io/projects/spring-boot)** - Spring Boot is a java framework that makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"

### Features
<ul>
<li>Find all files in a directory</li>
<li>Rename files</li>
</ul>


## Getting started with the project 
* Clone the repo `git clone https://github.com/DarkSeidNG/ImageRename.git`
* Navigate to the `ImageRename` directory
* Set up your db credentials in `application.properties` file
* Set the key pair you want to use in renaming in the PinRecord Model
* Run `./gradlew bootRun` to run the application
* Run `./gradlew build` to build the .jar executable

## Author
* **[Ifeanyi Orji](ifeanyicorji@gmail.com)**