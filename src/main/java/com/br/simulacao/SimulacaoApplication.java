package com.br.simulacao;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

@SpringBootApplication
public class SimulacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulacaoApplication.class, args);
	}

	@Bean
	BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
		return beanFactory ->
			genericApplicationContext((BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory());
	}

	void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
		ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
		beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
		beanDefinitionScanner.scan(
				"com.br.simulacao.application.gateway",
				"com.br.simulacao.application.utils",
				"com.br.simulacao.application.usecases",
				"com.br.simulacao.application.dataprovider",
				"com.br.simulacao.application.dataprovider.presenters",
				"com.br.simulacao.application.dataprovider.mapper",
				"com.br.simulacao.application.dataprovider.gateway",
				"com.br.simulacao.application.dataprovider.repository",
				"com.br.simulacao.application.dataprovider.service",
				"com.br.simulacao.application.entrypoint",
				"com.br.simulacao.application.infraesctructure"
		);
	}

	static TypeFilter removeModelAndEntitiesFilter() {
		return (MetadataReader mr, MetadataReaderFactory mrf) -> (
				!mr.getClassMetadata().getClassName().endsWith("Model")
				&& !mr.getClassMetadata().getClassName().endsWith("Exception")
		);
	}

}
