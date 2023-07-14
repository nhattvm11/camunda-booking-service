Step 1: we can use Neo4j desktop app or docker:
- Using Neo4j desktop app: run neo4j desktop app => add new local DBMS => setting DB name and password

- Using Docker:
  * Open cmd and run this command =>

  docker run \
  --name testneo4j \
  -p7474:7474 -p7687:7687 \
  -d \
  -v $HOME/neo4j/data:/data \
  -v $HOME/neo4j/logs:/logs \
  -v $HOME/neo4j/import:/var/lib/neo4j/import \
  -v $HOME/neo4j/plugins:/plugins \
  --env NEO4J_AUTH=neo4j/password \
  neo4j:latest

  * Run this comand to list the running containers =>
    tcp testneo4j


    * line -p7474:7474 -p7687:7687 to mapping port
      -d to run in Detach mode
      -v to mount some drirectories
    * By default, the Docker image exposes three ports for remote access:
      7474 for HTTP
      7473 for HTTPS
      7687 for Bolt

    * open http://localhost:7474/
      username: neo4j
      password: password
      => login

      => to see all node and relationship: WATCH(n) return(n)

Step 2: update in: "src\main\resources\application.properties" => follow this: spring.neo4j.authentication.password='password'

=> run project

Flow: request from camunda -> check the room type in booking form -> save booking to DB -> create relationship Booking -[has]> RoomMaster -> send message back to camunda