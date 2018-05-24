package com.mulesoft.demo.translation.transformers;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.mulesoft.demo.translation.dto.input.Message;

public class MessageToTweet extends AbstractMessageTransformer {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	private static final String TRANSLATION = "translation";
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
	
		Message inputMessage = (Message) message.getPayload();
		String translation = (String) message.getInvocationProperty(TRANSLATION);
		StringBuffer sb = new StringBuffer();
		sb.append(inputMessage.getText());
		
		if (!StringUtils.isEmpty(translation)) {
			sb.append("\r\n");
			sb.append(StringEscapeUtils.unescapeHtml4(translation));
		}
		
		if (!StringUtils.isEmpty(inputMessage.getUsers())) {
			sb.append("\r\n");
			sb.append(inputMessage.getUsers());
		}
		

		if (!StringUtils.isEmpty(inputMessage.getTags())) {
			sb.append("\r\n");
			sb.append(inputMessage.getTags());
		}
		return sb.toString();
	}
}
