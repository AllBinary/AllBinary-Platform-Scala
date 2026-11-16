/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront

import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.StoreTransformer
import _root_.org.allbinary.logic.visual.transform.data.TransformStoreDocumentFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.views.HttpComponentView

class HttpStoreComponentView(param_transformInfoInterface : TransformInfoInterface) extends HttpComponentView(param_transformInfoInterface) {

    val logUtil_HttpStoreComponentView : LogUtil = LogUtil.getInstance()

    val commonStrings_HttpStoreComponentView : CommonStrings = CommonStrings.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_HttpStoreComponentView.putF("View Name: " + transformInfoInterface.getName(), this, this.commonStrings_HttpStoreComponentView.CONSTRUCTOR)
        }
        this.setTransformDocumentInterface(TransformStoreDocumentFactory.getInstance(this.getPageContext(), this.getWeblisketSession()))
    }

    override def view() : String = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_HttpStoreComponentView.putF(this.commonStrings_HttpStoreComponentView.START, this, "view")
            }
            this.toXmlDoc()
            var success : String = XmlDocumentHelper.toString(this.getDoc())
            var result : String = new StoreTransformer(this.abeClientInformation, this.getTransformInfoInterface()).translate(success)
            return result
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_HttpStoreComponentView.put(this.commonStrings_HttpStoreComponentView.EXCEPTION, this, "view", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


