/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.util.CircularIndexUtil

class NullRotationAnimation2() extends NullRotationAnimation(AngleInfo.getInstance(AngleFactory.getInstance().QUARTER_TOTAL_ANGLE), CircularIndexUtil.createInstance(4), new IndexedAnimationBehavior(1, 250)) {

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

}


