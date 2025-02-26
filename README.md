# Vehicle Rental System

## Overview
The **Vehicle Rental System** is a Java-based application that allows users to rent vehicles using Hibernate ORM for database management. It provides functionalities for customers to rent and return vehicles while maintaining rental records in the database.

## Features
- Register and manage customers
- Add, update, and delete vehicle records
- Rent and return vehicles
- Track rental history

## Technologies Used
- Java
- Hibernate ORM
- MySQL (or any relational database)
- Maven
- Eclipse IDE (or any Java-supported IDE)

## Project Structure
```
VehicleRentalSystem/
│── src/
│   ├── main/java/com/vehicleRental/util/
│   │   ├── Main.java  # Entry point of the application
│   │   ├── CustomerMain.java  # Handles customer operations
│   │   ├── RentalMain.java  # Manages vehicle rentals
│   ├── main/resources/hibernate.cfg.xml  # Hibernate configuration file
│── pom.xml  # Maven dependencies
```

## Prerequisites
- Install Java (JDK 8 or later)
- Install MySQL and set up a database
- Install Maven
- Configure Hibernate (update database credentials in `hibernate.cfg.xml`)

## Setup & Installation
1. Clone the repository or extract the ZIP folder.
2. Open the project in Eclipse or any Java IDE.
3. Configure MySQL database and update `hibernate.cfg.xml`.
4. Build the project using Maven:
   ```sh
   mvn clean install
   ```
5. Run the application by executing `Main.java`.

## Database Configuration (hibernate.cfg.xml)
Update the following properties in `hibernate.cfg.xml` to match your database settings:
```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/vehiclerentaldb</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    </session-factory>
</hibernate-configuration>
```

## Running the Application
1. Run `Main.java` to start the system.
2. Perform operations like adding vehicles, renting, and returning.
3. Check the database for transaction records.

## Contributing
Feel free to fork this repository and contribute by submitting pull requests.

## License
This project is licensed under the MIT License.

