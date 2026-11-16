/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties

import _root_.java.util.HashMap
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.CategoryUtil
import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchyInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

/*  *Nothing more than a parent category reference to a category on the fs.  *i.e. unloaded category.  */
class CategoryProperties private () extends CategoryPropertiesInterface {
    import _root_.org.allbinary.business.category.properties.CategoryProperties.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var category : String = null

    def this(name : String) = {
        this()
        this.category = name
    }

    def this(node : Node) = {
        this()
        this.category = CategoryUtil.getNameFromNode(node)
    }

    def this(categoryPropertiesHashMap : HashMap[Object, Object]) = {
        this()
        this.category = new String(categoryPropertiesHashMap.get(CategoryData.getInstance().NAME).asInstanceOf[String])
    }

    def isRealRoot() : Boolean = {
        return false
    }

    def isRoot() : Boolean = {
        return false
    }

    def getKey() : Object = {
        return this.getValue().asInstanceOf[Object]
    }

    def getValue() : String = {
        return this.category
    }

    def getPath(categoryHierarchyInterface : CategoryHierarchyInterface) : AbPath = {
        val abPathData : AbPathData = AbPathData.getInstance()
        val pathStringBuffer : StringMaker = new StringMaker()
        val list : BasicArrayList = new BasicArrayListD()
        var nextParentCategoryInterface : CategoryInterface = categoryHierarchyInterface.getParent()
        //i.e. it would create an infinite loop
        if (this ne nextParentCategoryInterface.getProperties()) {
            var depthIndex : Int = 0

            {
                scala.util.boundary { (break_N73775 : scala.util.boundary.Label[Unit]) ?=>
                    while (nextParentCategoryInterface != null) {
                        //ignore the root if it is the real root to stop from using the root category value
                        if (nextParentCategoryInterface.getProperties().isRealRoot()) {
                            scala.util.boundary.break()(using break_N73775)
                        }
                        //if a root that is also not the real root bu an offset then add the path
                        if (nextParentCategoryInterface.getProperties().isRoot()) {
                            list.addAt(0, nextParentCategoryInterface.getPath().toString())
                        } else {
                            pathStringBuffer.delete(0, pathStringBuffer.length())
                            list.addAt(0, pathStringBuffer.append(abPathData.SEPARATOR).append(nextParentCategoryInterface.getProperties().getValue()).toString())
                        }
                        //at root
                        if (nextParentCategoryInterface eq nextParentCategoryInterface.getHierarchy().getParent()) {
                            scala.util.boundary.break()(using break_N73775)
                        }
                        nextParentCategoryInterface = nextParentCategoryInterface.getHierarchy().getParent()
                        depthIndex += 1
                        if (depthIndex > CategoryProperties.MAXDEPTH) {
                            //throw new Exception("Depth is to high: Probably child == parent");
                            throw new Exception("Probably Major Error")
                        }
                    }
                }
            }
        }
        pathStringBuffer.delete(0, pathStringBuffer.length())
        pathStringBuffer.append(abPathData.SEPARATOR).append(this.getValue())
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                pathStringBuffer.append(list.get(index).asInstanceOf[String])
                index += 1
            }
        }
        pathStringBuffer.append(abPathData.SEPARATOR)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF("path = " + pathStringBuffer.toString(), this, "getPath")
        }
        return new AbPath(pathStringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
    }

    def getFileName() : String = {
        return (this.getValue() + AbPathData.getInstance().EXTENSION_SEP) + CategoryData.getInstance().UNCRYPTED_EXTENSION
    }

    def getWebAppPath() : AbPath = {
        throw new Exception("Not Root")
    }

    /*    public String getFilePath(CategoryHierarchyInterface categoryHierarchyInterface)       throws Exception    {       return this.getPath(categoryHierarchyInterface) + FileData.SEPARATOR + this.getFileName();    }    */
    def setValue(value : String) : Unit = {
        this.category = value
    }

    def isValid() : _root_.java.lang.Boolean = {
        var returnBoolean : _root_.java.lang.Boolean = _root_.java.lang.Boolean.FALSE
        if (StringValidationUtil.getInstance().isValidRequired(this.category, 1, AbSqlData.MAXSTRING)) {
            returnBoolean = _root_.java.lang.Boolean.TRUE
        }
        return returnBoolean
    }

    def toHashMap() : HashMap[Object, Object] = {
        var categoryHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        categoryHashMap.put(CategoryData.getInstance().NAME, this.category)
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

object CategoryProperties {
    private val MAXDEPTH : Int = 100

}


