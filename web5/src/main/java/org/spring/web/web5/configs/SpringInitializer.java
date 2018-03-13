package org.spring.web.web5.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer	{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{PersistenceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

