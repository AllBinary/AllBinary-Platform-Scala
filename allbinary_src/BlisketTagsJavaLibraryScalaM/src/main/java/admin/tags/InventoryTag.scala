/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.tagext.Tag
import _root_.admin.taghelpers.InventoryHelperFactory
import _root_.admin.taghelpers.InventoryRequestHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler

class InventoryTag() extends TableTag() {

    private var storeName : String = null

    //Constructor
    {
        this.setTagHelperFactory(new InventoryHelperFactory())
        this.setTagRequestHelperFactory(new InventoryRequestHelperFactory())
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    override def doStartTag() : Int = {
        try {
            if (this.isEnabled()) {
                if (this.getCommand() != null) {
                    if ((((this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.BACKUP) != 0) && (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.RESTORE) != 0)) && (this.getCommand().compareTo(this.commonStrings.CREATE) != 0)) && (this.getCommand().compareTo(this.commonStrings.DROP) != 0)) {
                        var parentTag : Tag = this.getParent()
                        ParentInventoryTagHelper.getInstance().isValid(this, parentTag)
                        this.getPropertiesHashMap().put(AbTagData.PARENT, parentTag)
                        this.getPropertiesHashMap().put(StoreFrontData.getInstance().NAME, this.storeName)
                    }
                    return super.doStartTag()
                }
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


