package edu.wgu.serializer;

import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.avro.Schema;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;

import java.util.Map;

public class KafkaAvroDeserializerFiltered extends KafkaAvroDeserializer {

    public KafkaAvroDeserializerFiltered() {
        super();
    }

    public KafkaAvroDeserializerFiltered(SchemaRegistryClient client) {
        super(client);
    }

    public KafkaAvroDeserializerFiltered(SchemaRegistryClient client, Map<String, ?> props) {
        super(client, props);
    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] bytes) {
        try {
            return super.deserialize(topic, isKey, headers, bytes, specificAvroReaderSchema);
        }  catch (SerializationException serializationException) {
            return null;
        }
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        try {
            return deserialize(bytes);
        } catch (SerializationException serializationException) {
            return null;
        }
    }

    @Override
    public Object deserialize(String s, byte[] bytes, Schema readerSchema) {
        try {
            return deserialize(bytes, readerSchema);
        } catch (SerializationException serializationException) {
            return null;
        }
    }
}