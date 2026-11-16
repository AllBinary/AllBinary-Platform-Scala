/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.generator

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.generator.TransformsGeneratorUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class GeneratorStoreFrontContextView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_GeneratorStoreFrontContextView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_GeneratorStoreFrontContextView.putF("View Name: " + transformInfoInterface.getName(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def view(group : String) : String = {
        var result : String = TransformsGeneratorUtil.getInstance().generateComponentsFromObjectConfig(this.abeClientInformation, this.getTransformInfoInterface(), group)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPEXTRAOUTPUT)) {
            return result
        } else {
            return StringUtil.getInstance().EMPTY_STRING
        }
        throw new IllegalStateException()
    }

    override def view() : String = {
        try {
            return this.view(TransformInfosData.getInstance().ALL)
        } catch {
            case e : Exception => {
                //String error = "Failed To Generate StoreFront Context";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_GeneratorStoreFrontContextView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


