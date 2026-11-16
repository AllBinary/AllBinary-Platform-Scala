/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.tax.modules

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.business.user.commerce.money.tax.components.TaxData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigData
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class SimpleStateTaxModule() extends TaxModuleInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var streetAddress : StreetAddress = null

    private var storeFrontInterface : StoreFrontInterface = null

    private val ALL : String = CommonPhoneStrings.getInstance().STAR

    private val STATETAXPATH : String = "/generic/taxes/"

    private val STATETAXFILE : String = "stateTaxation.xml"

    private var document : Document = null

    /*    public Float getTaxRate()    {       String state = this.streetAddress.getState();       String country = this.streetAddress.getCountry();            state = state.toUpperCase();       if(country.compareTo("USA")==0 &&          (state.compareTo("TX")==0 || state.compareTo("TEXAS")==0))       {          return new Float(.0825);       }       else return new Float(0);    }     */
    def getTaxRate(streetAddress : StreetAddress, storeFrontInterface : StoreFrontInterface) : _root_.java.lang.Float = {
        this.streetAddress = streetAddress
        this.storeFrontInterface = storeFrontInterface
        var fileAbPath : AbPath = new AbPath(((URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH) + this.storeFrontInterface.getName()) + this.STATETAXPATH, this.STATETAXFILE)
        var data : String = new CryptFileReader(TransformInfoObjectConfigData.getInstance().UNCRYPTED_EXTENSION, TransformInfoObjectConfigData.getInstance().ENCRYPTED_EXTENSION).get(fileAbPath)
        this.document = DomDocumentHelper.create(data)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAX)) {
            this.logUtil.putF("Tax Doc: " + XmlDocumentHelper.toString(this.document), this, "getTaxRate")
        }
        var state : String = this.streetAddress.getState()
        var country : String = this.streetAddress.getCountry()
        state = state.toUpperCase()
        var nodeList : NodeList = this.document.getElementsByTagName(TaxData.NAME)

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var node : Node = nodeList.item(index)
                var taxNodeChildren : NodeList = node.getChildNodes()
                var streetAddressNode : Node = DomSearchHelper.getNode(StreetAddressData.NAME, taxNodeChildren)
                var taxableStreetAddress : StreetAddress = new StreetAddress(streetAddressNode)
                var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
                if ((!stringValidationUtil.isEmpty(country) && !stringValidationUtil.isEmpty(taxableStreetAddress.getCountry())) && (country.compareTo(taxableStreetAddress.getCountry()) == 0)) {
                    if (((state != null) && (taxableStreetAddress.getState() != null)) && (state.compareTo(taxableStreetAddress.getState()) == 0)) {
                        var rateNode : Node = DomSearchHelper.getNode(TaxData.RATE, taxNodeChildren)
                        var taxRate : String = DomNodeHelper.getTextNodeValue(rateNode)
                        var taxRateFloat : _root_.java.lang.Float = new _root_.java.lang.Float(new _root_.java.lang.Float(taxRate).floatValue() * 0.01)
                        return taxRateFloat
                    }
                }
                index += 1
            }
        }
        return new _root_.java.lang.Float(0)
    }

    def isValid(streetAddress : StreetAddress, storeFrontInterface : StoreFrontInterface) : _root_.java.lang.Boolean = {
        try {
            this.streetAddress = streetAddress
            this.storeFrontInterface = storeFrontInterface
            var fileAbPath : AbPath = new AbPath(((URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH) + this.storeFrontInterface.getName()) + this.STATETAXPATH, this.STATETAXFILE)
            var data : String = new CryptFileReader(TransformInfoObjectConfigData.getInstance().UNCRYPTED_EXTENSION, TransformInfoObjectConfigData.getInstance().ENCRYPTED_EXTENSION).get(fileAbPath)
            this.document = DomDocumentHelper.create(data)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAX)) {
                this.logUtil.putF("Tax Doc: " + XmlDocumentHelper.toString(this.document), this, this.commonStrings.IS_VALID)
            }
            var country : String = this.streetAddress.getCountry()
            var rootNode : Node = this.document.getElementsByTagName(TransformInfoObjectConfigData.getInstance().NAME).item(0)
            //rootNode.getChildNodes();
            var nodeList : NodeList = this.document.getElementsByTagName(TaxData.NAME)
            /*       if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAX))       {          this.logUtil.putF("Number Of Tax Nodes: " + nodeList.getLength(), this, this.commonStrings.IS_VALID);       }       */

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var node : Node = nodeList.item(index)
                    /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAX))          {             this.logUtil.putF("Node: " + node.getNodeName(), this, this.commonStrings.IS_VALID);          }          */
                    var taxNodeChildren : NodeList = node.getChildNodes()
                    /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAX))          {             this.logUtil.putF("Number Of Tax Child Nodes: " + taxNodeChildren.getLength(), this, this.commonStrings.IS_VALID);          }          */
                    var streetAddressNode : Node = DomSearchHelper.getNode(StreetAddressData.NAME, taxNodeChildren)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAX)) {
                        val stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append("StreetAddress Node: ")
                        stringBuffer.append(streetAddressNode.getNodeName())
                        stringBuffer.append(" Value: ")
                        stringBuffer.append(streetAddressNode.getNodeValue())
                        stringBuffer.append(" Number Of Children: ")
                        stringBuffer.appendint(streetAddressNode.getChildNodes().getLength())
                        this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                    }
                    var taxableStreetAddress : StreetAddress = new StreetAddress(streetAddressNode)
                    var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
                    if ((!stringValidationUtil.isEmpty(country) && !stringValidationUtil.isEmpty(taxableStreetAddress.getCountry())) && (taxableStreetAddress.getCountry().compareTo(this.ALL) == 0)) {
                        return _root_.java.lang.Boolean.TRUE
                    }
                    if ((!stringValidationUtil.isEmpty(country) && !stringValidationUtil.isEmpty(taxableStreetAddress.getCountry())) && (country.compareTo(taxableStreetAddress.getCountry()) == 0)) {
                        var state : String = this.streetAddress.getState()
                        if (state != null) {
                            return _root_.java.lang.Boolean.TRUE
                        }
                    }
                    index += 1
                }
            }
            return _root_.java.lang.Boolean.FALSE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

}


