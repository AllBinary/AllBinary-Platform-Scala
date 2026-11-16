/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.configuration

import _root_.javax.xml.bind.annotation.XmlAccessType
import _root_.javax.xml.bind.annotation.XmlAccessorType
import _root_.javax.xml.bind.annotation.XmlElement
import _root_.javax.xml.bind.annotation.XmlRootElement
import _root_.javax.xml.bind.annotation.XmlType
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.automation.InputAutomationData
import _root_.org.allbinary.input.automation.module.InputAutomationModuleData
import _root_.org.allbinary.input.automation.module.InputAutomationModuleFactoryInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "INPUT_AUTOMATION_MODULE")
@XmlType(name = "InputAutomationModuleConfiguration")
class InputAutomationModuleConfiguration() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    @XmlElement(name = "DYNAMICCOMPONENT_NAME")
    private var className : String = null

    private var name : String = null

    private var inputAutomationModuleInterface : InputAutomationModuleFactoryInterface = null

    def this(abeClientInformation : AbeClientInformationInterface, name : String, className : String) = {
        this()
        this.setName(name)
        this.setClassName(className)
        this.init(abeClientInformation)
    }

    def this(abeClientInformation : AbeClientInformationInterface, node : Node) = {
        this()
        this.init(abeClientInformation, node)
    }

    def this(inputAutomationModuleInterface : InputAutomationModuleFactoryInterface) = {
        this()
        this.setInputAutomationModuleInterface(inputAutomationModuleInterface)
        this.setClassName(this.inputAutomationModuleInterface.getClass().getName())
    }

    def init(abeClientInformation : AbeClientInformationInterface, node : Node) : Unit = {
        var nodeList : NodeList = node.getChildNodes()
        if (nodeList != null) {
            var classNameNode : Node = DomSearchHelper.getNode(DynamicObjectData.NAME, nodeList)
            if (classNameNode != null) {
                this.setClassName(DomNodeHelper.getTextNodeValue(classNameNode))
                /*                     JarFile jarFile = new JarFile(fileName);                     jarFile.entries();                     JarEntry jarEntry =                     jarEntry.getAttributes().                                      */
                this.init(abeClientInformation)
            } else {
                this.logUtil.putF("Class Node Null", this, this.commonStrings.INIT)
            }
        } else {
            this.logUtil.putF(InputAutomationData.NAME + " Node Has No Children", this, "Contructor")
        }
    }

    def init(abeClientInformation : AbeClientInformationInterface) : Unit = {
        try {
            this.logUtil.putF("Name: " + getName(), this, this.commonStrings.INIT)
            this.logUtil.putF("ClassName: " + className, this, this.commonStrings.INIT)
            this.setInputAutomationModuleInterface(AbeFactory.getInstance().getInstance(abeClientInformation, getClassName()).asInstanceOf[InputAutomationModuleFactoryInterface])
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
                throw new RuntimeException()
            }
        }
    }

    def toDomNode(document : Document) : Node = {
        var node : Node = document.createElement(InputAutomationModuleData.NAME)
        var classNameNode : Node = ModDomHelper.createTextNode(document, DynamicObjectData.NAME, this.getClassName())
        node.appendChild(classNameNode)
        return node
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.logUtil.putF("Name: " + name, this, "setName")
        this.name = name
    }

    def getClassName() : String = {
        return this.className
    }

    def setClassName(className : String) : Unit = {
        this.logUtil.putF("ClassName : " + className, this, "setClassName")
        this.className = className
    }

    def getInputAutomationModuleInterface() : InputAutomationModuleFactoryInterface = {
        return this.inputAutomationModuleInterface
    }

    def setInputAutomationModuleInterface(inputAutomationModuleInterface : InputAutomationModuleFactoryInterface) : Unit = {
        this.logUtil.putF("InputAutomationModuleFactoryInterface : " + inputAutomationModuleInterface, this, "setInputAutomationModuleInterface")
        this.inputAutomationModuleInterface = inputAutomationModuleInterface
        this.setName(this.inputAutomationModuleInterface.getName())
    }

}


