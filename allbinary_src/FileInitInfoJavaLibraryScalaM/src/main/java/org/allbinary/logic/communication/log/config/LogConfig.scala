/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config

import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigType
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeData
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypesData
import _root_.org.allbinary.logic.io.AbFileLocalInputStream
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.java.bool.BooleanUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class LogConfig private () {

    private var isEnabled_LogConfig : Boolean = false

    private var name : String = null

    private var description : String = null

    private var path : String = null

    private var fileName : String = null

    def this(aName : String, aDescription : String, aPath : String, aFileName : String) = {
        this()
        this.isEnabled_LogConfig = false
        this.name = aName
        this.description = aDescription
        this.path = aPath
        this.fileName = aFileName
    }

    def this(node : Node) = {
        this()
        var enabledValueNode : Node = DomSearchHelper.getNode(EntryData.getInstance().ENABLE, node.getChildNodes())
        var isEnabledString : String = DomNodeHelper.getTextNodeValue(enabledValueNode)
        this.isEnabled_LogConfig = BooleanUtil.getInstance().getFromString(isEnabledString)
        var logConfigData : LogConfigData = LogConfigData.getInstance()
        var nameValueNode : Node = DomSearchHelper.getNode(logConfigData.NAME, node.getChildNodes())
        this.name = DomNodeHelper.getTextNodeValue(nameValueNode)
        var descriptionValueNode : Node = DomSearchHelper.getNode(logConfigData.DESCRIPTION, node.getChildNodes())
        this.description = DomNodeHelper.getTextNodeValue(descriptionValueNode)
        /*         Node pathValueNode =         DomSearchHelper.getNode(logConfigData.PATH, node.getChildNodes());         this.path =         DomNodeHelper.getTextNodeValue(pathValueNode);          */
        var fileValueNode : Node = DomSearchHelper.getNode(logConfigData.FILE, node.getChildNodes())
        this.fileName = DomNodeHelper.getTextNodeValue(fileValueNode)
    }

    def getName() : String = {
        return this.name
    }

    def isEnabled() : Boolean = {
        return this.isEnabled_LogConfig
    }

    def enable() : Unit = {
        this.isEnabled_LogConfig = true
    }

    def disable() : Unit = {
        this.isEnabled_LogConfig = false
    }

    def getDescription() : String = {
        return this.description
    }

    /*     public String getPath()     {     return this.path;     }      */
    def getFileName() : String = {
        return this.fileName
    }

    def setName(value : String) : Unit = {
        this.name = value
    }

    def setDescription(value : String) : Unit = {
        this.description = value
    }

    def setPath(value : String) : Unit = {
        this.path = value
    }

    def setFileName(value : String) : Unit = {
        this.fileName = value
    }

    private def getDoc() : Document = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getWebappPath())
        //this.getPath() +
        stringBuffer.append(PATH_GLOBALS.getInstance().INIT_PATH)
        stringBuffer.append(this.getFileName())
        var file : AbFile = AbFile.createAbFile(stringBuffer.toString())
        var document : Document = DomDocumentHelper.create(new AbFileLocalInputStream(file))
        return document
    }

    def getTypeVector() : BasicArrayList = {
        var logKeyVector : BasicArrayList = new BasicArrayListD()
        var document : Document = this.getDoc()
        var logConfigTypesNodeList : NodeList = document.getElementsByTagName(LogConfigTypesData.getInstance().NAME)
        var logConfigTypesNode : Node = logConfigTypesNodeList.item(0)
        var logConfigTypeNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(LogConfigTypeData.getInstance().NAME, logConfigTypesNode.getChildNodes())
        val size : Int = logConfigTypeNodeVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var node : Node = logConfigTypeNodeVector.get(i).asInstanceOf[Node]
                var logType : LogConfigType = LogConfigTypes.getInstance(node)
                logKeyVector.add(logType)
                i += 1
            }
        }
        return logKeyVector
    }

}


