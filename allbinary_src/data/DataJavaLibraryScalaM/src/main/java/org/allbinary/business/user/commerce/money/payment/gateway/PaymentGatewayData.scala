/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway


class PaymentGatewayData private(param_value : String) {
    import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.{CRYPTNUM as _, ID as _, NAME as _, VALUE as _, PAYMENTTRANSACTIONINTERFACEFACTORYINTERFACE as _, PAYMENTPROCESSORINTERFACEFACTORYINTERFACE as _, MODE as _, SERVERPROTOCOL as _, SERVER as _, SERVERPORT as _, SERVERPATH as _, TESTPROTOCOL as _, TESTSERVER as _, TESTPORT as _, TESTPATH as _, TIMEOUT as _, PROXYPROTOCOL as _, PROXYSERVER as _, PROXYPATH as _, PROXYUSERNAME as _, PROXYPASSWORD as _, PROXYPORT as _, PROXYTIMEOUT as _, SPECIAL1 as _, SPECIAL2 as _, SPECIAL3 as _, SPECIAL4 as _, SPECIAL5 as _, SPECIAL6 as _, SPECIAL7 as _, SPECIAL8 as _, SPECIAL9 as _, *}
    def CRYPTNUM : Int = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.CRYPTNUM
    def ID : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.ID
    def NAME : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.NAME
    def VALUE : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.VALUE
    def PAYMENTTRANSACTIONINTERFACEFACTORYINTERFACE : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PAYMENTTRANSACTIONINTERFACEFACTORYINTERFACE
    def PAYMENTPROCESSORINTERFACEFACTORYINTERFACE : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PAYMENTPROCESSORINTERFACEFACTORYINTERFACE
    def MODE : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.MODE
    def SERVERPROTOCOL : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SERVERPROTOCOL
    def SERVER : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SERVER
    def SERVERPORT : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SERVERPORT
    def SERVERPATH : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SERVERPATH
    def TESTPROTOCOL : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.TESTPROTOCOL
    def TESTSERVER : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.TESTSERVER
    def TESTPORT : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.TESTPORT
    def TESTPATH : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.TESTPATH
    def TIMEOUT : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.TIMEOUT
    def PROXYPROTOCOL : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYPROTOCOL
    def PROXYSERVER : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYSERVER
    def PROXYPATH : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYPATH
    def PROXYUSERNAME : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYUSERNAME
    def PROXYPASSWORD : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYPASSWORD
    def PROXYPORT : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYPORT
    def PROXYTIMEOUT : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.PROXYTIMEOUT
    def SPECIAL1 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL1
    def SPECIAL2 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL2
    def SPECIAL3 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL3
    def SPECIAL4 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL4
    def SPECIAL5 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL5
    def SPECIAL6 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL6
    def SPECIAL7 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL7
    def SPECIAL8 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL8
    def SPECIAL9 : PaymentGatewayData = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData.SPECIAL9

    private var key : String = null

    //Constructor
    {
        val value : String = param_value
        this.key = value
    }

    override def toString() : String = {
        return this.key
    }

}

object PaymentGatewayData {
    val CRYPTNUM : Int = 5

    val ID : PaymentGatewayData = new PaymentGatewayData("PAYMENTGATEWAY_ID")

    val NAME : PaymentGatewayData = new PaymentGatewayData("PAYMENTGATEWAY_NAME")

    val VALUE : PaymentGatewayData = new PaymentGatewayData("PAYMENTGATEWAY_VALUE")

    val PAYMENTTRANSACTIONINTERFACEFACTORYINTERFACE : PaymentGatewayData = new PaymentGatewayData("PAYMENTGATEWAY_PAYMENTTRANSACTIONINTERFACEFACTORYINTERFACE")

    val PAYMENTPROCESSORINTERFACEFACTORYINTERFACE : PaymentGatewayData = new PaymentGatewayData("PAYMENTGATEWAY_PAYMENTPROCESSORINTERFACEFACTORYINTERFACE")

    val MODE : PaymentGatewayData = new PaymentGatewayData("MODE")

    val SERVERPROTOCOL : PaymentGatewayData = new PaymentGatewayData("SERVERPROTOCOL")

    val SERVER : PaymentGatewayData = new PaymentGatewayData("SERVER")

    val SERVERPORT : PaymentGatewayData = new PaymentGatewayData("SERVERPORT")

    val SERVERPATH : PaymentGatewayData = new PaymentGatewayData("SERVERPATH")

    val TESTPROTOCOL : PaymentGatewayData = new PaymentGatewayData("TESTSERVERPROTOCOL")

    val TESTSERVER : PaymentGatewayData = new PaymentGatewayData("TESTSERVER")

    val TESTPORT : PaymentGatewayData = new PaymentGatewayData("TESTPORT")

    val TESTPATH : PaymentGatewayData = new PaymentGatewayData("TESTSERVERPATH")

    val TIMEOUT : PaymentGatewayData = new PaymentGatewayData("TIMEOUT")

    val PROXYPROTOCOL : PaymentGatewayData = new PaymentGatewayData("PROXYPROTOCOL")

    val PROXYSERVER : PaymentGatewayData = new PaymentGatewayData("PROXYSERVER")

    val PROXYPATH : PaymentGatewayData = new PaymentGatewayData("PROXYPATH")

    val PROXYUSERNAME : PaymentGatewayData = new PaymentGatewayData("PROXYUSERNAME")

    val PROXYPASSWORD : PaymentGatewayData = new PaymentGatewayData("PROXYPASSWORD")

    val PROXYPORT : PaymentGatewayData = new PaymentGatewayData("PROXYPORT")

    val PROXYTIMEOUT : PaymentGatewayData = new PaymentGatewayData("PROXYTIMEOUT")

    val SPECIAL1 : PaymentGatewayData = new PaymentGatewayData("SPECIAL1")

    val SPECIAL2 : PaymentGatewayData = new PaymentGatewayData("SPECIAL2")

    val SPECIAL3 : PaymentGatewayData = new PaymentGatewayData("SPECIAL3")

    val SPECIAL4 : PaymentGatewayData = new PaymentGatewayData("SPECIAL4")

    val SPECIAL5 : PaymentGatewayData = new PaymentGatewayData("SPECIAL5")

    val SPECIAL6 : PaymentGatewayData = new PaymentGatewayData("SPECIAL6")

    val SPECIAL7 : PaymentGatewayData = new PaymentGatewayData("SPECIAL7")

    val SPECIAL8 : PaymentGatewayData = new PaymentGatewayData("SPECIAL8")

    val SPECIAL9 : PaymentGatewayData = new PaymentGatewayData("SPECIAL9")

}


