/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim


/**  *  * @author tberthel  */
class AuthorizeNetAimData private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.{X_DELIM_DATA as _, X_DELIM_CHAR as _, X_ENCAP_CHAR as _, X_AUTHENTICATION_INDICATOR as _, X_CARDHOLDER_AUTHENTICATION_VALUE as _, X_DRIVERS_LICENSE_NUM as _, X_DRIVERS_LICENSE_STATE as _, X_DRIVERS_LICENSE_DOB as _, *}
    def X_DELIM_DATA : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_DELIM_DATA
    def X_DELIM_CHAR : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_DELIM_CHAR
    def X_ENCAP_CHAR : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_ENCAP_CHAR
    def X_AUTHENTICATION_INDICATOR : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_AUTHENTICATION_INDICATOR
    def X_CARDHOLDER_AUTHENTICATION_VALUE : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_CARDHOLDER_AUTHENTICATION_VALUE
    def X_DRIVERS_LICENSE_NUM : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_DRIVERS_LICENSE_NUM
    def X_DRIVERS_LICENSE_STATE : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_DRIVERS_LICENSE_STATE
    def X_DRIVERS_LICENSE_DOB : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.processor.authorizenet.aim.AuthorizeNetAimData.X_DRIVERS_LICENSE_DOB

}

object AuthorizeNetAimData {
    //5
    val X_DELIM_DATA : String = "x_delim_data"

    //1
    val X_DELIM_CHAR : String = "x_delim_char"

    //1
    val X_ENCAP_CHAR : String = "x_encap_char"

    //For FDC Nashville and Vital
    val X_AUTHENTICATION_INDICATOR : String = "x_authentication_indicator"

    //Unk len - Required for AUTH_ONLY and AUTH_CAPTURE
    val X_CARDHOLDER_AUTHENTICATION_VALUE : String = "x_cardholder_authentication_value"

    //i.e. for all echecks that don't provide the customer_tax_id
    val X_DRIVERS_LICENSE_NUM : String = "x_drivers_license_num"

    //2 -
    val X_DRIVERS_LICENSE_STATE : String = "x_drivers_license_state"

    //unk len - format: YYYY-MM-DDD, YYYY/M/DD, MM/DD/YYYY, MM-DD-YYYY
    val X_DRIVERS_LICENSE_DOB : String = "x_drivers_license_dob"

}


