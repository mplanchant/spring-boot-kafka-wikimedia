# spring-boot-kafka-wikimedia

## Starting the Kafka environment

Run the following commands in order to start all services in the correct order:

```
# Start the ZooKeeper service
# Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

Open another terminal session and run:

```
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
```

Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

## MySQL

```
docker run --name wikimedia-mysql -e MYSQL_ROOT_PASSWORD=secret-pw -d mysql:8
```