package com.mulesoft.demo.translation.transformers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.mulesoft.demo.translation.dto.response.DetectLanguageResponse;
import com.mulesoft.demo.translation.dto.response.DetectLanguageResponseCollection;

public class DetectLanguages  extends AbstractMessageTransformer {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	private String defaultLanguage;
	
	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
	
		log.info("Processing language detections");
		DetectLanguageResponseCollection languages;
		String language = "";
		double confidence = 0.0;
		
		if (message.getPayload() != null) {
			languages = (DetectLanguageResponseCollection) message.getPayload();
			
			//loop through the languages returned, accept the language with the highest confidence
			for (DetectLanguageResponse response : languages.detections) {
				
				if (response.getConfidence() > confidence) {
					language = response.getLanguage();
					confidence = response.getConfidence();
					log.debug("Detected language: " + language + ". Confidence is : " + confidence);
				} else {
					log.debug("Skipping language because of low confidence: " + response.getLanguage());
				}
			}
		}
		 
		return language;
	}

}
