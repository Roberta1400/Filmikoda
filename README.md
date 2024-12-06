# Filmikoda

Filmikoda is a web application that allows users to explore a wide variety of movies, find suitable showtimes, and book tickets conveniently. Users can apply filters to quickly and easily find movies of interest. During ticket booking, the app suggests the best available seats in the cinema for an optimal viewing experience.

---

## Features
- Browse a wide selection of movies.
- Filter movies by genre, rating, and more.
- Book tickets conveniently with a suggested best seat selection.

---

## Getting Started

### Prerequisites
To run this project, you will need:
- **PostgreSQL** and **PgAdmin** (for the database setup)
- **Java Development Kit (JDK)** version 21
- **Maven** (for backend setup)
- **Node.js** and **npm** (for frontend setup)

---

### Setup Instructions

#### 1. Database Setup
1. Download and install **PostgreSQL** and **PgAdmin**.
2. During installation, set your username, password, and port for PostgreSQL.
3. Update the backend configuration:
   - Open the `application.properties` file located at `src/main/resources/application.properties`.
   - Update the following lines with your PostgreSQL credentials:
     ```properties
     spring.datasource.username=postgres
     spring.datasource.password=your_password
     ```

#### 2. Backend Setup
1. Clone or download the backend repository to your computer.
2. Open the project in IntelliJ IDEA or any Java IDE of your choice.
3. Navigate to `src/main/java/com/example/demo/DemoApplication.java` and run the `DemoApplication` class.

#### 3. Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd frontend
