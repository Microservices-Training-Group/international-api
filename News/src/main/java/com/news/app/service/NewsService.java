package com.news.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.app.model.Articles;
import com.news.app.model.Example;
import com.news.app.model.Source;

@Service
public class NewsService extends MappingJackson2HttpMessageConverter {

	private static NewsService ourInstance = new NewsService();
	
	 public static NewsService getInstance() {
	        return ourInstance;
	    }
	 
	    private NewsService() {
	    	setPrettyPrint(true);
	    }
	
	    public static List<Example> sendRefinedUpdate(String country,String category,String source123) throws IOException {	
	    		    	 
	    	String urlString = "https://newsapi.org/v2/top-headlines?apiKey="+"5ee76085768547ae9b4f58e25a78a7a9" +"&country="+country+"&category="+category+"&source="+source123+"";
	    	
	    	 RestTemplate restTemplate = new RestTemplate();
	    	    String result = restTemplate.getForObject(urlString, String.class);	    	
	    		    	  
	    	    JSONObject root = new JSONObject(result); 
	    	    
	    		String status = null;
	            Integer totalResults = null;
	            String id = null;
	            String name = null;                
	            String author = null;         		
	    		String title = null;
	    		String description = null;
	    		String urlother = null;
	    		String urlToImage = null;
	    		String publishedAt = null;
	    		String content = null;
	            
	            List<Example> newsList = new ArrayList<>();
	            				
				status =  root.getString("status");
				totalResults =  root.getInt("totalResults");
				
				 JSONArray articlesObject = root.getJSONArray("articles");

			        for(int i = 0; i < articlesObject.length(); i++) {
			              	
			            JSONObject arrayElement = articlesObject.getJSONObject(i);
			           
			            JSONObject sourceother = arrayElement.getJSONObject("source");
			            			          			            			     	        
			            if(!sourceother.isNull("id")){ 
			            	id = sourceother.getString("id");
			            	}else {
			            		id=null;
			            	}   
			            
			            name =  sourceother.getString("name");
			            			          
			            if(!arrayElement.isNull("author")){ 
			            	author = arrayElement.getString("author");
			            	}else {
			            		author = null;
			            	}    
			            
			            title = arrayElement.getString("title");
			            			         
			            if(!arrayElement.isNull("description")){ 
			            	description = arrayElement.getString("description");
			            	}else {
			            		description = null;
			            	}    
			            
			            urlother = arrayElement.getString("url");
			            			        
			            if(!arrayElement.isNull("urlToImage")){ 
			            	urlToImage = arrayElement.getString("urlToImage");
			            	}else {
			            		urlToImage = null;
			            	}    
			            
			            publishedAt = arrayElement.getString("publishedAt");
			            			         
			           if(!arrayElement.isNull("content")){ 
			            	content = arrayElement.getString("content");
			            	}else {
			            		content = null;
			            	}    
			            			            
				         Example emp = new Example();				    	 
				    	Articles articles = new Articles();				    		
				    	Source source = new Source();	
				    	
			            emp.setStatus(status);
			            emp.setTotalResults(totalResults);
			            articles.setAuthor(author);
			            articles.setContent(content);
			            articles.setDescription(description);
			            articles.setPublishedAt(publishedAt);
			            articles.setTitle(title);
			            articles.setUrlOther(urlother);
			            articles.setUrlToImage(urlToImage);
			            source.setId(id);
			            source.setName(name);	
			            
			            articles.setSource(source);
			            emp.setArticles(articles);
			            newsList.add(emp);
	    }    
			        return newsList;
    }
	    
	    public static List<Example> sendCategorizedUpdate(String country,String category) throws IOException {
	    	
	    	String urlString = "https://newsapi.org/v2/top-headlines?apiKey=a24d98f562554d239d33c2f9d3da0983&country="+country+"&category="+category+"";
	    	
	    	 RestTemplate restTemplate = new RestTemplate();
	    	    String result = restTemplate.getForObject(urlString, String.class);	    	
	    		    	  
	    	    JSONObject root = new JSONObject(result);   
	    	 
	    		String status = null;
	            Integer totalResults = null;
	            String id = null;
	            String name = null;                
	            String author = null;         		
	    		String title = null;
	    		String description = null;
	    		String urlother = null;
	    		String urlToImage = null;
	    		String publishedAt = null;
	    		String content = null;
	            
	            List<Example> newsList = new ArrayList<>();
	            				
				status =  root.getString("status");
				totalResults =  root.getInt("totalResults");
				
				 JSONArray articlesObject = root.getJSONArray("articles");

			        for(int i = 0; i < articlesObject.length(); i++) {
			              	
			            JSONObject arrayElement = articlesObject.getJSONObject(i);
			           
			            JSONObject sourceother = arrayElement.getJSONObject("source");
			            			          			            			     	        
			            if(!sourceother.isNull("id")){ 
			            	id = sourceother.getString("id");
			            	}else {
			            		id=null;
			            	}   
			            
			            name =  sourceother.getString("name");
			            			          
			            if(!arrayElement.isNull("author")){ 
			            	author = arrayElement.getString("author");
			            	}else {
			            		author = null;
			            	}    
			            
			            title = arrayElement.getString("title");
			            			         
			            if(!arrayElement.isNull("description")){ 
			            	description = arrayElement.getString("description");
			            	}else {
			            		description = null;
			            	}    
			            
			            urlother = arrayElement.getString("url");
			            			        
			            if(!arrayElement.isNull("urlToImage")){ 
			            	urlToImage = arrayElement.getString("urlToImage");
			            	}else {
			            		urlToImage = null;
			            	}    
			            
			            publishedAt = arrayElement.getString("publishedAt");
			            			         
			           if(!arrayElement.isNull("content")){ 
			            	content = arrayElement.getString("content");
			            	}else {
			            		content = null;
			            	}    
			            			            
				         Example emp = new Example();				    	 
				    	Articles articles = new Articles();				    		
				    	Source source = new Source();	
				    	
			            emp.setStatus(status);
			            emp.setTotalResults(totalResults);
			            articles.setAuthor(author);
			            articles.setContent(content);
			            articles.setDescription(description);
			            articles.setPublishedAt(publishedAt);
			            articles.setTitle(title);
			            articles.setUrlOther(urlother);
			            articles.setUrlToImage(urlToImage);
			            source.setId(id);
			            source.setName(name);	
			            
			            articles.setSource(source);
			            emp.setArticles(articles);
			            newsList.add(emp);
	    }    
			        return newsList;
	    	
}
	    
	    public static List<Example> sendSourcedUpdate(String country,String source123) throws IOException {
	    	
	    	String urlString = "https://newsapi.org/v2/top-headlines?apiKey=a24d98f562554d239d33c2f9d3da0983&country="+country+"&source="+source123+"";
	    	
	    	 RestTemplate restTemplate = new RestTemplate();
	    	    String result = restTemplate.getForObject(urlString, String.class);	    	
	    		    	  
	    	    JSONObject root = new JSONObject(result); 
	    		String status = null;
	            Integer totalResults = null;
	            String id = null;
	            String name = null;                
	            String author = null;         		
	    		String title = null;
	    		String description = null;
	    		String urlother = null;
	    		String urlToImage = null;
	    		String publishedAt = null;
	    		String content = null;
	            
	            List<Example> newsList = new ArrayList<>();
	            				
				status =  root.getString("status");
				totalResults =  root.getInt("totalResults");
				
				 JSONArray articlesObject = root.getJSONArray("articles");

			        for(int i = 0; i < articlesObject.length(); i++) {
			              	
			            JSONObject arrayElement = articlesObject.getJSONObject(i);
			           
			            JSONObject sourceother = arrayElement.getJSONObject("source");
			            			          			            			     	        
			            if(!sourceother.isNull("id")){ 
			            	id = sourceother.getString("id");
			            	}else {
			            		id=null;
			            	}   
			            
			            name =  sourceother.getString("name");
			            			          
			            if(!arrayElement.isNull("author")){ 
			            	author = arrayElement.getString("author");
			            	}else {
			            		author = null;
			            	}    
			            
			            title = arrayElement.getString("title");
			            			         
			            if(!arrayElement.isNull("description")){ 
			            	description = arrayElement.getString("description");
			            	}else {
			            		description = null;
			            	}    
			            
			            urlother = arrayElement.getString("url");
			            			        
			            if(!arrayElement.isNull("urlToImage")){ 
			            	urlToImage = arrayElement.getString("urlToImage");
			            	}else {
			            		urlToImage = null;
			            	}    
			            
			            publishedAt = arrayElement.getString("publishedAt");
			            			         
			           if(!arrayElement.isNull("content")){ 
			            	content = arrayElement.getString("content");
			            	}else {
			            		content = null;
			            	}    
			            			            
				         Example emp = new Example();				    	 
				    	Articles articles = new Articles();				    		
				    	Source source = new Source();	
				    	
			            emp.setStatus(status);
			            emp.setTotalResults(totalResults);
			            articles.setAuthor(author);
			            articles.setContent(content);
			            articles.setDescription(description);
			            articles.setPublishedAt(publishedAt);
			            articles.setTitle(title);
			            articles.setUrlOther(urlother);
			            articles.setUrlToImage(urlToImage);
			            source.setId(id);
			            source.setName(name);	
			            
			            articles.setSource(source);
			            emp.setArticles(articles);
			            newsList.add(emp);
	    }    
			        return newsList;
	    	
	    }    
	    
}