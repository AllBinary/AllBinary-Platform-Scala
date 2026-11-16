/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config

import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.io.AbFileLocalInputStream
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class LoggingInitInfo() {
    import _root_.org.allbinary.logic.communication.log.config.LoggingInitInfo.{*}

    def isValid() : Boolean = {
        try {
            return true
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    def getNumberOfLogConfigs() : Int = {
        return LoggingInitInfo.logConfigInfoList.size()
    }

    override def toString() : String = {
        try {
            val document : Document = LoggingInitInfo.getDoc()
            return XmlDocumentHelper.toString(document)
        } catch {
            case e : Exception => {
                return "Error"
            }
        }
        throw new IllegalStateException()
    }

}

object LoggingInitInfo {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val INITFILENAME : String = "logConfig.xml"

    private val PACKAGE : String = PATH_GLOBALS.getInstance().INIT_PATH

    private var logConfigInfoList : BasicArrayList = null

    private var hasRead : Boolean = false

    def getDoc() : Document = this.synchronized {
        //PreLogUtil.put("Package: " + PACKAGE, "LoggingInitInfo", "getDoc");
        val path : String = URLGLOBALS.getWebappPath() + LoggingInitInfo.PACKAGE
        val FILEABPATH : AbPath = new AbPath(path, INITFILENAME)
        //PreLogUtil.put("File Path: " + FILEABPATH, "LoggingInitInfo", "getDoc");
        val file : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
        val document : Document = DomDocumentHelper.create(new AbFileLocalInputStream(file))
        return document
    }

    def write() : Unit = this.synchronized {
        try {
            //write new logConfigFile
            LoggingInitInfo.hasRead = false
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    private def read() : Unit = this.synchronized {
        try {
            val document : Document = LoggingInitInfo.getDoc()
            val logConfigsNodeList : NodeList = document.getElementsByTagName(LogConfigsData.getInstance().NAME)
            val logConfigsNode : Node = logConfigsNodeList.item(0)
            val logConfigNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(LogConfigData.getInstance().NAME, logConfigsNode.getChildNodes())
            LoggingInitInfo.logConfigInfoList = new BasicArrayListD()
            val size : Int = logConfigNodeVector.size()

            {
                var i : Int = 0
                while (i < size) {
                    val node : Node = logConfigNodeVector.get(i).asInstanceOf[Node]
                    var logConfigInfo : LogConfig = new LogConfig(node)
                    LoggingInitInfo.logConfigInfoList.add(logConfigInfo)
                    i += 1
                }
            }
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    def setHasRead(value : Boolean) : Unit = this.synchronized {
        LoggingInitInfo.hasRead = value
    }

    private def updateIfNeeded() : Unit = this.synchronized {
        if (!LoggingInitInfo.hasRead) {
            LoggingInitInfo.read()
            LoggingInitInfo.hasRead = true
            if (LoggingInitInfo.logConfigInfoList == null) {
                throw new Exception("Read Failed")
            }
        }
    }

    def set(logConfigInfoVector : BasicArrayList) : Unit = this.synchronized {
        LoggingInitInfo.logConfigInfoList = logConfigInfoVector
    }

    def get() : BasicArrayList = {
        LoggingInitInfo.updateIfNeeded()
        return LoggingInitInfo.logConfigInfoList
    }

    def getTypeNameList() : BasicArrayList = {
        LoggingInitInfo.updateIfNeeded()
        var allLogTypeVector : BasicArrayList = new BasicArrayListD()
        val size : Int = LoggingInitInfo.logConfigInfoList.size()

        {
            var index : Int = 0
            while (index < size) {
                val logConfigInfo : LogConfig = LoggingInitInfo.logConfigInfoList.objectArray(index).asInstanceOf[LogConfig]
                var logTypeVector : BasicArrayList = logConfigInfo.getTypeVector()
                if (logConfigInfo.isEnabled()) {
                    allLogTypeVector.addAllList(logTypeVector)
                }
                index += 1
            }
        }
        return allLogTypeVector
    }

    def getTypeList() : BasicArrayList = {
        LoggingInitInfo.updateIfNeeded()
        val allLogTypeVector : BasicArrayList = new BasicArrayListD()
        val size : Int = LoggingInitInfo.logConfigInfoList.size()

        {
            var index : Int = 0
            while (index < size) {
                val logConfigInfo : LogConfig = LoggingInitInfo.logConfigInfoList.objectArray(index).asInstanceOf[LogConfig]
                val logTypeVector : BasicArrayList = logConfigInfo.getTypeVector()
                if (logConfigInfo.isEnabled()) {
                    allLogTypeVector.addAllList(logTypeVector)
                }
                index += 1
            }
        }
        return allLogTypeVector
    }

}


