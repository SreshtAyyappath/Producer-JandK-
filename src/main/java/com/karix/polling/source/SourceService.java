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

    public List<SourceEntity> getEntitiesWithStatusZero() {
        return sourceRepository.findByStatus(0);
    }

    public String getTemplateTxt(BigDecimal templateId){
        System.out.println("Searching templateId: " + templateId);
        String templateTxt = cacheManager.getFromCache(templateId);

        if(templateTxt == null){
            System.out.println("not in cache.");
            TemplateEntity templateEntity = templateRepository.findById(templateId);
            if(templateEntity == null){
                log.error("no value in template table");
                return null;
            }
            templateTxt = templateEntity.getTemplateTxt();

            if(templateTxt == null){
                log.error("templateTxt not found");
            }else{
                cacheManager.putInCache(templateId, templateTxt);
            }
        }
        return templateTxt;
    }


}
