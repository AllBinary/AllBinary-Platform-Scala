/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CategoriesView(param_categoryInterface : CategoryInterface) extends DomNodeInterface {

    private var categoryInterface : CategoryInterface = null

    //Constructor
    {
        val categoryInterface : CategoryInterface = param_categoryInterface
        this.categoryInterface = categoryInterface
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = new CategoryView(this.categoryInterface).toXmlNode(document)
        var childArray : Array[Object] = this.categoryInterface.getChildNodes().toArray()
        var size : Int = childArray.length

        {
            var i : Int = 0
            while (i < size) {
                var childCategoryInterface : CategoryInterface = childArray(i).asInstanceOf[CategoryInterface]
                var childCategoryNode : Node = new CategoriesView(childCategoryInterface).toXmlNode(document)
                node.appendChild(childCategoryNode)
                i += 1
            }
        }
        return node
    }

}


