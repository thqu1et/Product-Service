# Product Service

This application is a comprehensive Product Service built using Spring Boot. It provides RESTful APIs for managing products, categories, and suppliers, and stores the data in a PostgreSQL database.

## Features

- Add new products, categories, and suppliers
- Get product, category, and supplier details by ID
- Update product, category, and supplier details by ID
- Delete product, category, and supplier by ID
- Get a list of products, categories, and suppliers
- Find suppliers by name

## Technologies Used

- Spring Boot
- RESTful APIs
- PostgreSQL

## Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL

## Getting Started

1. **Clone the repository**

    ```bash
    git clone https://github.com/thqu1et/Product-Service.git
    cd product-service
    ```

2. **Configure the PostgreSQL Database**

   Ensure you have PostgreSQL installed and running. Create a database and update the `application.properties` file with your database credentials.

    ```properties
    spring.application.name=Product-Service
    server.port=8082
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:postgresql://localhost:5434/postgres
    spring.datasource.username=postgres
    spring.datasource.password=******
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.show-sql=true
    ```

3. **Build the Project**

   Use Maven to build the project:

    ```bash
    mvn clean install
    ```

4. **Run the Application**

   Start the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

   The application will start and be accessible at `http://127.0.0.1:8082`.

## API Endpoints

### Add Category

- **URL**: `/category`
- **Method**: `POST`
- **Request Body**: `Category`

    ```json
    {
        "name": "Electronics"
    }
    ```

### Get Category by ID

- **URL**: `/category/{id}`
- **Method**: `GET`
- **Response Body**: `Category`

    ```json
    {
        "id": 1,
        "name": "Electronics"
    }
    ```

### Update Category by ID

- **URL**: `/category/{id}`
- **Method**: `PUT`
- **Request Body**: `Category`

    ```json
    {
        "name": "Home Appliances"
    }
    ```

### Delete Category by ID

- **URL**: `/category/{id}`
- **Method**: `DELETE`

### List Categories

- **URL**: `/categories`
- **Method**: `GET`
- **Response Body**: List of `Category`

    ```json
    [
        {
            "id": 1,
            "name": "Electronics"
        }
    ]
    ```

### Add Supplier

- **URL**: `/supplier`
- **Method**: `POST`
- **Request Body**: `Supplier`

    ```json
    {
        "name": "ABC Supplies"
    }
    ```

### Get Supplier by ID

- **URL**: `/supplier/{id}`
- **Method**: `GET`
- **Response Body**: `Supplier`

    ```json
    {
        "id": 1,
        "name": "ABC Supplies"
    }
    ```

### Update Supplier by ID

- **URL**: `/supplier/{id}`
- **Method**: `PUT`
- **Request Body**: `Supplier`

    ```json
    {
        "name": "XYZ Supplies"
    }
    ```

### Delete Supplier by ID

- **URL**: `/supplier/{id}`
- **Method**: `DELETE`

### List Suppliers

- **URL**: `/suppliers`
- **Method**: `GET`
- **Response Body**: List of `Supplier`

    ```json
    [
        {
            "id": 1,
            "name": "ABC Supplies"
        }
    ]
    ```
### Find Supplier by Name

- **URL**: `/find-by-name`
- **Method**: `POST`
- **Request Body**: `FindByNameDto`

    ```json
    {
        "name": "ABC Supplies"
    }
    ```

- **Response Body**: `SupplierDto`

    ```json
    {
        "id": 1,
        "name": "ABC Supplies"
    }
    ```

### Add Product

- **URL**: `/product`
- **Method**: `POST`
- **Request Body**: `Product`

    ```json
    {
      "name" : "Apple",
      "description" : "Very very delicions fruits",
      "price" : 1.5,
      "quantity" : 50,
      "categoryId" : 1,
      "supplierId" : 1
    }
    ```

### Get Product by ID

- **URL**: `/product/{id}`
- **Method**: `GET`
- **Response Body**: `Product`

    ```json
    {
        "id": 1,
        "name": "Smartphone",
        "price": 699.99,
        "category": {
            "id": 1,
            "name": "Electronics"
        },
        "supplier": {
            "id": 1,
            "name": "ABC Supplies"
        }
    }
    ```

### Update Product by ID

- **URL**: `/product/{id}`
- **Method**: `PUT`
- **Request Body**: `Product`

    ```json
    {
        "name": "Smartphone",
        "price": 649.99,
        "categoryId": 1,
        "supplierId": 1
    }
    ```

### Delete Product by ID

- **URL**: `/product/{id}`
- **Method**: `DELETE`

### List Products

- **URL**: `/products`
- **Method**: `GET`
- **Response Body**: List of `Product`

    ```json
    [
        {
            "id": 1,
            "name": "Smartphone",
            "price": 699.99,
            "category": {
                "id": 1,
                "name": "Electronics"
            },
            "supplier": {
                "id": 1,
                "name": "ABC Supplies"
            }
        }
    ]
    ```


## Exception Handling

The application includes custom exception handling for the following scenarios:

- **ResourceNotFoundException**: Thrown when an entity with the given ID is not found.

## Logging

The application uses `Slf4j` for logging purposes. Logs will provide information on application events and errors.

## Conclusion

This Product Service application demonstrates the implementation of RESTful APIs using Spring Boot with a PostgreSQL database. It covers basic CRUD operations and includes exception handling and logging for better maintainability and debugging.

