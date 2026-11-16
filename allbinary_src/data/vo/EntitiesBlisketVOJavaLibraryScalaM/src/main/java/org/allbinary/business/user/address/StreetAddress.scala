/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.address

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StreetAddress() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var id : String = null

    private var name : String = null

    private var street : String = null

    private var city : String = null

    private var state : String = null

    private var code : String = null

    private var country : String = null

    private var isDefault_StreetAddress : Boolean = false

    def this(name : String, street : String, city : String, state : String, code : String, country : String) = {
        this()
        this.name = name
        this.street = street
        this.city = city
        this.state = state
        this.code = code
        this.country = country
        this.log()
    }

    def this(node : Node) = {
        this()
        val nameNode : Node = DomSearchHelper.getNode(StreetAddressData.NAME, node.getChildNodes())
        this.name = DomNodeHelper.getTextNodeValue(nameNode)
        val streetNode : Node = DomSearchHelper.getNode(StreetAddressData.STREET, node.getChildNodes())
        this.street = DomNodeHelper.getTextNodeValue(streetNode)
        val cityNode : Node = DomSearchHelper.getNode(StreetAddressData.CITY, node.getChildNodes())
        this.city = DomNodeHelper.getTextNodeValue(cityNode)
        val stateNode : Node = DomSearchHelper.getNode(StreetAddressData.STATE, node.getChildNodes())
        this.state = DomNodeHelper.getTextNodeValue(stateNode)
        val codeNode : Node = DomSearchHelper.getNode(StreetAddressData.CODE, node.getChildNodes())
        this.code = DomNodeHelper.getTextNodeValue(codeNode)
        val countryNode : Node = DomSearchHelper.getNode(StreetAddressData.COUNTRY, node.getChildNodes())
        this.country = DomNodeHelper.getTextNodeValue(countryNode)
        this.log()
    }

    def this(streetAddress : StreetAddress) = {
        this()
        this.id = streetAddress.getId()
        this.name = streetAddress.getName()
        this.street = streetAddress.getStreet()
        this.city = streetAddress.getCity()
        this.state = streetAddress.getState()
        this.code = streetAddress.getCode()
        this.country = streetAddress.getCountry()
        this.isDefault_StreetAddress = streetAddress.isDefault()
        this.log()
    }

    def this(request : HttpServletRequest) = {
        this()
        this.setId(request.getParameter(StreetAddressData.ID))
        this.setName(request.getParameter(StreetAddressData.NAME))
        this.setStreet(request.getParameter(StreetAddressData.STREET))
        this.setCity(request.getParameter(StreetAddressData.CITY))
        this.setState(request.getParameter(StreetAddressData.STATE))
        this.setCode(request.getParameter(StreetAddressData.CODE))
        this.setCountry(request.getParameter(StreetAddressData.COUNTRY))
        this.log()
    }

    def this(address : HashMap[Object, Object]) = {
        this()
        this.id = address.get(StreetAddressData.ID).asInstanceOf[String]
        this.name = address.get(StreetAddressData.NAME).asInstanceOf[String]
        this.street = address.get(StreetAddressData.STREET).asInstanceOf[String]
        this.city = address.get(StreetAddressData.CITY).asInstanceOf[String]
        this.state = address.get(StreetAddressData.STATE).asInstanceOf[String]
        this.code = address.get(StreetAddressData.CODE).asInstanceOf[String]
        this.country = address.get(StreetAddressData.COUNTRY).asInstanceOf[String]
        var `def` : String = address.get(StreetAddressData.DEFAULT).asInstanceOf[String]
        if ((`def` != null) && (`def`.compareTo(StreetAddressData.DEFAULT) == 0)) {
            this.isDefault_StreetAddress = true
        } else {
            this.isDefault_StreetAddress = false
        }
        this.log()
    }

    private def log() : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil.putF("Created Address: \n" + this.toHashMap(), this, "log")
        }
    }

    def setId(id : String) : Unit = {
        this.id = id
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def setStreet(value : String) : Unit = {
        this.street = value
    }

    def setCity(value : String) : Unit = {
        this.city = value
    }

    def setState(value : String) : Unit = {
        this.state = value
    }

    def setCode(value : String) : Unit = {
        this.code = value
    }

    def setCountry(value : String) : Unit = {
        this.country = value
    }

    def getName() : String = {
        return this.name
    }

    def getStreet() : String = {
        return this.street
    }

    def getCity() : String = {
        return this.city
    }

    def getState() : String = {
        return this.state
    }

    def getCode() : String = {
        return this.code
    }

    def getCountry() : String = {
        return this.country
    }

    def getId() : String = {
        return this.id
    }

    def isDefault() : Boolean = {
        return this.isDefault_StreetAddress
    }

    def isEmpty() : _root_.java.lang.Boolean = {
        /*        *      if(StringValidationUtil.isEmpty(this.getName()) &&          StringValidationUtil.isEmpty(this.getStreet()) &&          StringValidationUtil.isEmpty(this.getCity()) &&          StringValidationUtil.isEmpty(this.getState()) &&           StringValidationUtil.isEmpty(this.getCode()) &&          StringValidationUtil.isEmpty(this.getCountry())) */
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        if ((((((((((((this.getName() == null) && (this.getName().compareTo(EMPTY_STRING) == 0)) && (this.getStreet() == null)) && (this.getStreet().compareTo(EMPTY_STRING) == 0)) && (this.getCity() == null)) && (this.getCity().compareTo(EMPTY_STRING) == 0)) && (this.getState() == null)) && (this.getState().compareTo(EMPTY_STRING) == 0)) && (this.getCode() == null)) && (this.getCode().compareTo(EMPTY_STRING) == 0)) && (this.getCountry() == null)) && (this.getCountry().compareTo(EMPTY_STRING) == 0)) {
            return _root_.java.lang.Boolean.TRUE
        }
        return _root_.java.lang.Boolean.FALSE
    }

    def isValid() : _root_.java.lang.Boolean = {
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        if ((((((((((((this.getName() == null) || (this.getName().compareTo(EMPTY_STRING) == 0)) || (this.getStreet() == null)) || (this.getStreet().compareTo(EMPTY_STRING) == 0)) || (this.getCity() == null)) || (this.getCity().compareTo(EMPTY_STRING) == 0)) || (this.getState() == null)) || (this.getState().compareTo(EMPTY_STRING) == 0)) || (this.getCode() == null)) || (this.getCode().compareTo(EMPTY_STRING) == 0)) || (this.getCountry() == null)) || (this.getCountry().compareTo(EMPTY_STRING) == 0)) {
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def validationInfo() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Address Failed To Validate - All fields must contain data.<br></br>")
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.getName(), StreetAddressData.MIN, StreetAddressData.MAX)) {
            stringBuffer.append("Please enter a valid name")
            stringBuffer.append("<br></br>")
        }
        if (!stringValidationUtil.isValidRequired(this.getStreet(), StreetAddressData.MIN, StreetAddressData.MAX)) {
            stringBuffer.append("Please enter a valid street")
            stringBuffer.append("<br></br>")
        }
        if (!stringValidationUtil.isValidRequired(this.getCity(), StreetAddressData.MIN, StreetAddressData.MAX)) {
            stringBuffer.append("Please enter a valid city")
            stringBuffer.append("<br></br>")
        }
        if (!stringValidationUtil.isValidRequired(this.getState(), StreetAddressData.MIN, StreetAddressData.MAX)) {
            stringBuffer.append("Please enter a valid state")
            stringBuffer.append("<br></br>")
        }
        if (!stringValidationUtil.isValidRequired(this.getCode(), StreetAddressData.MIN, StreetAddressData.MAX)) {
            stringBuffer.append("Please enter a valid zipcode")
            stringBuffer.append("<br></br>")
        }
        if (!stringValidationUtil.isValidRequired(this.getCountry(), StreetAddressData.MIN, StreetAddressData.MAX)) {
            stringBuffer.append("Please enter a valid country")
            stringBuffer.append("<br></br>")
        }
        return stringBuffer.toString()
    }

    private def toValidationInfoDoc() : Document = {
        return null
    }

    private def toValidationInfoNode(document : Document) : Node = {
        try {
            var node : Node = document.createElement(StreetAddressData.FORM)
            node.appendChild(this.toXmlNode(document))
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "toValidationInfoNode", e)
                }
                //throw e;
                return null
            }
        }
        throw new IllegalStateException()
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(StreetAddressData.ID, this.id)
        hashMap.put(StreetAddressData.NAME, this.name)
        hashMap.put(StreetAddressData.STREET, this.street)
        hashMap.put(StreetAddressData.CITY, this.city)
        hashMap.put(StreetAddressData.STATE, this.state)
        hashMap.put(StreetAddressData.CODE, this.code)
        hashMap.put(StreetAddressData.COUNTRY, this.country)
        /*       if(this.isDefault)       {          hashMap.put(StreetAddressData.DEFAULT,StreetAddressData.DEFAULT);       }       else hashMap.put(StreetAddressData.DEFAULT,EMPTY_STRING);       */
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var stringUtil : StringUtil = StringUtil.getInstance()
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var keyArray : Array[Object] = keySet.toArray()
        var size : Int = keyArray.length
        var node : Node = document.createElement(StreetAddressData.ADDRESS)

        {
            var i : Int = 0
            while (i < size) {
                var name : String = keyArray(i).asInstanceOf[String]
                var value : String = stringUtil.getNonNull(hashMap.get(name).asInstanceOf[String])
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                i += 1
            }
        }
        return node
    }

}


