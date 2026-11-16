/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.game.health.HealthInterfaceCompositeInterface
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.part.CountedLayerInterfaceFactoryPart
import _root_.org.allbinary.game.part.PartInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

class PickupBehavior(param_ownerLayerInterface : CollidableCompositeLayer, param_countedIndex : Int) extends PickupBehaviorInterface {
    import _root_.org.allbinary.game.layer.pickup.PickupBehavior.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var countedIndex : Int = 0

    private var ownerLayerInterface : CollidableCompositeLayer = null

    //Constructor
    {
        val ownerLayerInterface : CollidableCompositeLayer = param_ownerLayerInterface
        val countedIndex : Int = param_countedIndex
        this.ownerLayerInterface = ownerLayerInterface
        this.countedIndex = countedIndex
    }

    override def doPickup(pickupProcessorInterface : PickupProcessorInterface) : Unit = {
        try {
            //Don't process non-weapon pickups if dead
            val healthInterfaceCompositeInterface : HealthInterfaceCompositeInterface = this.ownerLayerInterface.asInstanceOf[HealthInterfaceCompositeInterface]
            if (healthInterfaceCompositeInterface.getHealthInterface().isAlive()) {
                //PreLogUtil.put(commonStrings.PROCESS, this, "doPickup(PickupProcessorInterface)");
                pickupProcessorInterface.process(this.ownerLayerInterface)
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "doPickup", e)
            }
        }
    }

    override def doPickupLayer(pickupLayerInterface : PickedUpLayerInterface) : Unit = {
        try {
            val pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = pickupLayerInterface.getPickedUpLayerInterfaceFactoryInterface()
            val pickedUpLayerType : PickedUpLayerType = pickedUpLayerInterfaceFactoryInterface.getPickedUpLayerType()
            val pickedUpLayerTypeFactory : PickedUpLayerTypeFactory = PickedUpLayerTypeFactory.getInstance()
            if ((((pickedUpLayerType eq pickedUpLayerTypeFactory.BEAM) || (pickedUpLayerType eq pickedUpLayerTypeFactory.MINE)) || (pickedUpLayerType eq pickedUpLayerTypeFactory.PROJECTILE)) || (pickedUpLayerType eq pickedUpLayerTypeFactory.ENHANCEMENT)) {
                this.add(pickedUpLayerInterfaceFactoryInterface.asInstanceOf[CountedPickedUpLayerInterfaceFactoryInterface])
            } else if (pickedUpLayerInterfaceFactoryInterface.getPickedUpLayerType() eq pickedUpLayerTypeFactory.PART) {
                val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = this.ownerLayerInterface.asInstanceOf[CollidableDestroyableDamageableLayer]
                collidableDestroyableDamageableLayer.addPart(pickedUpLayerInterfaceFactoryInterface)
            } else if (pickedUpLayerType eq pickedUpLayerTypeFactory.NONE) {
            } else {
                val pickupProcessorInterface : PickupProcessorInterface = pickedUpLayerInterfaceFactoryInterface.asInstanceOf[PickupProcessorInterface]
                this.doPickup(pickupProcessorInterface)
            }
            pickupLayerInterface.setPickedUp()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                //this.logUtil.putF(commonStrings.EXCEPTION, this, "doPickup");
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, "doPickup", e)
            }
        }
    }

    def add(countedPickedUpLayerInterfaceFactoryInterface : CountedPickedUpLayerInterfaceFactoryInterface) : Unit = {
        val partIndex : Int = countedPickedUpLayerInterfaceFactoryInterface.getId() + this.countedIndex
        this.addAt(countedPickedUpLayerInterfaceFactoryInterface, partIndex)
    }

    def addAt(countedPickedUpLayerInterfaceFactoryInterface : CountedPickedUpLayerInterfaceFactoryInterface, partIndex : Int) : Unit = {
        val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = this.ownerLayerInterface.asInstanceOf[CollidableDestroyableDamageableLayer]
        val countedLayerInterfaceFactory : CountedLayerInterfaceFactoryPart = collidableDestroyableDamageableLayer.getPartInterfaceArray()(partIndex).asInstanceOf[CountedLayerInterfaceFactoryPart]
        countedLayerInterfaceFactory.setTotal(countedLayerInterfaceFactory.getTotal() + countedPickedUpLayerInterfaceFactoryInterface.getTotal())
    }

    def getFirstAvailableCountedLayerInterfaceFactory(pickedUpLayerTypeArray : Array[PickedUpLayerType]) : CountedLayerInterfaceFactoryPart = {
        val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = this.ownerLayerInterface.asInstanceOf[CollidableDestroyableDamageableLayer]
        val partInterfaceArray : Array[PartInterface] = collidableDestroyableDamageableLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var nextCountedLayerInterfaceFactory : CountedLayerInterfaceFactoryPart = null
        var countedPickedUpLayerInterfaceFactory : CountedPickedUpLayerInterfaceFactory = null

        {
            var index : Int = this.countedIndex
            while (index < size) {
                nextCountedLayerInterfaceFactory = collidableDestroyableDamageableLayer.getPartInterfaceArray()(index).asInstanceOf[CountedLayerInterfaceFactoryPart]
                countedPickedUpLayerInterfaceFactory = nextCountedLayerInterfaceFactory.getCountedPickedUpLayerInterfaceFactory()

                {
                    var index2 : Int = pickedUpLayerTypeArray.length
                    while ({ index2 -= 1; index2 } >= 0) {
                        if (countedPickedUpLayerInterfaceFactory.getPickedUpLayerType() eq pickedUpLayerTypeArray(index2)) {
                            /*                      * if(countedPickedUpLayerInterfaceFactory.getPickedUpLayerType                      * () == PickedUpLayerType.PROJECTILE &&                      * this.inFirstPosition) {                      *                       * } else                      */
                            if (nextCountedLayerInterfaceFactory.getTotal() > 0) {
                                return nextCountedLayerInterfaceFactory
                            }
                        }
                    }
                }
                index += 1
            }
        }
        return CountedLayerInterfaceFactoryPart.NULL_COUNTED_LAYER_INTERFACE_FACTORY
    }

    def getCountedLayerInterfaceFactoryForSlot(slotIndex : Int) : CountedLayerInterfaceFactoryPart = {
        var currentSlot : Int = 0
        val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = this.ownerLayerInterface.asInstanceOf[CollidableDestroyableDamageableLayer]
        val partInterfaceArray : Array[PartInterface] = collidableDestroyableDamageableLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var nextCountedLayerInterfaceFactory : CountedLayerInterfaceFactoryPart = null

        {
            var index : Int = this.countedIndex
            while (index < size) {
                nextCountedLayerInterfaceFactory = collidableDestroyableDamageableLayer.getPartInterfaceArray()(index).asInstanceOf[CountedLayerInterfaceFactoryPart]
                if (nextCountedLayerInterfaceFactory.getTotal() > 0) {
                    if (currentSlot == slotIndex) {
                        return nextCountedLayerInterfaceFactory
                    } else {
                        currentSlot += 1
                    }
                }
                index += 1
            }
        }
        return CountedLayerInterfaceFactoryPart.NULL_COUNTED_LAYER_INTERFACE_FACTORY
    }

    def getCountedIndex() : Int = {
        return this.countedIndex
    }

}

object PickupBehavior {
    var NULL_PICKUP_BEHAVIOR : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : PickupBehavior = {
        if (PickupBehavior.NULL_PICKUP_BEHAVIOR eq NullUtil.getInstance().NULL_OBJECT) {
            PickupBehavior.NULL_PICKUP_BEHAVIOR = new PickupBehavior(CollidableCompositeLayer.getNullInstance(), 0)
        }
        return PickupBehavior.NULL_PICKUP_BEHAVIOR.asInstanceOf[PickupBehavior]
    }

}


