# Clickatell Race Application

## Overview
This project is a simple application for tracking and reporting on races such as mountain bike races. It stores information about riders, races, and race results, and provides various reports such as the fastest riders, riders who didn't finish, and those who didn't participate. Additionally, the application integrates with a public weather API to provide weather information for the race location.

## Features
- Track riders, races, and race results.
- Generate reports for:
    - The fastest 3 riders per race.
    - Riders who did not finish a race.
    - Riders who did not participate in a race.
- Fetch weather conditions for the race location.

## Technologies Used
- **Java 8**
- **Spring Boot**
- **JPA/Hibernate** for ORM
- **MySQL** (or any relational database)
- **JUnit** and **Mockito** for unit testing
- **OpenWeatherMap API** for weather data

## How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Emmnauel-Irabor/clickatell-race-service.git
   cd clickatell-race-service
