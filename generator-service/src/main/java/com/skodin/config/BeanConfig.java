package com.skodin.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class BeanConfig {

    @SneakyThrows
    @Bean
    public XML producerXml() {
//        try(InputStream resourceAsStream = getClass()
//                .getResourceAsStream("/home/nikita/Desktop/JAVA/JavaProjects/microservice-architecture-kafka-beta-3/generator-service/" +
//                        "src/main/resources/kafka/producer.xml");) {
//
//            return new XMLDocument(
//                    resourceAsStream
//                            .readAllBytes()
//            );
//        }

        return new XMLDocument(
                Files.readAllBytes(Paths.get("/home/nikita/Desktop/JAVA/JavaProjects/microservice-architecture-kafka-beta-3/generator-service/" +
                        "src/main/resources/kafka/producer.xml"))
        );

    }

}
