/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.org.allbinary.business.category.CategoryView
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.visual.theme.ThemeInterface
import _root_.org.allbinary.logic.visual.theme.ThemePropertiesView
import _root_.org.allbinary.logic.visual.theme.ThemeValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StoreThemeCategoryPathView(param_categoryInterface : StoreThemeCategoryInterface) extends CategoryView(param_categoryInterface.asInstanceOf[StoreThemeCategoryInterface]) with DomNodeInterface {

    //Constructor
    {
        val categoryInterface : StoreThemeCategoryInterface = param_categoryInterface
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        var storeThemeCategoryInterface : StoreThemeCategoryInterface = this.getCategoryInterface().asInstanceOf[StoreThemeCategoryInterface]
        var themeArray : Array[Object] = storeThemeCategoryInterface.getThemes().toArray()
        var size : Int = themeArray.length

        {
            var i : Int = 0
            while (i < size) {
                var themeValidation : ThemeValidation = themeArray(i).asInstanceOf[ThemeValidation]
                var domNodeInterface : DomNodeInterface = (new ThemePropertiesView(themeValidation.asInstanceOf[ThemeInterface])).asInstanceOf[DomNodeInterface]
                node.appendChild(domNodeInterface.toXmlNode(document))
                i += 1
            }
        }
        return node
    }

}


