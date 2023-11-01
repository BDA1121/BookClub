package com.example.thebookclub;
//*****Do not run this file haven't successfully connected with DB thus commented the code************

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

//*****Do not run this file haven't successfully connected with DB thus commented the code************

public class mongo {
    public static void main(String[] args) {
        // Connect to MongoDB server
//        String connectionString = "mongodb+srv://balamurugand:balamurugand@cluster0.hxvdyug.mongodb.net";
//        System.out.println(connectionString);
//        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
//            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//            databases.forEach(db -> System.out.println(db.toJson()));
//        }
        // Access a database
//        MongoDatabase database = mongoClient.getDatabase("mydb");
//
//        // Access a collection
//        MongoCollection<Document> collection = database.getCollection("mycollection");
//
//        // Create a document
//        Document document = new Document("name", "John").append("age", 30);
//
//        // Insert the document
//        collection.insertOne(document);
//
//        // Close the MongoDB client
//        mongoClient.close();
    }
}

