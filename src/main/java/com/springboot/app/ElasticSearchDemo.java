package com.springboot.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.springboot.service.ElasticSearchService;
import com.springboot.service.MetaDocReaderService;
import com.springboot.model.TiaDocument;
import com.springboot.model.MetaDocuments.MetaDocument;

import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@ComponentScan({"com.springboot.*"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ElasticSearchDemo implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ElasticSearchDemo.class, args);
	}
	
	@Autowired
    private ElasticsearchOperations es;
    @Autowired
    private MetaDocReaderService docReader;
    @Autowired
    private ElasticSearchService searchService;

	

	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			logger.info("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				logger.info(beanName);
			}
		};
	}*/
	
	@Override
    public void run(String... args) throws Exception {
        printElasticSearchInfo();
        
        docReader.loadMetaDataDoc();
        for(MetaDocument metaDoc : docReader.getMetaDocuments()) {
        	TiaDocument tiaDoc = new TiaDocument(metaDoc);
        	searchService.save(tiaDoc);
        }
        
        Page<TiaDocument> searchResult = searchService.findByUserName("anshu", new PageRequest(0, 10));//Title("Apache");
        searchResult.forEach(x -> logger.info("docs found -> " + x.toString()));
        
        /*logger.info("--Hit 2 --");
        //A16B
        searchResult = searchService.findById("A16B", new PageRequest(0, 10));
        searchResult.forEach(x -> logger.info("docs found -> " + x.toString()));*/
    }
	
	//useful for debug, print elastic search details
    private void printElasticSearchInfo() {

    	logger.info("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            logger.info(k + " = " + v);
        });
        logger.info("--ElasticSearch--");
    }
}
