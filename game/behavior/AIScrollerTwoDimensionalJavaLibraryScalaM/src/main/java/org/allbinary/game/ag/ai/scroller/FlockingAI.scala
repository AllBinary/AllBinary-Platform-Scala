/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.layer.identification.GroupLayerManagerListener
import _root_.org.allbinary.game.layer.weapon.WeaponLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

class FlockingAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    private var allowedDistance : Int = 0

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        val allowedDistance : Integer = hashtable.get(BasePatrolAI.MAX_DISTANCE).asInstanceOf[Integer]
        this.allowedDistance = allowedDistance.intValue()
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        var maxDistance : Int = 0
        var farAllbinaryLayer : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER
        val groupLayerManagerListener : GroupLayerManagerListener = GroupLayerManagerListener.getInstance()
        val list : BasicArrayList = groupLayerManagerListener.getList(BasicGroupFactory.getInstance().ENEMY)
        val size : Int = list.size()
        var allBinaryLayer : AllBinaryLayer = null
        var ownerLayerInterface : AllBinaryLayer = null

        {
            var index : Int = 0
            scala.util.boundary { (break_N72820 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    allBinaryLayer = list.get(index).asInstanceOf[AllBinaryLayer]
                    if (allBinaryLayer.getType() != WeaponLayer.getStaticType()) {
                        var distance : Int = this.getXYDistance(allBinaryLayer)
                        if (distance > maxDistance) {
                            maxDistance = distance
                            farAllbinaryLayer = allBinaryLayer
                            if (distance > this.allowedDistance) {
                                scala.util.boundary.break()(using break_N72820)
                            }
                        }
                    }
                    index += 1
                }
            }
        }
        if (maxDistance > this.allowedDistance) {
            // Go towards flock
            if (farAllbinaryLayer ne AllBinaryLayer.NULL_ALLBINARY_LAYER) {
                ownerLayerInterface = this.getOwnerLayerInterface()
                if (farAllbinaryLayer.getXP() < ownerLayerInterface.getXP()) {
                    this.processKeyAI(Canvas.LEFT)
                } else if (farAllbinaryLayer.getXP() > ownerLayerInterface.getXP()) {
                    this.processKeyAI(Canvas.RIGHT)
                } else if (farAllbinaryLayer.getYP() > ownerLayerInterface.getYP()) {
                    this.processKeyAI(Canvas.UP)
                } else if (farAllbinaryLayer.getYP() < ownerLayerInterface.getYP()) {
                    this.processKeyAI(Canvas.DOWN)
                }
            }
        }
    }

    private def getXYDistance(allBinaryLayer : AllBinaryLayer) : Int = {
        val ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        val xTotalDistance : Int = (allBinaryLayer.getXP() + allBinaryLayer.getHalfWidth()) - (ownerLayerInterface.getXP() + ownerLayerInterface.getHalfWidth())
        val yTotalDistance : Int = (allBinaryLayer.getYP() + allBinaryLayer.getHalfHeight()) - (ownerLayerInterface.getYP() + ownerLayerInterface.getHalfHeight())
        val mathUtil : MathUtil = MathUtil.getInstance()
        val totalDistance : Int = mathUtil.abs(xTotalDistance) + mathUtil.abs(yTotalDistance)
        return totalDistance
    }

}


