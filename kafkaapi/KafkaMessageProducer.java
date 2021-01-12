package kafkaapi;

import java.util.*;
//import simple producer packages
import org.apache.kafka.clients.producer.Producer;
//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;

public class KafkaMessageProducer {

    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
         
        try{
            for(int i = 5010; i < 5015; i++){
                //System.out.println("Kafka Message Producer sent a message successfully" + i);
                kafkaProducer.send(new ProducerRecord("Kafka-Partition", 2, "Key", "Kafka Partition 0: Message ID - " + i));
                System.out.println("Kafka Message Producer sent a message successfully" + i);
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        	kafkaProducer.close();
        }
    }

	


}
