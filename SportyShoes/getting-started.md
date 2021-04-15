# Getting Started

This is a document on what we did to get started in the course.

This is *NOT* prescriptive. These are merely suggestions to get started and not in any way 
to be inferred as requirements for the project.

 
### SQL

Here is some SQL (not required) that you **could** use if you want to:

```sql
use my_database;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_c
```

```sql
insert into user (email, name, password) VALUES ("tim@gmail.com", "Tim", "password");
insert into user (email, name, password) VALUES ("mary@gmail.com", "Mary", "password");
insert into user (email, name, password) VALUES ("lee@gmail.com", "Lee", "password");
```

## Steps

### Step 1: Create a GitHub Repo under your account.

If you don't already have a github repo, create one for this project. I actually recommend that you have a special repo
just for this project, but if you choose to combine it with other things from this class that should be ok as long as
its clear where you work from Sporty Shoes is.

### Step 2:  Create a Spring Initializer.

You can create as follows.  

Please note there are two modules you may want to consider:
1. Thymeleaf -- if you prefer thymeleaf views to JSPs.  Please see the SpringStarter project.
2. Spring Security -- Spring Security is rather complex but does have a lot of features around authentication and security.

![](../images/SportyShoes-Initializer.png)

Go ahead and unzip the SportyShoes.zip and put it in your git repository.


## Step 3: Import the Maven Project into Eclipse (or your IDE of choice)

Go Import -> Existing Maven Project.

Navigate to your git repo folder and find the SportyShoes subfolder.

Select the springtarter subfolder.


## Step 4: Edit application.properties.

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



## Step 5: Add some extra dependencies to `pom.xml` file

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


## Step 6: Create Entity Class: User

Create a new class User.  It can be under the `com.example.SportyShoes` package.

It can look like this:

```java

package com.example.SportyShoes.entities;

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

package com.example.SportyShoes.entities;

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


## Step 7: Create A Repository Interface.

Create a new Java Interface called UserRepository.

Paste the following code:

```java
package com.example.SportyShoes.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.SportyShoes.entities.User;


public interface UserRepository extends CrudRepository<User, Integer> {
}
```

## Step 8: Create a User Service

Create a new class called UserService

Paste the following Code:

```java
package com.example.SportyShoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.repositories.UserRepository;



@Service
public class UserService {

        @Autowired
         private UserRepository userRepository;



    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }

}

```
