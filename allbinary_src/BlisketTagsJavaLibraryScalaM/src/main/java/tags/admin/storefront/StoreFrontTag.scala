/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.admin.storefront

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.StoreValidationTransformTag

class StoreFrontTag() extends StoreValidationTransformTag {

    override def doStartTag() : Int = {
        try {
            if (this.getCommand() != null) {
                if (this.getCommand().compareTo(this.commonStrings.INSERT) == 0) {
                    this.setName("Add Validation StoreFront View")
                    this.setObjectFile("views.admin.storefront.AddValidationStoreFrontView")
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.VIEW) == 0) {
                    throw new Exception("View not implemented")
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.EDIT) == 0) {
                    this.setName("Edit Validation StoreFront View")
                    this.setObjectFile("views.admin.storefront.EditValidationStoreFrontView")
                } else if (this.getCommand().compareTo(this.commonStrings.UPDATE) == 0) {
                    this.setName("Update Validation StoreFront View")
                    this.setObjectFile("views.admin.storefront.UpdateValidationStoreFrontView")
                } else if (this.getCommand().compareTo(this.commonStrings.DELETE) == 0) {
                    this.setName("Delete Validation StoreFront View")
                    this.setObjectFile("views.admin.storefront.DeleteValidationStoreFrontView")
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.BACKUP) == 0) {
                    throw new Exception("View not implemented")
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.RESTORE) == 0) {
                    throw new Exception("View not implemented")
                } else if (this.getCommand().compareTo(this.commonStrings.DROP) == 0) {
                    throw new Exception("View not implemented")
                } else if (this.getCommand().compareTo(this.commonStrings.CREATE) == 0) {
                    throw new Exception("View not implemented")
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


