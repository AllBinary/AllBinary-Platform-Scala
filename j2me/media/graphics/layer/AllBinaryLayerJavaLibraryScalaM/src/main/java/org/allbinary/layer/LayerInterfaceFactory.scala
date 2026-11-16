/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class LayerInterfaceFactory {
    import _root_.org.allbinary.layer.LayerInterfaceFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var list : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    private val HASHTABLE_LABEL : String = "Hashtable: "

    def init() : Unit = {
        this.list = new BasicArrayListD()
    }

    def getNexInstance(hashtable : ABHashtable[Object, Object], x : Int, y : Int, z : Int) : AllBinaryLayer = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(new StringMaker().append(this.HASHTABLE_LABEL).append(StringUtil.getInstance().toString(hashtable)).toString(), this, commonStrings.GET_INSTANCE)
        val typeInteger : Integer = hashtable.get(Layer.ID.asInstanceOf[Object]).asInstanceOf[Integer]
        /*       if(this.list.objectArray.length <= typeInteger.intValue() - 1)       {        PrelogUtil.putF("Layer ID: ").append(typeInteger.toString(), this, commonStrings.GET_INSTANCE);       }       */
        val layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface = this.list.objectArray(typeInteger.intValue() - 1).asInstanceOf[LayerInterfaceFactoryInterface]
        /*       if(layerInterfaceFactoryInterface == null)       {        PrelogUtil.putF("Layer ID: ").append(typeInteger.toString(), this, commonStrings.GET_INSTANCE);       }       */
        return layerInterfaceFactoryInterface.getNextInstance(hashtable, x, y, z)
    }

    def add(layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface) : Unit = {
        this.list.add(layerInterfaceFactoryInterface)
    }

}

object LayerInterfaceFactory {
    private val SINGLETON : LayerInterfaceFactory = new LayerInterfaceFactory()

    def getInstance() : LayerInterfaceFactory = {
        return LayerInterfaceFactory.SINGLETON
    }

}


