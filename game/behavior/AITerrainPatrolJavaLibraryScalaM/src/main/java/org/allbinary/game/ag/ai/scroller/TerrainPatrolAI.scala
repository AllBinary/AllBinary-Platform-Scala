/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.terrain.BasicTerrainInfo
import _root_.org.allbinary.game.terrain.TerrainEvent
import _root_.org.allbinary.game.terrain.TerrainEventCircularStaticPool
import _root_.org.allbinary.game.terrain.TerrainEventHandler
import _root_.org.allbinary.game.terrain.TerrainEventListener
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
class TerrainPatrolAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends PacePatrolAI(param_hashtable, param_ownerLayerInterface, param_gameInput) {

    private val terrainEventListener : TerrainEventListener = new TerrainEventListener()

    private val DOWN : Angle = AngleFactory.getInstance().DOWN

    private val CLIFF : BasicTerrainInfo = new BasicTerrainInfo(this.DOWN)

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        TerrainEventHandler.getInstance(ownerLayerInterface).addListener(this.terrainEventListener)
        this.terrainEventListener.onTerrainEvent(TerrainEventCircularStaticPool.getInstance().getNext(this.CLIFF))
    }

    override def update() : Unit = {
        super.update()
        this.changeDirectionIfCliffReached()
    }

    private def changeDirectionIfCliffReached() : Unit = {
        val list : BasicArrayList = this.terrainEventListener.getList()
        // Limit pacing to a perch/shelf area
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                val terrainEvent : TerrainEvent = list.removeAt(index).asInstanceOf[TerrainEvent]
                val basicTerrainInfo : BasicTerrainInfo = terrainEvent.getBasicTerrainInfo()
                val angle : Angle = basicTerrainInfo.getAngle()
                if (angle eq this.DOWN) {
                    // this.logUtil.putF("TerrainEvent: " + terrainEvent.getBasicTerrainInfo().getAngle().getValue(), this, this.commonStrings.PROCESS);
                    this.nextDirection()
                    if (!this.isFollowLimitedByTerrain) {
                        this.logUtil.putF("Following Limited", this, "onTerrainEvent")
                        this.isFollowLimitedByTerrain = true
                    }
                }
                index += 1
            }
        }
    }

}


