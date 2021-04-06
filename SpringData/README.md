# Spring Data Example

## Step 1:  Create New Template

![](../images/SpringData-Intializer.png)

Add the following;
1. Spring Web
2. Spring Data JPA
3. MySQL Driver
4. Thymeleaf
5. Spring Boot Devtools



## Step 2: Unzip Spring Initializer in your git rep

Use your OS of choice to unzip the SpringStarter.zip in your git repo.


## Step 3: Import the Maven Project into Eclipse (or your IDE of choice)

Go Import -> Existing Maven Project.

Navigate to your git repo folder and find the SpringStarter subfolder.

Select the springtarter subfolder.


## Step 4: Try building.


Eclipse: Right Click -> Run As -> Maven Build...  Then type in goals: spring-boot:run

Or in STS, simply right click -> run as -> Spring Boot App.

Unfortunately, it won't work due to not configured mysql.

## Step 5: Open Up application.properties.

Go to src/main/resources/application.properties
Add the following:

```text
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword

logging.level.org.springframework.web: DEBUG
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
server.port=8090
```

## Step 6: Try building.


Eclipse: Right Click -> Run As -> Maven Build...  Then type in goals: spring-boot:run

Or in STS, simply right click -> run as -> Spring Boot App.

It should run this time, but won't neccessarily do anything.




## Step 7: Add some extra dependencies to `pom.xml` file

```xml
        <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
                <version>1.2</version>
        </dependency>


        <dependency>
             <groupId>org.apache.tomcat.embed</groupId>
             <artifactId>tomcat-embed-jasper</artifactId>
             <scope>provided</scope>
        </dependency>

````

You may need to use eclipse to "Reload Maven" after changing the pom.xml


## Step 8: Add index.jsp file to the project.

Create the following file/folder

`SpringSetup/src/main/webapp/WEB-INF/jsp/index.jsp`

Add in a small jsp file in that folder

```html
<html>
<body>
<h2>Spring Application</h2>

</body>
</html>

```

## Step 9: Add `MainController` class



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
                return("index");
        }


}
```




