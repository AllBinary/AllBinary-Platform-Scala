/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.generic.payment

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.StoreValidationTransformTag

class PaymentTag() extends StoreValidationTransformTag {

    override def doStartTag() : Int = {
        try {
            this.setName("Basic Payment View")
            this.setObjectFile("views.generic.payment.ValidationView")
            if (this.getCommand() != null) {
                if (((this.getCommand().compareTo(PaymentData.VIEW) == 0) || (this.getCommand().compareTo(PaymentData.CHANGE) == 0)) || (this.getCommand().compareTo(PaymentData.ADDNEW) == 0)) {
                } else if (this.getCommand().compareTo(this.commonStrings.INSERT) == 0) {
                } else if (this.getCommand().compareTo(this.commonStrings.DELETE) == 0) {
                    return this.EVAL_BODY_INCLUDE
                } else if (this.getCommand().compareTo(PaymentData.SELECT) == 0) {
                    return this.EVAL_BODY_INCLUDE
                } else {
                    throw new Exception("No Such View Command: " + this.getCommand())
                }
                return super.doStartTag()
            }
            throw new Exception("Command Null")
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


