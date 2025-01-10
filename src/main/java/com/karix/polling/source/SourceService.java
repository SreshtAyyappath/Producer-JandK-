package com.karix.polling.source;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SourceService {

    private static final Logger log = LoggerFactory.getLogger(SourceService.class);
    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private CacheManager cacheManager;

    public List<SourceEntity> getEntitiesWithStatusZero(String tableName, Integer priority, Integer limit) {
        return sourceRepository.fetchDataFromTable(tableName, priority, limit);
    }

    public String getTemplateTxt(BigDecimal templateId){
        System.out.println("Searching templateId: " + templateId);
        String templateTxt = cacheManager.getFromCache(templateId);

        if(templateTxt == null){
            log.info("Finding TemplateTxt in Template DB(Does not exist in Cache)");
            try{
                TemplateEntity templateEntity = templateRepository.findById(templateId);

                if(templateEntity == null){
                    log.info("TemplateEntity for the TemplateId not found in DB");
                    return null;
                }
                templateTxt = templateEntity.getTemplateTxt();

                if(templateTxt == null){
                    log.info("TemplateTxt not present for the row");
                }else{
                    cacheManager.putInCache(templateId, templateTxt);
                }
            }catch(Exception e){
                log.error(String.valueOf(e));
            }


        }

        return templateTxt;
    }


}
