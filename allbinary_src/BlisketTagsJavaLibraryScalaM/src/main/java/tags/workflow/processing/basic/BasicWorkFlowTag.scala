/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.workflow.processing.basic

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.tags.StoreWorkFlowTag

//and remove the hidden fields
class BasicWorkFlowTag() extends StoreWorkFlowTag {

    val logUtil_BasicWorkFlowTag : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_BasicWorkFlowTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_BasicWorkFlowTag.putF(this.commonStrings.START, this, tagStrings.DO_START_TAG)
            }
            //Temporary should be replaced by view in xml of workflow
            this.getPropertiesHashMap().put(DynamicObjectData.NAME, "workflows.template.data.BasicStoreWorkFlow")
            return super.doStartTag()
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


