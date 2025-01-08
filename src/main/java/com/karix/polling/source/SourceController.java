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
    @Scheduled(fixedRate = 5000)
    public void getEntitiesWithStatusZero(){
        sourceEntityList = sourceService.getEntitiesWithStatusZero();
        System.out.println(sourceEntityList.toString());
        for(int i = 0; i < sourceEntityList.size(); i++){
            BigDecimal templateId = sourceEntityList.get(i).getTemplateID();
            System.out.println(sourceService.getTemplateTxt(templateId));
        }
        return;
    }

}
