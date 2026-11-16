/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store

import _root_.org.allbinary.business.category.Category
import _root_.org.allbinary.business.category.CategoryAbstractFactory
import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.CategoryUtil
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactoryInterface
import _root_.org.allbinary.business.category.properties.root.store.RootStoreCategoryPropertiesFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Node

class StoreCategoryFactory(param_transformInfoInterface : TransformInfoInterface) extends CategoryAbstractFactory with CategoryFactoryInterface {

    val logUtil_StoreCategoryFactory : LogUtil = LogUtil.getInstance()

    private var transformInfoInterface : TransformInfoInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil_StoreCategoryFactory.putF(this.commonStrings.START, this, "StoreCategoryFactory(TransformInfoInterface transformInfoInterface)")
        }
        this.transformInfoInterface = transformInfoInterface
    }

    //Completely New Root Category
    override def getRootInstance() : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new RootStoreCategoryPropertiesFactory(this.transformInfoInterface)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(categoryPropertiesFactoryInterface)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil_StoreCategoryFactory.put(this.commonStrings.EXCEPTION, this, "getInstance(String, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //Get Root Category with possible offset from root
    override def getRootInstance(categoryPath : AbPath) : CategoryInterface = {
        try {
            var level : Int = CategoryUtil.getPathLevel(categoryPath)
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new RootStoreCategoryPropertiesFactory(this.transformInfoInterface, categoryPath)).asInstanceOf[CategoryPropertiesFactoryInterface]
            return (new Category(categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil_StoreCategoryFactory.put(commonStrings.EXCEPTION, this, "getInstance(String, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //Get Root Category with possible offset from root
    override def getRootInstanceFromNode(node : Node) : CategoryInterface = {
        try {
            var categoryPropertiesFactoryInterface : CategoryPropertiesFactoryInterface = (new RootStoreCategoryPropertiesFactory(this.transformInfoInterface, node)).asInstanceOf[CategoryPropertiesFactoryInterface]
            var categoryPath : AbPath = new AbPath(CategoryUtil.getNameFromNode(node), StringUtil.getInstance().EMPTY_STRING)
            var level : Int = CategoryUtil.getPathLevel(categoryPath)
            return (new Category(categoryPropertiesFactoryInterface, level)).asInstanceOf[CategoryInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil_StoreCategoryFactory.put(this.commonStrings.EXCEPTION, this, "getInstance(String, int)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


