/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.weapon


class SimpleWeaponProperties {

    private var damage : Int = 0

    private var dissipation : Short = 0

    private var range : Int = 0

    def set(simpleWeaponProperties : SimpleWeaponProperties) : Unit = {
        this.setDamage(simpleWeaponProperties.getDamage())
        this.setDissipation(simpleWeaponProperties.getDissipation())
        this.setRange(simpleWeaponProperties.getRange())
    }

    def setDamage(damage : Int) : Unit = {
        this.damage = damage
    }

    def getDamage() : Int = {
        return this.damage
    }

    def setDissipation(dissipation : Short) : Unit = {
        this.dissipation = dissipation
    }

    def getDissipation() : Short = {
        return this.dissipation
    }

    /**      * @return the range      */
    def getRange() : Int = {
        return this.range
    }

    def setRange(range : Int) : Unit = {
        this.range = range
    }

}


