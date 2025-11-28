FROM apache/kafka:latest
USER root

RUN mkdir -p /opt/kafka/config \
    && mkdir -p /var/lib/kafka/data

COPY config/server.properties /opt/kafka/config/server.properties

RUN KAFKA_CLUSTER_ID=$(/opt/kafka/bin/kafka-storage.sh random-uuid) && \
    /opt/kafka/bin/kafka-storage.sh format \
        -t $KAFKA_CLUSTER_ID \
        -c /opt/kafka/config/server.properties

EXPOSE 9092 9093

CMD ["/opt/kafka/bin/kafka-server-start.sh", "/opt/kafka/config/server.properties"]
