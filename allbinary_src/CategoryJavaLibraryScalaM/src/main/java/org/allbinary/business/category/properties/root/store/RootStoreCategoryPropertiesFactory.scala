/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties.root.store

import _root_.java.util.HashMap
import _root_.org.allbinary.business.category.properties.CategoryPropertiesFactoryInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Node

class RootStoreCategoryPropertiesFactory private () extends CategoryPropertiesFactoryInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var categoryPropertiesInterface : CategoryPropertiesInterface = null

    def this(transformInfoInterface : TransformInfoInterface, abPath : AbPath) = {
        this()
        this.categoryPropertiesInterface = (new RootStoreCategoryProperties(transformInfoInterface, abPath)).asInstanceOf[CategoryPropertiesInterface]
    }

    def this(transformInfoInterface : TransformInfoInterface, node : Node) = {
        this()
        this.categoryPropertiesInterface = (new RootStoreCategoryProperties(transformInfoInterface, node)).asInstanceOf[CategoryPropertiesInterface]
    }

    def this(transformInfoInterface : TransformInfoInterface, categoryPropertiesHashMap : HashMap[Object, Object]) = {
        this()
        this.categoryPropertiesInterface = (new RootStoreCategoryProperties(transformInfoInterface, categoryPropertiesHashMap)).asInstanceOf[CategoryPropertiesInterface]
    }

    def this(transformInfoInterface : TransformInfoInterface) = {
        this()
        this.categoryPropertiesInterface = (new RootStoreCategoryProperties(transformInfoInterface)).asInstanceOf[CategoryPropertiesInterface]
    }

    //New Loner Category
    def getInstance() : CategoryPropertiesInterface = {
        try {
            return this.categoryPropertiesInterface.asInstanceOf[CategoryPropertiesInterface]
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


