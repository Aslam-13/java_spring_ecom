# API Documentation

This project uses SpringDoc to automatically generate interactive API documentation in the OpenAPI 3.0 format.

## How to Access the Documentation

1.  **Run the application.**
2.  Open your web browser and navigate to the following URL:
    *   [**http://localhost:8080/swagger-ui.html**](http://localhost:8080/swagger-ui.html)

You will be presented with the Swagger UI, an interactive web page where you can see all available API endpoints, view their details, and even try them out directly from your browser.

---

## API Endpoint Summary

Here is a quick reference of the available API endpoints.

### Authentication (`/api/auth`)

*   `POST /api/auth/register`: Creates a new user account.
*   `POST /api/auth/login`: Authenticates a user and returns a JWT token.

### Users (`/api/users`)

*   `GET /api/users`: Retrieves a list of all users.
*   `GET /api/users/{id}`: Retrieves a single user by their ID.
*   **Note:** These endpoints are currently open but should be restricted to administrators in a real application.

### Products (`/api/products`)

*   `POST /api/products`: Creates a new product.
*   `GET /api/products`: Retrieves a list of all products.
*   `GET /api/products/{id}`: Retrieves a single product by its ID.
*   `PUT /api/products/{id}`: Updates an existing product.
*   `DELETE /api/products/{id}`: Deletes a product.

### Shopping Cart (`/api/carts`)

*   `GET /api/carts/user/{userId}`: Retrieves the shopping cart for a given user.
*   `POST /api/carts/user/{userId}/items`: Adds an item to the user's shopping cart.
*   `PUT /api/carts/user/{userId}/items/{productId}`: Updates the quantity of an item in the cart.
*   `DELETE /api/carts/user/{userId}/items/{productId}`: Removes an item from the cart.

### Orders (`/api/orders`)

*   `POST /api/orders/user/{userId}`: Creates a new order from the user's current shopping cart and clears the cart.
*   `GET /api/orders/user/{userId}`: Retrieves a list of all orders for a given user.
*   `GET /api/orders/{orderId}`: Retrieves a single order by its ID.

### Health Check

*   `GET /actuator/health`: Returns the health status of the application.
