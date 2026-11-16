/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.java.bool.BooleanUtil
import _root_.org.allbinary.logic.string.StringUtil

class InitInfo private() {
    import _root_.org.allbinary.business.init.InitInfo.{*}

    val TESTING : String = "TESTING"

    val MAINPATH : String = "MAINPATH"

    val TESTHTMLPATH : String = "TESTHTMLPATH"

    private var testing : String = null

    private var mainPath : AbPath = null

    //used to store newly generated pages before copied to specific storefront
    private var testHtmlPath : AbPath = null

    private var hasRead : Boolean = false

    /*    public InitData()    {       try       {          this.testing = "PathNotSet";          this.mainPath = "PathNotSet";          this.testHtmlPath = "PathNotSet";          webappPath = "PathNotSet";       }       catch(Exception e)       {            }    }     */
    def set() : Unit = this.synchronized {
        try {
            var initInfoEntity : InitInfoEntity = new InitInfoEntity()
            if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
                PreLogUtil.put("created entity", "InitInfo", "set()")
            }
            if (!initInfoEntity.is()) {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
                    PreLogUtil.put("adding", "InitInfo", "set()")
                }
                initInfoEntity.add()
            } else {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
                    PreLogUtil.put("update", "InitInfo", "set()")
                }
                initInfoEntity.update()
            }
            this.hasRead = false
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("error", "InitInfo", "set()", e)
                }
            }
        }
    }

    def set(hashMap : HashMap[Object, Object]) : Unit = this.synchronized {
        try {
            this.testing = hashMap.get(this.TESTING).asInstanceOf[String]
            this.mainPath = new AbPath(hashMap.get(this.MAINPATH).asInstanceOf[String], StringUtil.getInstance().EMPTY_STRING)
            this.testHtmlPath = new AbPath(hashMap.get(this.TESTHTMLPATH).asInstanceOf[String], StringUtil.getInstance().EMPTY_STRING)
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("error", "InitInfo", "set()", e)
                }
            }
        }
    }

    private def get() : Unit = this.synchronized {
        try {
            this.testing = null
            this.mainPath = null
            this.testHtmlPath = null
            var initInfoEntity : InitInfoEntity = new InitInfoEntity()
            initInfoEntity.get()
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("error", "InitInfo", "set()", e)
                }
                return
            }
        }
    }

    def setHasRead(value : Boolean) : Unit = this.synchronized {
        this.hasRead = value
    }

    private def updateIfNeeded() : Unit = this.synchronized {
        try {
            if (!this.hasRead) {
                this.hasRead = true
                this.get()
            }
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("error", "InitInfo", "updateIfNeeded()", e)
                }
                return
            }
        }
    }

    def isTesting() : Boolean = {
        try {
            this.updateIfNeeded()
            return BooleanUtil.getInstance().getFromString(this.testing)
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE("error", "InitInfo", "updateIfNeeded()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def getTesting() : String = {
        this.updateIfNeeded()
        return this.testing
    }

    def getTestHtmlPath() : String = {
        this.updateIfNeeded()
        if (this.testHtmlPath != null) {
            return this.testHtmlPath.toString()
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def getMainPath() : String = {
        this.updateIfNeeded()
        if (this.mainPath != null) {
            return this.mainPath.toString()
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def setTesting(value : String) : Unit = {
        this.testing = value
    }

    def setTestHtmlPath(value : AbPath) : Unit = {
        this.testHtmlPath = value
    }

    def setMainPath(value : AbPath) : Unit = {
        this.mainPath = value
    }

    def isMainPathValid(abPath : AbPath) : Boolean = {
        return true
    }

    def isTestHtmlPathValid(abPath : AbPath) : Boolean = {
        return true
    }

    def isTestingValid(testing : String) : Boolean = {
        return BooleanUtil.getInstance().isStringBoolean(testing)
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(this.TESTING, this.getTesting())
        hashMap.put(this.MAINPATH, this.getMainPath())
        hashMap.put(this.TESTHTMLPATH, this.getTestHtmlPath())
        return hashMap
    }

}

object InitInfo {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : InitInfo = new InitInfo()

    def getInstance() : InitInfo = {
        return InitInfo.instance
    }

}


