/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.admin

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.tags.StoreValidationTransformTag

class DateRangeOrderHistoryTag() extends StoreValidationTransformTag() {

    val logUtil_DateRangeOrderHistoryTag : LogUtil = LogUtil.getInstance()

    //private String id;
    private var status : String = null

    /*    public void setId(String id)    {       this.id=id;    }  */
    def setStatus(value : String) : Unit = {
        this.status = value
    }

    /*    public void setShipped(String value)    {       this.shipped=value;    }         public void setPartiallyShipped(String value)    {       this.partiallyShipped=value;    }         public void setPreprocessing(String value)    {       this.preprocessing=value;    }         public void setProcessing(String value)    {       this.processing=value;    }         public void setCancelled(String value)    {       this.cancelled=value;    }     */
    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_DateRangeOrderHistoryTag.putF("Tag Start", this, tagStrings.DO_START_TAG)
            }
            this.setName("Range Order History View")
            this.setObjectFile("views.admin.orderhistory.DateRangeOrderHistoryView")
            if (this.getCommand() != null) {
                if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.VIEW) == 0) {
                } else {
                    throw new Exception("No Such View Command: " + this.getCommand())
                }
                return super.doStartTag()
            }
            throw new Exception("Command Null")
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


