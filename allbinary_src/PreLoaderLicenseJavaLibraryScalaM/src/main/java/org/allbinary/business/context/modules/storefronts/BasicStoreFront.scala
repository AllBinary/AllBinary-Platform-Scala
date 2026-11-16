/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefronts

import _root_.java.util.HashMap
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicStoreFront() extends BasicStoreFrontInterface {

    private var name : String = null

    private var userName : String = null

    private var basketName : String = null

    private var homeHostName : String = null

    private var homeHostNamePath : String = null

    private var hostName : String = null

    private var hostNamePath : String = null

    private var testHomeHostName : String = null

    private var testHomeHostNamePath : String = null

    private var testHostName : String = null

    private var testHostNamePath : String = null

    private var imagePath : String = null

    private var staticPath : String = null

    private var categoryPath : String = null

    private var inventoryControl : String = null

    private var subStores : String = null

    private var tagLocation : String = null

    private var packageLocation : String = null

    private var ftp : String = null

    private var ftpPath : String = null

    private var ftpUserName : String = null

    private var ftpPassword : String = null

    private var testFtp : String = null

    private var testFtpPath : String = null

    private var testFtpUserName : String = null

    private var testFtpPassword : String = null

    private var timeCreated : String = null

    private var lastModified : String = null

    def this(storeHashMap : HashMap[Object, Object]) = {
        this()
        var storeFrontData : StoreFrontData = StoreFrontData.getInstance()
        this.name = storeHashMap.get(storeFrontData.NAME).asInstanceOf[String]
        this.userName = storeHashMap.get(UserData.USERNAME).asInstanceOf[String]
        this.basketName = storeHashMap.get(storeFrontData.NAME).asInstanceOf[String]
        this.homeHostName = storeHashMap.get(storeFrontData.HOMEHOSTNAME).asInstanceOf[String]
        this.homeHostNamePath = storeHashMap.get(storeFrontData.HOMEHOSTNAMEPATH).asInstanceOf[String]
        this.hostName = storeHashMap.get(storeFrontData.HOSTNAME).asInstanceOf[String]
        this.hostNamePath = storeHashMap.get(storeFrontData.HOSTNAMEPATH).asInstanceOf[String]
        this.testHomeHostName = storeHashMap.get(storeFrontData.TESTHOMEHOSTNAME).asInstanceOf[String]
        this.testHomeHostNamePath = storeHashMap.get(storeFrontData.TESTHOMEHOSTNAMEPATH).asInstanceOf[String]
        this.testHostName = storeHashMap.get(storeFrontData.TESTHOSTNAME).asInstanceOf[String]
        this.testHostNamePath = storeHashMap.get(storeFrontData.TESTHOSTNAMEPATH).asInstanceOf[String]
        this.imagePath = storeHashMap.get(storeFrontData.IMAGEPATH).asInstanceOf[String]
        this.staticPath = storeHashMap.get(storeFrontData.STATICPATH).asInstanceOf[String]
        this.categoryPath = storeHashMap.get(storeFrontData.CATEGORYPATH).asInstanceOf[String]
        this.inventoryControl = storeHashMap.get(storeFrontData.INVENTORYCONTROL).asInstanceOf[String]
        this.subStores = storeHashMap.get(storeFrontData.SUBSTORES).asInstanceOf[String]
        this.tagLocation = storeHashMap.get(storeFrontData.TAGLOCATION).asInstanceOf[String]
        this.packageLocation = storeHashMap.get(storeFrontData.PACKAGELOCATION).asInstanceOf[String]
        this.ftp = storeHashMap.get(storeFrontData.FTP).asInstanceOf[String]
        this.ftpPath = storeHashMap.get(storeFrontData.FTPPATH).asInstanceOf[String]
        this.ftpUserName = storeHashMap.get(storeFrontData.FTPUSERNAME).asInstanceOf[String]
        this.ftpPassword = storeHashMap.get(storeFrontData.FTPPASSWORD).asInstanceOf[String]
        this.testFtp = storeHashMap.get(storeFrontData.TESTFTP).asInstanceOf[String]
        this.testFtpPath = storeHashMap.get(storeFrontData.TESTFTPPATH).asInstanceOf[String]
        this.testFtpUserName = storeHashMap.get(storeFrontData.TESTFTPUSERNAME).asInstanceOf[String]
        this.testFtpPassword = storeHashMap.get(storeFrontData.TESTFTPPASSWORD).asInstanceOf[String]
        this.timeCreated = storeHashMap.get(EntryData.getInstance().TIMECREATED).asInstanceOf[String]
        this.lastModified = storeHashMap.get(EntryData.getInstance().LASTMODIFIED).asInstanceOf[String]
    }

    //these files should be copied to the real server + staticpages path probably with ftp
    def getTestHtmlPath() : String = {
        //in testing mode return the test location else return the working location
        return String.valueOf(_root_.org.allbinary.globals.URLGLOBALS.getTestHtmlPath()) + this.getCurrentHostNamePath()
    }

    def getCurrentHostName() : String = {
        var location : String = null
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHostName()
        } else {
            location = this.getHostName()
        }
        return location
    }

    def getCurrentHostNamePath() : String = {
        var location : String = null
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHostNamePath()
        } else {
            location = this.getHostNamePath()
        }
        return location
    }

    def getCurrentHomeHostName() : String = {
        var location : String = null
        //in testing mode return the test location else return the working location
        if (_root_.org.allbinary.globals.URLGLOBALS.isTestingMode()) {
            location = this.getTestHomeHostName()
        } else {
            location = this.getHomeHostName()
        }
        return location
    }

    def getCurrentHomeHostNamePath() : String = {
        var location : String = null
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

    def getUserName() : String = {
        return this.userName
    }

    def getBasketName() : String = {
        return this.basketName
    }

    def getHomeHostName() : String = {
        return this.homeHostName
    }

    def getHomeHostNamePath() : String = {
        return this.homeHostNamePath
    }

    def getHostName() : String = {
        return this.hostName
    }

    def getHostNamePath() : String = {
        return this.hostNamePath
    }

    def getTestHomeHostName() : String = {
        return this.testHomeHostName
    }

    def getTestHomeHostNamePath() : String = {
        return this.testHomeHostNamePath
    }

    def getTestHostName() : String = {
        return this.testHostName
    }

    def getTestHostNamePath() : String = {
        return this.testHostNamePath
    }

    /*    public String getImagePath()    {       return this.imagePath;    }    */
    def getStaticPath() : String = {
        return this.staticPath
    }

    def getCategoryPath() : String = {
        return this.categoryPath
    }

    def getInventoryControl() : String = {
        return this.inventoryControl
    }

    def getSubStores() : BasicArrayList = {
        try {
            var tokenizer : Tokenizer = new Tokenizer(CommonSeps.getInstance().SEMICOLON)
            var subStoreVector : BasicArrayList = tokenizer.getTokensFromString(this.subStores, new BasicArrayListD())
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
        return this.ftpPath
    }

    def getTestFtpPath() : String = {
        return this.testFtpPath
    }

    def getTimeCreated() : String = {
        return this.timeCreated
    }

    def getLastModified() : String = {
        return this.lastModified
    }

}


