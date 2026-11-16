/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.admin

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.sql.SqlStrings
import _root_.tags.StoreValidationTransformTag

class UserTag() extends StoreValidationTransformTag {

    private var role : String = null

    def setRole(value : String) : Unit = {
        this.role = value
        this.getPropertiesHashMap().put(UserRoleData.NAME, this.role)
    }

    override def doStartTag() : Int = {
        try {
            if (this.getCommand() != null) {
                if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.NEW) == 0) {
                    this.setName("New User View")
                    this.setObjectFile("views.admin.user.NewUserView")
                } else if ((this.getCommand().compareTo(this.commonStrings.INSERT) == 0) || (this.getCommand().compareTo(SqlStrings.getInstance().INSERT_INTO) == 0)) {
                    this.setName("Add Validation User View")
                    this.setObjectFile("views.admin.user.AddValidationUserView")
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.VIEW) == 0) {
                    this.setName("Validation User View")
                    this.setObjectFile("views.admin.user.ViewValidationUserView")
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.EDIT) == 0) {
                    this.setName("Validation User View")
                    this.setObjectFile("views.admin.user.EditValidationUserView")
                } else if ((this.getCommand().compareTo(this.commonStrings.UPDATE) == 0) || (this.getCommand().compareTo(SqlStrings.getInstance().UPDATE) == 0)) {
                    this.setName("Update Validation User View")
                    this.setObjectFile("views.admin.user.UpdateValidationUserView")
                } else if (this.getCommand().compareTo(this.commonStrings.DELETE) == 0) {
                    this.setName("Delete Validation User View")
                    this.setObjectFile("views.admin.user.DeleteValidationUserView")
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
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


