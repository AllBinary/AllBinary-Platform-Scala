/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.javax.servlet.jsp.tagext.Tag
import _root_.org.allbinary.logic.string.StringMaker

/**  *  * @author user  */
class ParentInventoryTagHelper {
    import _root_.admin.tags.ParentInventoryTagHelper.{*}

    def isValid(tagClass : Object, parentTag : Tag) : Unit = {
        if (parentTag == null) {
            throw new Exception("Must have parent tag.")
        } else if (!(parentTag.isInstanceOf[_root_.tags.HelperTag])) {
            var stringBuffer : StringMaker = new StringMaker()
            //tagClass
            stringBuffer.append("Must have at least a ")
            stringBuffer.append("tags.HelperTag")
            stringBuffer.append(" as parent")
            stringBuffer.append("and not: ")
            stringBuffer.append(parentTag.getClass().getName())
            throw new Exception(stringBuffer.toString())
        }
    }

}

object ParentInventoryTagHelper {
    private val instance : ParentInventoryTagHelper = new ParentInventoryTagHelper()

    /**      * @return the instance      */
    def getInstance() : ParentInventoryTagHelper = {
        return ParentInventoryTagHelper.instance
    }

}


