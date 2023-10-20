package com.example.famto.entity;


import java.util.HashMap;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonSubTypes;
//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTagsModel implements 
AttributeConverter<HashMap, String>  {
	
	
	protected String tags;

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String convertToDatabaseColumn(HashMap attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return null;
	}


}