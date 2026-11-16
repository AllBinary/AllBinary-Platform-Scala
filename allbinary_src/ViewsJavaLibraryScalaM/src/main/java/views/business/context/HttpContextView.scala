/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context

import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.ContextTransformer
import _root_.org.allbinary.logic.visual.transform.data.TransformHttpRequestDocumentFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.views.HttpComponentView

class HttpContextView(param_transformInfoInterface : TransformInfoInterface) extends HttpComponentView(param_transformInfoInterface) {

    val logUtil_HttpContextView : LogUtil = LogUtil.getInstance()

    val commonStrings_HttpContextView : CommonStrings = CommonStrings.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_HttpContextView.putF("View Name: " + transformInfoInterface.getName(), this, this.commonStrings_HttpContextView.CONSTRUCTOR)
        }
        this.setTransformDocumentInterface(TransformHttpRequestDocumentFactory.getInstance(this.getPageContext(), this.getWeblisketSession()))
    }

    override def view() : String = {
        try {
            this.toXmlDoc()
            var success : String = XmlDocumentHelper.toString(this.getDoc())
            var result : String = new ContextTransformer(this.abeClientInformation, this.getTransformInfoInterface()).translate(success)
            return result
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_HttpContextView.put(this.commonStrings_HttpContextView.EXCEPTION, this, "view", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


