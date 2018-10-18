package ru.deft.mongo;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Created by Sergey Golitsyn (deft) on 18.10.2018
 */
@EnableReactiveMongoRepositories
public class AppConfig extends AbstractReactiveMongoConfiguration {


  @Bean
  protected String getDatabaseName() {
	return "mongodb";
  }

  @Bean
  public MongoClient reactiveMongoClient() {
	return MongoClients.create();
  }
}
