/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.java.util.HashMap
import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.CategoryUtil
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactory
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactoryInterface
import _root_.org.allbinary.business.category.properties.root.store.theme.RootStoreThemeCategoryPropertiesFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Node

class StoreThemeCategoryFactory(param_transformInfoInterface : TransformInfoInterface) extends CategoryFactoryInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var transformInfoInterface : TransformInfoInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF(this.commonStrings.START, this, "StoreCategoryFactory(TransformInfoInterface transformInfoInterface)")
        }
        this.transformInfoInterface = transformInfoInterface
    }

    //Create new Root
    def getRootInstance() : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new RootStoreThemeCategoryPropertiesFactory(this.transformInfoInterface)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, categoryPropertiesFactoryInterface, 0)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getRootInstance()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //Create new Root
    def getRootInstance(categoryAbPath : AbPath) : CategoryInterface = {
        try {
            var level : Int = CategoryUtil.getPathLevel(categoryAbPath)
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new RootStoreThemeCategoryPropertiesFactory(this.transformInfoInterface, categoryAbPath)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getRootInstance(String)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getRootInstanceFromNode(node : Node) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new RootStoreThemeCategoryPropertiesFactory(this.transformInfoInterface, node)).asInstanceOf[CategoryPropertiesFactoryInterface]
            var categoryPath : AbPath = new AbPath(CategoryUtil.getNameFromNode(node), StringUtil.getInstance().EMPTY_STRING)
            var level : Int = CategoryUtil.getPathLevel(categoryPath)
            return (new StoreThemeCategory(this.transformInfoInterface, node, categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getRootInstance(node)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //New Loner Category
    def getInstance(categoryPath : String, level : Int) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryPath)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getInstance(String, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //New Category With Parent Child Relationships
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPath : String) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryPath)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(CategoryInterface, CategoryInterface , String, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(node : Node, level : Int) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(node)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getInstance(Node, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, node : Node) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(node)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(CategoryInterface, CategoryInterface, Node, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //Create from request
    def getInstance(categoryPropertiesHashMap : HashMap[Object, Object], level : Int) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryPropertiesHashMap)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getInstance(HashMap)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //Create from request
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesHashMap : HashMap[Object, Object]) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryPropertiesHashMap)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new StoreThemeCategory(this.transformInfoInterface, rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(CategoryInterface, CategoryInterface, HashMap)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


