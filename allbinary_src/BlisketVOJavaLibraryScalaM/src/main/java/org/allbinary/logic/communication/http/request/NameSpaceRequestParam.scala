/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.logic.visual.dhtml.html.name.HtmlNameMathData
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class NameSpaceRequestParam(param_nameSpace : String, param_value : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var nameSpaceVector : BasicArrayList = null

    //A hashmap of hashmaps
    private var nameSpacePropertiesHashMap : HashMap[Object, Object] = null

    private var value : String = null

    //Constructor
    {
        val nameSpace : String = param_nameSpace
        val value : String = param_value
        this.nameSpaceVector = new BasicArrayListD()
        this.nameSpacePropertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.value = value
        var beginIndex : Int = nameSpace.indexOf(NameSpaceRequestParamData.NAME)
        if (beginIndex < 0) {
            throw new Exception("Not a NameSpaceRequest")
        }
        var packages : String = nameSpace.substring((beginIndex + NameSpaceRequestParamData.NAME.length()) + NameSpaceRequestParamData.SEP.length())
        var sepTokenizer : Tokenizer = new Tokenizer(NameSpaceRequestParamData.SEP)
        var nameSpaceWithPropertiesVector : BasicArrayList = sepTokenizer.getTokensFromString(packages, new BasicArrayListD())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil.putF("\nSep Tokens: " + nameSpaceWithPropertiesVector.toString(), this, "NameSpaceRequestParam()")
        }
        var nameSpaceAndPropertiesTokenizer : Tokenizer = new Tokenizer(NameSpaceRequestParamData.PROPERTIES)
        var packageIndex : Int = 0
        val list : BasicArrayList = new BasicArrayListD()
        var index : Int = 0
        var size : Int = nameSpaceWithPropertiesVector.size()

        {
            while (index < size) {
                var nameSpaceWithProperties : String = nameSpaceWithPropertiesVector.get({ val value_N72695 = index; index += 1; value_N72695 }).asInstanceOf[String]
                // ["nameSpace", "properties"]
                list.clear()
                var nameSpaceAndPropertiesVector : BasicArrayList = nameSpaceAndPropertiesTokenizer.getTokensFromString(nameSpaceWithProperties, list)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil.putF("\nPackageName and PackageName Properties Tokens: " + nameSpaceAndPropertiesVector.toString(), this, "NameSpaceRequestParam()")
                }
                //add packageName and packageName properties
                if (nameSpaceAndPropertiesVector.size() > 0) {
                    //add packageName
                    var packageName : String = nameSpaceAndPropertiesVector.get(0).asInstanceOf[String]
                    if (packageName == null) {
                        throw new Exception("Package Name Is Null")
                    }
                    this.nameSpaceVector.add(packageName)
                    //packageName properties
                    if (nameSpaceAndPropertiesVector.size() > 1) {
                        var properties : String = nameSpaceAndPropertiesVector.get(1).asInstanceOf[String]
                        var packagePropertiesHashMap : HashMap[Object, Object] = this.generatePackagePropertiesHashMap(properties).asInstanceOf[HashMap[Object, Object]]
                        this.nameSpacePropertiesHashMap.put(Integer.toString(packageIndex), packagePropertiesHashMap)
                    }
                    packageIndex += 1
                }
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil.putF("NameSpace: " + this.nameSpaceVector.toString(), this, "NameSpaceRequestParam()")
        }
    }

    def getPackages() : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil.putF("NameSpace: " + this.nameSpaceVector.toString(), this, "getPackages()")
        }
        return this.nameSpaceVector
    }

    def getPackageProperties(packageIndex : Int) : HashMap[Object, Object] = {
        var packagePropertiesHashMap : HashMap[Object, Object] = this.nameSpacePropertiesHashMap.get(Integer.toString(packageIndex)).asInstanceOf[HashMap[Object, Object]]
        if (packagePropertiesHashMap == null) {
            packagePropertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil.putF("Package Properties: " + packagePropertiesHashMap.toString(), this, "getPackagesProperties()")
        }
        return packagePropertiesHashMap
    }

    def getValue() : String = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil.putF("\nValue: " + this.value, this, "getValue()")
        }
        return this.value
    }

    private def generatePackagePropertiesHashMap(properties : String) : HashMap[Object, Object] = {
        var propertiesTokenizer : Tokenizer = new Tokenizer(NameSpaceRequestParamData.PROPERTIESSEPARATOR)
        var packagePropertiesHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var propertyVector : BasicArrayList = propertiesTokenizer.getTokensFromString(properties, new BasicArrayListD())
        //First Item is Always the key the rest are Properties
        val list : BasicArrayList = new BasicArrayListD()
        val propertyTokenizer : Tokenizer = new Tokenizer(HtmlNameMathData.getInstance().EQUALS)
        var index : Int = 0
        var size : Int = propertyVector.size()

        {
            while (index < size) {
                var property : String = propertyVector.get(index).asInstanceOf[String]
                list.clear()
                var propertyNameValueVector : BasicArrayList = propertyTokenizer.getTokensFromString(property, list)
                var index2 : Int = 0

                {
                    while (index2 < propertyNameValueVector.size()) {
                        var propertyName : String = propertyNameValueVector.get({ val value_N75385 = index2; index2 += 1; value_N75385 }).asInstanceOf[String]
                        if (propertyNameValueVector.size() > 1) {
                            var propertyValue : String = propertyNameValueVector.get({ val value_N75551 = index2; index2 += 1; value_N75551 }).asInstanceOf[String]
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                                this.logUtil.putF((("\nProperty Name: " + propertyName) + "\nProperty Value: ") + propertyValue, this, "generatePackagePropertiesHashMap()")
                            }
                            packagePropertiesHashMap.put(propertyName, propertyValue)
                        } else {
                            packagePropertiesHashMap.put(propertyName, StringUtil.getInstance().EMPTY_STRING)
                        }
                    }
                }
            }
        }
        return packagePropertiesHashMap
    }

}


