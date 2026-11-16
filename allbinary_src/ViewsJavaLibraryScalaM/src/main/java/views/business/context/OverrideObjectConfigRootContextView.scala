/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context

import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.info.GeneratorTransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.RootTransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttp
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigAndManipulatorFactory
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface
import _root_.org.allbinary.logic.visual.transform.template.TransformTemplateInterface
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class OverrideObjectConfigRootContextView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_OverrideObjectConfigRootContextView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_OverrideObjectConfigRootContextView.putF("View Name: " + transformInfoInterface.getName(), this, "OverrideObjectRootContextView()")
        }
    }

    //Used for Payment Gateway specific Pages
    override def view() : String = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_OverrideObjectConfigRootContextView.putF("View Name: " + this.getTransformInfoInterface().getName(), this, "view()")
            }
            var rootTransformInfoInterface : TransformInfoInterface = (new TransformInfoHttp(this.getTransformInfoInterface().asInstanceOf[TransformInfoHttp])).asInstanceOf[TransformInfoInterface]
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.getTransformInfoInterface().getStoreName())
            stringBuffer.append(CommonSeps.getInstance().SPACE)
            var nameStart : String = stringBuffer.toString()
            //From Event Listeners
            if (this.getTransformInfoInterface().getName().indexOf(GeneratorTransformInfoData.NAME) > 0) {
                rootTransformInfoInterface.setName(nameStart + GeneratorTransformInfoData.NAME)
            } else if (this.getTransformInfoInterface().getName().indexOf(RootTransformInfoData.NAME) > 0) {
                rootTransformInfoInterface.setName(nameStart + RootTransformInfoData.NAME)
            } else {
                throw new Exception("Override Currently Not Supported")
            }
            var overrideObjectConfigDocument : Document = this.getTransformInfoInterface().getObjectConfigInterface().toXmlDoc()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_OverrideObjectConfigRootContextView.putF("Retrieved OverrideObjectConfig: " + XmlDocumentHelper.toString(overrideObjectConfigDocument), this, "view()")
            }
            val transformFactory : TransformFactory = TransformFactory.getInstance()
            var rootComponentInterface : TransformInterface = transformFactory.getInstance(this.abeClientInformation, rootTransformInfoInterface.getName(), rootTransformInfoInterface)
            var transformTemplateInterface : TransformTemplateInterface = rootComponentInterface.asInstanceOf[TransformTemplateInterface]
            //The view that the Root is pointing to as specified in its TransformInfoObjectConfig
            var componentInterface : TransformInterface = transformFactory.getInstance(this.abeClientInformation, transformTemplateInterface.getName(), rootComponentInterface.getTransformInfoInterface())
            var transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface = TransformInfoObjectConfigAndManipulatorFactory.getInstance().getInstance(this.abeClientInformation, componentInterface.getTransformInfoInterface(), overrideObjectConfigDocument)
            componentInterface.getTransformInfoInterface().setObjectConfigInterface(transformInfoObjectConfigInterface)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_OverrideObjectConfigRootContextView.putF("Set OverrideObjectConfig: " + componentInterface.getTransformInfoInterface().getObjectConfigInterface().toString(), this, "view()")
            }
            return componentInterface.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_OverrideObjectConfigRootContextView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


