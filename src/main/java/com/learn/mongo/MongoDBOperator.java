package com.learn.mongo;

import com.learn.excel.DrugInfoObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


/**
 * Created by zcx on 2017/9/18.
 */
public class MongoDBOperator {

    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI("mongodb://wanhuaudit:123456@10.1.10.51:27017/audit_test");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("audit_test");
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        database.withCodecRegistry(pojoCodecRegistry);
        MongoCollection<DrugInfoObject> collection = database.getCollection("drug_info", DrugInfoObject.class);

        System.out.println(collection.find().first().commonName());

    }
}
