/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user


class UserData private() {
    import _root_.org.allbinary.business.user.UserData.{NAME as _, USERNAME as _, PASSWORD as _, PREFIXNAME as _, FIRSTNAME as _, LASTNAME as _, MIDDLENAME as _, SUFFIXNAME as _, COMPANY as _, POSITIONATCOMPANY as _, MAINEMAIL as _, SECONDARYEMAIL as _, HOMEPHONE as _, CELLPHONE as _, WORKPHONE as _, OTHERCONTACT as _, ELECTRONICDEVICE as _, FAX as _, SECRET as _, PERMISSIONS as _, CONFIGURATION as _, *}
    def NAME : String = _root_.org.allbinary.business.user.UserData.NAME
    def USERNAME : String = _root_.org.allbinary.business.user.UserData.USERNAME
    def PASSWORD : String = _root_.org.allbinary.business.user.UserData.PASSWORD
    def PREFIXNAME : String = _root_.org.allbinary.business.user.UserData.PREFIXNAME
    def FIRSTNAME : String = _root_.org.allbinary.business.user.UserData.FIRSTNAME
    def LASTNAME : String = _root_.org.allbinary.business.user.UserData.LASTNAME
    def MIDDLENAME : String = _root_.org.allbinary.business.user.UserData.MIDDLENAME
    def SUFFIXNAME : String = _root_.org.allbinary.business.user.UserData.SUFFIXNAME
    def COMPANY : String = _root_.org.allbinary.business.user.UserData.COMPANY
    def POSITIONATCOMPANY : String = _root_.org.allbinary.business.user.UserData.POSITIONATCOMPANY
    def MAINEMAIL : String = _root_.org.allbinary.business.user.UserData.MAINEMAIL
    def SECONDARYEMAIL : String = _root_.org.allbinary.business.user.UserData.SECONDARYEMAIL
    def HOMEPHONE : String = _root_.org.allbinary.business.user.UserData.HOMEPHONE
    def CELLPHONE : String = _root_.org.allbinary.business.user.UserData.CELLPHONE
    def WORKPHONE : String = _root_.org.allbinary.business.user.UserData.WORKPHONE
    def OTHERCONTACT : String = _root_.org.allbinary.business.user.UserData.OTHERCONTACT
    def ELECTRONICDEVICE : String = _root_.org.allbinary.business.user.UserData.ELECTRONICDEVICE
    def FAX : String = _root_.org.allbinary.business.user.UserData.FAX
    def SECRET : String = _root_.org.allbinary.business.user.UserData.SECRET
    def PERMISSIONS : String = _root_.org.allbinary.business.user.UserData.PERMISSIONS
    def CONFIGURATION : String = _root_.org.allbinary.business.user.UserData.CONFIGURATION

}

object UserData {
    var MAXLEN : Int = 250

    //public static final String CUSTOMERS = "CUSTOMERS";
    val NAME : String = "USER_NAME"

    //user variables
    val USERNAME : String = "CUSTOMER_USER_NAME"

    val PASSWORD : String = "CUSTOMER_PASSWORD"

    val PREFIXNAME : String = "CUSTOMER_PREFIX_NAME"

    val FIRSTNAME : String = "CUSTOMER_FIRST_NAME"

    val LASTNAME : String = "CUSTOMER_LAST_NAME"

    val MIDDLENAME : String = "CUSTOMER_MIDDLE_NAME"

    val SUFFIXNAME : String = "CUSTOMER_SUFFIX_NAME"

    val COMPANY : String = "CUSTOMER_COMPANY"

    val POSITIONATCOMPANY : String = "CUSTOMER_POSITION_AT_COMPANY"

    val MAINEMAIL : String = "CUSTOMER_MAIN_EMAIL"

    val SECONDARYEMAIL : String = "CUSTOMER_SECONDARY_EMAIL"

    val HOMEPHONE : String = "CUSTOMER_HOME_PHONE"

    val CELLPHONE : String = "CUSTOMER_CELL_PHONE"

    val WORKPHONE : String = "CUSTOMER_WORK_PHONE"

    val OTHERCONTACT : String = "CUSTOMER_OTHER_CONTACT"

    val ELECTRONICDEVICE : String = "CUSTOMER_ELECTRONIC_DEVICE"

    val FAX : String = "CUSTOMER_FAX"

    val SECRET : String = "CUSTOMER_SECRET"

    val PERMISSIONS : String = "CUSTOMER_PERMISSIONS"

    //For rarely used data - should not be loaded for most user business objects in future orm imp
    val CONFIGURATION : String = "CUSTOMER_CONFIGURATION"

}


