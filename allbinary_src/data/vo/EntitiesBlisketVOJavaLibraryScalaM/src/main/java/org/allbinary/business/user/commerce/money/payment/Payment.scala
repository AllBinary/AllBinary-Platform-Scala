/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment

import _root_.java.util.HashMap
import _root_.javax.servlet.ServletRequest
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class Payment() extends PaymentInterface with DomNodeInterface {

    private var name : String = null

    private var expiration : String = null

    private var encryption : String = null

    private var number : String = null

    private var id : String = null

    private var `type` : String = null

    private var tenderType : String = null

    private var transactionType : String = null

    private var aba : String = null

    private var account : String = null

    private var accountType : String = null

    private var authorizationCode : String = null

    private var checkNumber : String = null

    private var checkType : String = null

    private var driversLicense : String = null

    private var magneticInkCheckReader : String = null

    private var isDefault_Payment : Boolean = false

    def this(payment : HashMap[Object, Object]) = {
        this()
        this.name = payment.get(PaymentData.NAME).asInstanceOf[String]
        this.`type` = payment.get(PaymentData.TYPE).asInstanceOf[String]
        this.expiration = payment.get(PaymentData.EXPIRATION).asInstanceOf[String]
        this.encryption = payment.get(EntryData.getInstance().ENCRYPTION).asInstanceOf[String]
        this.number = new SuperCrypt(new Integer(this.encryption).intValue()).decrypt(payment.get(PaymentData.NUMBER).asInstanceOf[String]).asInstanceOf[String]
        this.id = payment.get(PaymentData.ID).asInstanceOf[String]
        var `def` : String = payment.get(EntryData.getInstance().DEFAULT).asInstanceOf[String]
        if ((`def` != null) && (`def`.compareTo(EntryData.getInstance().DEFAULT) == 0)) {
            this.isDefault_Payment = true
        } else {
            this.isDefault_Payment = false
        }
        this.tenderType = payment.get(PaymentData.TENDERTYPE).asInstanceOf[String]
        this.transactionType = payment.get(PaymentData.TRANSACTIONTYPE).asInstanceOf[String]
        this.aba = payment.get(PaymentData.ABA).asInstanceOf[String]
        this.account = payment.get(PaymentData.ACCOUNT).asInstanceOf[String]
        this.accountType = payment.get(PaymentData.ACCOUNTTYPE).asInstanceOf[String]
        this.authorizationCode = payment.get(PaymentData.AUTHORIZATIONCODE).asInstanceOf[String]
        this.checkNumber = payment.get(PaymentData.CHECKNUMBER).asInstanceOf[String]
        this.checkType = payment.get(PaymentData.CHECKTYPE).asInstanceOf[String]
        this.driversLicense = payment.get(PaymentData.DRIVERSLICENSE).asInstanceOf[String]
        this.magneticInkCheckReader = payment.get(PaymentData.MAGNETICINKCHECKREADER).asInstanceOf[String]
    }

    def this(request : ServletRequest) = {
        this()
        this.name = request.getParameter(PaymentData.NAME)
        this.`type` = request.getParameter(PaymentData.TYPE)
        this.expiration = request.getParameter(PaymentData.EXPIRATION)
        this.number = request.getParameter(PaymentData.NUMBER)
        this.tenderType = request.getParameter(PaymentData.TENDERTYPE)
        this.transactionType = request.getParameter(PaymentData.TRANSACTIONTYPE)
        this.aba = request.getParameter(PaymentData.ABA)
        this.account = request.getParameter(PaymentData.ACCOUNT)
        this.accountType = request.getParameter(PaymentData.ACCOUNTTYPE)
        this.authorizationCode = request.getParameter(PaymentData.AUTHORIZATIONCODE)
        this.checkNumber = request.getParameter(PaymentData.CHECKNUMBER)
        this.checkType = request.getParameter(PaymentData.CHECKTYPE)
        this.driversLicense = request.getParameter(PaymentData.DRIVERSLICENSE)
        this.magneticInkCheckReader = request.getParameter(PaymentData.MAGNETICINKCHECKREADER)
    }

    def isValid() : _root_.java.lang.Boolean = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        var aFalse : _root_.java.lang.Boolean = _root_.java.lang.Boolean.FALSE
        if ((this.name == null) || (this.name.compareTo(stringUtil.EMPTY_STRING) == 0)) {
            return aFalse
        }
        if ((this.`type` == null) || (this.`type`.compareTo(stringUtil.EMPTY_STRING) == 0)) {
            return aFalse
        }
        if ((this.expiration == null) || (this.expiration.compareTo(stringUtil.EMPTY_STRING) == 0)) {
            return aFalse
        }
        if ((this.number == null) || (this.number.compareTo(stringUtil.EMPTY_STRING) == 0)) {
            return aFalse
        }
        if (this.number.length() > _root_.org.allbinary.business.user.commerce.money.payment.types.CreditCardType.MAXLEN) {
            return aFalse
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def setTenderType(value : String) : Unit = {
        this.tenderType = value
    }

    def setTransactionType(value : String) : Unit = {
        this.transactionType = value
    }

    def setAuthorizationCode(value : String) : Unit = {
        this.authorizationCode = value
    }

    def setCheckType(value : String) : Unit = {
        this.checkType = value
    }

    //
    def setCheckNumber(value : String) : Unit = {
        this.checkNumber = value
    }

    def setDriversLicense(value : String) : Unit = {
        this.driversLicense = value
    }

    def setMagneticInkCheckReader(value : String) : Unit = {
        this.magneticInkCheckReader = value
    }

    def setAba(value : String) : Unit = {
        this.aba = value
    }

    def setAccountType(value : String) : Unit = {
        this.accountType = value
    }

    //
    def setName(value : String) : Unit = {
        this.name = value
    }

    def setType(value : String) : Unit = {
        this.`type` = value
    }

    def setExpiration(value : String) : Unit = {
        this.expiration = value
    }

    def setNumber(value : String) : Unit = {
        this.number = value
    }

    def getId() : String = {
        return this.id
    }

    def getName() : String = {
        return this.name
    }

    def getType() : String = {
        return this.`type`
    }

    def getExpiration() : String = {
        return this.expiration
    }

    def getEncryption() : String = {
        return this.encryption
    }

    def getNumber() : String = {
        return this.number
    }

    def getTenderType() : String = {
        return this.tenderType
    }

    def getTransactionType() : String = {
        return this.transactionType
    }

    def getAba() : String = {
        return this.aba
    }

    def getAccount() : String = {
        return this.account
    }

    def getAccountType() : String = {
        return this.accountType
    }

    def getAuthorizationCode() : String = {
        return this.authorizationCode
    }

    def getCheckNumber() : String = {
        return this.checkNumber
    }

    def getCheckType() : String = {
        return this.checkType
    }

    def getDriversLicense() : String = {
        return this.driversLicense
    }

    def getMagneticInkCheckReader() : String = {
        return this.magneticInkCheckReader
    }

    def getLastFour() : String = {
        if ((this.number.length() > PaymentData.MIN) && (this.number.length() <= PaymentData.MAX)) {
            return this.number.substring(this.number.length() - 4)
        } else {
            return "Invalid #"
        }
        throw new IllegalStateException()
    }

    def isDefault() : Boolean = {
        return this.isDefault_Payment
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(PaymentData.NAME, this.name)
        hashMap.put(PaymentData.TYPE, this.`type`)
        hashMap.put(PaymentData.EXPIRATION, this.expiration)
        hashMap.put(PaymentData.NUMBER, this.getLastFour())
        hashMap.put(PaymentData.TENDERTYPE, this.tenderType)
        hashMap.put(PaymentData.TRANSACTIONTYPE, this.transactionType)
        hashMap.put(PaymentData.ABA, this.aba)
        hashMap.put(PaymentData.ACCOUNT, this.account)
        hashMap.put(PaymentData.ACCOUNTTYPE, this.accountType)
        hashMap.put(PaymentData.AUTHORIZATIONCODE, this.authorizationCode)
        hashMap.put(PaymentData.CHECKNUMBER, this.checkNumber)
        hashMap.put(PaymentData.DRIVERSLICENSE, this.driversLicense)
        hashMap.put(PaymentData.MAGNETICINKCHECKREADER, this.magneticInkCheckReader)
        if (this.isDefault_Payment) {
            hashMap.put(EntryData.getInstance().DEFAULT, EntryData.getInstance().DEFAULT)
        } else {
            hashMap.put(EntryData.getInstance().DEFAULT, StringUtil.getInstance().EMPTY_STRING)
        }
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNameValueNodes(document, PaymentData.PAYMENT, hashMap)
        return node
    }

    def toXmlDoc() : Document = {
        return null
    }

    def view() : String = {
        return null
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def validationInfo() : String = {
        return null
    }

}


