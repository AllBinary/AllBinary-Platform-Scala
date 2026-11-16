/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties.root

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchyInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

/*  *Nothing more than a parent category reference to a category on the fs.    *i.e. unloaded category.  */
class RootCategoryPropertiesAbstract() extends RootCategoryPropertiesInterface {

    private val category : String = CategoryData.getInstance().ROOTCATEGORY

    private val fileName : String = (this.category + AbPathData.getInstance().EXTENSION_SEP) + CategoryData.getInstance().UNCRYPTED_EXTENSION

    def getKey() : Object = {
        return this.getValue().asInstanceOf[Object]
    }

    def getValue() : String = {
        return this.category
    }

    def setValue(value : String) : Unit = {
        throw new Exception("No Value Allowed")
    }

    def setRootFilePath(value : AbPath) : Unit = {
        throw new RuntimeException()
    }

    def setRootFilePath(value : String) : Unit = {
        throw new Exception("No Value Allowed")
    }

    def getRootFilePath() : AbPath = {
        throw new Exception("No Value Allowed")
    }

    def isRealRoot() : Boolean = {
        throw new Exception("No A Real Root")
    }

    def isRoot() : Boolean = {
        throw new Exception("Root but not implemented")
    }

    def getWebAppPath(categoryHierarchyInterface : CategoryHierarchyInterface) : String = {
        throw new Exception("Not Root")
    }

    def getPath(categoryHierarchyInterface : CategoryHierarchyInterface) : AbPath = {
        return AbPath.createAbPath()
    }

    def getFileName() : String = {
        return this.fileName
    }

    /*    public String getFilePath(CategoryHierarchyInterface categoryHierarchyInterface)    {       return this.getPath(categoryHierarchyInterface) + this.getFileName();    }     */
    def isValid() : _root_.java.lang.Boolean = {
        //if() return false;
        return _root_.java.lang.Boolean.TRUE
    }

    def toHashMap() : HashMap[Object, Object] = {
        var categoryHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        categoryHashMap.put(CategoryData.getInstance().NAME, this.category)
        //categoryHashMap.put(CategoryData.LEVEL,new Integer(this.level).toString());
        return categoryHashMap
    }

    def toVector() : BasicArrayList = {
        var categoryVector : BasicArrayList = new BasicArrayListD()
        categoryVector.add(this.category)
        //categoryVector.add(new Integer(this.level).toString());
        return categoryVector
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def validationInfo() : String = {
        return null
    }

}


