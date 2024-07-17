package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Ruben
 */
public class DaoConnection {

    private MongoClient mongoClientCo;
    private MongoDatabase database;
    private final String URL = "mongodb://anonimo:l20%3Asd2SDz@localhost:27017/?authSource=BuilderPCDB";

    public DaoConnection() {
    }

    public FindIterable<Document> genericQuery(String ColletionName, Bson filter) {
        MongoCollection<Document> collection = database.getCollection(ColletionName);
        return collection.find(filter);
    }

    public boolean EstablecerC() {
        try {
            Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
            mongoClientCo = MongoClients.create(URL);
            database = mongoClientCo.getDatabase("BuilderPCDB");
            return true;
        } catch (MongoException me) {
            //System.out.println("opshpaofhopaf");
            //System.out.println(me);
        }
        return false;
    }

    public void closeCo() {
        try {
            mongoClientCo.close();
        } catch (MongoException me) {
            System.out.println(me);
        }
    }
}
