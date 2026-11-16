/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.generic.order

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.tags.StoreValidationTransformTag

class OrderTag() extends StoreValidationTransformTag {

    //         pageContext.getOut().print("Please Review the order below, and click on the Place Order button.<p>");
    override def doStartTag() : Int = {
        try {
            this.setName("Basic Order View")
            this.setObjectFile("views.generic.order.ValidationView")
            //this.propertiesHashMap.put(OrderData.ORDERID, this.orderId);
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
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


