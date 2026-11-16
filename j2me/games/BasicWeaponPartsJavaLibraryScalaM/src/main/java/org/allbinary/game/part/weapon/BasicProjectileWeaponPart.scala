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

class BasicProjectileWeaponPart(param_animationInterface : Animation, param_sourceLayerInterface : AllBinaryLayer, param_weaponLayerCircularStaticPool : WeaponLayerCircularPool, param_weaponProperties : WeaponProperties, param_scoreableInterface : ScoreableInterface, param_relativeRelationship : RelativeRelationship) extends BasicWeaponPart(param_animationInterface, param_sourceLayerInterface, param_weaponProperties, param_scoreableInterface, param_relativeRelationship) {
    import _root_.org.allbinary.game.part.weapon.BasicProjectileWeaponPart.{*}

    private var weaponLayerCircularStaticPool : WeaponLayerCircularPool = null

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val sourceLayerInterface : AllBinaryLayer = param_sourceLayerInterface
        val weaponLayerCircularStaticPool : WeaponLayerCircularPool = param_weaponLayerCircularStaticPool
        val weaponProperties : WeaponProperties = param_weaponProperties
        val scoreableInterface : ScoreableInterface = param_scoreableInterface
        val relativeRelationship : RelativeRelationship = param_relativeRelationship
        this.weaponLayerCircularStaticPool = weaponLayerCircularStaticPool
    }

    override def processScore(allbinaryLayerManager : AllBinaryLayerManager, angle : Short, otherAngle : Short, weaponProperties : WeaponProperties, scoreableInterface : ScoreableInterface) : Unit = {
        val weaponLayer : WeaponLayer = this.weaponLayerCircularStaticPool.getInstanceWeaponLayer(this.getOwnerLayerInterface(), this.relativeRelationship.getX(), this.relativeRelationship.getY(), this.relativeRelationship.getZ(), angle.toInt, otherAngle.toInt, weaponProperties, scoreableInterface)
        allbinaryLayerManager.append(weaponLayer)
    }

}

object BasicProjectileWeaponPart {
    def createBasicProjectileWeaponPart(animationInterface : Animation, weaponLayerCircularStaticPool : WeaponLayerCircularPool) : BasicProjectileWeaponPart = {
        return new BasicProjectileWeaponPart(animationInterface, AllBinaryLayer.NULL_ALLBINARY_LAYER, weaponLayerCircularStaticPool, WeaponProperties.NULL_WEAPON_PROPERTIES, NoScoreable.getInstance(), RelativeRelationship.NULL_RELATIVE_RELATIONSHIP)
    }

}


