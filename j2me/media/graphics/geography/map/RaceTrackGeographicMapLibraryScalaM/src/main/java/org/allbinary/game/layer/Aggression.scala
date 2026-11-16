/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

/**  *  * @author user  */
class Aggression(param_ram : Integer, param_projectile : Integer, param_drops : Integer) {

    private var ram : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

    private var projectile : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

    private var drops : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

    //Constructor
    {
        val ram : Integer = param_ram
        val projectile : Integer = param_projectile
        val drops : Integer = param_drops
        this.setRam(ram)
        this.setProjectile(projectile)
        this.setDrops(drops)
    }

    def getRam() : Integer = {
        return this.ram
    }

    def setRam(ram : Integer) : Unit = {
        this.ram = ram
    }

    def getProjectile() : Integer = {
        return this.projectile
    }

    def setProjectile(projectile : Integer) : Unit = {
        this.projectile = projectile
    }

    def getDrops() : Integer = {
        return this.drops
    }

    def setDrops(drops : Integer) : Unit = {
        this.drops = drops
    }

}


