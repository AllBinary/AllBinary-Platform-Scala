/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon

import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerCircularPool

class WeaponLayerCircularPool() extends AllBinaryLayerCircularPool {

    def getInstanceWeaponLayer(sourceLayerInterface : AllBinaryLayer, x : Int, y : Int, z : Int, angle : Int, otherAngle : Int, weaponProperties : WeaponProperties, scoreable : ScoreableInterface) : WeaponLayer = {
        var weaponLayer : WeaponLayer = super.getNextInstance().asInstanceOf[WeaponLayer]
        /*         if(!weaponLayer.isDestroyed())         {             this.logUtil.putF("TWB Exception: WeaponLayer Pool Is Too Small For: " + weaponLayer, this, this.commonStrings.GET_INSTANCE);         }         */
        weaponLayer.initXYZ(x, y, z)
        weaponLayer.init(sourceLayerInterface, angle, otherAngle, weaponProperties, scoreable)
        return weaponLayer
    }

}


