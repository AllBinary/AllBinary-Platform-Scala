/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.w3c.dom.NodeList

/**  *  * @author user  */
class DomNodeListHelper {
    import _root_.org.allbinary.data.tree.dom.DomNodeListHelper.{*}

}

object DomNodeListHelper {
    def getVector(nodeList : NodeList) : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        var size : Int = nodeList.getLength()

        {
            var index : Int = 0
            while (index < size) {
                vector.add(DomNodeHelper.getTextNodeValue(nodeList.item(index)))
                index += 1
            }
        }
        return vector
    }

}


