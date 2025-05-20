# LCL Backend

## Database

This project uses PostgreSQL as the main database and H2 for tests.

### Database Configuration

The database connection is configured in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lcl
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=postgres
```

For tests, H2 in-memory database is used, configured in `src/test/resources/application-test.properties`.

## Database Migrations

This project uses Flyway for database migrations. The migrations are located in the `src/main/resources/db/migration` directory.

### Migration Files

Migration files follow the Flyway naming convention:

```
V{version}__{description}.sql
```

For example:
- `V1__create_accounts_table.sql`

### Running Migrations

There are two ways to run migrations:

1. **Automatically during application startup**:

   When you start the application, Flyway will automatically run any pending migrations.

2. **Using the MigrationRunner**:

   You can also run migrations manually using the MigrationRunner class:

   ```bash
   ./gradlew bootRun --args='--spring.profiles.active=migration'
   ```

   Or run the MigrationRunner class directly from your IDE with the "migration" profile active.

### Creating New Migrations

To create a new migration:

1. Create a new SQL file in the `src/main/resources/db/migration` directory following the naming convention.
2. Write your SQL migration script.
3. Run the migrations using one of the methods described above.

## Database Schema

### Accounts Table

The accounts table stores user account information:

| Column   | Type          | Description                    |
|----------|---------------|--------------------------------|
| id       | BIGSERIAL     | Primary key, auto-incremented  |
| email    | VARCHAR(256)  | User's email address          |
| password | VARCHAR(64)   | User's hashed password        |

Note: In PostgreSQL, BIGSERIAL is used for auto-incrementing big integers, while in H2 (used for tests), BIGINT AUTO_INCREMENT is used.

## Development

### Running the Application

```bash
./gradlew bootRun
```

### Running Tests

```bash
./gradlew test
```

### Building the Application

```bash
./gradlew build
```
