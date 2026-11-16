/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties

import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Element
import _root_.org.w3c.dom.Node

class CategoryPropertiesView(param_categoryPropertiesInterface : CategoryPropertiesInterface) extends DomNodeInterface {

    var categoryPropertiesInterface : CategoryPropertiesInterface = null

    //Constructor
    {
        val categoryPropertiesInterface : CategoryPropertiesInterface = param_categoryPropertiesInterface
        this.categoryPropertiesInterface = categoryPropertiesInterface
    }

    def toXmlNode(document : Document) : Node = {
        var categoryNode : Node = document.createElement(CategoryData.getInstance().NAME)
        var newCategoryNode : Element = categoryNode.asInstanceOf[Element]
        newCategoryNode.setAttribute(CategoryData.getInstance().LABEL, this.categoryPropertiesInterface.getValue())
        return categoryNode
    }

}


