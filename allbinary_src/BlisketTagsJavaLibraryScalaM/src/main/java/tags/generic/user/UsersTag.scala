/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.generic.user

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.tags.StoreValidationTransformTag

class UsersTag() extends StoreValidationTransformTag {

    private var role : String = null

    def setRole(value : String) : Unit = {
        this.role = value
    }

    override def doStartTag() : Int = {
        try {
            this.setName("Generic Users View")
            this.setObjectFile("views.generic.user.UsersValidationView")
            if (this.getCommand() != null) {
                this.getPropertiesHashMap().put(UserRoleData.NAME, this.role)
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


