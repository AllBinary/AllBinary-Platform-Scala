/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.tagext.Tag
import _root_.admin.taghelpers.MultipartRequestParamForwardHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport
import _root_.tags.HelperTag

class MultipartRequestParamForwardTag extends CustomTagSupport {

    private var page : String = null

    private var command : String = null

    private var paramVector : BasicArrayList = null

    /**      * @param page the page to set      */
    def setPage(page : String) : Unit = {
        this.page = page
    }

    /**      * @param command the command to set      */
    def setCommand(command : String) : Unit = {
        this.command = command
    }

    /**      * @param paramVector the paramVector to set      */
    def setParamVector(paramVector : BasicArrayList) : Unit = {
        this.paramVector = paramVector
    }

    override def doStartTag() : Int = {
        try {
            var parentTag : HelperTag = this.getParent().asInstanceOf[HelperTag]
            ParentInventoryTagHelper.getInstance().isValid(this, parentTag)
            var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            hashMap.put(AbTagData.PARENT, parentTag)
            var multipartRequestParamForwardHelper : MultipartRequestParamForwardHelper = new MultipartRequestParamForwardHelper(parentTag, this.page, this.command, this.paramVector, this.pageContext)
            multipartRequestParamForwardHelper.forward()
            return Tag.SKIP_BODY
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


