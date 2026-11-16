/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewaysData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

/**  *  * @author user  */
class PaymentTypeUtil private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.PaymentTypeUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var PAYMENTGATEWAYFILEPATHSTRING : String = null

    private val SHIPPINGMETHODSFILENAME : String = "paymentGatewayTypes.xml"

    private var defaultName : String = null

    private var paymentTypeVector : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val stringBuffer : StringMaker = new StringMaker()
        val sep : String = AbPathData.getInstance().SEPARATOR
        stringBuffer.append(sep)
        stringBuffer.append("generic")
        stringBuffer.append(sep)
        stringBuffer.append("user")
        stringBuffer.append(sep)
        stringBuffer.append("commerce")
        stringBuffer.append(sep)
        stringBuffer.append("money")
        stringBuffer.append(sep)
        stringBuffer.append("payment")
        stringBuffer.append(sep)
        stringBuffer.append("gateway")
        stringBuffer.append(sep)
        this.PAYMENTGATEWAYFILEPATHSTRING = stringBuffer.toString()
    }

    def add(paymentType : PaymentType) : Unit = {
        this.paymentTypeVector.add(paymentType)
    }

    def get(paymentTypeString : String) : PaymentType = {
        var size : Int = this.paymentTypeVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var paymentType : PaymentType = this.paymentTypeVector.get(i).asInstanceOf[PaymentType]
                if (paymentType.getBasicPaymentType().getName().compareTo(paymentTypeString) == 0) {
                    return paymentType
                }
                i += 1
            }
        }
        throw new Exception("Unknown PaymentType: " + paymentTypeString)
    }

    def initDefault(storeName : String) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
            this.logUtil.putF("initDefault Payment: " + this.defaultName, this, "initDefault")
        }
        if (StringValidationUtil.getInstance().isEmpty(this.defaultName)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getMainPath())
            stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
            stringBuffer.append(storeName)
            stringBuffer.append(AbPathData.getInstance().SEPARATOR)
            stringBuffer.append(this.PAYMENTGATEWAYFILEPATHSTRING)
            var abPath : AbPath = (new AbPath(stringBuffer.toString(), this.SHIPPINGMETHODSFILENAME)).asInstanceOf[AbPath]
            var data : String = new CryptFileReader(TransformInfoObjectConfigData.getInstance().UNCRYPTED_EXTENSION, TransformInfoObjectConfigData.getInstance().ENCRYPTED_EXTENSION).get(abPath)
            var document : Document = DomDocumentHelper.create(data)
            var nodeList : NodeList = document.getElementsByTagName(PaymentGatewaysData.NAME)

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var node : Node = nodeList.item(index)
                    /*             NodeList paymentGatewayNodeList = node.getChildNodes();              Node paymentGatewayNode =                DomSearchHelper.getNode(PaymentGatewayData.NAME.toString(), paymentGatewayNodeList);              Node paymentGatewayNodeName =                DomSearchHelper.getNode(PaymentGatewayData.NAME.toString(), paymentGatewayNode.getChildNodes());              String paymentGatewayNodeNameValue =                DomNodeHelper.getTextNodeValue(paymentGatewayNodeName);              */
                    var defaultPaymentGatewayNode : Node = DomSearchHelper.getNode(EntryData.getInstance().DEFAULT, node.getChildNodes())
                    //paymentGatewayNode.getChildNodes()
                    var defaultPaymentGatewayNodeValue : String = DomNodeHelper.getTextNodeValue(defaultPaymentGatewayNode)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
                        this.logUtil.putF("DefaultPaymentGatewayNodeValue: " + defaultPaymentGatewayNodeValue, this, "initDefault")
                    }
                    if (!StringValidationUtil.getInstance().isEmpty(defaultPaymentGatewayNodeValue)) {
                        this.defaultName = defaultPaymentGatewayNodeValue
                    }
                    index += 1
                }
            }
        }
    }

    def getDefault(storeName : String) : PaymentType = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
            this.logUtil.putF(this.commonStrings.START, this, "getDefault")
        }
        this.initDefault(storeName)
        if (!StringValidationUtil.getInstance().isEmpty(this.defaultName)) {
            return this.get(this.defaultName)
        }
        throw new Exception("No Default: " + this.defaultName)
    }

    def isContain(paymentType : PaymentType) : Boolean = {
        return this.paymentTypeVector.contains(paymentType)
    }

    def difference(a_PaymentTypeVector : BasicArrayList) : BasicArrayList = {
        var diff : BasicArrayList = new BasicArrayListD()
        var size : Int = this.paymentTypeVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var paymentType : PaymentType = this.paymentTypeVector.get(i).asInstanceOf[PaymentType]
                if (!a_PaymentTypeVector.contains(paymentType)) {
                    diff.add(paymentType)
                }
                i += 1
            }
        }
        return diff
    }

}

object PaymentTypeUtil {
    private val instance : PaymentTypeUtil = new PaymentTypeUtil()

    {
    }

    /**      * @return the instance      */
    def getInstance() : PaymentTypeUtil = {
        return PaymentTypeUtil.instance
    }

}


