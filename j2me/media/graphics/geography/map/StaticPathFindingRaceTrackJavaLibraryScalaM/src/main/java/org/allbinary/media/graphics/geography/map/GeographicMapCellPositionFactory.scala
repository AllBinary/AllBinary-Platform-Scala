/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.ABHashtable

class GeographicMapCellPositionFactory extends GeographicMapCellPositionBaseFactory {
    import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //For the Non Caching version - Turning off caching here requires turning of caching of paths as well
    override def getInstance(geographicMapInterface : BasicGeographicMap) : BasicGeographicMapCellPositionFactory = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val allBinaryTiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        var geographicMapCellPositionFactoryCanBeNull : Object = GeographicMapCellPositionFactory.hashtable.get(allBinaryTiledLayer.getDataId())
        if (geographicMapCellPositionFactoryCanBeNull == null) {
            this.logUtil.putF(new StringMaker().append("Creating GeographicMapCellPositionFactory for TileLayer: ").appendint(allBinaryTiledLayer.getDataId().intValue()).toString(), this, commonStrings.GET_INSTANCE)
            geographicMapCellPositionFactoryCanBeNull = new BasicGeographicMapCellPositionFactory(geographicMapInterface)
            GeographicMapCellPositionFactory.hashtable.put(allBinaryTiledLayer.getDataId(), geographicMapCellPositionFactoryCanBeNull)
            return geographicMapCellPositionFactoryCanBeNull.asInstanceOf[BasicGeographicMapCellPositionFactory]
        } else {
            this.logUtil.putF(new StringMaker().append("Reusing GeographicMapCellPositionFactory for TileLayer: ").appendint(allBinaryTiledLayer.getDataId().intValue()).toString(), this, commonStrings.GET_INSTANCE)
            return geographicMapCellPositionFactoryCanBeNull.asInstanceOf[BasicGeographicMapCellPositionFactory]
        }
        throw new IllegalStateException()
    }

}

object GeographicMapCellPositionFactory {
    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def getHashtable() : ABHashtable[Object, Object] = {
        return GeographicMapCellPositionFactory.hashtable
    }

}


