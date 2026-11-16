/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.java.util.Arrays
import _root_.org.allbinary.business.category.CategoryView
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.visual.theme.ThemeValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StoreThemeCategoryView(param_categoryInterface : StoreThemeCategoryInterface) extends CategoryView(param_categoryInterface.asInstanceOf[StoreThemeCategoryInterface]) with DomNodeInterface {

    //Constructor
    {
        val categoryInterface : StoreThemeCategoryInterface = param_categoryInterface
    }

    override def toXmlNode(document : Document) : Node = {
        val node : Node = super.toXmlNode(document)
        val storeThemeCategoryInterface : StoreThemeCategoryInterface = this.getCategoryInterface().asInstanceOf[StoreThemeCategoryInterface]
        val themeValidationArray : Array[ThemeValidation] = storeThemeCategoryInterface.getThemes().toArray().asInstanceOf[Array[ThemeValidation]]
        Arrays.sort(themeValidationArray, new ThemeComparator())
        var size : Int = themeValidationArray.length

        {
            var index : Int = 0
            while (index < size) {
                var themeValidation : ThemeValidation = themeValidationArray(index).asInstanceOf[ThemeValidation]
                node.appendChild(themeValidation.toXmlNode(document))
                index += 1
            }
        }
        /*       Object[] themeArray = storeThemeCategoryInterface.getThemes().toArray();       int size = themeArray.length;       for (int i = 0; i < size; i++)       {          ThemeValidation themeValidation = (ThemeValidation) themeArray[i];           node.appendChild(themeValidation.toXmlNode(document));       }       */
        return node
    }

}


