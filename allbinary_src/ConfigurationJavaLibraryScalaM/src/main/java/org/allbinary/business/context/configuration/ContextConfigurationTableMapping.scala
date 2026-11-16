/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.configuration

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.StdUtil

class ContextConfigurationTableMapping(param_contextConfigurationInterface : ContextConfigurationInterface) extends TableMappingInterface {

    private var contextConfigurationInterface : ContextConfigurationInterface = null

    //Constructor
    {
        val contextConfigurationInterface : ContextConfigurationInterface = param_contextConfigurationInterface
        this.contextConfigurationInterface = contextConfigurationInterface
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        return hashMap
    }

    def getKey() : Object = {
        return ContextConfigurationData.getInstance().NAME
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        return vector
    }

}


