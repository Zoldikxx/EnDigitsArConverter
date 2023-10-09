package org.EnArCov;

import Logic.Converter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @PostMapping("/convertToArabicWords")
    public String convertToArabicWords(@RequestBody ConverterRequest request) {
        return Converter.numberToArabicWords(request.getNumber(), request.isFeminine());
    }
}
