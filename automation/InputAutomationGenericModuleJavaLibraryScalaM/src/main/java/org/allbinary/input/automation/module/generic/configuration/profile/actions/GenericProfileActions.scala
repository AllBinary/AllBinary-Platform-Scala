/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions

import _root_.java.io.DataOutputStream
import _root_.java.io.File
import _root_.java.io.FileInputStream
import _root_.java.io.FileOutputStream
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.mapping.DomDocumentMappingInterface
import _root_.org.allbinary.input.automation.module.DefaultListModelHelper
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfiles
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.CommonDataFileStrings
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class GenericProfileActions private () extends DomNodeInterface with DomDocumentMappingInterface {
    import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActions.{DEFAULT_PROFILE_ACTIONS_PATH as _, *}
    def DEFAULT_PROFILE_ACTIONS_PATH : String = _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActions.DEFAULT_PROFILE_ACTIONS_PATH

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonFileStrings : CommonDataFileStrings = CommonDataFileStrings.getInstance()

    private var name : String = null

    private var genericProfileActionsJPanel : GenericProfileActionsJPanel = null

    private var actionsDefaultListModelHelper : DefaultListModelHelper = null

    private var hashMap : HashMap[Object, Object] = null

    def this(genericProfileActionsJPanel : GenericProfileActionsJPanel, abPath : AbPath, name : String) = {
        this()
        this.setName(name)
        this.init(genericProfileActionsJPanel)
        this.load()
    }

    def this(genericProfileActionsJPanel : GenericProfileActionsJPanel, fileInputStream : FileInputStream, name : String) = {
        this()
        this.setName(name)
        this.init(genericProfileActionsJPanel)
        this.fileInit(fileInputStream)
    }

    def this(genericProfileActionsJPanel : GenericProfileActionsJPanel, name : String) = {
        this()
        this.setName(name)
        this.init(genericProfileActionsJPanel)
        this.load()
    }

    private def init(genericProfileActionsJPanel : GenericProfileActionsJPanel) : Unit = {
        this.setGenericProfileActionsJPanel(genericProfileActionsJPanel)
        this.actionsDefaultListModelHelper = new DefaultListModelHelper()
        this.setHashMap(new HashMap[Object, Object]())
    }

    def save() : Unit = {
        var idFile : FileOutputStream = new FileOutputStream((GenericProfileActions.DEFAULT_PROFILE_ACTIONS_PATH + getName()) + this.commonFileStrings._XML)
        var idOutData : DataOutputStream = new DataOutputStream(idFile)
        idOutData.writeBytes(XmlDocumentHelper.toString(this.toXmlDoc()))
    }

    def getFile(name : String) : File = {
        var fileName : String = (DEFAULT_PROFILE_ACTIONS_PATH + name) + this.commonFileStrings._XML
        return new File(fileName)
    }

    private def load() : Unit = {
        var file : File = this.getFile(getName())
        if (file.isFile()) {
            var idFile : FileInputStream = new FileInputStream(file)
            this.fileInit(idFile)
        } else {
            this.logUtil.putF("No Profile: " + file.getAbsolutePath(), this, "Contructor")
        }
    }

    private def fileInit(fileInputStream : FileInputStream) : Unit = {
        var bytes : Array[Byte] = new Array[Byte](100000)
        var length : Int = fileInputStream.read(bytes)
        var data : String = new String(bytes)
        var endIndex : Int = data.lastIndexOf('>')
        var document : Document = DomDocumentHelper.create(data.substring(0, endIndex + 1))
        var nameNodeList : NodeList = document.getElementsByTagName(GenericProfileActionsData.NAME)
        this.logUtil.putF("Number Of Profiles Specified: " + nameNodeList.getLength(), this, "Contructor")

        {
            var index : Int = 0
            while (index < nameNodeList.getLength()) {
                var node : Node = nameNodeList.item(index)
                var nodeList : NodeList = node.getChildNodes()
                if (nodeList != null) {
                    this.initActions(nodeList)
                } else {
                    throw new Exception(GenericProfileActionData.NAME + " Name Node Node Children")
                }
                index += 1
            }
        }
        this.logUtil.putF(("Loaded: " + this.getHashMap().size()) + " Configuration Profile Action(s)", this, "Contructor")
        this.getDefaultListModelHelper().initDefaultModelList()
    }

    private def initActions(nodeList : NodeList) : Unit = {

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var actionNode : Node = nodeList.item(index)
                //GenericProfileActionData.NAME
                if (actionNode != null) {
                    var genericConfigurationProfileAction : GenericProfileAction = new GenericProfileAction(this.getGenericProfileActionsJPanel().getGenericProfileActionJPanel(), actionNode)
                    this.getHashMap().put(genericConfigurationProfileAction.getName(), genericConfigurationProfileAction)
                    this.getDefaultListModelHelper().add(genericConfigurationProfileAction.getName())
                } else {
                    throw new Exception(GenericProfileActionData.NAME + " Node Null")
                }
                index += 1
            }
        }
    }

    def getDefaultListModelHelper() : DefaultListModelHelper = {
        return this.actionsDefaultListModelHelper
    }

    def getAction(string : String) : GenericProfileAction = {
        return this.getHashMap().get(string).asInstanceOf[GenericProfileAction]
    }

    def add(name : String) : Unit = {
        var genericProfileAction : GenericProfileAction = new GenericProfileAction(name)
        this.getHashMap().put(genericProfileAction.getName(), genericProfileAction)
        this.getDefaultListModelHelper().add(genericProfileAction.getName())
        this.getDefaultListModelHelper().initDefaultModelList()
        this.save()
    }

    def remove(name : String) : Unit = {
        this.getHashMap().remove(name)
        this.getDefaultListModelHelper().remove(name)
        this.getDefaultListModelHelper().initDefaultModelList()
        this.save()
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.logUtil.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GenericProfileActionsData.NAME)
        var set : Set[Object] = this.getHashMap().keySet().asInstanceOf[Set[Object]]
        val actionNameArray : Array[Object] = set.toArray()
        val size : Int = actionNameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var nextActionName : String = actionNameArray(index).asInstanceOf[String]
                var nextGenericProfileAction : GenericProfileAction = this.getAction(nextActionName).asInstanceOf[GenericProfileAction]
                node.appendChild(nextGenericProfileAction.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

    def toXmlDoc() : Document = {
        var document : Document = DomDocumentHelper.create()
        var node : Node = this.toXmlNode(document)
        document.appendChild(node)
        return document
    }

    def getGenericProfileActionsJPanel() : GenericProfileActionsJPanel = {
        return this.genericProfileActionsJPanel
    }

    def setGenericProfileActionsJPanel(genericProfileActionsJPanel : GenericProfileActionsJPanel) : Unit = {
        this.genericProfileActionsJPanel = genericProfileActionsJPanel
    }

    def getHashMap() : HashMap[Object, Object] = {
        return this.hashMap
    }

    def setHashMap(hashMap : HashMap[Object, Object]) : Unit = {
        this.hashMap = hashMap
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

}

object GenericProfileActions {
    val DEFAULT_PROFILE_ACTIONS_PATH : String = GenericProfiles.DEFAULT_PROFILES_PATH + "actions/"

}


