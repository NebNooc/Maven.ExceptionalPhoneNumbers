package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] listOfNums = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < phoneNumberCount; i++){
            listOfNums[i] = createRandomPhoneNumber();
        }
        return listOfNums;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        Integer threeDigit = RandomNumberFactory.createInteger(100, 999);
        Integer fourDigit = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(threeDigit, threeDigit, fourDigit);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {

        PhoneNumber num;

        try {

            num = createPhoneNumber("(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode);
            return num;

        } catch(InvalidPhoneNumberFormatException e) {
            Logger.getLogger("What is the problem?");
        }
        return null;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString)throws InvalidPhoneNumberFormatException {
        Logger.getLogger("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        return new PhoneNumber(phoneNumberString);
    }
}
