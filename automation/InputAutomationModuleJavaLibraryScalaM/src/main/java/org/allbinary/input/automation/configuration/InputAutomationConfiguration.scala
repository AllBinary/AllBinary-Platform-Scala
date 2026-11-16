/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.configuration

import _root_.java.io.File
import _root_.java.util.List
import _root_.javax.xml.bind.JAXBContext
import _root_.javax.xml.bind.Marshaller
import _root_.javax.xml.bind.annotation.XmlAccessType
import _root_.javax.xml.bind.annotation.XmlAccessorType
import _root_.javax.xml.bind.annotation.XmlElement
import _root_.javax.xml.bind.annotation.XmlRootElement
import _root_.javax.xml.bind.annotation.XmlType
import _root_.org.allbinary.data.tree.dom.document.DomDocumentFileHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfiguration
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.file.FileWrapperUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.w3c.dom.Document

//name="inputAutomationConfiguration", 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.allbinary.com/InputAutomationConfiguration")
@XmlType(name = "InputAutomationConfiguration")
class InputAutomationConfiguration() {
    import _root_.org.allbinary.input.automation.configuration.InputAutomationConfiguration.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    @XmlElement(name = "INPUT_AUTOMATION_INSTALLATION")
    private var installed : Boolean = false

    @XmlElement(name = "INPUT_AUTOMATION_MODULE")
    private var inputAutomationModuleConfigurationList : List[InputAutomationModuleConfiguration] = null

    /*     //Get create dom node from new module on the existing document     public void add(         InputAutomationModuleConfiguration inputAutomationModuleConfiguration)         throws Exception     {         this.logUtil.putF("Adding: " + inputAutomationModuleConfiguration.getName(), this, "add");          Node newNode = inputAutomationModuleConfiguration.toDomNode(             this.getDocument();         NodeList nodeList = this.getDocument().getElementsByTagName(             InputAutomationModulesData.NAME);                  if(nodeList.getLength() != 0)         {             Node node = nodeList.item(0);             node.appendChild(newNode);         }         else         {             throw new Exception("Unable to add new module");         }     }          public void remove(InputAutomationModuleFactoryInterface inputAutomationModuleInterface)         throws Exception     {         this.logUtil.putF("Removing: " + inputAutomationModuleInterface.getName(), this, "remove");          Document document = this.getDocument();                  Node modulesNode = document.getElementsByTagName(             InputAutomationModulesData.NAME).item(0);                  NodeList nameNodeList =             document.getElementsByTagName(InputAutomationModuleData.NAME);                  this.logUtil.putF("Number Of Module(s) Specified: " + nameNodeList.getLength(), this, "remove");                  for(int index = 0; index < nameNodeList.getLength(); index++)         {             Node node = nameNodeList.item(index);             NodeList nodeList = node.getChildNodes();                          if(nodeList!=null)             {                 Node classNameNode =                     DomSearchHelper.getNode(DynamicObjectData.NAME, nodeList);                                  if(classNameNode!=null)                 {                     String className =                         DomNodeHelper.getTextNodeValue(classNameNode);                                          this.logUtil.putF("Name : " + className, this, "Contructor");                                          InputAutomationModuleFactoryInterface gameAutomationRobotModuleInterface =                         (InputAutomationModuleFactoryInterface) AbeFactory.getInstance().getInstance(className);                                          if(inputAutomationModuleInterface.getName().compareTo(                         gameAutomationRobotModuleInterface.getName()) == 0)                     {                                                  modulesNode.removeChild(node);                     }                 }                 else                 {                     this.logUtil.putF("Class Node Null", this, "Contructor");                 }             }             else             {                 LogUtil.putF(InputAutomationData.NAME + " Name Node Node Children", this,"Contructor");             }         }         this.save();     }     */
    def isInstalled() : Boolean = {
        return this.installed
    }

    def setInstalled(installed : Boolean) : Unit = {
        this.installed = installed
        this.logUtil.putF("Installed: " + installed, this, "setIntalled")
    }

    /**      * @return the inputAutomationModuleConfigurationList      */
    def getInputAutomationModuleConfigurationList() : List[InputAutomationModuleConfiguration] = {
        return this.inputAutomationModuleConfigurationList
    }

    def save() : Unit = {
        var document : Document = DomDocumentHelper.create()

        var file : File = new File(FILENAME)
        FileUtil.getInstance().copy(new AbPath(file.getAbsolutePath(), StringUtil.getInstance().EMPTY_STRING), new AbPath(file.getAbsolutePath() + ".bak.xml", StringUtil.getInstance().EMPTY_STRING))
        var jaxbContext : JAXBContext = JAXBContext.newInstance(classOf[InputAutomationConfiguration])
        var marshaller : Marshaller = jaxbContext.createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        marshaller.marshal(this, document)
        DomDocumentFileHelper.save(FileWrapperUtil.wrapFile(file), document)
    }

}

object InputAutomationConfiguration {
    private val FILENAME : String = "InputAutomationConfig.xml"

    def getFile() : File = {
        return new File(FILENAME)
    }

}


