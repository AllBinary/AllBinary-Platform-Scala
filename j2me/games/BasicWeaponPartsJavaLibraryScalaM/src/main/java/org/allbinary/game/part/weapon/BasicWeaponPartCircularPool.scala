/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part.weapon

import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.layer.AllBinaryLayer

class BasicWeaponPartCircularPool {
    import _root_.org.allbinary.game.part.weapon.BasicWeaponPartCircularPool.{NULL_BASIC_WEAPON_PART_CIRCULAR_POOL as _, *}
    def NULL_BASIC_WEAPON_PART_CIRCULAR_POOL : BasicWeaponPartCircularPool = _root_.org.allbinary.game.part.weapon.BasicWeaponPartCircularPool.NULL_BASIC_WEAPON_PART_CIRCULAR_POOL

    //private BasicWeaponPart[] VECTOR_GRAPHIC_ARRAY = new BasicWeaponPart[MAX];
    private var basicWeaponPart : BasicWeaponPart = BasicWeaponPart.NULL_BASIC_WEAPON_PART

    def init(basicWeaponPartFactoryInterface : BasicWeaponPartFactoryInterface) : Unit = {
        this.basicWeaponPart = basicWeaponPartFactoryInterface.getInstance()
    }

    def getInstance(sourceLayerInterface : AllBinaryLayer, weaponProperties : WeaponProperties, scoreableInterface : ScoreableInterface, relativeRelationship : RelativeRelationship) : BasicWeaponPart = this.synchronized {
        //BasicWeaponPart basicWeaponPart = (BasicWeaponPart) VECTOR_GRAPHIC_ARRAY[this.circularIndexUtil.getIndex()];
        this.basicWeaponPart.init(sourceLayerInterface, weaponProperties, scoreableInterface, relativeRelationship)
        //this.circularIndexUtil.next();
        return this.basicWeaponPart
    }

}

object BasicWeaponPartCircularPool {
    val NULL_BASIC_WEAPON_PART_CIRCULAR_POOL : BasicWeaponPartCircularPool = new BasicWeaponPartCircularPool()

}


