package com.sumanth.algos;
/*
Usually when you buy something, you're asked whether your credit card number, phone number or answer to
your most secret question is still correct. However, since someone could look over your shoulder,
you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function maskify, which will:
    Mask all digits (0-9) with #, unless they are first or last four characters.
    Never mask credit cards with less than 6 characters.
    Never mask non-digit characters.

Examples
Input 	Output 	Comments
"4556364607935616" 	"4###########5616"
"4556-3646-0793-5616" 	"4###-####-####-5616"
"64607935616" 	"6######5616"
ABCD-EFGH-IJKLM-NOPQ 	ABCD-EFGH-IJKLM-NOPQ
A1234567BCDEFG89HI 	A#######BCDEFG89HI
"12345" 	"12345" 	No #s if less than 6 characters
"" 	"" 	Make sure to handle empty strings
"Skippy" 	"Skippy"
 */
public class MaskString {
    private static final int MIN_NONMASKING_LENGTH = 6;
    private static final int NONMASKING_START_POSITION = 0;
    private static final int MASKING_START_POSITION = 1;
    private static final int NONMASKING_END_POSITION = 4;

    public static void maskifyMethod() {
        // test input
        String creditCardNumber="4556364607935616";
        System.out.println(maskify(creditCardNumber));
    }

    // Main call to mask a string
    private static String maskify(String creditCardNumber) {

        // handle empty strings
        if(creditCardNumber.length()!=0){
            if(creditCardNumber.length()<MIN_NONMASKING_LENGTH){
                // Never mask credit cards with less than 6 characters.
                return creditCardNumber;
            }else{
                // Mask all digits (0-9) with #, unless they are first or last four characters.
                String maskableString=creditCardNumber.substring(MASKING_START_POSITION,creditCardNumber.length()-NONMASKING_END_POSITION);
                String maskedString=buildMaskableString(maskableString);
                return creditCardNumber.charAt(NONMASKING_START_POSITION)+
                        maskedString+
                        creditCardNumber.substring(creditCardNumber.length()-NONMASKING_END_POSITION,creditCardNumber.length());
            }
        }
        return "";
    }

    // build maskable string depending on presence of digits
    private static String buildMaskableString(String maskableString) {
        char[] maskableArray = maskableString.toCharArray();
        StringBuffer strBuff=new StringBuffer();
        for (char ch: maskableArray) {
            // Never mask non-digit characters.
            Character res=(Character.isDigit(ch))?'#':ch;
            strBuff.append(res);
        }
        return strBuff.toString();
    }
}
