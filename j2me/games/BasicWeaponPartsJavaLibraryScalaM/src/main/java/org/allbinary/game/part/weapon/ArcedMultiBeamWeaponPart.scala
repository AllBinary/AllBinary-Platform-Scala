/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part.weapon

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.layer.weapon.WeaponLayer
import _root_.org.allbinary.game.layer.weapon.WeaponLayerCircularPool
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.math.AngleFactory

class ArcedMultiBeamWeaponPart(param_animationInterface : Animation, param_sourceLayerInterface : AllBinaryLayer, param_weaponLayerCircularStaticPool : WeaponLayerCircularPool, param_total : Int, param_weaponProperties : WeaponProperties, param_scoreableInterface : ScoreableInterface, param_relativeRelationship : RelativeRelationship) extends BasicWeaponPart(param_animationInterface, param_sourceLayerInterface, param_weaponProperties, param_scoreableInterface, param_relativeRelationship) {

    private var weaponLayerCircularStaticPool : WeaponLayerCircularPool = null

    private var total : Int = 0

    private val TOTAL_ANGLE : Int = AngleFactory.getInstance().TOTAL_ANGLE.toInt

    //   }
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
        //WeaponLayer[] weaponLayerArray = WeaponLayerArrayLayerCircularStaticPool.getInstance(total);
        val increment : Short = ((this.total - 1) / this.TOTAL_ANGLE).toShort
        val minAngle : Short = (angle - ((increment * this.total) >> 1)).toShort
        var next : Int = 0
        var weaponLayer : WeaponLayer = null

        {
            var index : Int = 0
            while (index < this.total) {
                weaponLayer = this.weaponLayerCircularStaticPool.getInstanceWeaponLayer(this.getOwnerLayerInterface(), this.relativeRelationship.getX(), this.relativeRelationship.getY(), 0, (minAngle + increment).toInt, otherAngle.toInt, weaponProperties, scoreableInterface)
                allbinaryLayerManager.append(weaponLayer)
                next += increment
                index += 1
            }
        }
    }

}


