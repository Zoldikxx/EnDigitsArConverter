package Logic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static Logic.Words.*;

public class Converter {

    public static String numberToArabicWords(String n) {
        return numberToArabicWords(n, false);
    }

    public static String numberToArabicWords(String number, boolean isFeminine) {
        return numberToArabicWords(new BigDecimal(number), isFeminine);
    }

    public static String numberToArabicWords(BigDecimal number, boolean isFeminine) {
        return convertToArabic(number, isFeminine).trim();
    }

    private static String convertFractionalPart(BigDecimal fractionalPart) {
        StringBuilder fractionalResult = new StringBuilder();

        int tens = fractionalPart.multiply(BigDecimal.TEN).intValue();
        int ones = fractionalPart.movePointRight(2).remainder(BigDecimal.TEN).intValue();

        int onesLessTwen = fractionalPart.multiply(new BigDecimal("100")).intValue();

        if (tens >= 2) {
            int tensMod = tens- 2;
            fractionalResult.append(" و ").append(arabicTens.get(tensMod)).append(" ");
        }

        if (ones > 0 && tens >= 2) {
            fractionalResult.insert(0, " و " + arabicOnes.get(ones));
        }

        if (ones > 0 && tens == 1){
            fractionalResult.insert(0, " و " + arabicOnes.get(onesLessTwen) + " ");
        }

        return fractionalResult.toString();
    }

    static String convertToArabic(BigDecimal number, boolean isFeminine) {
        if (number.equals(BigDecimal.ZERO)) {
            return "صفر";
        }

        BigDecimal fractionalPart = number.remainder(BigDecimal.ONE);

        String fractionResult = convertFractionalPart(fractionalPart);

        BigDecimal tempNumber = number;

        tempNumber = tempNumber.subtract(fractionalPart);

        StringBuilder result = new StringBuilder();
        short group = 0;

        while (tempNumber.compareTo(BigDecimal.ONE) >= 0) {

            // separate number into groups
            BigDecimal numberToProcess = tempNumber.remainder(new BigDecimal("1000"));

            tempNumber = tempNumber.divide(new BigDecimal("1000"));

            // convert group into its text
            final int tempValue = tempNumber.setScale(0, RoundingMode.FLOOR).intValue();
            String groupDescription = processArabicGroup(numberToProcess.intValue(), group, tempValue, isFeminine);

            if (!groupDescription.isEmpty()) { // here we add the new converted group to the previous concatenated text
                if (group > 0) {
                    if (result.length() > 0) {
                        result.insert(0, "و" + " ");
                    }
                    if (numberToProcess.compareTo(new BigDecimal(2)) != 0) {
                        if (numberToProcess.remainder(new BigDecimal("100")).compareTo(BigDecimal.ONE) != 0) {
                            if (numberToProcess.compareTo(new BigDecimal("3")) >= 0 && numberToProcess.compareTo(new BigDecimal("10")) <= 0) { // for numbers between 3 and 9 we use plural name
                                result.insert(0, arabicPluralGroups.get(group) + " ");
                            } else {
                                if (result.length() > 0) { // use appending case
                                    result.insert(0, arabicAppendedGroup.get(group) + " ");
                                } else {
                                    result.insert(0, arabicGroup.get(group) + " "); // use normal case
                                }
                            }
                        }
                    }
                }
                result.insert(0, groupDescription + " ");

            }

            group++;
        }
        if (result != null && !result.isEmpty()) {
            result.append("جنيها");
            result.append(" مصريا");
        }
        result.append(fractionResult);
        if (fractionResult != null && !fractionResult.isEmpty()) {
            result.append("قرشا");
        }
        result.append(" فقط لاغير");

        return ((result.length() > 0) ? result.toString() : "");
    }


    private static String processArabicGroup(int groupNumber, int groupLevel, int remainingNumber, boolean isFeminine) {
        int tens = groupNumber % 100;

        int hundreds = groupNumber / 100;

        String result = "";

        if (hundreds > 0) {
            if (tens == 0 && hundreds == 2) { // حالة المضاف
                if (groupLevel == 0) {
                    result = arabicHundreds.get(hundreds);
                } else {
                    result = arabicAppendedTwos.get(0);
                }
            } else { //  الحالة العادية
                result = arabicHundreds.get(hundreds);
            }
        }

        if (tens > 0) {
            if (tens < 20) { // if we are processing under 20 numbers
                if (tens == 2 && hundreds == 0 && groupLevel > 0) { // This is special case for number 2 when it comes alone in the group
                    result = arabicTwos.get(groupLevel);//  في حالة الافراد
                } else { // General case
                    if (!result.isEmpty())
                        result += " و";

                    if (tens == 1 && groupLevel > 0)
                        result += arabicGroup.get(groupLevel);
                    else if ((tens == 1 || tens == 2)
                            && (groupLevel == 0 || groupLevel == -1)
                            && hundreds == 0
                            && remainingNumber == 0)
                        result += ""; // Special case for 1 and 2 numbers
                    else
                        result += getDigitFeminineStatus(tens, groupLevel, isFeminine);// Get Feminine status for this digit
                }
            } else {
                int ones = tens % 10;
                tens = (tens / 10) - 2; // 20's offset

                if (ones > 0) {
                    if (!result.isEmpty())
                        result += " و";

                    // Get Feminine status for this digit
                    result += getDigitFeminineStatus(ones, groupLevel, isFeminine);
                }

                if (!result.isEmpty())
                    result += " و";

                // Get Tens text
                result += arabicTens.get(tens);
            }
        }

        return result;
    }

    private static String getDigitFeminineStatus(int digit, int groupLevel, boolean isFeminine) {
        if (groupLevel == -1 || groupLevel == 0) {
            if (!isFeminine) {
                return arabicOnes.get(digit);
            }
            return arabicFemOnes.get(digit);
        }
        return arabicOnes.get(digit);
    }

}