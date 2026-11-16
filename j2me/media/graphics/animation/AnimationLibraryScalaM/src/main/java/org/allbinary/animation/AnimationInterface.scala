/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.LocationPaintableInterface

trait AnimationInterface extends LocationPaintableInterface {

    def nextFrame() : Unit

    def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit

}


