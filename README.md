# CELFOCUS Online Interview (base project)

Hello, this is the base project for your practical interview.

### How to run the application?

- Open the project on your favourite IDE. (we recommend IntelliJ IDEA)
- Compile the project:
    ```sh
    $ mvnw clean install
    ```
- Run the application (spring boot):
    ```sh
    $ mvnw spring-boot:run
    ```

### Is everything working?

- Open your favourite browser.
- Head to http://localhost:8080/index.html and confirm you see the 'Welcome :)' message.
- Call http://localhost:8080/topups/ping to check if you are reaching the backend services. 'pong' must be the answer :)