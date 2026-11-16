/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.generator

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.org.allbinary.string.CommonSeps

class PreviewGeneratorStoreFrontContextView(param_transformInfoInterface : TransformInfoInterface) extends GeneratorStoreFrontContextView(param_transformInfoInterface) {

    val logUtil_PreviewGeneratorStoreFrontContextView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    override def view() : String = {
        try {
            var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
            httpTransformInfoInterface.getPropertiesHashMap().put(TransformInfoData.getInstance().PARTIAL, CommonSeps.getInstance().SPACE + TransformInfosData.getInstance().PREVIEW)
            return this.view(TransformInfosData.getInstance().PREVIEW)
        } catch {
            case e : Exception => {
                //String error = "Failed To View Store Template Compound Component";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_PreviewGeneratorStoreFrontContextView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


