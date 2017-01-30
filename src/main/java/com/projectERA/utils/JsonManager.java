package com.projectERA.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JsonManager {
//	private final String LOCAL_REPO = "./saves";
//	private final String FILE_NAME = "default";
	
	ObjectMapper mapper = new ObjectMapper();
	public ArrayList<Object>objects = new ArrayList<Object>();
	
//	public JsonManager addItem(Object item){
//		this.objects.add(item);
//		return this;
//	}
//	
//	public JsonManager clear(){
//		this.objects.clear();
//		return this;
//	}
	
	/**
	 * Constructeur du singleton
	 */
	private JsonManager(){
		super();
	}
	
	private static JsonManager INSTANCE;
	
	public static JsonManager getInstance(){
		if(INSTANCE == null) {
			return INSTANCE = new JsonManager();
		}
		return INSTANCE;
	}
	
//	public String toJSON(){
//		try {
//			return mapper.writeValueAsString(this.objects);
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public void writeJsonFile(){
//		this.writeJsonFile(this.FILE_NAME, this.LOCAL_REPO);
//	}
//	
//	public void writeJsonFile(String filename){
//		this.writeJsonFile(filename, LOCAL_REPO);
//	}
	
	/**
	 * Write manager to a file
	 * @param filename
	 * @param path
	 */
	public void writeJsonFile(String filename, String path){
		File file = new File(path + File.pathSeparator + filename);
		
		if(!file.exists()){
			System.out.println("Création du répertoire: " + path);
		} 
		try {
			mapper.writeValue(file, objects);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public <T>ArrayList<T> readJsonFile(Class<?>currentClass){
//		return this.readJsonFile(this.FILE_NAME, this.LOCAL_REPO, currentClass);
//	}
//	
//	public <T>ArrayList<T> readJsonFile(String filename, Class<?>currentClass){
//		return this.readJsonFile(filename, this.LOCAL_REPO, currentClass);
//	}
//	
	/**
	 * Read a json file 
	 * @param filename
	 * @param path
	 */
	public <T> ArrayList<T> readJsonFile(String path, String filename, Class<?>currentClass){
		File file = new File(path + filename);
		ArrayList<T>jsonReading = new ArrayList<T>();
		
		if(!file.exists()){
			System.out.println("Le fichier n'existe pas !");
			// throw Exception
		} else {
			try {
				jsonReading = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, currentClass));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonReading;
	}

}
