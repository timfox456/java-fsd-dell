# Spring Data Example

## Step 1:  Create New Template

Please note that despite the screenshot we are **NOT** using Thymleaf. Please do NOT include that.

![](../images/SpringData-Intializer.png)

Add the following;
1. Spring Web
2. Spring Data JPA
3. MySQL Driver
4. Spring Boot Devtools



## Step 2: Unzip Spring Initializer in your git rep

Use your OS of choice to unzip the SpringData.zip in your git repo.


## Step 3: Import the Maven Project into Eclipse (or your IDE of choice)

Go Import -> Existing Maven Project.

Navigate to your git repo folder and find the SpringData subfolder.

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

`SpringData/src/main/webapp/WEB-INF/jsp/index.jsp`

Add in a small jsp file in that folder

```html
<html>
<body>
<h2>Spring Application</h2>

</body>
</html>

```

## Step 9: Add `MainController` class

Add a new Java class `MainController.java` as follows:

```java
package com.example.SpringData;

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


## Step 9: Run


Eclipse: Right Click -> Run As -> Maven Build...  Then type in goals: spring-boot:run

Or in STS, simply right click -> run as -> Spring Boot App.

Navigate your browser of choice to `http://localhost:8090/`

You should see: 

**Spring Application**


## Step 10: Create Entity Class: User

Create a new class User.  It can be under the `com.example.SpringData` package.

It can look like this:

```java

package com.example.SpringData;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	private String email;
	private String name;
	private String password;

}
```

Use your IDE of choice to generate setters and getters (Eclipse: Source -> Generate Setters and Getters). 
The result should look like this:

```java

package com.example.SpringData;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	private String email;
	private String name;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

```


## Step 11: Create A Repository Interface.

Create a new Java Interface called UserRepository.

Paste the following code:

```java
package com.example.SpringData;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
```

## Step 12: Create a User Service

Create a new class called UserService

Paste the following Code:

```java
package com.example.SpringData

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

        @Autowired
         private UserRepository userRepository;



    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }

```

