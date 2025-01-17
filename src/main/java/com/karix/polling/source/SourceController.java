package com.karix.polling.source;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@EnableScheduling
public class SourceController {

    @Autowired
    private SourceService sourceService;

    private List<SourceEntity> sourceEntityList;

    //@GetMapping("/entities/status-zero")
    //Scheduled(fixedRate = 5000)
    public void getEntitiesWithStatusZero(){
        sourceEntityList = sourceService.getEntitiesWithStatusZero("SOURCE_TABLE2", 1, 10);
        System.out.println(sourceEntityList.toString());
        for(int i = 0; i < sourceEntityList.size(); i++){
            BigDecimal templateId = sourceEntityList.get(i).getTemplateID();
            String msg=sourceService.getTemplateTxt(templateId);
            System.out.println(msg);
            if(msg != null) {
                String finalMessage=MessageCreator.createMessage(msg, sourceEntityList.get(i));
                String requestBody=JsonPayloadConverter.convertToJsonPayload(sourceEntityList.get(i),finalMessage);
                System.out.println(requestBody);
            }
        }
        return;
    }

}
