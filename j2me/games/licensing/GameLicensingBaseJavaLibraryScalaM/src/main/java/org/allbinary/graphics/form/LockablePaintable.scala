/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.logic.system.security.licensing.LockedResources
import _root_.org.allbinary.logic.system.security.licensing.LockedUtil

class LockablePaintable(param_lockedIndex : Int) extends ItemPaintable {

    private val animation : Animation = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(LockedResources.getInstance().LOCKED_DEMO_GAME_FEATURE_RESOURCE).getInstance(0)

    private var lockedIndex : Int = 0

    //Constructor
    {
        val lockedIndex : Int = param_lockedIndex
        this.lockedIndex = lockedIndex
    }

    override def paint(graphics : Graphics, currentIndex : Int, x : Int, y : Int) : Unit = {
        if (LockedUtil.getInstance().isLocked() && (currentIndex >= this.getLockedIndex())) {
            //- this.halfWidth
            this.getAnimation().paintXY(graphics, x, y)
        }
    }

    def getLockedIndex() : Int = {
        return this.lockedIndex
    }

    def getAnimation() : Animation = {
        return this.animation
    }

}


