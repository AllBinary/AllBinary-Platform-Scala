/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.UserHelperFactory
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler

class UserTag() extends TableTag {

    private var role : String = null

    private var enable : String = null

    //Constructor
    {
        this.setTagHelperFactory(new UserHelperFactory())
        this.setTagRequestHelperFactory(new UserHelperFactory())
    }

    def setRole(value : String) : Unit = {
        this.role = value
        this.getPropertiesHashMap().put(UserRoleData.NAME, this.role)
    }

    def setEnable(value : String) : Unit = {
        this.enable = value
        this.getPropertiesHashMap().put(EntryData.getInstance().ENABLE, this.enable)
    }

    override def doStartTag() : Int = {
        try {
            if (this.isEnabled()) {
                return super.doStartTag()
            }
            return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


