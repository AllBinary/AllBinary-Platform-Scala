/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.java.util.HashMap
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactory
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactoryInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Node

class CategoryAbstractFactory() extends CategoryFactoryInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def getRootInstance() : CategoryInterface = {
        throw new RuntimeException()
    }

    def getRootInstance(categoryAbPath : AbPath) : CategoryInterface = {
        throw new RuntimeException()
    }

    def getRootInstanceFromNode(node : Node) : CategoryInterface = {
        throw new RuntimeException()
    }

    //New Loner Category
    def getInstance(categoryName : String) : CategoryInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                this.logUtil.putF(this.commonStrings.START, this, "getInstance(String)")
            }
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryName)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
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
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryName : String) : CategoryInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                this.logUtil.putF(this.commonStrings.START, this, "getInstance(CategoryInterface, CategoryInterface, String)")
            }
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryName)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getInstance(CategoryInterface, CategoryInterface , String, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(node : Node) : CategoryInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                this.logUtil.putF(this.commonStrings.START, this, "getInstance(Node)")
            }
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(node)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
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

    /*    public CategoryInterface getInstance(Node node, int level)    {       try       {          CategoryPropertiesFactoryInterface categoryPropertiesFactoryInterface =              (CategoryPropertiesFactoryInterface) new CategoryPropertiesFactory(node);                    return (CategoryInterface) new Category(             categoryPropertiesFactoryInterface, level);       }       catch(Exception e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR))          {             LogUtil.put(this.commonStrings.EXCEPTION, this, "getInstance(Node, int)", e);          }          return null;       }    }    */
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, node : Node) : CategoryInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                this.logUtil.putF(this.commonStrings.START, this, "getInstance(CategoryInterface, CategoryInterface, Node)")
            }
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(node)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
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
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesHashMap : HashMap[Object, Object]) : CategoryInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                this.logUtil.putF(this.commonStrings.START, this, "getInstance(CategoryInterface, CategoryInterface, HashMap)")
            }
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new CategoryPropertiesFactory(categoryPropertiesHashMap)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(rootCategoryInterface, parentCategoryInterface, categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(CategoryInterface, CategoryInterface, HashMap)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


