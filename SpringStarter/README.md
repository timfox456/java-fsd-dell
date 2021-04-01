# SpringStarter

## Step 1: Go to Spring Initializer

Enter in Group `com.example`, Artifact as `SpringStarter`, Jar Packaging, Java version `8`

Dependencies add the following:

1. Spring Boot Web
2. Thymeleaf

Generate `.zip` file and download.


## Step 2: Unzip Spring Initializer in your git rep

Use your OS of choice to unzip the SpringStarter.zip in your git repo.


## Step 3: Import the Maven Project into Eclipse (or your IDE of choice)

Go Import -> Existing Maven Project.

Navigate to your git repo folder and find the SpringStarter subfolder.

Select the springtarter subfolder.

## Step 4: Add Thymleaf template `hello.html` in your `src/main/resources/templates`

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello, World!'" />
</body>
</html>
```


## Step 5: Add New Java Class MainController

Add a new Java class `MainController.java` as follows:

```java
package com.example.SpringStarter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String printHello() 
	{
		return("hello");
	}
	
	
}
```

## Step 6: If needed, add thymleaf dependency to pom.xml

Add the following depedency to your pom.xml:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

The final dependencies should look like this:

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
</dependencies>
```


## Step 7: Run application using Maven build

Right click on project, select Run As -> Maven Build

Type in `spring-boot:run`

Allow applicaition to run.


## Step 8: Open Browser
Open Browser, navigate to `localhost:8080`

You should see the following in your browser:

```console
Hello World!
```
