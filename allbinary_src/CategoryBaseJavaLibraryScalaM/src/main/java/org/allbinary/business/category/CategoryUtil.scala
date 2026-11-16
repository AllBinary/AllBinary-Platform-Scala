/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.apache.commons.lang3.StringUtils
import _root_.org.w3c.dom.Attr
import _root_.org.w3c.dom.NamedNodeMap
import _root_.org.w3c.dom.Node

class CategoryUtil private() {
    import _root_.org.allbinary.business.category.CategoryUtil.{*}

}

object CategoryUtil {
    /*    public static synchronized String getPath(String categoryPath)    {       int beginIndex = categoryPath.lastIndexOf(FileData.SEPARATOR);       if(beginIndex < 0) return null;        String path = categoryPath.substring(0, beginIndex);              return path;    }    */
    def getPathLevel(categoryPath : AbPath) : Int = this.synchronized {
        var count : Int = StringUtils.countMatches(categoryPath.toString(), AbPathData.getInstance().SEPARATOR)
        return count
    }

    def getNameFromNode(node : Node) : String = this.synchronized {
        var attributes : NamedNodeMap = node.getAttributes()
        var attrNode : Attr = attributes.getNamedItem(CategoryData.getInstance().LABEL).asInstanceOf[Attr]
        if (attrNode != null) {
            return attrNode.getValue()
        } else {
            //This is for flash request
            var labelNode : Node = DomSearchHelper.getNodeNoThrow(CategoryData.getInstance().LABEL, node.getChildNodes())
            if (labelNode != null) {
                return DomNodeHelper.getTextNodeValue(labelNode)
            }
        }
        return StringUtil.getInstance().EMPTY_STRING
    }

}


