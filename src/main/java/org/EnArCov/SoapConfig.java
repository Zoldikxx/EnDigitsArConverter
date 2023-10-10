//package org.EnArCov;
//
//@EnableWs
//@Configuration
//public class SoapConfig extends WsConfigurerAdapter {
//
//    @Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean<>(servlet, "/soap/*");
//    }
//
//    @Bean(name = "arabicWords")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema arabicWordsSchema) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("ArabicWordsPort");
//        wsdl11Definition.setLocationUri("/soap");
//        wsdl11Definition.setTargetNamespace("http://yournamespace/yourproject");
//        wsdl11Definition.setSchema(arabicWordsSchema);
//        return wsdl11Definition;
//    }
//
//    @Bean
//    public XsdSchema arabicWordsSchema() {
//        // Define your XSD schema if needed
//        return new SimpleXsdSchema(new ClassPathResource("arabicWords.xsd"));
//    }
//}
//
