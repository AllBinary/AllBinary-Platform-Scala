/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.properties.CategoryPropertiesInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesView
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.anyType.InterfaceUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CategoryView(param_categoryInterface : CategoryInterface) extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var categoryInterface : CategoryInterface = null

    //Constructor
    {
        val categoryInterface : CategoryInterface = param_categoryInterface
        this.categoryInterface = categoryInterface
    }

    def getCategoryInterface() : CategoryInterface = {
        return this.categoryInterface
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(CategoryData.getInstance().NAME)
        /*       NamedNodeMap nodeAttributes = node.getAttributes();       Attr nameAttr = document.createAttribute(DomData.ID);       nameAttr.setValue(this.getCategoryInterface().getPath());       CategoryData.ROOTCATEGORY       nodeAttributes.setNamedItem(nameAttr);        */
        var childCategoryVector : BasicArrayList = this.categoryInterface.getChildNodes()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF("Number Of Children: " + childCategoryVector.size(), this, "toXmlNode")
        }
        var size : Int = childCategoryVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var anyType : Object = childCategoryVector.get(i)
                var categoryPropertiesInterface : CategoryPropertiesInterface = null
                if (InterfaceUtil.isImplemented("CategoryPropertiesInterface", anyType)) {
                    categoryPropertiesInterface = anyType.asInstanceOf[CategoryPropertiesInterface]
                } else if (InterfaceUtil.isImplemented("CategoryInterface", anyType)) {
                    var categoryInterface : CategoryInterface = anyType.asInstanceOf[CategoryInterface]
                    categoryPropertiesInterface = categoryInterface.getProperties()
                } else {
                    var isImpl : String = InterfaceUtil.viewAll(anyType.getClass(), CommonSeps.getInstance().NEW_LINE)
                    //"CategoryView found unknown object:\n" + 
                    throw new Exception(("CategoryView found unknown object.\n" + "Show Testing:") + isImpl)
                }
                var childCategoryNode : Node = new CategoryPropertiesView(categoryPropertiesInterface).toXmlNode(document)
                node.appendChild(childCategoryNode)
                i += 1
            }
        }
        return node
    }

}


