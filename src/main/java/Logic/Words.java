package Logic;

import java.util.ArrayList;
import java.util.List;

public class Words {

    static final List<String> arabicOnes = new ArrayList<>();
    static final List<String> arabicFemOnes = new ArrayList<>();
    static final List<String> arabicTens = new ArrayList<>();
    static final List<String> arabicHundreds = new ArrayList<>();
    static final List<String> arabicTwos = new ArrayList<>();
    static final List<String> arabicAppendedTwos = new ArrayList<>();
    static final List<String> arabicGroup = new ArrayList<>();
    static final List<String> arabicAppendedGroup = new ArrayList<>();
    static final List<String> arabicPluralGroups = new ArrayList<>();

    static {
        arabicOnes.add("");
        arabicOnes.add("واحد");
        arabicOnes.add("اثنان");
        arabicOnes.add("ثلاثة");
        arabicOnes.add("أربعة");
        arabicOnes.add("خمسة");
        arabicOnes.add("ستة");
        arabicOnes.add("سبعة");
        arabicOnes.add("ثمانية");
        arabicOnes.add("تسعة");
        arabicOnes.add("عشرة");
        arabicOnes.add("أحد عشر");
        arabicOnes.add("اثنا عشر");
        arabicOnes.add("ثلاثة عشر");
        arabicOnes.add("أربعة عشر");
        arabicOnes.add("خمسة عشر");
        arabicOnes.add("ستة عشر");
        arabicOnes.add("سبعة عشر");
        arabicOnes.add("ثمانية عشر");
        arabicOnes.add("تسعة عشر");

        arabicFemOnes.add("");
        arabicFemOnes.add("إحدى");
        arabicFemOnes.add("اثنتان");
        arabicFemOnes.add("ثلاث");
        arabicFemOnes.add("أربع");
        arabicFemOnes.add("خمس");
        arabicFemOnes.add("ست");
        arabicFemOnes.add("سبع");
        arabicFemOnes.add("ثمان");
        arabicFemOnes.add("تسع");
        arabicFemOnes.add("عشر");
        arabicFemOnes.add("إحدى عشرة");
        arabicFemOnes.add("اثنتا عشرة");
        arabicFemOnes.add("ثلاث عشرة");
        arabicFemOnes.add("أربع عشرة");
        arabicFemOnes.add("خمس عشرة");
        arabicFemOnes.add("ست عشرة");
        arabicFemOnes.add("سبع عشرة");
        arabicFemOnes.add("ثماني عشرة");
        arabicFemOnes.add("تسع عشرة");

        arabicTens.add("عشرون");
        arabicTens.add("ثلاثون");
        arabicTens.add("أربعون");
        arabicTens.add("خمسون");
        arabicTens.add("ستون");
        arabicTens.add("سبعون");
        arabicTens.add("ثمانون");
        arabicTens.add("تسعون");

        arabicHundreds.add("");
        arabicHundreds.add("مائة");
        arabicHundreds.add("مئتان");
        arabicHundreds.add("ثلاثمائة");
        arabicHundreds.add("أربعمائة");
        arabicHundreds.add("خمسمائة");
        arabicHundreds.add("ستمائة");
        arabicHundreds.add("سبعمائة");
        arabicHundreds.add("ثمانمائة");
        arabicHundreds.add("تسعمائة");

        arabicTwos.add("مئتان");
        arabicTwos.add("ألفان");
        arabicTwos.add("مليونان");
        arabicTwos.add("ملياران");

        {
            arabicAppendedTwos.add("مئتا");
            arabicAppendedTwos.add("ألفا");
            arabicAppendedTwos.add("مليونا");
            arabicAppendedTwos.add("مليارا");
        }

        arabicGroup.add("مائة");
        arabicGroup.add("ألف");
        arabicGroup.add("مليون");
        arabicGroup.add("مليار");

        {
            arabicAppendedGroup.add("");
            arabicAppendedGroup.add("ألفاً");
            arabicAppendedGroup.add("مليوناً");
            arabicAppendedGroup.add("ملياراً");
        }

        arabicPluralGroups.add("");
        arabicPluralGroups.add("آلاف");
        arabicPluralGroups.add("ملايين");
        arabicPluralGroups.add("مليارات");
    }

}