/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties.root.store

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryUtil
import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchyInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesInterface
import _root_.org.allbinary.business.category.properties.root.RootCategoryPropertiesInterface
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

/*  *Nothing more than a parent category reference to a category on the fs.    *i.e. unloaded category.  */
class RootStoreCategoryProperties private () extends RootCategoryPropertiesInterface with CategoryPropertiesInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val pathData : AbPathData = AbPathData.getInstance()

    private var fileAbPath : AbPath = null

    private var abPath : AbPath = null

    private var category : String = null

    private var isRealRoot_RootStoreCategoryProperties : Boolean = false

    var webAppAbPath : AbPath = null

    var transformInfoInterface : TransformInfoInterface = null

    //will be storeCategoryPath/Category/Category.xml which is a sub category of the root
    def this(transformInfoInterface : TransformInfoInterface, categoryAbPath : AbPath) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        this.abPath = categoryAbPath
        this.category = this.pathData.getNameFromPath(categoryAbPath.toString())
        if (StringValidationUtil.getInstance().isEmpty(this.category)) {
            this.isRealRoot_RootStoreCategoryProperties = true
            this.category = CategoryData.getInstance().ROOTCATEGORY
        }
        this.initPath()
        this.log()
    }

    def this(transformInfoInterface : TransformInfoInterface, node : Node) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        val categoryPath : String = CategoryUtil.getNameFromNode(node)
        this.abPath = new AbPath(categoryPath, StringUtil.getInstance().EMPTY_STRING)
        this.category = this.pathData.getNameFromPath(categoryPath)
        if (StringValidationUtil.getInstance().isEmpty(this.category)) {
            this.isRealRoot_RootStoreCategoryProperties = true
            this.category = CategoryData.getInstance().ROOTCATEGORY
        }
        this.initPath()
        this.log()
    }

    def this(transformInfoInterface : TransformInfoInterface, categoryPropertiesHashMap : HashMap[Object, Object]) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        val categoryPath : String = new String(categoryPropertiesHashMap.get(CategoryData.getInstance().NAME).asInstanceOf[String])
        this.abPath = new AbPath(categoryPath, StringUtil.getInstance().EMPTY_STRING)
        this.category = this.pathData.getNameFromPath(categoryPath)
        if (StringValidationUtil.getInstance().isEmpty(this.category)) {
            this.isRealRoot_RootStoreCategoryProperties = true
            this.category = CategoryData.getInstance().ROOTCATEGORY
        }
        this.initPath()
        this.log()
    }

    //This is the real root category
    def this(transformInfoInterface : TransformInfoInterface) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        this.abPath = AbPath.createAbPath()
        this.category = CategoryData.getInstance().ROOTCATEGORY
        this.isRealRoot_RootStoreCategoryProperties = true
        this.initPath()
        this.log()
    }

    def initPath() : Unit = {
        val transformInfoHttpStoreInterface : TransformInfoHttpInterface = this.transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
        val storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(transformInfoHttpStoreInterface.getStoreName())
        val postPath : String = storeFrontInterface.getCurrentHostNamePath() + storeFrontInterface.getCategoryPath()
        val httpServletRequest : HttpServletRequest = transformInfoHttpStoreInterface.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        this.webAppAbPath = new AbPath(httpServletRequest.getContextPath() + postPath, StringUtil.getInstance().EMPTY_STRING)
        this.setRootFilePath(new AbPath(URLGLOBALS.getMainPath() + postPath, StringUtil.getInstance().EMPTY_STRING))
    }

    def isRealRoot() : Boolean = {
        return this.isRealRoot_RootStoreCategoryProperties
    }

    def isRoot() : Boolean = {
        return true
    }

    def getKey() : Object = {
        return this.getValue().asInstanceOf[Object]
    }

    def setPath(path : AbPath) : Unit = {
        this.abPath = path
    }

    def setRootFilePath(value : AbPath) : Unit = {
        this.fileAbPath = value
    }

    def getRootFilePath() : AbPath = {
        return this.fileAbPath
    }

    def getValue() : String = {
        return this.category
    }

    def getWebAppPath() : AbPath = {
        return this.webAppAbPath
    }

    def getPath(categoryHierarchyInterface : CategoryHierarchyInterface) : AbPath = {
        return this.abPath
    }

    def getFileName() : String = {
        return (this.getValue() + AbPathData.getInstance().EXTENSION_SEP) + CategoryData.getInstance().UNCRYPTED_EXTENSION
    }

    def setValue(value : String) : Unit = {
        this.category = value
    }

    def isValid() : _root_.java.lang.Boolean = {
        //if() return false;
        return _root_.java.lang.Boolean.TRUE
    }

    def toHashMap() : HashMap[Object, Object] = {
        val categoryHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        categoryHashMap.put(CategoryData.getInstance().NAME, this.getValue())
        //categoryHashMap.put(CategoryData.getInstance().LEVEL,new Integer(this.level).toString());
        return categoryHashMap
    }

    def toVector() : BasicArrayList = {
        var categoryVector : BasicArrayList = new BasicArrayListD()
        categoryVector.add(this.getValue())
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

    def log() : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF(new StringMaker().append("filePath = ").append(this.fileAbPath.toString()).append("\npath = ").append(this.abPath.toString()).append("\ncategory = ").append(this.category).toString(), this, "log()")
        }
    }

}


