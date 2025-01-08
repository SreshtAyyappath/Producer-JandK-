package com.karix.polling.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class JsonPayloadConverter {

    public static String convertToJsonPayload(SourceEntity sourceEntity, String message) {
        try {
            // Initialize ObjectMapper for JSON creation
            ObjectMapper objectMapper = new ObjectMapper();

            // Format the ENTRY_TIME to ISO-8601 format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            String requestTimestamp = dateFormat.format(sourceEntity.getEntryTime());

            // Build JSON structure
            ObjectNode smsGatewayReq = objectMapper.createObjectNode();

            // Message Header
            ObjectNode messageHeader = objectMapper.createObjectNode();
            messageHeader.put("transactionId", sourceEntity.getTransactionId());
            messageHeader.put("appId", "JKBXXX");
            messageHeader.put("requestTimestamp", requestTimestamp);

            // Message Body
            ObjectNode messageBody = objectMapper.createObjectNode();
            ObjectNode msgDetails = objectMapper.createObjectNode();
            msgDetails.put("mobileNumber", sourceEntity.getMobileNo());
            msgDetails.put("message", message);
            msgDetails.put("templateId", sourceEntity.getTemplateID().toString());
            msgDetails.put("custRef", sourceEntity.getId());

            // Adding MsgDetails array
            messageBody.set("MsgDetails", objectMapper.createArrayNode().add(msgDetails));
            messageBody.put("schld_at", "");

            // Combine into smsGatewayReq
            smsGatewayReq.set("messageHeader", messageHeader);
            smsGatewayReq.set("messageBody", messageBody);

            // Wrap in final payload
            ObjectNode finalPayload = objectMapper.createObjectNode();
            finalPayload.set("smsGatewayReq", smsGatewayReq);

            // Convert to JSON string
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(finalPayload);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

