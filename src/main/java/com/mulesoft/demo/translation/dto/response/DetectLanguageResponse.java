package com.mulesoft.demo.translation.dto.response;

public class DetectLanguageResponse {

	/* I am not user annotation for json-to-object purely  
	 * to show an example using data weave */
	 
	public String language;
	public double confidence;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
	
}
