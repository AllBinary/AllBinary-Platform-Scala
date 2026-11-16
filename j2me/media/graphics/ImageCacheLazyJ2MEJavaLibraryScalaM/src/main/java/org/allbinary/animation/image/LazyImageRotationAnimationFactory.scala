/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.media.ScaleProperties

/**  *  * @author User  */
class LazyImageRotationAnimationFactory(param_layoutIndex : Int, param_associatedLazyAnimationId : Int, param_animationInterfaceFactoryInterface : BaseImageAnimationFactory) extends AnimationInterfaceFactoryInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var layoutIndex : Int = 0

    private var animationInterfaceFactoryInterface : BaseImageAnimationFactory = null

    var scaleProperties : ScaleProperties = ScaleProperties.instance

    //Constructor
    {
        val layoutIndex : Int = param_layoutIndex
        val associatedLazyAnimationId : Int = param_associatedLazyAnimationId
        val animationInterfaceFactoryInterface : BaseImageAnimationFactory = param_animationInterfaceFactoryInterface
        this.layoutIndex = layoutIndex
        this.animationInterfaceFactoryInterface = animationInterfaceFactoryInterface
        ImageCacheFactory.getInstance().hasAnyLazyAnimationFactories = true
        if (this.animationInterfaceFactoryInterface.animationBehaviorFactory eq AnimationBehaviorFactory.getInstance()) {
            ForcedLogUtil.log("Using default AnimationBehaviorFactory with IndexedAnimationFactory", this)
        }
    }

    override def getInstance(instanceId : Int) : Animation = {
        if (this.animationInterfaceFactoryInterface.getImage().isReady()) {
            this.animationInterfaceFactoryInterface.setInitialScale(this.scaleProperties)
            return this.animationInterfaceFactoryInterface.getInstance(instanceId)
        } else {
            return new LazyImageRotationAnimation(this.layoutIndex, instanceId, this.scaleProperties, this.animationInterfaceFactoryInterface, this.animationInterfaceFactoryInterface.animationBehaviorFactory.getOrCreateInstance())
        }
        throw new IllegalStateException()
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
        //this.logUtil.putF(scaleProperties.toString(), this, commonStrings.CONSTRUCTOR);
        this.scaleProperties = scaleProperties
    }

}


