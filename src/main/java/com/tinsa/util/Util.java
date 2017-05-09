package com.tinsa.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * Created by
 *
 * @author marinovilchez
 * @since 9/5/17
 */
public class Util {

    public static boolean checkPhone(final String telefono) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber
                spanishNumberProto = null;
        try {
            spanishNumberProto = phoneUtil.parse(telefono, "ES");
        } catch (NumberParseException e) {
            System.out.println("NumberParseException was thrown:  " + e.toString());
        }
        return (spanishNumberProto != null) && phoneUtil.isValidNumber(spanishNumberProto);
    }
}
