/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.Encoder
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.OutputTypeData
import _root_.org.allbinary.logic.io.path.AbFilePath
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.info.data.TransformInfoDataData
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfig
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigAndManipulatorFactory
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface
import _root_.org.allbinary.logic.visual.transform.info.template.TransformInfoTemplateData
import _root_.org.allbinary.logic.visual.transform.info.viewObject.TransformInfoObjectData
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document

class TransformInfo() extends TransformInfoInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var isChild_TransformInfo : Boolean = false

    private var name : String = null

    private var storeName : String = null

    private var objectFileName : String = null

    private var anyType : Object = null

    private var objectConfigFileName : String = null

    private var objectConfigInterface : TransformInfoObjectConfigInterface = null

    private var template : String = null

    private var templateFileName : String = null

    private var dataFileName : String = null

    private var data : String = StringUtil.getInstance().EMPTY_STRING

    def this(name : String, objectFileName : String, objectConfigFileName : String, templateFileName : String, dataFileName : String) = {
        this()
        this.setName(name)
        this.setObjectFile(objectFileName)
        this.setObjectConfigFile(objectConfigFileName)
        this.setTemplateFile(templateFileName)
        this.setDataFile(dataFileName)
    }

    def this(name : String) = {
        this()
        this.setName(name)
    }

    def `override`(hashMap : HashMap[Object, Object]) : Unit = {
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        var aName : String = hashMap.get(transformInfoData.NAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aName)) {
            this.name = aName
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("TransformInfo properties overridden for: ")
            stringBuffer.append(this.getName())
            stringBuffer.append("\n properties: ")
            stringBuffer.append(hashMap.toString())
            this.logUtil.putF(stringBuffer.toString(), this, "override(HashMap hashMap)")
        }
        var aStoreName : String = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aStoreName)) {
            this.storeName = aStoreName
        }
        var aObjectFileName : String = hashMap.get(transformInfoData.OBJECTFILENAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aObjectFileName)) {
            this.objectFileName = aObjectFileName
        }
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
        stringBuffer.append(this.storeName)
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        var fileAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
        var aObject : String = hashMap.get(transformInfoData.OBJECT).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aObject)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TransformInfo override view Object for: " + this.getName(), this, "override(HashMap hashMap)")
            }
            var fileDataString : String = new CryptFileReader(TransformInfoObjectData.getInstance().UNCRYPTED_EXTENSION, TransformInfoObjectData.getInstance().ENCRYPTED_EXTENSION).get(new AbPath(fileAbPath.toString(), aObject))
            if (fileDataString != null) {
                this.anyType = fileDataString
            }
        }
        if (!stringValidationUtil.isEmpty(hashMap.get(transformInfoData.OBJECTCONFIG).asInstanceOf[String])) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TransformInfo override ObjectConfig for: " + this.getName(), this, "override(HashMap hashMap)")
            }
            this.setObjectConfig(hashMap.get(transformInfoData.OBJECTCONFIG).asInstanceOf[String])
        }
        var objectConfigFileName : String = hashMap.get(transformInfoData.OBJECTCONFIGFILENAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(objectConfigFileName)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TransformInfo override ObjectConfig File for: " + this.getName(), this, "override(HashMap hashMap)")
            }
            this.setObjectConfigFile(objectConfigFileName)
        }
        var `type` : String = hashMap.get(OutputTypeData.getInstance().NAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(`type`)) {
            //TWB - for inserting after
            if (this.getObjectConfigInterface() == null) {
                this.setObjectConfigInterface(new TransformInfoObjectConfig(this))
            }
            this.getObjectConfigInterface().setOutputTypeName(`type`)
        }
        var aTemplateFileName : String = hashMap.get(transformInfoData.TEMPLATEFILENAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aTemplateFileName)) {
            this.templateFileName = aTemplateFileName
        }
        var aTemplate : String = hashMap.get(transformInfoData.TEMPLATE).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aTemplate)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TransformInfo override Template for: " + this.getName(), this, "override(HashMap hashMap)")
            }
            var fileDataString : String = new CryptFileReader(TransformInfoTemplateData.getInstance().UNCRYPTED_EXTENSION, TransformInfoTemplateData.getInstance().ENCRYPTED_EXTENSION).get(new AbPath(fileAbPath.toString(), aTemplate))
            if (!stringValidationUtil.isEmpty(fileDataString)) {
                this.template = fileDataString
            }
        }
        var aDataFileName : String = hashMap.get(transformInfoData.DATAFILENAME).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aDataFileName)) {
            this.dataFileName = aDataFileName
        }
        var aData : String = hashMap.get(transformInfoData.DATA).asInstanceOf[String]
        if (!stringValidationUtil.isEmpty(aData)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TransformInfo override Data for: " + this.getName(), this, "override(HashMap hashMap)")
            }
            var fileDataString : String = new CryptFileReader(TransformInfoDataData.getInstance().UNCRYPTED_EXTENSION, TransformInfoDataData.getInstance().ENCRYPTED_EXTENSION).get(new AbPath(fileAbPath.toString(), aData))
            if (!stringValidationUtil.isEmpty(fileDataString)) {
                this.data = fileDataString
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            stringBuffer = new StringMaker()
            stringBuffer.append("Name: ")
            stringBuffer.append(aName)
            stringBuffer.append("\nTemp Object File: ")
            stringBuffer.append(aObject)
            stringBuffer.append("\nTemp Object Config File: ")
            stringBuffer.append(this.getObjectConfigFilePath().toString())
            stringBuffer.append("\nTemp Template File: ")
            stringBuffer.append(aTemplate)
            stringBuffer.append("\nTemp Data File: ")
            stringBuffer.append(aData)
            stringBuffer.append("\nStore Name: ")
            stringBuffer.append(aStoreName)
            stringBuffer.append("\nObjectFile: ")
            stringBuffer.append(this.getObjectFile())
            stringBuffer.append("->TransformInfo")
            this.logUtil.putF(stringBuffer.toString(), this, "TransformInfoInterface(HashMap)")
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
            this.logUtil.putF(this.log(), this, "override")
        }
    }

    def log() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Name: ")
        stringBuffer.append(this.name)
        stringBuffer.append("\nObject File: ")
        stringBuffer.append(this.objectFileName)
        stringBuffer.append("\nObject Config File Path: ")
        stringBuffer.append(this.getObjectConfigFile())
        stringBuffer.append("\nTemplate File: ")
        stringBuffer.append(this.templateFileName)
        stringBuffer.append("\nData File: ")
        stringBuffer.append(this.dataFileName)
        stringBuffer.append("\nStore Name: ")
        stringBuffer.append(this.storeName)
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append(this.getObjectFile())
        stringBuffer.append("->TransformInfo")
        stringBuffer.append("TransformInfoInterface(HashMap)")
        return stringBuffer.toString()
    }

    def setName(value : String) : Unit = {
        this.name = value
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    def getStoreName() : String = {
        return this.storeName
    }

    def setObject(anyType : Object) : Unit = {
        this.anyType = anyType
    }

    def setObjectFile(value : String) : Unit = {
        this.objectFileName = value
    }

    def setTemplate(value : String) : Unit = {
        this.template = value
    }

    def setTemplateFile(value : String) : Unit = {
        this.templateFileName = value
    }

    def setObjectConfigFileName(value : String) : Unit = {
        this.objectConfigFileName = value
    }

    def setObjectConfigFile(value : String) : Unit = {
        this.objectConfigFileName = value
        this.setObjectConfigInterface(TransformInfoObjectConfigAndManipulatorFactory.getInstance().getInstance(this.abeClientInformation, this, this.getObjectConfigFilePath()))
    }

    def setObjectConfig(value : String) : Unit = {
        var document : Document = DomDocumentHelper.create(value)
        this.setObjectConfigInterface(TransformInfoObjectConfigAndManipulatorFactory.getInstance().getInstance(this.abeClientInformation, this, document))
    }

    def setDataFile(value : String) : Unit = {
        this.dataFileName = value
    }

    def setData(value : String) : Unit = {
        this.data = value
    }

    def getName() : String = {
        return this.name
    }

    def getObject() : Object = {
        return this.anyType
    }

    def getObjectFile() : String = {
        return this.objectFileName
    }

    def getTemplate() : String = {
        return this.template
    }

    def getTemplateFile() : String = {
        return this.templateFileName
    }

    //Expects Absolute URI
    def getTemplateFilePath() : AbPath = {
        return new AbFilePath(this.getTemplateFile())
    }

    //Expects Absolute URI
    def getObjectConfigFilePath() : AbPath = {
        return new AbFilePath(this.getObjectConfigFile())
    }

    //Expects Absolute URI
    def getDataFilePath() : AbPath = {
        return new AbFilePath(this.getDataFile())
    }

    def getObjectConfigFile() : String = {
        return this.objectConfigFileName
    }

    private def getData() : String = {
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        var dataFileString : String = this.getDataFile()
        if (!stringValidationUtil.isEmpty(dataFileString)) {
            try {
                var fileData : String = new CryptFileReader(TransformInfoDataData.getInstance().UNCRYPTED_EXTENSION, TransformInfoDataData.getInstance().ENCRYPTED_EXTENSION).get(this.getDataFilePath())
                if (!stringValidationUtil.isEmpty(this.data)) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil.putF("Data File overriding existing data: " + this.getDataFilePath(), this, "getData()")
                    }
                }
                this.data = fileData
            } catch {
                case e : Exception => {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                        this.logUtil.put("Could Not Load Data from: " + this.getDataFile(), this, "getData()", e)
                    }
                }
            }
        }
        try {
            if (!stringValidationUtil.isEmpty(this.data)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.putF("Data: " + XmlDocumentHelper.toString(DomDocumentHelper.create(data)), this, "getData()")
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Name: ")
                    stringBuffer.append(this.name)
                    stringBuffer.append("\nEmpty Data For: ")
                    stringBuffer.append(dataFileString)
                    stringBuffer.append("\nPath: ")
                    stringBuffer.append(this.getDataFilePath().toFileSystemString())
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                        this.logUtil.putF(stringBuffer.toString(), this, "getData()")
                    }
                }
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Could Not Preview Data: " + this.data, this, "getData()", e)
                }
            }
        }
        return this.data
    }

    //return the needed node from the data
    def getDataDocument() : Document = {
        var localData : String = this.getData()
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (stringValidationUtil.isEmpty(localData)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                this.logUtil.putF("No Data So Creating New Document", this, "getDataDocument()")
            }
            return DomDocumentHelper.create()
        } else {
            var document : Document = DomDocumentHelper.create(localData)
            return document
        }
        throw new IllegalStateException()
    }

    def getDataFile() : String = {
        return this.dataFileName
    }

    def toHashMap() : HashMap[Object, Object] = {
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(transformInfoData.NAME, this.name)
        hashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
        hashMap.put(transformInfoData.OBJECTFILENAME, this.objectFileName)
        hashMap.put(transformInfoData.OBJECT, this.anyType)
        hashMap.put(transformInfoData.OBJECTCONFIGFILENAME, this.getObjectConfigFile())
        //hashMap.put(transformInfoData.OBJECTCONFIG, this.getObjectConfigInterface().toString());
        hashMap.put(transformInfoData.OBJECTCONFIG, Encoder.encode(this.getObjectConfigInterface().toString().getBytes()))
        hashMap.put(transformInfoData.TEMPLATEFILENAME, this.templateFileName)
        hashMap.put(transformInfoData.TEMPLATE, this.template)
        hashMap.put(transformInfoData.DATAFILENAME, this.dataFileName)
        hashMap.put(transformInfoData.DATA, Encoder.encode(this.data.getBytes()))
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        hashMap.put(EntryData.getInstance().LASTMODIFIED, time)
        //add time
        return hashMap
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.name)
        vector.add(this.storeName)
        vector.add(this.objectFileName)
        vector.add(this.anyType)
        vector.add(this.getObjectConfigFile())
        //vector.add(this.getObjectConfigInterface().toString());
        vector.add(Encoder.encode(this.getObjectConfigInterface().toString().getBytes()))
        vector.add(this.templateFileName)
        vector.add(this.template)
        vector.add(this.dataFileName)
        vector.add(Encoder.encode(this.data.getBytes()))
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        vector.add(time)
        vector.add(time)
        return vector
    }

    def getKey() : Object = {
        return this.getName().asInstanceOf[Object]
    }

    def setChild() : Unit = {
        this.isChild_TransformInfo = true
    }

    def isChild() : Boolean = {
        return this.isChild_TransformInfo
    }

    def getObjectConfigInterface() : TransformInfoObjectConfigInterface = {
        return this.objectConfigInterface
    }

    def setObjectConfigInterface(objectConfigInterface : TransformInfoObjectConfigInterface) : Unit = {
        this.objectConfigInterface = objectConfigInterface
    }

}


