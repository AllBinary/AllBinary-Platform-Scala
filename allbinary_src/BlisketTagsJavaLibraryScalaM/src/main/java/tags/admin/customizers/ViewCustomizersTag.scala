/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.admin.customizers

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.tags.StoreValidationTransformTag

class ViewCustomizersTag() extends StoreValidationTransformTag {

    override def doStartTag() : Int = {
        try {
            this.setName("Add Validation Customizers View")
            this.setObjectFile("views.admin.customizers.CustomizersValidationView")
            return super.doStartTag()
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


