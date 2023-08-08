# Docker containers
Some services that are used by this application are served via [Docker](https://www.docker.com/) to make easy
running without having to install everything locally.

## Mockoon
It's a small server that mocks REST APIs with custom data and configurations from a YAML file.
It has a GUI software to guide building this configuration file and also a CLI and Docker image.

https://mockoon.com/

### How it is used here
To serve fake generated users to be used on login.

### How to run
- Run the [./start-mockoon.sh](./start-mockoon.sh) script from your terminal.
  - Or start manually via [docker-compose](https://docs.docker.com/compose/):
    ```bash
    $ docker-compose up mockoon
    ```
    - Feel free to use `-d` or any other command that does the same thing.
- The [Postman collection](../docs/fernandos-kotlin-crud.postman_collection.json) + [environment](../docs/fernandos-kotlin-crud.postman_environment.json) also have the mocked endpoints.

## MongoDB
I's one of the most used NoSQL databases.

https://www.mongodb.com/

### How it is used here
It is the main database for the data used and stored by the application.

### How to run
- Run the [./start-mongodb.sh](./start-mongodb.sh) script from your terminal.
  - Or start manually via [docker-compose](https://docs.docker.com/compose/):
    ```bash
    $ docker-compose up mongo mongo-express
    ```
    - Feel free to use `-d` or any other command that does the same thing.
- You can connect to it with an administrative tool of your choice, or with the [Mongo Express](https://github.com/mongo-express/mongo-express) Docker container that's also included:
  - Host: `localhost`
  - Port: `47017`
  - Database user: `mango`
  - Database password: `fruit`
  - Database name: `kotlin_crud`
  - Mongo Express URL: http://localhost:8081
  - Admin user: `admin`
  - Admin password: `password`
- You can reset the stored data by running the [./reset-mongodb.sh](./reset-mongodb.sh) script from your terminal.
  - Or by running manually via [docker-compose](https://docs.docker.com/compose/) ([source](https://stackoverflow.com/a/71796529)):
    ```bash
    $ docker-compose rm -s -f -v mongo mongo-express
    ```

## InfluxDB, Grafana and K6
K6 is a load test tool, and it uses InfluxDB to store the results and Grafana to show them in dashboards.

https://k6.io/

### How to run
- Run the [./start-k6-dependencies.sh](./start-k6-dependencies.sh) script from your terminal.
  - Or start manually via [docker-compose](https://docs.docker.com/compose/):
    ```bash
    $ docker-compose up influxdb grafana
    ```
- Start the application (see the [root README.md](./../README.md#how-to-run)).
- Run the [./start-k6-tests.sh](./start-k6-tests.sh) script from your terminal.
  - Or start manually via [docker-compose](https://docs.docker.com/compose/):
    ```bash
    $ docker-compose up k6
    ```
- See and wait the tests execution in the terminal.
- Check the results in the terminal or in the [Grafana dashboard](http://localhost:3000/d/XKhgaUpik/k6-load-testing-results-by-groups):
- You can reset the stored data by running the [./reset-k6.sh](./reset-k6.sh) script from your terminal.
  - Or by running manually via [docker-compose](https://docs.docker.com/compose/) ([source](https://stackoverflow.com/a/71796529)):
    ```bash
    $ docker-compose rm -s -f -v influxdb grafana k6
    ```
