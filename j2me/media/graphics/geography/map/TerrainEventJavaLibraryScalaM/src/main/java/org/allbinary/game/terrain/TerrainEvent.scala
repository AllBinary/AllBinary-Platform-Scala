/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.terrain

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class TerrainEvent(param_basicTerrainInfo : Object) extends AllBinaryEventObject(param_basicTerrainInfo) {

    private var basicTerrainInfo : BasicTerrainInfo = BasicTerrainInfo.NULL_BASIC_TERRAIN_INFO

    //Constructor
    {
        val basicTerrainInfo : Object = param_basicTerrainInfo
        this.setBasicTerrainInfo(this.basicTerrainInfo)
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("TerrainEvent: \n")
        stringBuffer.append("LayerInterface: ")
        stringBuffer.append(this.basicTerrainInfo.toString())
        return stringBuffer.toString()
    }

    def getBasicTerrainInfo() : BasicTerrainInfo = {
        return this.basicTerrainInfo
    }

    def setBasicTerrainInfo(basicTerrainInfo : BasicTerrainInfo) : Unit = {
        this.basicTerrainInfo = basicTerrainInfo
    }

    def setBasicTerrainInfoForCircularStaticPool(basicTerrainInfo : BasicTerrainInfo) : Unit = {
        this.basicTerrainInfo = basicTerrainInfo
    }

}


