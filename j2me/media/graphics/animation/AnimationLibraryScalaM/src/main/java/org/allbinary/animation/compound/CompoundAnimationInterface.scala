/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.compound

import _root_.org.allbinary.animation.AnimationInterface
import _root_.org.allbinary.animation.IndexedAnimation

/**  *  * @author user  */
trait CompoundAnimationInterface extends AnimationInterface {

    def nextAnimation() : Unit

    def previousAnimation() : Unit

    def setAnimation(index : Int) : Unit

    def getCurrentAnimation() : IndexedAnimation

}


