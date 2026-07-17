# REST Assured API Automation Framework

A scalable REST API automation framework built using Java, REST Assured, TestNG, and Maven. This framework supports API validation, reusable utilities, reporting, logging, and environment-based configuration.

## Tech Stack
| Technology            | Version        |
|-----------------------|----------------|
| Java                  | 17+            |
| REST Assured          | 5.5.6          |
| TestNG                | 7.11.8         |
| JUnit                 | 3.8.1 (Legacy) |
| Maven                 | Latest         |
| Jackson               | Latest         |
| Maven Surefire Plugin | Latest         |

---

## Project Structure

```
src
│
├── test
│   ├── java
│   │   ├── com.mohammad
│   │   ├── files
│   │   ├── utils
│   │   
│   │
│   └── resources
│       ├── dev.properties
│       ├── regression.xml
│       └── smoke.xml
```

---

## Features

- REST Assured API Testing
- GET, POST, PUT, PATCH, DELETE requests
- Environment Configuration
- Authorization Support
- API Logging
- Assertions using TestNG
- Data Driven Testing
- Maven Integration

---

## Maven Dependencies

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mohammad</groupId>
    <artifactId>restAssured</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <name>restAssured</name>
    <url>http://maven.apache.org</url>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.6</version>
            <scope>test</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.22.1</version>
            <scope>compile</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.11.0</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest -->
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>3.0</version>
            <scope>test</scope>
        </dependency>
        <!-- Allure TestNG -->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.29.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.17</version>
        </dependency>

        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.18</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.3</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>
                            src/test/resources/smoke.xml
                        </suiteXmlFile>
                        <suiteXmlFile>
                            src/test/resources/regression.xml
                        </suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
            <plugin>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-maven</artifactId>
                <version>2.12.0</version>
            </plugin>
        </plugins>
    </build>
</project>


```

---

## Configuration

Store environment-specific settings inside:

```
src/test/resources/dev.properties
```

Load properties using a utility class.

---

## Running Tests

Run all tests

mvn clean test

Run TestNG suite

```bash
mvn test -DsuiteXmlFile=regression
```
Run a specific TestNG group

```bash
mvn test -Dgroups=smoke
```

## Framework Components

- Base Test
- Test Utilities
- Logging Utility
- Common Assertions

---

## Test Reports

Reports can be generated using:

- TestNG Reports
- Surefire Reports
- Allure Reports (Optional)

Default Maven report location:

```
target/surefire-reports/
```

---

## Best Practices

- Keep test data separate from test logic.
- Reuse Request Specifications.
- Use POJOs for request and response models.
- Avoid hardcoding URLs and credentials.
- Use constants for endpoints.
- Follow the Page Object–like pattern for API classes.
- Validate status codes, headers, response time, and response body.
- Organize tests using TestNG groups (Smoke, Regression, Sanity).

---

## Supported HTTP Methods

- GET
- POST
- PUT
- PATCH
- DELETE

---

## Future Enhancements

- Extent Reporting
- CI/CD Integration (GitHub Actions, Jenkins, Azure DevOps)
- Retry Analyzer
- Database Validation
- JSON Schema Validation
- Docker Support

---

## Author

Mohammad Rahman
Senior SDET | API Automation | Java | REST Assured | TestNG
