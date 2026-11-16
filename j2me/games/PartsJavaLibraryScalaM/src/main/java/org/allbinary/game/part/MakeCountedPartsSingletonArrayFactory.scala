/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part

import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactoryPool
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class MakeCountedPartsSingletonArrayFactory {
    import _root_.org.allbinary.game.part.MakeCountedPartsSingletonArrayFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var list : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    def getUpdated(partInterfaceArray : Array[PartInterface]) : Array[PartInterface] = {
        this.list = new BasicArrayListD()

        {
            var index : Int = 0
            while (index < partInterfaceArray.length) {
                this.list.add(partInterfaceArray(index))
                index += 1
            }
        }
        val countedBasicArrayList : BasicArrayList = CountedPickedUpLayerInterfaceFactoryPool.getInstance().getList()
        var layerInterfaceFactoryInterface : CountedPickedUpLayerInterfaceFactory = null
        var size : Int = countedBasicArrayList.size()

        {
            var index : Int = 0
            while (index < size) {
                layerInterfaceFactoryInterface = countedBasicArrayList.objectArray(index).asInstanceOf[CountedPickedUpLayerInterfaceFactory]
                this.list.add(new CountedLayerInterfaceFactoryPart(0, layerInterfaceFactoryInterface))
                index += 1
            }
        }
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Total Parts: ")
        stringBuffer.appendint(this.list.size())
        stringBuffer.append(" Counted: ")
        stringBuffer.appendint(countedBasicArrayList.size())
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(stringBuffer.toString(), this, commonStrings.GET_INSTANCE)
        //final PartInterface[] newPartInterfaceArray = (PartInterface[]) list.toArray(new PartInterface[list.size()]);
        val newPartInterfaceArray : Array[PartInterface] = new Array[PartInterface](this.list.size())
        val newSize : Int = newPartInterfaceArray.length

        {
            var index : Int = 0
            while (index < newSize) {
                newPartInterfaceArray(index) = this.list.get(index).asInstanceOf[PartInterface]
                index += 1
            }
        }
        return newPartInterfaceArray
    }

}

object MakeCountedPartsSingletonArrayFactory {
    private val instance : MakeCountedPartsSingletonArrayFactory = new MakeCountedPartsSingletonArrayFactory()

    def getInstance() : MakeCountedPartsSingletonArrayFactory = {
        return MakeCountedPartsSingletonArrayFactory.instance
    }

}


