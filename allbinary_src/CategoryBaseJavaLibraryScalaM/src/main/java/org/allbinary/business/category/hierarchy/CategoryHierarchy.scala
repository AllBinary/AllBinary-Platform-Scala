/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.hierarchy

import _root_.java.util.HashMap
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.logic.string.StringUtil

/*  *Nothing more than a parent category reference to a category on the fs.    *i.e. unloaded category.  */
class CategoryHierarchy private () extends CategoryHierarchyInterface {

    private var rootCategoryInterface : CategoryInterface = null

    private var parentCategoryInterface : CategoryInterface = null

    private var level : Int = 0

    def this(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, level : Int) = {
        this()
        this.level = level
        this.setRoot(rootCategoryInterface)
        this.setParent(parentCategoryInterface)
    }

    def this(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesHashMap : HashMap[Object, Object]) = {
        this()
        var levelString : String = StringUtil.getInstance().getNonNull(categoryPropertiesHashMap.get(CategoryData.getInstance().LEVEL).asInstanceOf[String])
        this.level = Integer.valueOf(levelString).intValue()
        this.setRoot(rootCategoryInterface)
        this.setParent(parentCategoryInterface)
    }

    def this(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface) = {
        this()
        this.level = 0
        this.setRoot(rootCategoryInterface)
        this.setParent(parentCategoryInterface)
    }

    def getLevel() : Int = {
        return this.level
    }

    def getLevelString() : String = {
        return Integer.toString(this.level)
    }

    def setLevel(level : Int) : Unit = {
        this.level = level
    }

    def setParent(categoryInterface : CategoryInterface) : Unit = {
        this.parentCategoryInterface = categoryInterface
    }

    def setRoot(categoryInterface : CategoryInterface) : Unit = {
        this.rootCategoryInterface = categoryInterface
    }

    def getRoot() : CategoryInterface = {
        return this.rootCategoryInterface
    }

    def getParent() : CategoryInterface = {
        return this.parentCategoryInterface
    }

}


