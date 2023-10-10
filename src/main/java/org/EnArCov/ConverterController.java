package org.EnArCov;

import Logic.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ConverterController {

    @PostMapping("/convertToArabicWords")
    public ResponseEntity<String> convertToArabicWords(@RequestBody ConverterRequest request) {
        String number = request.getNumber();

        if (number == null) {
            return new ResponseEntity<>("The number is missing", HttpStatus.BAD_REQUEST);
        }

        if (!isNumeric(number)) {
            return new ResponseEntity<>("Invalid number format", HttpStatus.BAD_REQUEST);
        }

        String result = Converter.numberToArabicWords(new BigDecimal(number), request.isFeminine());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
