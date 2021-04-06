# java-fsd-dell

Java FSD for Dell


## Projects

 * [SpringStarter](./SpringStarter/): Hello World for Spring Web
 * [SpringData](./SpringData/): Hello World for Spring Data

## Using Git

You can use one of the following methods to use this repo:

1. [Github Desktop](https://desktop.github.com)
2. The [Git for Windows client](https://git-scm.com/download/win)
3. Your IDE of choice (Eclipse, STS, etc)


## Database


You will need to install MySQL or MariaDB. You can download [here](https://dev.mysql.com/downloads/)

One alternative to this if you lack admin permissions is [XAMPP](https://www.apachefriends.org/download.html).

When installing MySQL, use legacy authentication, and type in your desired root password on install. Make sure you remember or squirrel the password away.
Select "Yes" for MySQL router connecting to InnoDB clusters.


#### Creating a database and user

```sql
create database db_example; -- Creates the new database
create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

#### Creating a table

```sql
CREATE TABLE db_example.user (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
```

#### Inserting some data

```sql
use db_example;
insert into db_example.user (id, email, name, password) values (1, 'someemail@someemailprovider.com', 'First', 'mypassword');
insert into db_example.user (id, email, name, password) values (2, 'someemail@someemailprovider.com', 'Second', 'mypassword2');
```


#### Testing a select

```sql
use db_example;
select * from user;
```

#### MYSQL Root Password Reset

Here's what to do if you run windows and have to reset your root password:

[How to Reset Root Password](https://dev.mysql.com/doc/mysql-windows-excerpt/5.7/en/resetting-permissions-windows.html)

