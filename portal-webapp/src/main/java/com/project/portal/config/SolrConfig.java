package com.project.portal.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "com.project.portal.server" })
public class SolrConfig {
	
	@Bean
	public SolrClient solrServer(@Value("${solr.uri}") String solrHost) {
		return new HttpSolrClient.Builder(solrHost).build();
	}
	
	@Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }

}
