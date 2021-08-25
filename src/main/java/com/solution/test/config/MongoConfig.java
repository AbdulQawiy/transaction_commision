package com.solution.test.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * Created by Ubanagu.Obidigbo on 5/9/2018.
 */

@Configuration
@EnableMongoRepositories(basePackages = {"com.solution.test.dao"})
public class MongoConfig extends AbstractMongoClientConfiguration {


    @Value("${spring.mongo.host}")
    private String mongoHost;

    @Value("${spring.mongo.databaseName}")
    private String databaseName;


    @Override
    public MongoClient mongoClient() {

        return MongoClients.create(mongoHost);
    }

    protected String getDatabaseName() {
        return databaseName;
    }

    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(mongoClient(),getDatabaseName());
    }
}
