# Exposure Microservice (ccte-api-exposure)

## Overview
The Exposure Microservice is a RESTful API designed to manage and provide Exposure data. It interacts with a PostgreSQL database and offers various endpoints for Exposure-related operations.

## Available Data
Data underlying the Exposure API comes from the Chemicals and Products Database (CPDat) [Learn more: The Chemical and Products Database, a resource for exposure-relevant data on chemicals in consumer products](https://www.nature.com/articles/sdata2018125) and predictions from EPA’s Quantitative Structure Use Relationship (QSUR) models [Learn more: High-throughput screening of chemicals as functional substitutes using structure-based classification models](https://pubs.rsc.org/en/content/articlelanding/2017/gc/c6gc02744j).

For exposure-related questions, contact the Chemical Exposure Knowledgebase team (chemexpo.support@epa.gov).

## Technologies Used
- **Java**: Programming language used for the development of the application.
- **Spring Boot**: Framework used to create stand-alone, production-grade Spring-based applications.
- **Spring Data JPA**: Part of the Spring Data family, used to simplify data access and persistence.
- **Spring Data REST**: Used to expose Spring Data repositories as RESTful web services.
- **PostgreSQL**: Relational database used for storing Exposure data.
- **Maven**: Build automation tool used for managing project dependencies and build lifecycle.
- **Lombok**: Java library used to reduce boilerplate code.
- **MapStruct**: Code generator used to simplify the implementation of mappings between Java bean types.
- **Swagger/OpenAPI**: Used for API documentation and testing.
- **Testcontainers**: Java library used for integration testing with Docker containers.

## Configuration
The application configuration is managed through properties files. The main configuration file is `application.properties`, and environment-specific configurations can be added as needed.

## Build and Deployment
The project uses Maven for build and deployment processes. Continuous integration and deployment can be set up using tools like GitHub Actions.

## Getting Started
To build and run the project locally, use the following Maven commands:

```sh
mvn clean install
mvn spring-boot:run
```

## Project Structure
```plaintext
src/
├── main/
│   ├── java/
│   │   └── gov/epa/ccte/api/exposure/
│   │       ├── projection/
│   │       │   └── assay/
│   │       ├── repository/
│   │       ├── service/
│   │       └── web/
│   │           └── rest/
│   └── resources/
│       └── application.properties
└── test/
```

## Dependencies
- `spring-boot-starter-web`
- `spring-boot-starter-data-rest`
- `spring-boot-starter-data-jpa`
- `postgresql`
- `lombok`
- `springdoc-openapi-starter-webmvc-ui`
- `mapstruct`
- `spring-boot-starter-test`
- `spring-boot-testcontainers`
- `testcontainers`
- `jackson-datatype-hibernate6`

## Contributing
Contributions are welcome! Please read the `CONTRIBUTING.md` file for guidelines.

## Contact
For any inquiries, please contact the project maintainer. **[Rashid, Asif](https://github.com/asif-rashid)** , **[Dirks, Brianna](https://github.com/bridirks)**, **[Feshuk, Madison](https://github.com/madison-feshuk)**

## Disclaimer
The United States Environmental Protection Agency (EPA) GitHub project code is provided on an "as is" basis and the user assumes responsibility for its use. EPA has relinquished control of the information and no longer has responsibility to protect the integrity, confidentiality, or availability of the information. Any reference to specific commercial products, processes, or services by service mark, trademark, manufacturer, or otherwise, does not constitute or imply their endorsement, recommendation or favoring by EPA. The EPA seal and logo shall not be used in any manner to imply endorsement of any commercial product or activity by EPA or the United States Government. 