package com.salaryup.lazyboot.config;

import org.apache.catalina.connector.Connector;

import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AJPConfig {
    /*// application.properties에서 설정 값을 받아온다.
    @Value("${tomcat.ajp.port}")
    private int port;
    // bean 설정
    @Bean
    public ServletWebServerFactory servletContainer() {
// AJP/1.3 프로토콜의 Connector를 생성
        Connector ajpConnector = new Connector("AJP/1.3");
// 포트 설정을 application.properties에서 설정
        ajpConnector.setPort(port);
// ajp 로그 설정 이전 server.xml의 allowTrace 어트리뷰트
        ajpConnector.setAllowTrace(false);
// http와 https 처리.. 현재는 필요없기 때문에 주석 처리
// ajpConnector.setScheme("http");
// SSL연결 시에 사용
// ajpConnector.setSecure(false);
// server.xml에서 secretRequired 설정
        ((AbstractAjpProtocol<?>)ajpConnector.getProtocolHandler()).setSecretRequired(false);
// tomcat 설정
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
// 추가
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
        return tomcat;
    }*/
}
