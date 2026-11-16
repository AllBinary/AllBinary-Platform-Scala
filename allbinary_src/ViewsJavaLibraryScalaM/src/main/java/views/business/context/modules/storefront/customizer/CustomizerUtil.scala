/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntity
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfo
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface
import _root_.org.w3c.dom.Document

class CustomizerUtil private() {
    import _root_.views.business.context.modules.storefront.customizer.CustomizerUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getTransformInfoInterfaceToCustomize(customizerTransformInfoInterface : TransformInfoInterface, transformInfoInterface : TransformInfoInterface) : TransformInfoInterface = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + customizerTransformInfoInterface.getName(), this, "getTransformInfoInterfaceToCustomize()")
        }
        var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
        var viewName : String = transformInfoInterface.getName()
        var httpTransformInfoInterface : TransformInfoHttpInterface = customizerTransformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
        var customizedTransformInfoInterface : TransformInfoInterface = transformInfoEntityInterface.get(viewName, httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
        return customizedTransformInfoInterface
    }

    //get all of the components for a component that is modified by the customizer view
    def getTransformInfoObjectConfigComponentNodesToCustomize(customizerTransformInfoInterface : TransformInfoInterface, transformInfoInterface : TransformInfoInterface) : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + customizerTransformInfoInterface.getName(), this, "getTransformInfoObjectConfigComponentNodesToCustomize()")
        }
        var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
        var viewName : String = transformInfoInterface.getName()
        var httpTransformInfoInterface : TransformInfoHttpInterface = customizerTransformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
        var customizedTransformInfoInterface : TransformInfoInterface = transformInfoEntityInterface.get(viewName, httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
        return this.getTransformInfoObjectConfigComponentNodes(customizedTransformInfoInterface)
    }

    //get all components in objectconfig
    def getTransformInfoObjectConfigComponentNodes(transformInfoInterface : TransformInfoInterface) : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + transformInfoInterface.getName(), this, "getTransformInfoObjectConfigComponentNodes()")
        }
        var transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface = transformInfoInterface.getObjectConfigInterface()
        return transformInfoObjectConfigInterface.getTransforms()
    }

    def getTransformInfoObjectConfigGroupComponentNodes(transformInfoInterface : TransformInfoInterface) : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + transformInfoInterface.getName(), this, "getTransformInfoObjectConfigComponentNodes()")
        }
        var transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface = transformInfoInterface.getObjectConfigInterface()
        return transformInfoObjectConfigInterface.getGroupTransforms()
    }

    //The new data/xml is generated by the domNodeInterface
    def insert(transformInfoInterface : TransformInfoInterface, domNodeInterface : DomNodeInterface) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + transformInfoInterface.getName(), this, "insert()")
        }
        var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
        var allViewsToBeModified : BasicArrayList = this.getTransformInfoObjectConfigGroupComponentNodes(transformInfoInterface)
        //get the view xml/data that will replace the old xml/data
        var document : Document = DomDocumentHelper.create()
        document.appendChild(domNodeInterface.toXmlNode(document))
        var documentString : String = XmlDocumentHelper.toString(document)
        var stringBuffer : StringMaker = new StringMaker()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            stringBuffer.append("Total Views For Modification: ")
            stringBuffer.appendint(allViewsToBeModified.size())
            stringBuffer.append(" New Xml/Data: ")
            stringBuffer.append(documentString)
            this.logUtil.putF(stringBuffer.toString(), this, "insert()")
        }
        //CustomizerUtil.getInstance().write(transformInfoInterface, documentString);
        transformInfoInterface.setData(documentString)
        val size : Int = allViewsToBeModified.size()

        {
            var index : Int = 0
            while (index < size) {
                var transformInfo : TransformInfo = allViewsToBeModified.get(index).asInstanceOf[TransformInfo]
                var viewNameOfViewToBeModified : String = transformInfo.getName()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(transformInfoInterface.getName())
                    stringBuffer.append(" is modifying view: ")
                    stringBuffer.append(viewNameOfViewToBeModified)
                    this.logUtil.putF(stringBuffer.toString(), this, "insert()")
                }
                var httpTransformInfoInterface : TransformInfoHttpInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
                var specifiedTransformInfoInterface : TransformInfoInterface = transformInfoEntityInterface.get(viewNameOfViewToBeModified, httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
                if (specifiedTransformInfoInterface == null) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.append(transformInfoInterface.getName())
                        stringBuffer.append(" is unable to add data to view: ")
                        stringBuffer.append(viewNameOfViewToBeModified)
                        stringBuffer.append(" since it does not exist")
                        this.logUtil.putF(stringBuffer.toString(), this, "insert()")
                    }
                } else {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil.putF((transformInfoInterface.getName() + " is adding data to view: ") + viewNameOfViewToBeModified, this, "insert()")
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.append(viewNameOfViewToBeModified)
                        stringBuffer.append(" is changing data in ")
                        stringBuffer.append(specifiedTransformInfoInterface.getDataFilePath().toString())
                        stringBuffer.append(" to the following data:\n")
                        stringBuffer.append(documentString)
                        this.logUtil.putF(stringBuffer.toString(), this, "insert()")
                    }
                    //save xml data to specified view
                    this.write(specifiedTransformInfoInterface, documentString)
                }
                index += 1
            }
        }
    }

    def write(specifiedTransformInfoInterface : TransformInfoInterface, documentString : String) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + specifiedTransformInfoInterface.getName(), this, "write()")
        }
        var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
        //should encrypt
        specifiedTransformInfoInterface.setData(documentString)
        //specifiedTransformInfoInterface.setData();
        transformInfoEntityInterface.update(specifiedTransformInfoInterface.toHashMap())
    }

    //that are all updated at once with the CustomizerUtils.write
    def getViewDataForComponentsInObjectConfig(transformInfoInterface : TransformInfoInterface) : Document = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + transformInfoInterface.getName(), this, "getViewDataForComponentsInObjectConfig()")
        }
        //BasicArrayList allViewsToBeModified = CustomizerUtil.getInstance().getTransformInfoObjectConfigComponentNodes(transformInfoInterface);
        var transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface = transformInfoInterface.getObjectConfigInterface()
        var allViewsToBeModified : BasicArrayList = transformInfoObjectConfigInterface.getGroupTransforms()
        var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
        val size : Int = allViewsToBeModified.size()

        {
            var index : Int = 0
            while (index < size) {
                var nextTransformInfoInterface : TransformInfo = allViewsToBeModified.get(index).asInstanceOf[TransformInfo]
                var viewNameOfViewToBeModified : String = nextTransformInfoInterface.getName()
                var httpTransformInfoInterface : TransformInfoHttpInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
                var specifiedTransformInfoInterface : TransformInfoInterface = transformInfoEntityInterface.get(viewNameOfViewToBeModified, httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
                return specifiedTransformInfoInterface.getDataDocument()
                index += 1
            }
        }
        throw new Exception("No Components Specified in ObjectConfig")
    }

}

object CustomizerUtil {
    private val instance : CustomizerUtil = new CustomizerUtil()

    def getInstance() : CustomizerUtil = {
        return CustomizerUtil.instance
    }

}


