/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part.weapon

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.part.PartInterface
import _root_.org.allbinary.game.score.NoScoreable
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.view.ViewPositionBase

class BasicWeaponPart(param_animationInterface : Animation, param_sourceLayerInterface : AllBinaryLayer, param_weaponProperties : WeaponProperties, param_scoreableInterface : ScoreableInterface, param_relativeRelationship : RelativeRelationship) extends PartInterface with SalvoInterface {
    import _root_.org.allbinary.game.part.weapon.BasicWeaponPart.{NULL_BASIC_WEAPON_PART as _, *}
    def NULL_BASIC_WEAPON_PART : BasicWeaponPart = _root_.org.allbinary.game.part.weapon.BasicWeaponPart.NULL_BASIC_WEAPON_PART

    private var animationInterface : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    private var ownerLayerInterface : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    private var weaponProperties : WeaponProperties = WeaponProperties.NULL_WEAPON_PROPERTIES

    private var scoreableInterface : ScoreableInterface = NoScoreable.getInstance()

    var relativeRelationship : RelativeRelationship = RelativeRelationship.NULL_RELATIVE_RELATIONSHIP

    //   }
    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val sourceLayerInterface : AllBinaryLayer = param_sourceLayerInterface
        val weaponProperties : WeaponProperties = param_weaponProperties
        val scoreableInterface : ScoreableInterface = param_scoreableInterface
        val relativeRelationship : RelativeRelationship = param_relativeRelationship
        this.init(sourceLayerInterface, weaponProperties, scoreableInterface, relativeRelationship)
        this.setAnimationInterface(animationInterface)
    }

    def init(sourceLayerInterface : AllBinaryLayer, weaponProperties : WeaponProperties, scoreableInterface : ScoreableInterface, relativeRelationship : RelativeRelationship) : Unit = {
        this.setOwnerLayerInterface(sourceLayerInterface)
        this.setWeaponProperties(weaponProperties)
        this.scoreableInterface = scoreableInterface
        this.relativeRelationship = relativeRelationship
    }

    override def process(allbinaryLayerManager : AllBinaryLayerManager, angle : Short, otherAngle : Short) : Unit = {
        this.processScore(allbinaryLayerManager, angle, otherAngle, this.getWeaponProperties(), this.scoreableInterface)
    }

    override def processScore(allbinaryLayerManager : AllBinaryLayerManager, angle : Short, otherAngle : Short, weaponProperties : WeaponProperties, scoreableInterface : ScoreableInterface) : Unit = {
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

    def getOwnerLayerInterface() : AllBinaryLayer = {
        return this.ownerLayerInterface
    }

    def setOwnerLayerInterface(ownerLayerInterface : AllBinaryLayer) : Unit = {
        this.ownerLayerInterface = ownerLayerInterface
    }

    override def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

    def setAnimationInterface(animationInterface : Animation) : Unit = {
        this.animationInterface = animationInterface
    }

    override def paint(graphics : Graphics) : Unit = {
        val viewPosition : ViewPositionBase = this.getOwnerLayerInterface().getViewPosition()
        val viewX : Int = viewPosition.getX()
        val viewY : Int = viewPosition.getY()
        this.animationInterface.paintXY(graphics, viewX, viewY)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    /**      * @return the weaponProperties      */
    def getWeaponProperties() : WeaponProperties = {
        return this.weaponProperties
    }

    /**      * @param weaponProperties the weaponProperties to set      */
    def setWeaponProperties(weaponProperties : WeaponProperties) : Unit = {
        this.weaponProperties = weaponProperties
    }

}

object BasicWeaponPart {
    def createBasicWeaponPart(animationInterface : Animation) : BasicWeaponPart = {
        return new BasicWeaponPart(animationInterface, AllBinaryLayer.NULL_ALLBINARY_LAYER, WeaponProperties.NULL_WEAPON_PROPERTIES, NoScoreable.getInstance(), RelativeRelationship.NULL_RELATIVE_RELATIONSHIP)
    }

    val NULL_BASIC_WEAPON_PART : BasicWeaponPart = BasicWeaponPart.createBasicWeaponPart(NullAnimationFactory.getFactoryInstance().getInstance(0))

}


