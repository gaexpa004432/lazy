package admin.cms.config;

import admin.cms.interceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/*/*")
                .excludePathPatterns("/css/*")
                .excludePathPatterns("/img/*")
                .excludePathPatterns("/js/*"); // 해당 경로는 인터셉터가 가로채지 않는다.
    }
}