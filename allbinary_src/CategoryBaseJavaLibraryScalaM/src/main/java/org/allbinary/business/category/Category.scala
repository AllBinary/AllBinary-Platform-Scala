/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchy
import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchyInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactoryInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesInterface
import _root_.org.allbinary.business.category.properties.root.RootCategoryPropertiesInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class Category private () extends CategoryInterface {
    import _root_.org.allbinary.business.category.Category.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var categoryHierarchyInterface : CategoryHierarchyInterface = null

    private var categoryPropertiesInterface : CategoryPropertiesInterface = null

    //BasicArrayList of child Categories
    private val childCategoryVector : BasicArrayList = new BasicArrayListD()

    private val typeVector : BasicArrayList = new BasicArrayListD()

    private val PROPERTIES : Integer = new Integer(1)

    private val CATEGORY : Integer = new Integer(0)

    //New Category With Parent Child Relationships
    def this(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface) = {
        this()
        this.categoryPropertiesInterface = categoryPropertiesFactoryInterface.getInstance().asInstanceOf[CategoryPropertiesInterface]
        this.categoryHierarchyInterface = (new CategoryHierarchy(rootCategoryInterface, parentCategoryInterface)).asInstanceOf[CategoryHierarchyInterface]
        this.log()
    }

    def this(categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface, level : Int) = {
        this()
        this.categoryPropertiesInterface = categoryPropertiesFactoryInterface.getInstance()
        this.categoryHierarchyInterface = (new CategoryHierarchy(this, this, level)).asInstanceOf[CategoryHierarchyInterface]
        this.log()
    }

    //New Loner Category
    def this(categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, "Category(CategoryPropertiesFactoryInterface)")
        }
        this.categoryPropertiesInterface = categoryPropertiesFactoryInterface.getInstance()
        this.categoryHierarchyInterface = (new CategoryHierarchy(this, this)).asInstanceOf[CategoryHierarchyInterface]
        this.log()
    }

    def getKey() : Object = {
        return this.categoryPropertiesInterface.getKey()
    }

    def getRootFilePath() : AbPath = {
        var rootAbPath : AbPath = new AbPath(NOT_ROOT, StringUtil.getInstance().EMPTY_STRING)
        var categoryInterface : CategoryInterface = this.categoryHierarchyInterface.getRoot()
        if (categoryInterface.getProperties().isRoot()) {
            var rootCategoryPropertiesInterface : RootCategoryPropertiesInterface = categoryInterface.getProperties().asInstanceOf[RootCategoryPropertiesInterface]
            rootAbPath = rootCategoryPropertiesInterface.getRootFilePath()
        }
        return rootAbPath
    }

    def getFilePath() : AbPath = {
        return new AbPath(this.getRootFilePath().toString() + this.getProperties().getPath(this.getHierarchy()).toString(), this.getProperties().getFileName())
    }

    def getWebAppPath() : AbPath = {
        var categoryInterface : CategoryInterface = this.categoryHierarchyInterface.getRoot()
        return categoryInterface.getProperties().getWebAppPath()
    }

    def getPath() : AbPath = {
        return this.categoryPropertiesInterface.getPath(this.categoryHierarchyInterface)
    }

    def addChildProperty(categoryPropertiesInterface : CategoryPropertiesInterface) : Boolean = this.synchronized {
        this.typeVector.add(this.PROPERTIES)
        return this.childCategoryVector.add(categoryPropertiesInterface)
    }

    def addChild(categoryInterface : CategoryInterface) : Boolean = this.synchronized {
        //remove duplicate if available
        this.removeDuplicateChild(categoryInterface)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF("adding", this, "addChild")
        }
        //update relationship
        var childCategoryHierarchyInterface : CategoryHierarchyInterface = categoryInterface.getHierarchy()
        childCategoryHierarchyInterface.setParent(this)
        childCategoryHierarchyInterface.setRoot(this.getHierarchy().getRoot())
        categoryInterface.setHierarchy(childCategoryHierarchyInterface)
        this.typeVector.add(this.CATEGORY)
        return this.childCategoryVector.add(categoryInterface)
    }

    def getChildNodes() : BasicArrayList = {
        return this.childCategoryVector
    }

    //private static final String CATEGORYPROPERTIESINTERFACE = "CategoryPropertiesInterface";
    def removeChild(categoryInterface : CategoryInterface) : Boolean = this.synchronized {
        val removalVector : BasicArrayList = new BasicArrayListD()
        var bool_return : Boolean = false
        val size : Int = this.childCategoryVector.size()

        {
            var index : Int = 0
            while (index < size) {
                if (this.CATEGORY == this.typeVector.get(index)) {
                    var anyType : Object = this.childCategoryVector.get(index)
                    var currentCategoryInterface : CategoryInterface = anyType.asInstanceOf[CategoryInterface]
                    if (currentCategoryInterface.getProperties().getValue().compareTo(categoryInterface.getProperties().getValue()) == 0) {
                        removalVector.add(currentCategoryInterface)
                        bool_return = true
                    }
                }
                index += 1
            }
        }
        this.removal(removalVector)
        return bool_return
    }

    final private def removal(removalVector : BasicArrayList) : Unit = {
        val removalSize : Int = removalVector.size()

        {
            var index : Int = 0
            while (index < removalSize) {
                var anyType : Object = removalVector.get(index)
                var objectIndex : Int = this.childCategoryVector.indexOf(anyType)
                this.typeVector.remove(Integer.valueOf(objectIndex))
                this.childCategoryVector.remove(Integer.valueOf(objectIndex))
                index += 1
            }
        }
    }

    private def removeDuplicateChild(categoryInterface : CategoryInterface) : Boolean = this.synchronized {
        val removalVector : BasicArrayList = new BasicArrayListD()
        var bool_return : Boolean = false
        val size : Int = this.childCategoryVector.size()

        {
            var index : Int = 0
            scala.util.boundary { (break_N77124 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    var anyType : Object = this.childCategoryVector.get(index)
                    if (this.PROPERTIES == this.typeVector.get(index)) {
                        var categoryPropertiesInterface : CategoryPropertiesInterface = anyType.asInstanceOf[CategoryPropertiesInterface]
                        if (categoryInterface.getProperties().getValue().compareTo(categoryPropertiesInterface.getValue()) == 0) {
                            removalVector.add(categoryPropertiesInterface)
                            bool_return = true
                            scala.util.boundary.break()(using break_N77124)
                        }
                    } else if (this.CATEGORY == this.typeVector.get(index)) {
                        var existingCategoryInterface : CategoryInterface = anyType.asInstanceOf[CategoryInterface]
                        var categoryPropertiesInterface : CategoryPropertiesInterface = existingCategoryInterface.getProperties()
                        if (categoryInterface.getProperties().getValue().compareTo(categoryPropertiesInterface.getValue()) == 0) {
                            removalVector.add(existingCategoryInterface)
                            bool_return = true
                            scala.util.boundary.break()(using break_N77124)
                        }
                    }
                    index += 1
                }
            }
        }
        this.removal(removalVector)
        return bool_return
    }

    def isLeaf() : Boolean = {
        if (this.childCategoryVector == null) {
            throw new Exception("Category Error")
        }
        if (this.childCategoryVector.size() == 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getProperties() : CategoryPropertiesInterface = {
        return this.categoryPropertiesInterface
    }

    def setProperties(categoryPropertiesInterface : CategoryPropertiesInterface) : Unit = {
        this.categoryPropertiesInterface = categoryPropertiesInterface
    }

    def getHierarchy() : CategoryHierarchyInterface = {
        return this.categoryHierarchyInterface
    }

    def setHierarchy(categoryHierarchyInterface : CategoryHierarchyInterface) : Unit = {
        this.categoryHierarchyInterface = categoryHierarchyInterface
    }

    def isValid() : _root_.java.lang.Boolean = this.synchronized {
        if (!this.categoryPropertiesInterface.isValid().booleanValue()) {
            return _root_.java.lang.Boolean.FALSE
        }
        val size : Int = this.childCategoryVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var anyType : Object = this.childCategoryVector.get(index)
                if (this.PROPERTIES == this.typeVector.get(index)) {
                    var categoryPropertiesInterface : CategoryPropertiesInterface = anyType.asInstanceOf[CategoryPropertiesInterface]
                    if (!categoryPropertiesInterface.isValid().booleanValue()) {
                        return _root_.java.lang.Boolean.FALSE
                    }
                } else if (this.CATEGORY == this.typeVector.get(index)) {
                    var categoryInterface : CategoryInterface = anyType.asInstanceOf[CategoryInterface]
                    if (!categoryInterface.isValid().booleanValue()) {
                        return _root_.java.lang.Boolean.FALSE
                    }
                }
                index += 1
            }
        }
        return _root_.java.lang.Boolean.TRUE
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

    def toHashMap() : HashMap[Object, Object] = {
        var categoryHashMap : HashMap[Object, Object] = this.categoryPropertiesInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        return categoryHashMap
    }

    def toVector() : BasicArrayList = {
        var categoryVector : BasicArrayList = this.categoryPropertiesInterface.toVector()
        categoryVector.add(this.childCategoryVector)
        return categoryVector
    }

    def log() : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Category Name: ")
            stringBuffer.append(this.categoryPropertiesInterface.getValue())
            stringBuffer.append("\nPath = ")
            stringBuffer.append(this.getPath().toString())
            stringBuffer.append("\nFile Path: ")
            stringBuffer.append(this.getFilePath().toString())
            this.logUtil.putF(stringBuffer.toString(), this, "log()")
        }
    }

}

object Category {
    private val NOT_ROOT : String = "This is not the root so it has no file path."

}


