/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.Category
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactoryInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.visual.theme.ThemeData
import _root_.org.allbinary.logic.visual.theme.ThemeValidation
import _root_.org.allbinary.logic.visual.theme.ThemesData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class StoreThemeCategory private (super_1 : CategoryInterface, super_2 : CategoryInterface, super_3 : CategoryPropertiesFactoryInterface, constructor_ : Unit) extends Category(super_1, super_2, super_3) with StoreThemeCategoryInterface {

    private var transformInfoInterface : TransformInfoInterface = null

    //BasicArrayList of themes
    private var themeVector : BasicArrayList = null

    //New Category With Parent Child Relationships
    def this(transformInfoInterface : TransformInfoInterface, node : Node, rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface) = {
        this(rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface, ())
        this.transformInfoInterface = transformInfoInterface
        this.themeVector = new BasicArrayListD()
        this.addThemes(node)
    }

    //New Category With Parent Child Relationships
    def this(transformInfoInterface : TransformInfoInterface, rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface) = {
        this(rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface, ())
        this.transformInfoInterface = transformInfoInterface
        this.themeVector = new BasicArrayListD()
    }

    def this(transformInfoInterface : TransformInfoInterface, node : Node, categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface, level : Int) = {
        this(categoryPropertiesFactoryInterface, level, null, ())
        this.transformInfoInterface = transformInfoInterface
        this.themeVector = new BasicArrayListD()
        this.addThemes(node)
    }

    //New Loner Category
    def this(transformInfoInterface : TransformInfoInterface, categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface, level : Int) = {
        this(categoryPropertiesFactoryInterface, level, null, ())
        this.transformInfoInterface = transformInfoInterface
        this.themeVector = new BasicArrayListD()
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.transformInfoInterface
    }

    def addThemes(node : Node) : Unit = {
        var themesNode : Node = DomSearchHelper.getNode(ThemesData.getInstance().NAME, node.getChildNodes())
        var nodeList : NodeList = themesNode.getChildNodes()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var themeNode : Node = nodeList.item(index)
                if (themeNode.getNodeName().compareTo(ThemeData.getInstance().NAME) == 0) {
                    this.themeVector.add(new ThemeValidation(this, themeNode))
                }
                index += 1
            }
        }
    }

    //ThemeInterface themeInterface
    def addTheme(themeValidation : ThemeValidation) : Unit = {
        //Interface
        this.themeVector.add(themeValidation)
    }

    def getThemes() : BasicArrayList = {
        return this.themeVector
    }

    override def isValid() : _root_.java.lang.Boolean = {
        if (!super.isValid().booleanValue()) {
            return _root_.java.lang.Boolean.FALSE
        }
        /*       int size = this.themeVector.size();       for (int i = 0; i < size; i++)       {          Category category = (Category) this.themeVector.get(i);          if(!category.isValid().booleanValue()) return Boolean.FALSE;       }       */
        return _root_.java.lang.Boolean.TRUE
    }

    override def toHashMap() : HashMap[Object, Object] = {
        var categoryHashMap : HashMap[Object, Object] = super.toHashMap().asInstanceOf[HashMap[Object, Object]]
        categoryHashMap.put(ThemesData.getInstance().NAME, this.themeVector)
        return categoryHashMap
    }

    override def toVector() : BasicArrayList = {
        var categoryVector : BasicArrayList = super.toVector()
        //categoryVector.add(this.themeVector);
        return categoryVector
    }

}


