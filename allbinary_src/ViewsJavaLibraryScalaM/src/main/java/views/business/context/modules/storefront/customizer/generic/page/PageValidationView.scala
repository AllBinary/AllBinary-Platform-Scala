/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.generic.page

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntity
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfo
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.page.PageValidation
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.customizer.CustomizerUtil

class PageValidationView(param_transformInfoInterface : TransformInfoInterface) extends PageView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_PageValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_PageValidationView.putF("View Name: " + transformInfoInterface.getName(), this, "PageViewValidation()")
        }
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_PageValidationView.putF(this.commonStrings.START, this, this.commonStrings.IS_VALID)
            }
            //CustomizerUtils.insert(this.getTransformInfoInterface(),(DomNodeInterface) pageValidation);
            var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
            //need page titles
            var pageObjectConfigInterface : TransformInfoObjectConfigInterface = this.getTransformInfoInterface().getObjectConfigInterface()
            //BasicArrayList allViewsToBeModified = objectConfig.getComponents();
            var allViewsToBeModifiedVector : BasicArrayList = pageObjectConfigInterface.getGroupTransforms()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_PageValidationView.putF("Views To Be Modified: " + allViewsToBeModifiedVector.size(), this, "get(transformInfoInterface)")
            }
            val size : Int = allViewsToBeModifiedVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var transformInfoInterface : TransformInfo = allViewsToBeModifiedVector.get(index).asInstanceOf[TransformInfo]
                    var viewNameOfViewToBeModified : String = transformInfoInterface.getName()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        var stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append(this.getTransformInfoInterface().getName())
                        stringBuffer.append(" is modifying view: ")
                        stringBuffer.append(viewNameOfViewToBeModified)
                        this.logUtil_PageValidationView.putF(stringBuffer.toString(), this, "insert()")
                    }
                    var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
                    var specifiedTransformInfoInterface : TransformInfoInterface = transformInfoEntityInterface.get(viewNameOfViewToBeModified, httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        var stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append(this.getTransformInfoInterface().getName())
                        stringBuffer.append(" is adding data to view: ")
                        stringBuffer.append(viewNameOfViewToBeModified)
                        this.logUtil_PageValidationView.putF(stringBuffer.toString(), this, "insert()")
                    }
                    var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                    var title : String = specifiedTransformInfoInterface.getName().substring(this.getTransformInfoInterface().getStoreName().length())
                    if (title.compareTo("index") == 0) {
                        hashMap.put(TitleData.getInstance().TEXT, this.getTransformInfoInterface().getStoreName() + " - Home Page")
                    } else {
                        hashMap.put(TitleData.getInstance().TEXT, (this.getTransformInfoInterface().getStoreName() + " -") + title)
                    }
                    var pageValidation : PageValidation = new PageValidation(hashMap)
                    if (pageValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                        isValid = _root_.java.lang.Boolean.FALSE
                    }
                    if (isValid == _root_.java.lang.Boolean.TRUE) {
                        //get the view xml/data that will replace the old xml/data
                        var document : Document = DomDocumentHelper.create()
                        document.appendChild(pageValidation.toXmlNode(document))
                        var documentString : String = XmlDocumentHelper.toString(document)
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                            var stringBuffer : StringMaker = new StringMaker()
                            stringBuffer.append(viewNameOfViewToBeModified)
                            stringBuffer.append(" is changing data in ")
                            stringBuffer.append(specifiedTransformInfoInterface.getDataFilePath().toString())
                            stringBuffer.append(" to the following data:\n")
                            stringBuffer.append(documentString)
                            this.logUtil_PageValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                        }
                        //save xml data to specified view
                        CustomizerUtil.getInstance().write(specifiedTransformInfoInterface, documentString)
                    }
                    index += 1
                }
            }
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_PageValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            var transformInfoEntityInterface : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
            var objectConfig : TransformInfoObjectConfigInterface = this.getTransformInfoInterface().getObjectConfigInterface()
            var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
            var allViewsToBeModifiedVector : BasicArrayList = objectConfig.getGroupTransforms()
            val size : Int = allViewsToBeModifiedVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var transformInfoInterface : TransformInfo = allViewsToBeModifiedVector.get(index).asInstanceOf[TransformInfo]
                    var viewNameOfViewToBeModified : String = transformInfoInterface.getName()
                    var specifiedTransformInfoInterface : TransformInfoInterface = transformInfoEntityInterface.get(viewNameOfViewToBeModified, httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
                    var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                    var title : String = specifiedTransformInfoInterface.getName().substring(this.getTransformInfoInterface().getStoreName().length())
                    if (title.compareTo("index") == 0) {
                        hashMap.put(TitleData.getInstance().TEXT, this.getTransformInfoInterface().getStoreName() + " - Home Page")
                    } else {
                        hashMap.put(TitleData.getInstance().TEXT, (this.getTransformInfoInterface().getStoreName() + " -") + title)
                    }
                    var pageValidation : PageValidation = new PageValidation(hashMap)
                    if (pageValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                        stringBuffer.append("TransformInfo Name for PageValidation:" + specifiedTransformInfoInterface.getName())
                        stringBuffer.append("PageValidation:" + hashMap)
                        stringBuffer.append("PageValidation Info:" + pageValidation.validationInfo())
                    }
                    index += 1
                }
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_PageValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "An auto generated page name was invalid."
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


