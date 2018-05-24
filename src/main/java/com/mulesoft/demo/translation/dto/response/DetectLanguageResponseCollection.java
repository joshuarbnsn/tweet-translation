package com.mulesoft.demo.translation.dto.response;

import java.util.ArrayList;
import java.util.List;

public class DetectLanguageResponseCollection {

	public List<DetectLanguageResponse> detections;

	public List<DetectLanguageResponse> getDetections() {
		if (detections == null) {
			detections = new ArrayList<DetectLanguageResponse>();
		}
		return detections;
	}

	public void setDetections(List<DetectLanguageResponse> detections) {
		this.detections = detections;
	}
	
}
