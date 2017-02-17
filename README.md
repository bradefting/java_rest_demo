# java_rest_demo

My first effort to build a web app in Java. Built in two and a half days.

Uses the Spring Boot framework (https://spring.io/), with MySql for the db, and JS/jQuery for the frontend.

In order to run, you will of course need Java installed, and MySql installed and running. I configured this one
with a user of root and a password of password, so copy that if you want it to run out of the box, otherwise, change them
to whatever you see fit. Just make sure you make the corresponding change in the application-db.properties file.

Once you have MySql installed and running, you can use the queries in the /resources/db/migrations/V1__Create_Database.sql
file to create the db and the tables necessary for it to run (this was a failed attempt to incorporate Flyway, a db migration
plugin, which I definitely intend to take another stab at).

The DB schema uses two tables, 'customers' and 'addresses' to split up the data, but only one class 'Customers' by making 
use of the @SecondaryTable JPA annotation. I could certainly have done separate classes; not quite sure what's considered
proper, but this way works, and I was working fast, so this is the way I went.

For my Java-impaired friends:

Then get yourself to the root demo directory, and type `./gradlew build` to build yourself a nice little executable JAR file.
Then navigate to the /build/lib folder and run `java -jar <filename>` where the filename is the name of the JAR file you find
there.

