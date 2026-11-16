/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.compound

import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class CompoundComponentView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_CompoundComponentView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    //Override view for Compound View
    override def view() : String = {
        try {
            var success : String = XmlDocumentHelper.toString(this.getDoc())
            var result : String = new CompoundTransform(this.getTransformInfoInterface()).translate(success)
            return result
        } catch {
            case e : Exception => {
                //String error = "Failed To View Store Template Compound Component";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_CompoundComponentView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


