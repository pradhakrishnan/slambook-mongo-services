package org.slambook.mongoservices;

import java.net.UnknownHostException;

import org.slambook.mongoservices.domain.SlamBookData;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public abstract class BaseMongoServices<T extends SlamBookData> implements SlamBookServices<T> {
	private String mongoHost;

	private int mongoPort;

	private String db;

	public MongoOperations mongoOperation;

	MongoClient client;

	public BaseMongoServices(String mongoHost, int mongoPort, String db) {
		super();
		this.mongoHost = mongoHost;
		this.mongoPort = mongoPort;
		this.db = db;
	}

	@Override
	public void connectMongoServer() throws MongoException {
		try {
			client = new MongoClient(mongoHost, mongoPort);
			mongoOperation = new MongoTemplate(client, db);
		} catch (UnknownHostException e) {
			System.err.println("Error while connectig mongo server"
					+ e.getMessage());
			throw new MongoException(
					"Error while connectig mongo server : host is  "
							+ mongoHost + " and port is " + mongoPort);
		}

	}

	@Override
	public void closeMongoConnection() {
		if (null != client) {
			client.close();
		}

	}
}
