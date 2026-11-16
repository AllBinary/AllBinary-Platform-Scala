/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.template

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.info.GeneratorTransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfo
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView
import _root_.views.business.context.modules.storefront.customizer.template.objectConfig.InsertTemplateCustomizerTransformInfoObjectConfig
import _root_.views.business.context.modules.storefront.customizer.template.objectConfig.NoTemplateTransformInfoObjectConfig

//Sets Template Type
class InsertCustomizerValidationView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_InsertCustomizerValidationView : LogUtil = LogUtil.getInstance()

    private var viewName : String = null

    //private Integer total;
    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_InsertCustomizerValidationView.putF("View Name: " + transformInfoInterface.getName(), this, this.commonStrings.CONSTRUCTOR)
        }
        var requestHashMap : HashMap[Object, Object] = new RequestParams(this.getPageContext()).toHashMap().asInstanceOf[HashMap[Object, Object]]
        this.viewName = requestHashMap.get(TransformInfoData.getInstance().NAME).asInstanceOf[String]
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_InsertCustomizerValidationView.putF("Started Validation", this, this.commonStrings.IS_VALID)
            }
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (StringValidationUtil.getInstance().isEmpty(this.viewName)) {
                isValid = _root_.java.lang.Boolean.FALSE
            } else {
                //Use original objectconfig because root template is not known yet
                var objectConfig : NoTemplateTransformInfoObjectConfig = new NoTemplateTransformInfoObjectConfig(this.getTransformInfoInterface(), this.getTransformInfoInterface().getObjectConfigInterface().toXmlDoc())
                //Iterate throught components specified in objectConfig
                val componentVector : BasicArrayList = objectConfig.getGroupTransforms()
                val size : Int = componentVector.size()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Pointing ")
                    stringBuffer.appendint(componentVector.size())
                    stringBuffer.append(" Components")
                    this.logUtil_InsertCustomizerValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                }

                {
                    var index : Int = 0
                    while (index < size) {
                        var transformInfo : TransformInfo = componentVector.get(index).asInstanceOf[TransformInfo]
                        var transformInfoName : String = transformInfo.getName()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                            this.logUtil_InsertCustomizerValidationView.putF("Setting Template Component with ViewName: " + transformInfoName, this, this.commonStrings.IS_VALID)
                        }
                        var componentInterface : TransformInterface = TransformFactory.getInstance().getInstance(this.abeClientInformation, transformInfoName, this.getTransformInfoInterface())
                        var templateViewObjectConfig : InsertTemplateCustomizerTransformInfoObjectConfig = new InsertTemplateCustomizerTransformInfoObjectConfig(componentInterface.getTransformInfoInterface(), componentInterface.getTransformInfoInterface().getObjectConfigInterface().toXmlDoc())
                        var storeName : String = this.getTransformInfoInterface().getStoreName()
                        var endIndex : Int = this.viewName.indexOf(storeName) + storeName.length()
                        var storePrepend : String = this.viewName.substring(0, endIndex)
                        var viewNamePostfix : String = this.viewName.substring(endIndex, this.viewName.length())
                        var newViewNameStringBuffer : StringMaker = new StringMaker()
                        newViewNameStringBuffer.append(storePrepend)
                        var commonSeps : CommonSeps = CommonSeps.getInstance()
                        var transformInfosData : TransformInfosData = TransformInfosData.getInstance()
                        //update viewName
                        if (transformInfoName.indexOf(transformInfosData.SMALL_PREVIEW) >= 0) {
                            newViewNameStringBuffer.append(commonSeps.SPACE)
                            newViewNameStringBuffer.append(transformInfosData.SMALL_PREVIEW)
                        } else if (transformInfoName.indexOf(transformInfosData.PREVIEW) >= 0) {
                            newViewNameStringBuffer.append(commonSeps.SPACE)
                            newViewNameStringBuffer.append(transformInfosData.PREVIEW)
                        }
                        newViewNameStringBuffer.append(commonSeps.SPACE)
                        newViewNameStringBuffer.append(viewNamePostfix)
                        if (transformInfoName.indexOf(GeneratorTransformInfoData.NAME) >= 0) {
                            newViewNameStringBuffer.append(commonSeps.SPACE)
                            newViewNameStringBuffer.append(GeneratorTransformInfoData.NAME)
                        }
                        val newViewName : String = newViewNameStringBuffer.toString()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                            var stringBuffer : StringMaker = new StringMaker()
                            stringBuffer.append("Template Component: ")
                            stringBuffer.append(transformInfoName)
                            stringBuffer.append("\n Now Pointing To View Name: ")
                            stringBuffer.append(newViewName)
                            this.logUtil_InsertCustomizerValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                        }
                        templateViewObjectConfig.set(newViewName)
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                            var stringBuffer : StringMaker = new StringMaker()
                            stringBuffer.append("Template Component: ")
                            stringBuffer.append(transformInfoName)
                            stringBuffer.append("\n with ObjectConfig: ")
                            stringBuffer.append(templateViewObjectConfig.toString())
                            this.logUtil_InsertCustomizerValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                        }
                        componentInterface.getTransformInfoInterface().setObjectConfigInterface(templateViewObjectConfig)
                        var updatedTransformInfoHashMap : HashMap[Object, Object] = componentInterface.getTransformInfoInterface().toHashMap().asInstanceOf[HashMap[Object, Object]]
                        TransformInfoEntityBuilder.getInstance().update(updatedTransformInfoHashMap)
                        index += 1
                    }
                }
            }
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_InsertCustomizerValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Error: Template Name Is Empty.")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_InsertCustomizerValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
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

    override def view() : String = {
        return views.ValidationOnlyTempUtil.getInstance().view(this)
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


