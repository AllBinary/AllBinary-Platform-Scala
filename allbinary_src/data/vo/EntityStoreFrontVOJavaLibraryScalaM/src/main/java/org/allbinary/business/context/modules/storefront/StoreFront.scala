/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.context.configuration.ContextConfiguration
import _root_.org.allbinary.business.context.configuration.ContextConfigurationDomDocumentMapping
import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterface
import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterfaceFactory
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.io.path.AbPathUtil
import _root_.org.allbinary.logic.string.SpecialCharacterUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.apache.commons.lang3.StringEscapeUtils
import _root_.org.w3c.dom.Document

class StoreFront() extends StoreFrontInterface {
    import _root_.org.allbinary.business.context.modules.storefront.StoreFront.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val directory : Directory = Directory.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val abPathUtil : AbPathUtil = AbPathUtil.getInstance()

    private var name : String = this.stringUtil.EMPTY_STRING

    private var basketName : String = this.stringUtil.EMPTY_STRING

    private var homeHostName : String = this.stringUtil.EMPTY_STRING

    private var homeHostNamePath : AbPath = this.abPathUtil.NO_ABPATH

    private var hostName : String = this.stringUtil.EMPTY_STRING

    private var hostNamePath : AbPath = this.abPathUtil.NO_ABPATH

    private var testHomeHostName : String = this.stringUtil.EMPTY_STRING

    private var testHomeHostNamePath : AbPath = this.abPathUtil.NO_ABPATH

    private var testHostName : String = this.stringUtil.EMPTY_STRING

    private var testHostNamePath : AbPath = this.abPathUtil.NO_ABPATH

    private var imagePath : AbPath = this.abPathUtil.NO_ABPATH

    private var staticPath : AbPath = this.abPathUtil.NO_ABPATH

    private var categoryPath : AbPath = this.abPathUtil.NO_ABPATH

    private var inventoryControl : String = this.stringUtil.EMPTY_STRING

    private var contextConfigurationInterface : ContextConfigurationInterface = null

    private var subStores : String = this.stringUtil.EMPTY_STRING

    private var tagLocation : String = this.stringUtil.EMPTY_STRING

    private var packageLocation : String = this.stringUtil.EMPTY_STRING

    private var ftp : String = this.stringUtil.EMPTY_STRING

    private var ftpPath : AbPath = this.abPathUtil.NO_ABPATH

    private var ftpUserName : String = this.stringUtil.EMPTY_STRING

    private var ftpPassword : String = this.stringUtil.EMPTY_STRING

    private var testFtp : String = this.stringUtil.EMPTY_STRING

    private var testFtpPath : AbPath = this.abPathUtil.NO_ABPATH

    private var testFtpUserName : String = this.stringUtil.EMPTY_STRING

    private var testFtpPassword : String = this.stringUtil.EMPTY_STRING

    private var timeCreated : String = this.stringUtil.EMPTY_STRING

    private var lastModified : String = this.stringUtil.EMPTY_STRING

    private val MINCHAR : Int = 0

    private val MINSTORENAMELENGTH : Int = 1

    private val MAXCHAR : Int = 255

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    private val ONE_EMPTY_STRING_ARRAY : Array[String] = StringUtil.getInstance().ONE_EMPTY_STRING_ARRAY

    //Constructor
    {
        this.contextConfigurationInterface = new ContextConfiguration()
    }

    def this(request : HttpServletRequest) = {
        this()
        this.getFormData(new RequestParams(request).toHashMap())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF("TWB- needs update for adding and updating context configuration - currently defaults to admin context config", this, "StoreFront")
        }
        //(ContextConfigurationInterface) new ContextConfiguration(storeHashMap));
        this.setContextConfigurationInterface(ContextConfigurationInterfaceFactory.getInstance().getInstance("Admin"))
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.getFormData(hashMap)
        val domDocumentString : String = hashMap.get(StoreFrontData.getInstance().CONFIGURATION).asInstanceOf[String]
        if (domDocumentString == null) {
            val document : Document = DomDocumentHelper.create(domDocumentString)
            this.setContextConfigurationInterface(ContextConfigurationInterfaceFactory.getInstance().getInstance(document))
        }
    }

    //in the future could use vector from table data
    private def isColumn(columnName : String) : Boolean = {
        if ((columnName.compareTo(StoreFrontData.getInstance().NAME) == 0) || (columnName.compareTo(UserData.MAINEMAIL) == 0)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    //should be in the pathUtil
    private def createPath(key : String, hashMap : HashMap[Object, Object]) : AbPath = {
        return new AbPath(this.create(this.EMPTY_STRING, key, hashMap), StringUtil.getInstance().EMPTY_STRING)
    }

    private def createPath(append : String, key : String, hashMap : HashMap[Object, Object]) : AbPath = {
        return new AbPath(this.create(append, key, hashMap), StringUtil.getInstance().EMPTY_STRING)
    }

    private def get(key : String, hashMap : HashMap[Object, Object]) : String = {
        return this.create(this.EMPTY_STRING, key, hashMap)
    }

    private def create(append : String, key : String, hashMap : HashMap[Object, Object]) : String = {
        var path : String = hashMap.get(key).asInstanceOf[String]
        if (StringValidationUtil.getInstance().isEmpty(path)) {
            return this.EMPTY_STRING
        } else {
            if (this.isColumn(path)) {
                return hashMap.get(path).asInstanceOf[String] + append
            } else {
                return path
            }
        }
        throw new IllegalStateException()
    }

    private def getFormData(storeHashMap : HashMap[Object, Object]) : Unit = {
        var storeFrontData : StoreFrontData = StoreFrontData.getInstance()
        this.name = storeHashMap.get(storeFrontData.NAME).asInstanceOf[String]
        this.basketName = storeHashMap.get(storeFrontData.NAME).asInstanceOf[String]
        this.homeHostName = storeHashMap.get(storeFrontData.HOMEHOSTNAME).asInstanceOf[String]
        this.homeHostNamePath = this.createPath(storeFrontData.HOMEHOSTNAMEPATH, storeHashMap)
        this.hostName = storeHashMap.get(storeFrontData.HOSTNAME).asInstanceOf[String]
        this.hostNamePath = this.createPath(storeFrontData.HOSTNAMEPATH, storeHashMap)
        this.testHomeHostName = storeHashMap.get(storeFrontData.TESTHOMEHOSTNAME).asInstanceOf[String]
        this.testHomeHostNamePath = this.createPath(storeFrontData.TESTHOMEHOSTNAMEPATH, storeHashMap)
        this.testHostName = storeHashMap.get(storeFrontData.TESTHOSTNAME).asInstanceOf[String]
        this.testHostNamePath = this.createPath(storeFrontData.TESTHOSTNAMEPATH, storeHashMap)
        this.imagePath = this.createPath(StoreFront.RESOURCES, storeFrontData.IMAGEPATH, storeHashMap)
        this.staticPath = this.createPath(" Products" + AbPathData.getInstance().SEPARATOR, storeFrontData.STATICPATH, storeHashMap)
        this.categoryPath = this.createPath(StoreFront.RESOURCES, storeFrontData.CATEGORYPATH, storeHashMap)
        this.inventoryControl = storeHashMap.get(storeFrontData.INVENTORYCONTROL).asInstanceOf[String]
        //this.sale = this.get(storeFrontData.SALE, storeHashMap);
        this.subStores = storeHashMap.get(storeFrontData.SUBSTORES).asInstanceOf[String]
        this.tagLocation = storeHashMap.get(storeFrontData.TAGLOCATION).asInstanceOf[String]
        this.packageLocation = storeHashMap.get(storeFrontData.PACKAGELOCATION).asInstanceOf[String]
        this.ftp = storeHashMap.get(storeFrontData.FTP).asInstanceOf[String]
        this.ftpPath = this.createPath(storeFrontData.FTPPATH, storeHashMap)
        this.ftpUserName = storeHashMap.get(storeFrontData.FTPUSERNAME).asInstanceOf[String]
        this.ftpPassword = storeHashMap.get(storeFrontData.FTPPASSWORD).asInstanceOf[String]
        this.testFtp = storeHashMap.get(storeFrontData.TESTFTP).asInstanceOf[String]
        this.testFtpPath = this.createPath(storeFrontData.TESTFTPPATH, storeHashMap)
        this.testFtpUserName = storeHashMap.get(storeFrontData.TESTFTPUSERNAME).asInstanceOf[String]
        this.testFtpPassword = storeHashMap.get(storeFrontData.TESTFTPPASSWORD).asInstanceOf[String]
        this.timeCreated = storeHashMap.get(EntryData.getInstance().TIMECREATED).asInstanceOf[String]
        this.lastModified = storeHashMap.get(EntryData.getInstance().LASTMODIFIED).asInstanceOf[String]
    }

    def isNameValid() : _root_.java.lang.Boolean = {
        if (!StringValidationUtil.getInstance().isValidRequired(this.name, this.MINSTORENAMELENGTH, this.MAXCHAR)) {
            return _root_.java.lang.Boolean.FALSE
        } else {
            //Since StoreName is used as the store directory
            var isEscapedCharactersContained : Boolean = false
            val storeNameEscaped : String = StringEscapeUtils.escapeHtml3(this.name)
            if (this.name.compareTo(storeNameEscaped) != 0) {
                isEscapedCharactersContained = true
            }
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            var isSpacesContained : Boolean = false
            if (stringValidationUtil.containsSpaces(this.name)) {
                isSpacesContained = true
            }
            if (isSpacesContained || isEscapedCharactersContained) {
                val hashMap : HashMap[Object, Object] = SpecialCharacterUtil.getHashMap().asInstanceOf[HashMap[Object, Object]]
                hashMap.put(Array[String](CommonSeps.getInstance().SPACE), this.ONE_EMPTY_STRING_ARRAY)
                this.name = new Replace(hashMap).all(this.name)
            }
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def isValid() : _root_.java.lang.Boolean = {
        var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
        valid = this.isNameValid()
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.basketName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.homeHostName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.homeHostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.hostName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.hostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testHomeHostName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testHomeHostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testHostName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testHostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.imagePath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.staticPath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.categoryPath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.inventoryControl, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        /*         if(!stringValidationUtil.isValidNotRequired(this.out, MINCHAR, this.MAXCHAR))         {         valid = Boolean.FALSE;         }          if(!stringValidationUtil.isValidNotRequired(this.age, MINCHAR, this.MAXCHAR))         {         valid = Boolean.FALSE;         }          if(!stringValidationUtil.isValidNotRequired(this.sale, MINCHAR, this.MAXCHAR))         {         valid = Boolean.FALSE;         }          if(!stringValidationUtil.isValidNotRequired(this.notification, MINCHAR, this.MAXCHAR))         {         valid = Boolean.FALSE;         }          if(!stringValidationUtil.isValidNotRequired(this.order, MINCHAR, this.MAXCHAR))         {         valid = Boolean.FALSE;         }          if(!stringValidationUtil.isValidNotRequired(this.orderCancel, MINCHAR, this.MAXCHAR))         {         valid = Boolean.FALSE;         }          */
        if (!stringValidationUtil.isValidNotRequired(this.subStores, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.tagLocation, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidRequired(this.packageLocation, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.ftp, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.ftpPath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.ftpUserName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.ftpPassword, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testFtp, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testFtpPath.toString(), this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testFtpUserName, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (!stringValidationUtil.isValidNotRequired(this.testFtpPassword, this.MINCHAR, this.MAXCHAR)) {
            valid = _root_.java.lang.Boolean.FALSE
        }
        if (valid.booleanValue() == true) {
            //if(InventoryEntityFactory.getInstance().getItem(id)==null)
            return _root_.java.lang.Boolean.TRUE
        } else {
            return _root_.java.lang.Boolean.FALSE
        }
        throw new IllegalStateException()
    }

    def nameValidationInfo() : String = {
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.name, this.MINCHAR, this.MAXCHAR)) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Name is invalid. Must be < ")
            stringBuffer.appendint(this.MAXCHAR)
            stringBuffer.append(" and > 0 characters.<br>")
            return stringBuffer.toString()
        }
        return this.EMPTY_STRING
    }

    def validationInfo() : String = {
        try {
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.nameValidationInfo())
            if (!stringValidationUtil.isValidRequired(this.basketName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append("Basket name is invalid. Must be < ")
                stringBuffer.appendint(this.MAXCHAR)
                stringBuffer.append(" and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.homeHostName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append("Home host name is invalid. Must be < ")
                stringBuffer.appendint(this.MAXCHAR)
                stringBuffer.append(" and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.homeHostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append("Home host name path is invalid. Must be < ")
                stringBuffer.appendint(this.MAXCHAR)
                stringBuffer.append(" and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.hostName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append("Host name is invalid. Must be < ")
                stringBuffer.appendint(this.MAXCHAR)
                stringBuffer.append(" and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.hostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append("Host name path is invalid. Must be < ")
                stringBuffer.appendint(this.MAXCHAR)
                stringBuffer.append(" and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testHomeHostName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test home host name is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testHomeHostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test home host name path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testHostName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test host name is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testHostNamePath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test host name path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.imagePath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Image path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.staticPath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Static path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.categoryPath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Category path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.inventoryControl, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Inventory control is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            /*             if(!stringValidationUtil.isValidNotRequired(this.out, MINCHAR, this.MAXCHAR))             {             stringBuffer.append("Out is invalid. Must be < " + this.MAXCHAR + " and > 0 characters.<br>");             }              if(!stringValidationUtil.isValidNotRequired(this.age, MINCHAR, this.MAXCHAR))             {             stringBuffer.append("Age is invalid. Must be < " + this.MAXCHAR + " and > 0 characters.<br>");             }              if(!stringValidationUtil.isValidNotRequired(this.sale, MINCHAR, this.MAXCHAR))             {             stringBuffer.append("Sale is invalid. Must be < " + this.MAXCHAR + " and > 0 characters.<br>");             }              if(!stringValidationUtil.isValidNotRequired(this.notification, MINCHAR, this.MAXCHAR))             {             stringBuffer.append("Notification is invalid. Must be < " + this.MAXCHAR + " and > 0 characters.<br>");             }              if(!stringValidationUtil.isValidNotRequired(this.order, MINCHAR, this.MAXCHAR))             {             stringBuffer.append("Order is invalid. Must be < " + this.MAXCHAR + " and > 0 characters.<br>");             }              if(!stringValidationUtil.isValidNotRequired(this.orderCancel, MINCHAR, this.MAXCHAR))             {             stringBuffer.append("Order cancel is invalid. Must be < " + this.MAXCHAR + " and > 0 characters.<br>");             }              */
            if (!stringValidationUtil.isValidNotRequired(this.subStores, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Sub stores is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.tagLocation, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Tag location is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidRequired(this.packageLocation, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Package location is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.ftp, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Ftp is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.ftpPath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Ftp path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.ftpUserName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Ftp username is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.ftpPassword, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Ftp password is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testFtp, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test ftp is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testFtpPath.toString(), this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test ftp Path is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testFtpUserName, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test ftp username is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            if (!stringValidationUtil.isValidNotRequired(this.testFtpPassword, this.MINCHAR, this.MAXCHAR)) {
                stringBuffer.append(("Test ftp password is invalid. Must be < " + this.MAXCHAR) + " and > 0 characters.<br>")
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    //these files should be copied to the real server + staticpages path probably with ftp
    def getTestHtmlPath() : String = {
        //in testing mode return the test location else return the working location
        return String.valueOf(_root_.org.allbinary.globals.URLGLOBALS.getTestHtmlPath()) + this.getCurrentHostNamePath()
    }

    def getCurrentHostName() : String = {
        var location : String = this.EMPTY_STRING
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHostName()
        } else {
            location = this.getHostName()
        }
        return location
    }

    //host name is used by Blisket urls
    def getCurrentHostNamePath() : String = {
        var location : String = this.EMPTY_STRING
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHostNamePath()
        } else {
            location = this.getHostNamePath()
        }
        return location
    }

    //Home host name is used by remote non blisket urls
    def getCurrentHomeHostName() : String = {
        var location : String = this.EMPTY_STRING
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHomeHostName()
        } else {
            location = this.getHomeHostName()
        }
        return location
    }

    def getCurrentHomeHostNamePath() : String = {
        var location : String = this.EMPTY_STRING
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHomeHostNamePath()
        } else {
            location = this.getHomeHostNamePath()
        }
        return location
    }

    def getName() : String = {
        return this.name
    }

    def getBasketName() : String = {
        return this.basketName
    }

    def getHomeHostName() : String = {
        return this.homeHostName
    }

    def getHomeHostNamePath() : String = {
        return this.homeHostNamePath.toString()
    }

    def getHostName() : String = {
        return this.hostName
    }

    def getHostNamePath() : String = {
        return this.hostNamePath.toString()
    }

    def getTestHomeHostName() : String = {
        return this.testHomeHostName
    }

    def getTestHomeHostNamePath() : String = {
        return this.testHomeHostNamePath.toString()
    }

    def getTestHostName() : String = {
        return this.testHostName
    }

    def getTestHostNamePath() : String = {
        return this.testHostNamePath.toString()
    }

    /*     public String getImagePath()     {     return this.imagePath;     }      */
    def getStaticPath() : String = {
        return this.staticPath.toString()
    }

    def getCategoryPath() : String = {
        return this.categoryPath.toString()
    }

    def getInventoryControl() : String = {
        return this.inventoryControl
    }

    def getSubStores() : BasicArrayList = {
        try {
            val tokenizer : Tokenizer = new Tokenizer(CommonSeps.getInstance().SEMICOLON)
            val subStoreVector : BasicArrayList = tokenizer.getTokensFromString(this.subStores, new BasicArrayListD())
            return subStoreVector
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def getTagLocation() : String = {
        return this.tagLocation
    }

    def getPackageLocation() : String = {
        return this.packageLocation
    }

    def getFtp() : String = {
        return this.ftp
    }

    def getFtpUserName() : String = {
        return this.ftpUserName
    }

    def getFtpPassword() : String = {
        return this.ftpPassword
    }

    def getTestFtp() : String = {
        return this.testFtp
    }

    def getTestFtpUserName() : String = {
        return this.testFtpUserName
    }

    def getTestFtpPassword() : String = {
        return this.testFtpPassword
    }

    def getFtpPath() : String = {
        return this.ftpPath.toString()
    }

    def getTestFtpPath() : String = {
        return this.testFtpPath.toString()
    }

    def getTimeCreated() : String = {
        return this.timeCreated
    }

    def getLastModified() : String = {
        return this.lastModified
    }

    def setName(value : String) : Unit = {
        this.name = value
    }

    def setBasketName(value : String) : Unit = {
        this.basketName = value
    }

    def setHomeHostName(value : String) : Unit = {
        this.homeHostName = value
    }

    def setHomeHostNamePath(value : String) : Unit = {
        this.homeHostNamePath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setHostName(value : String) : Unit = {
        this.hostName = value
    }

    def setHostNamePath(value : String) : Unit = {
        this.hostNamePath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setTestHomeHostName(value : String) : Unit = {
        this.testHomeHostName = value
    }

    def setTestHomeHostNamePath(value : String) : Unit = {
        this.testHomeHostNamePath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setTestHostName(value : String) : Unit = {
        this.testHostName = value
    }

    def setTestHostNamePath(value : String) : Unit = {
        this.testHostNamePath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setImagePath(value : String) : Unit = {
        this.imagePath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setStaticPath(value : String) : Unit = {
        this.staticPath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setCategoryPath(value : String) : Unit = {
        this.categoryPath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setSubStores(value : String) : Unit = {
        this.subStores = value
    }

    def setTagLocation(value : String) : Unit = {
        this.tagLocation = value
    }

    def setPackageLocation(value : String) : Unit = {
        this.packageLocation = value
    }

    def setInventoryControl(value : String) : Unit = {
        this.inventoryControl = value
    }

    def getPackageLocation(value : String) : Unit = {
        this.packageLocation = value
    }

    def setFtp(value : String) : Unit = {
        this.ftp = value
    }

    def setFtpUserName(value : String) : Unit = {
        this.ftpUserName = value
    }

    def setFtpPassword(value : String) : Unit = {
        this.ftpPassword = value
    }

    def setTestFtp(value : String) : Unit = {
        this.testFtp = value
    }

    def setTestFtpUserName(value : String) : Unit = {
        this.testFtpUserName = value
    }

    def setTestFtpPassword(value : String) : Unit = {
        this.testFtpPassword = value
    }

    def setTimeCreated(value : String) : Unit = {
        this.timeCreated = value
    }

    def setLastModified(value : String) : Unit = {
        this.lastModified = value
    }

    def setFtpPath(value : String) : Unit = {
        this.ftpPath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    def setTestFtpPath(value : String) : Unit = {
        this.testFtpPath = new AbPath(value, StringUtil.getInstance().EMPTY_STRING)
    }

    private def createDirectories() : Boolean = {
        //use storename as man directory
        var storeAbPath : AbPath = new AbPath(URLGLOBALS.getWebappPath() + this.getCurrentHomeHostNamePath(), StringUtil.getInstance().EMPTY_STRING)
        if (!this.directory.create(storeAbPath)) {
            return false
        }
        if (!this.directory.create(new AbPath(String.valueOf(storeAbPath) + this.getCategoryPath(), StringUtil.getInstance().EMPTY_STRING))) {
            return false
        }
        /*         if(!Directory.create(storeAbPath + this.getImagePath()))         return false;          */
        if (!this.directory.create(new AbPath(String.valueOf(storeAbPath) + this.getStaticPath(), StringUtil.getInstance().EMPTY_STRING))) {
            return false
        }
        return true
    }

    //Create directories and copy files for store installation
    def install(current : Int, total : Int) : Unit = {
        try {
            //create new store directories if they do not already exist
            if (!this.createDirectories()) {
                throw new Exception("Unable to create store directories")
            }
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append(URLGLOBALS.getMainPath())
            stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
            val viewPath : String = stringBuffer.toString()
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append(viewPath)
            stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().INSTALLPATH)
            val fromDirectoryAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append(viewPath)
            stringBuffer.append("special")
            stringBuffer.append(AbPathData.getInstance().SEPARATOR)
            val fromSpecialDirectoryAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append(viewPath)
            stringBuffer.append(this.getName())
            stringBuffer.append(AbPathData.getInstance().SEPARATOR)
            val toDirectoryAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
            if (current == 0) {
                if (!this.directory.create(toDirectoryAbPath)) {
                    throw new Exception("Unable to create store view directory: " + toDirectoryAbPath.toString())
                }
            }
            val viewTotal : Int = (total * 85) / 100
            val installTotal : Int = (total * 93) / 100
            if (current < viewTotal) {
                val file : AbFile = AbFile.createAbFileFromAbPath(fromSpecialDirectoryAbPath)
                if (file.isDirectory()) {
                    var halfViewTotal : Int = viewTotal / 2
                    if (current < halfViewTotal) {
                        this.installViews(fromSpecialDirectoryAbPath, toDirectoryAbPath, current, halfViewTotal)
                    } else if (current < viewTotal) {
                        this.installViews(fromDirectoryAbPath, toDirectoryAbPath, current - halfViewTotal, viewTotal - halfViewTotal)
                    }
                } else {
                    this.installViews(fromDirectoryAbPath, toDirectoryAbPath, current, viewTotal)
                }
            } else if (current < installTotal) {
                this.installResources(fromDirectoryAbPath, current - viewTotal, installTotal - viewTotal)
            } else {
                this.installMedia(fromDirectoryAbPath, current - installTotal, total - installTotal)
            }
        } catch {
            case e : Exception => {
                //String error = "Failed to install storefront";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "install()", e)
                }
                throw e
            }
        }
    }

    private def installViews(fromDirectoryAbPath : AbPath, toDirectoryAbPath : AbPath, current : Int, total : Int) : Unit = {
        //copy install template/view files for new store
        FileUtil.getInstance().copyDirectoryPortion(fromDirectoryAbPath, toDirectoryAbPath, true, false, current, total)
    }

    private def installResources(fromDirectoryAbPath : AbPath, current : Int, total : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        //Copy in default Resources
        stringBuffer.append(fromDirectoryAbPath.toString())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append("Resources")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        val installCategoryAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(this.getCurrentHomeHostNamePath())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append(this.getCategoryPath())
        val categoryAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
        FileUtil.getInstance().copyDirectoryPortion(installCategoryAbPath, categoryAbPath, true, false, current, total)
    }

    private def installMedia(fromDirectoryAbPath : AbPath, current : Int, total : Int) : Unit = {
        // CategoryData.ENCRYPTED_EXTENSION);
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(fromDirectoryAbPath.toString())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().TEMPLATEPATH)
        stringBuffer.append("images")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        val viewStoreImagesDirectoryAbPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
        val storeAbPath : AbPath = new AbPath(URLGLOBALS.getWebappPath() + this.getCurrentHomeHostNamePath(), StringUtil.getInstance().EMPTY_STRING)
        FileUtil.getInstance().copyDirectoryPortion(viewStoreImagesDirectoryAbPath, storeAbPath, true, false, current, total)
    }

    def toVector() : BasicArrayList = {
        val dataVector : BasicArrayList = new BasicArrayListD()
        dataVector.add(this.name)
        dataVector.add(this.homeHostName)
        dataVector.add(this.homeHostNamePath.toString())
        dataVector.add(this.hostName)
        dataVector.add(this.hostNamePath.toString())
        dataVector.add(this.testHomeHostName)
        dataVector.add(this.testHomeHostNamePath.toString())
        dataVector.add(this.testHostName)
        dataVector.add(this.testHostNamePath.toString())
        dataVector.add(this.imagePath.toString())
        dataVector.add(this.staticPath.toString())
        dataVector.add(this.categoryPath.toString())
        dataVector.add(this.inventoryControl)
        val contextConfigurationDomDocumentMapping : ContextConfigurationDomDocumentMapping = new ContextConfigurationDomDocumentMapping(this.getContextConfigurationInterface())
        dataVector.add(contextConfigurationDomDocumentMapping.toDomDocumentString())
        dataVector.add(this.subStores)
        dataVector.add(this.tagLocation)
        dataVector.add(this.packageLocation)
        dataVector.add(this.ftp)
        dataVector.add(this.ftpPath.toString())
        dataVector.add(this.ftpUserName)
        dataVector.add(this.ftpPassword)
        dataVector.add(this.testFtp)
        dataVector.add(this.testFtpPath.toString())
        dataVector.add(this.testFtpUserName)
        dataVector.add(this.testFtpPassword)
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        dataVector.add(time)
        dataVector.add(time)
        return dataVector
    }

    def toHashMap() : HashMap[Object, Object] = {
        val storeFrontData : StoreFrontData = StoreFrontData.getInstance()
        val dataHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        dataHashMap.put(storeFrontData.NAME, this.name)
        dataHashMap.put(storeFrontData.HOMEHOSTNAME, this.homeHostName)
        dataHashMap.put(storeFrontData.HOMEHOSTNAMEPATH, this.homeHostNamePath.toString())
        dataHashMap.put(storeFrontData.HOSTNAME, this.hostName)
        dataHashMap.put(storeFrontData.HOSTNAMEPATH, this.hostNamePath.toString())
        dataHashMap.put(storeFrontData.TESTHOMEHOSTNAME, this.testHomeHostName)
        dataHashMap.put(storeFrontData.TESTHOMEHOSTNAMEPATH, this.testHomeHostNamePath.toString())
        dataHashMap.put(storeFrontData.TESTHOSTNAME, this.testHostName)
        dataHashMap.put(storeFrontData.TESTHOSTNAMEPATH, this.testHostNamePath.toString())
        dataHashMap.put(storeFrontData.IMAGEPATH, this.imagePath.toString())
        dataHashMap.put(storeFrontData.STATICPATH, this.staticPath.toString())
        dataHashMap.put(storeFrontData.CATEGORYPATH, this.categoryPath.toString())
        dataHashMap.put(storeFrontData.INVENTORYCONTROL, this.inventoryControl)
        var contextConfigurationDomDocumentMapping : ContextConfigurationDomDocumentMapping = new ContextConfigurationDomDocumentMapping(this.getContextConfigurationInterface())
        dataHashMap.put(storeFrontData.CONFIGURATION, contextConfigurationDomDocumentMapping.toDomDocumentString())
        dataHashMap.put(storeFrontData.SUBSTORES, this.subStores)
        dataHashMap.put(storeFrontData.TAGLOCATION, this.tagLocation)
        dataHashMap.put(storeFrontData.PACKAGELOCATION, this.packageLocation)
        dataHashMap.put(storeFrontData.FTP, this.ftp)
        dataHashMap.put(storeFrontData.FTPPATH, this.ftpPath.toString())
        dataHashMap.put(storeFrontData.FTPUSERNAME, this.ftpUserName)
        dataHashMap.put(storeFrontData.FTPPASSWORD, this.ftpPassword)
        dataHashMap.put(storeFrontData.TESTFTP, this.testFtp)
        dataHashMap.put(storeFrontData.TESTFTPPATH, this.testFtpPath.toString())
        dataHashMap.put(storeFrontData.TESTFTPUSERNAME, this.testFtpUserName)
        dataHashMap.put(storeFrontData.TESTFTPPASSWORD, this.testFtpPassword)
        val calendar : Calendar = Calendar.getInstance()
        val time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        dataHashMap.put(EntryData.getInstance().LASTMODIFIED, time)
        return dataHashMap
    }

    def getKey() : Object = {
        return this.getName().asInstanceOf[Object]
    }

    def getContextConfigurationInterface() : ContextConfigurationInterface = {
        return this.contextConfigurationInterface
    }

    def setContextConfigurationInterface(contextConfigurationInterface : ContextConfigurationInterface) : Unit = {
        this.contextConfigurationInterface = contextConfigurationInterface
    }

}

object StoreFront {
    private val RESOURCES : String = " Resources" + AbPathData.getInstance().SEPARATOR

}


