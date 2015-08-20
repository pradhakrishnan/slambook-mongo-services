package org.slambook.mongoservices;

import java.util.List;

import org.slambook.mongoservices.domain.SlamBookUser;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoException;


public class SlamBookUserServicesImpl extends BaseMongoServices<SlamBookUser>{

	public SlamBookUserServicesImpl(String mongoHost, int mongoPort, String db) {
		super(mongoHost, mongoPort, db);
		super.connectMongoServer();
	}

	@Override
	public void insertDocument(SlamBookUser user, String collectionName) {
		mongoOperation.insert(user, collectionName);
	}

	@Override
	public void updateDocument(SlamBookUser user,  String collectionName) {
		mongoOperation.save(user, collectionName);
	}

	@Override
	public SlamBookUser findDocument(Query query, String collectionName) {
		return mongoOperation
				.findOne(query, SlamBookUser.class, collectionName);
	}

	@Override
	public List<SlamBookUser> findAllDocument(String collectionName) throws MongoException {
		return mongoOperation
				.findAll(SlamBookUser.class, collectionName);
	}

	@Override
	public List<SlamBookUser> findDocumentsByQuery(Query query,
			String collectionName) throws MongoException {
		return mongoOperation
				.find(query, SlamBookUser.class, collectionName);
	}

}
