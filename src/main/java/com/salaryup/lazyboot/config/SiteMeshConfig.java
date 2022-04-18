package com.salaryup.lazyboot.config;


import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class SiteMeshConfig extends ConfigurableSiteMeshFilter {

    @Bean
    public FilterRegistrationBean<SiteMeshConfig> siteMeshFilter() {
        FilterRegistrationBean<SiteMeshConfig> filter = new FilterRegistrationBean<SiteMeshConfig>();
        filter.setFilter(new SiteMeshConfig());
        return filter;
    }


    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder // Map decorators to path patterns.
                .addDecoratorPath("/login", "/WEB-INF/jsp/decorator/emptyLayout.jsp")
                .addDecoratorPath("/*", "/WEB-INF/jsp/decorator/defaultLayout.jsp")
                // Exclude path from decoration.
                .addExcludedPath("/html/*")
                .addExcludedPath(".json")
                .setMimeTypes("text/html");
    }
}





