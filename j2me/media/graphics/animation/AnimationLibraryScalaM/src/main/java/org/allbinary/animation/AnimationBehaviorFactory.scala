/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation


/**  *  * @author User  */
class AnimationBehaviorFactory {
    import _root_.org.allbinary.animation.AnimationBehaviorFactory.{*}

    def getOrCreateInstance() : AnimationBehavior = {
        return AnimationBehavior.getInstance()
    }

}

object AnimationBehaviorFactory {
    private val instance : AnimationBehaviorFactory = new AnimationBehaviorFactory()

    /**      * @return the instance      */
    def getInstance() : AnimationBehaviorFactory = {
        return AnimationBehaviorFactory.instance
    }

}


