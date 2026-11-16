/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation


/**  *  * @author User  */
class IndexedAnimationBehaviorFactory(param_loopTotal : Int, param_frameDelayTime : Long) extends AnimationBehaviorFactory {

    var frameDelayTime : Long = 0L

    var loopTotal : Int = 0

    //Constructor
    {
        val loopTotal : Int = param_loopTotal
        val frameDelayTime : Long = param_frameDelayTime
        this.loopTotal = loopTotal
        this.frameDelayTime = frameDelayTime
    }

    override def getOrCreateInstance() : AnimationBehavior = {
        return new IndexedAnimationBehavior(this.loopTotal, this.frameDelayTime)
    }

}


