package org.slambook.mongoservices;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoException;

public interface SlamBookServices<T> {
	public void insertDocument(T document, String collectionName) throws MongoException;
	public void updateDocument(T document, String collectionName) throws MongoException;
	public T findDocument(Query query, String collectionName) throws MongoException;
	public void connectMongoServer() throws MongoException;
	public void closeMongoConnection() throws MongoException;
	public List<T> findAllDocument(String collectionName) throws MongoException;
	public List<T> findDocumentsByQuery(Query query, String collectionName) throws MongoException;
}
