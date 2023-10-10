//package org.EnArCov;
//
//import Logic.Converter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation;
//
//@Endpoint
//public class ArabicWordsEndpoint {
//
//    private static final String NAMESPACE_URI = "http://yournamespace/yourproject";
//
//    private Converter converter;
//
//    @Autowired
//    public ArabicWordsEndpoint(Converter converter) {
//        this.converter = converter;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "arabicWordsRequest")
//    @ResponsePayload
//    public ArabicWordsResponse getArabicWords(@RequestPayload ArabicWordsRequest request) {
//        ArabicWordsResponse response = new ArabicWordsResponse();
//        response.setResult(converter.numberToArabicWords(request.getNumber()));
//        return response;
//    }
//}
