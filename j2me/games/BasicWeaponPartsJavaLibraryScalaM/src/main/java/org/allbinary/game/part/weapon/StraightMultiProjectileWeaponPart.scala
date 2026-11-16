/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part.weapon

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.layer.weapon.WeaponLayer
import _root_.org.allbinary.game.layer.weapon.WeaponLayerCircularPool
import _root_.org.allbinary.game.score.NoScoreable
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.math.NoDecimalTrigTable

class StraightMultiProjectileWeaponPart(param_animationInterface : Animation, param_sourceLayerInterface : AllBinaryLayer, param_weaponLayerCircularStaticPool : WeaponLayerCircularPool, param_total : Int, param_weaponProperties : WeaponProperties, param_scoreableInterface : ScoreableInterface, param_relativeRelationship : RelativeRelationship) extends BasicWeaponPart(param_animationInterface, param_sourceLayerInterface, param_weaponProperties, param_scoreableInterface, param_relativeRelationship) {
    import _root_.org.allbinary.game.part.weapon.StraightMultiProjectileWeaponPart.{*}

    private var weaponLayerCircularStaticPool : WeaponLayerCircularPool = null

    private var total : Int = 0

    private val noDecimalTrigTable : NoDecimalTrigTable = NoDecimalTrigTable.getInstance()

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val sourceLayerInterface : AllBinaryLayer = param_sourceLayerInterface
        val weaponLayerCircularStaticPool : WeaponLayerCircularPool = param_weaponLayerCircularStaticPool
        val total : Int = param_total
        val weaponProperties : WeaponProperties = param_weaponProperties
        val scoreableInterface : ScoreableInterface = param_scoreableInterface
        val relativeRelationship : RelativeRelationship = param_relativeRelationship
        this.total = total
        this.weaponLayerCircularStaticPool = weaponLayerCircularStaticPool
    }

    override def processScore(allbinaryLayerManager : AllBinaryLayerManager, angle : Short, otherAngle : Short, weaponProperties : WeaponProperties, scoreableInterface : ScoreableInterface) : Unit = {
        val sourceLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        val reducedWidth : Int = ((sourceLayerInterface.getWidth() * 8) / 10)
        val halfWidth : Int = (reducedWidth >> 1)
        //int halfHeight = sourceLayerInterface.getHalfHeight();
        val x : Int = this.relativeRelationship.getX()
        val y : Int = this.relativeRelationship.getY()
        //WeaponLayer[] weaponLayerArray = WeaponLayerArrayLayerCircularStaticPool.getInstance(total);
        var sine : Long = 0L
        var beamX : Int = 0
        var cosine : Long = 0L
        var beamY : Int = 0
        var weaponLayer : WeaponLayer = null
        val increment : Int = reducedWidth / (this.total - 1)
        var next : Int = -halfWidth

        {
            var index : Int = 0
            while (index < this.total) {
                sine = (next * this.noDecimalTrigTable.sin(angle.toInt)).toLong
                beamX = (sine / this.noDecimalTrigTable.SCALE).toInt
                cosine = (next * this.noDecimalTrigTable.cos(angle.toInt)).toLong
                beamY = -(cosine / this.noDecimalTrigTable.SCALE).toInt
                weaponLayer = this.weaponLayerCircularStaticPool.getInstanceWeaponLayer(sourceLayerInterface, x + beamX, y + beamY, 0, angle.toInt, otherAngle.toInt, weaponProperties, scoreableInterface)
                allbinaryLayerManager.append(weaponLayer)
                next += increment
                index += 1
            }
        }
    }

}

object StraightMultiProjectileWeaponPart {
    def createStraightMultiProjectileWeaponPart(animationInterface : Animation, weaponLayerCircularStaticPool : WeaponLayerCircularPool) : StraightMultiProjectileWeaponPart = {
        return new StraightMultiProjectileWeaponPart(animationInterface, AllBinaryLayer.NULL_ALLBINARY_LAYER, weaponLayerCircularStaticPool, 2, WeaponProperties.NULL_WEAPON_PROPERTIES, NoScoreable.getInstance(), RelativeRelationship.NULL_RELATIVE_RELATIONSHIP)
    }

}


