package kafkaapi;
//import java.util.Properties;
import java.util.*;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaMessageConsumer {

    public static void main(String[] args) {
        final int giveUp = 100;   int noRecordsCount = 0;
        
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test-group");

        System.out.println("About to initialize Kafka Consumer");
        final KafkaConsumer<Long, String> kafkaConsumer =
                new KafkaConsumer<>(properties);

        TopicPartition tp = new TopicPartition("Kafka-Partition", 1);
        Long startOffset = 0L;
        Long endOffset = 2L;
        
        //KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        List<TopicPartition> topics = Arrays.asList(tp);
        //topics.add("Kafka-Test");
        kafkaConsumer.assign(topics);
        kafkaConsumer.seek(tp, startOffset);
		
        //kafkaConsumer.subscribe(topics);
        final ConsumerRecords<Long, String> consumerRecords =
        kafkaConsumer.poll(100000);

        // The number 100000 is the time up until which the listener listens to the Kafka topic
        //ConsumerRecords records = kafkaConsumer.poll(1000000000);
        System.out.println("Number of Records = " + consumerRecords.count());
	
        consumerRecords.forEach(record -> {
        	if (record.offset() <= endOffset) {
            //System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
              //      record.key(), record.value(),
               //     record.partition(), record.offset());
            System.out.println("Kafka Partition ID = " + record.partition() + "Record Value" + record.value());
        	}       
        });
	
        kafkaConsumer.commitAsync();  
        kafkaConsumer.close();
	}
}