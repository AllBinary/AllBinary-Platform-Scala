/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.configuration

import _root_.java.io.File
import _root_.java.io.FileInputStream
import _root_.java.util.HashMap
import _root_.java.util.List
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.input.automation.module.InputAutomationModuleData
import _root_.org.allbinary.input.automation.module.NewInputAutomationModulesData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class InputAutomationModuleConfigurations() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var hashMap : HashMap[Object, Object] = null

    //Constructor
    {
        this.setHashMap(new HashMap[Object, Object]())
    }

    def this(abeClientInformation : AbeClientInformationInterface, file : File) = {
        this()
        this.setHashMap(new HashMap[Object, Object]())
        val bytes : Array[Byte] = new Array[Byte](100000)
        val idFile : FileInputStream = new FileInputStream(file)
        val length : Int = idFile.read(bytes)
        val data : String = new String(bytes)
        val endIndex : Int = data.lastIndexOf('>')
        val document : Document = DomDocumentHelper.create(data.substring(0, endIndex + 1))
        val nodeList : NodeList = document.getElementsByTagName(NewInputAutomationModulesData.NAME)
        if (nodeList.getLength() > 0) {
            val nameNodeList : NodeList = document.getElementsByTagName(InputAutomationModuleData.NAME)
            this.logUtil.putF("Number Of Module(s) Specified: " + nameNodeList.getLength(), this, "Contructor")

            {
                var index : Int = 0
                while (index < nameNodeList.getLength()) {
                    val node : Node = nameNodeList.item(index)
                    this.add(new InputAutomationModuleConfiguration(abeClientInformation, node))
                    index += 1
                }
            }
        }
    }

    def this(abeClientInformation : AbeClientInformationInterface, document : Document) = {
        this()
        this.setHashMap(new HashMap[Object, Object]())
        val nameNodeList : NodeList = document.getElementsByTagName(InputAutomationModuleData.NAME)
        this.logUtil.putF("Number Of Module(s) Specified: " + nameNodeList.getLength(), this, "Contructor")

        {
            var index : Int = 0
            while (index < nameNodeList.getLength()) {
                var node : Node = nameNodeList.item(index)
                this.add(new InputAutomationModuleConfiguration(abeClientInformation, node))
                index += 1
            }
        }
    }

    def this(inputAutomationModuleConfigurationList : List[InputAutomationModuleConfiguration]) = {
        this()
        this.setHashMap(new HashMap[Object, Object]())
        val size : Int = inputAutomationModuleConfigurationList.size()
        var inputAutomationModuleConfiguration : InputAutomationModuleConfiguration = null

        {
            var index : Int = 0
            while (index < size) {
                inputAutomationModuleConfiguration = inputAutomationModuleConfigurationList.get(index)
                this.add(inputAutomationModuleConfiguration)
                index += 1
            }
        }
    }

    def add(inputAutomationModuleConfiguration : InputAutomationModuleConfiguration) : Unit = {
        this.getHashMap().put(inputAutomationModuleConfiguration.getClassName(), inputAutomationModuleConfiguration)
    }

    def remove(inputAutomationModuleConfiguration : InputAutomationModuleConfiguration) : Unit = {
        this.getHashMap().remove(inputAutomationModuleConfiguration.getClassName())
    }

    def getHashMap() : HashMap[Object, Object] = {
        return this.hashMap
    }

    def setHashMap(hashMap : HashMap[Object, Object]) : Unit = {
        this.hashMap = hashMap
    }

}


