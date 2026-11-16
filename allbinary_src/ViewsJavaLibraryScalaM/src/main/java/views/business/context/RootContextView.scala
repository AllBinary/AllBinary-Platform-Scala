/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfo
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.TransformTemplateInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView
import _root_.views.business.context.modules.storefront.customizer.template.objectConfig.NoTemplateTransformInfoObjectConfig

class RootContextView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with TransformTemplateInterface {

    val logUtil_RootContextView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_RootContextView.putF("View Name: " + transformInfoInterface.getName(), this, "RootContextView()")
        }
    }

    //Loads the view stored in the object config and views it
    override def view() : String = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_RootContextView.putF("View Name: " + this.getTransformInfoInterface().getName(), this, "view()")
            }
            var viewName : String = this.getName()
            var componentInterface : TransformInterface = TransformFactory.getInstance().getInstance(this.abeClientInformation, viewName, this.getTransformInfoInterface())
            return componentInterface.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_RootContextView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def getName() : String = {
        try {
            var objectConfig : NoTemplateTransformInfoObjectConfig = new NoTemplateTransformInfoObjectConfig(this.getTransformInfoInterface(), this.getTransformInfoInterface().getObjectConfigInterface().toXmlDoc())
            var componentsVector : BasicArrayList = objectConfig.getTransforms()
            if (componentsVector.size() == 0) {
                throw new Exception("Template View Not Set - No Components")
            }
            if (componentsVector.size() > 1) {
                throw new Exception("To Many Root Template Views: " + componentsVector.size())
            }
            var transformInfoInterface : TransformInfo = componentsVector.get(0).asInstanceOf[TransformInfo]
            var viewName : String = transformInfoInterface.getName()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_RootContextView.putF("Root Template With View Name: " + viewName, this, "getName()")
            }
            if (StringValidationUtil.getInstance().isEmpty(viewName)) {
                throw new Exception("Template View Not Set - No View Name")
            }
            return viewName
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_RootContextView.put(this.commonStrings.EXCEPTION, this, "getName()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


