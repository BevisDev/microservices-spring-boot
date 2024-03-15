package com.rest.constant;

public class RegexConst {
    // ================== START DEFINE CONSTANT REGEX ================== //
    public static final String NUMBER = "[0-9]";
    public static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d$@$!%*?&]{8,}$";
    public static final String MOBILE_NUMBER_VN = "^(84|0)[1-9][0-9]{8}$";
    public static final String MOBILE_NUMBER_SG = "(^(658|659|6|8|9)\\d{7}$$)|(^(601|01|1)\\d{8,9}$$)";
    public static final String DATE_OF_BIRTH = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";

}
