# ManagerFranchises

ManagerFranchises-api

## First steps

## Development

### Installing java 17

Get the latest version of java from the [official website] https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

Confirm your current java version with

```
java -version

```

### Installing gradle 
Windows:  We recommend using Chocolatey:

```
choco install gradle

```

### Installing gradle 

```
gradle wrapper --gradle-version 8.0

```
Confirm your current gradle version with

./gradlew -v         

```

```
execute gradle wrapper

gradle wrapper    

```

### Database configuration

Create mysql db with:
```
# mysql

Mysql: `create database franchise_db;`

### Migrations

config file in explorer files 

 go file \src\main\resources\application.properties

create variables example
 ```
spring.datasource.url=jdbc:mysql://localhost:3306/franchise_db
spring.datasource.username=root
spring.datasource.password=secret

 ```

### Starting your app

Now, to start your app run `./gradlew bootRun` in the rootpath of the project. Then access your app at **localhost:port**. The port is logged in the console where you ran the start script.
The tables that you have in the migration will be automatically created

for example
 ```
\src\main\resources\db\migration
V1__create_franchises.sql
```



### Testing


#### Heroku

Pushing the desired branch to heroku should be enough.

## Contributing

1. Go https://signup.heroku.com/
2. Create your app assing your an  name in lowercase example (`managerfranchises`)
3. Go resources page an find JawsDB MySQL 
4. click in JawsDB MySQL, copy Connection Info
5. Connection Info is the info for necesary application.properties
spring.datasource.url=${JDBC_DATABASE_URL}
spring.datasource.username=${JDBC_DATABASE_USERNAME}
spring.datasource.password=${JDBC_DATABASE_PASSWORD}


## Deploy

1. heroku login
2. heroku git:clone -a nameaplication
3. cd nameaplication
4. git add .
5. push heroku main 

## Deploy not changes

1. git branch
2. git checkout main
3. git push heroku main
4. heroku repo:reset -a namaplication
5. git commit --allow-empty -m "Re-deploy not chnages"
6. git push heroku main
