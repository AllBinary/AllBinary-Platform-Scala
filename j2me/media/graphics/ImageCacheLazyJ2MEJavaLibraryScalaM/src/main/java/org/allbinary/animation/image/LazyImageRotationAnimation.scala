/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.NullRotationAnimationFactory
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.ScaleProperties
import _root_.org.allbinary.util.CircularIndexUtil

/**  *  * @author User  */
class LazyImageRotationAnimation(param_layoutIndex : Int, param_instanceId : Int, param_scaleProperties : ScaleProperties, param_animationInterfaceFactoryInterface : BaseImageAnimationFactory, param_animationBehavior : AnimationBehavior) extends RotationAnimation(AngleInfo.getInstance(AngleFactory.getInstance().QUARTER_TOTAL_ANGLE), CircularIndexUtil.createInstance(4), param_animationBehavior) {
    import _root_.org.allbinary.animation.image.LazyImageRotationAnimation.{*}

    val logUtil_LazyImageRotationAnimation : LogUtil = LogUtil.getInstance()

    var layoutIndex : Int = 0

    var instanceId : Int = 0

    var animationInterfaceFactoryInterface : BaseImageAnimationFactory = null

    private var NULL_INDEX_ANIMATION : IndexedAnimation = null

    private var animation : IndexedAnimation = null

    var scaleProperties : ScaleProperties = ScaleProperties.instance

    //private float scaleY;
    //Constructor
    {
        val layoutIndex : Int = param_layoutIndex
        val instanceId : Int = param_instanceId
        val scaleProperties : ScaleProperties = param_scaleProperties
        val animationInterfaceFactoryInterface : BaseImageAnimationFactory = param_animationInterfaceFactoryInterface
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.layoutIndex = layoutIndex
        this.instanceId = instanceId
        this.animationInterfaceFactoryInterface = animationInterfaceFactoryInterface
        val imageCache : ImageCache = ImageCacheFactory.getInstance()
        imageCache.add(this)
        this.scaleProperties = scaleProperties
        this.NULL_INDEX_ANIMATION = NullRotationAnimationFactory.getFactoryInstance().getInstance(0).asInstanceOf[IndexedAnimation]
        //this.logUtil.putF(this.NULL_INDEX_ANIMATION.toString(), this, this.commonStrings.PROCESS);
        class ActualRotationAnimation(param_lazyImageRotationAnimation : LazyImageRotationAnimation) extends RotationAnimation(AngleInfo.getInstance(AngleFactory.getInstance().QUARTER_TOTAL_ANGLE), CircularIndexUtil.createInstance(4), param_animationBehavior) {

            private[ActualRotationAnimation] var lazyImageRotationAnimation : LazyImageRotationAnimation = null

            private[ActualRotationAnimation] var index : Int = 0

            //Constructor
            {
                val lazyImageRotationAnimation : LazyImageRotationAnimation = param_lazyImageRotationAnimation
                this.lazyImageRotationAnimation = lazyImageRotationAnimation
            }

            override def setFrame(index : Int) : Unit = {
                this.index = index
            }

            override def getFrame() : Int = {
                return this.index
            }

            override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
                try {
                    ImageCacheFactory.getInstance().insertFirst(LazyImageRotationAnimation.this)
                    this.lazyImageRotationAnimation.animation = this.lazyImageRotationAnimation.NULL_INDEX_ANIMATION
                } catch {
                    case e : Exception => {
                        val logUtil : LogUtil = LogUtil.getInstance()
                        logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                    }
                }
            }

            override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
                try {
                    ImageCacheFactory.getInstance().insertFirst(LazyImageRotationAnimation.this)
                    this.lazyImageRotationAnimation.animation = this.lazyImageRotationAnimation.NULL_INDEX_ANIMATION
                } catch {
                    case e : Exception => {
                        val logUtil : LogUtil = LogUtil.getInstance()
                        logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                    }
                }
            }

        }


        this.animation = new ActualRotationAnimation(this)
    }

    def setRealAnimation() : Unit = {
        try {
            val animation : IndexedAnimation = this.animation
            this.animationInterfaceFactoryInterface.setInitialScale(this.scaleProperties)
            this.animation = this.animationInterfaceFactoryInterface.getInstance(this.instanceId).asInstanceOf[IndexedAnimation]
            this.animation.setState(animation)
        } catch {
            case e : Exception => {
                this.logUtil_LazyImageRotationAnimation.put(this.commonStrings.EXCEPTION, this, LazyImageRotationAnimation.SET_REAL_ANIMATION, e)
            }
        }
    }

    override def setScale(scaleX : Float, scaleY : Float) : Unit = {
        //this.scaleY = scaleY;
        this.animation.setScale(scaleX, scaleY)
    }

    override def getAnimationBehavior() : AnimationBehavior = {
        return this.animation.getAnimationBehavior()
    }

    override def set(gl : GL) : Unit = {
        this.animation.set(gl)
    }

    override def setAlpha(alpha : Int) : Unit = {
        this.animation.setAlpha(alpha)
    }

    override def setDx(dx : Int) : Unit = {
        this.animation.setDx(dx)
    }

    override def setDy(dy : Int) : Unit = {
        this.animation.setDy(dy)
    }

    override def setMaxScale(maxScaleX : Float, maxScaleY : Float) : Unit = {
        this.animation.setMaxScale(maxScaleX, maxScaleY)
    }

    override def nextRotation() : Unit = {
        val rotationAnimation : RotationAnimation = (this.animation.asInstanceOf[RotationAnimation])
        rotationAnimation.nextRotation()
    }

    override def previousRotation() : Unit = {
        val rotationAnimation : RotationAnimation = (this.animation.asInstanceOf[RotationAnimation])
        rotationAnimation.previousRotation()
    }

    override def nextRotationX() : Unit = {
        val rotationAnimation : RotationAnimation = (this.animation.asInstanceOf[RotationAnimation])
        rotationAnimation.nextRotationX()
    }

    override def previousRotationX() : Unit = {
        val rotationAnimation : RotationAnimation = (this.animation.asInstanceOf[RotationAnimation])
        rotationAnimation.previousRotationX()
    }

    override def nextRotationZ() : Unit = {
        val rotationAnimation : RotationAnimation = (this.animation.asInstanceOf[RotationAnimation])
        rotationAnimation.nextRotationZ()
    }

    override def previousRotationZ() : Unit = {
        val rotationAnimation : RotationAnimation = (this.animation.asInstanceOf[RotationAnimation])
        rotationAnimation.previousRotationZ()
    }

    override def changeBasicColor(basicColor : BasicColor) : Unit = {
        this.animation.changeBasicColor(basicColor)
    }

    override def getBasicColorP() : BasicColor = {
        return this.animation.getBasicColorP()
    }

    override def getChangeBasicColor() : BasicColor = {
        return this.animation.getChangeBasicColor()
    }

    override def getChangeColor() : Int = {
        return this.animation.getChangeColor()
    }

    override def getColor() : Int = {
        return this.animation.getColor()
    }

    override def getDx() : Int = {
        return this.animation.getDx()
    }

    override def getDy() : Int = {
        return this.animation.getDy()
    }

    override def isThreed() : Boolean = {
        return this.animation.isThreed()
    }

    override def nextFrame() : Unit = {
        this.animation.nextFrame()
    }

    override def reset() : Unit = {
        this.animation.reset()
    }

    override def setFrame(index : Int) : Unit = {
        this.animation.setFrame(index)
    }

    override def getFrame() : Int = {
        return this.animation.getFrame()
    }

    override def getAnimationSize() : Int = {
        return this.animation.getAnimationSize()
    }

    override def getSize() : Int = {
        return this.animation.getSize()
    }

    override def previousFrame() : Unit = {
        this.animation.previousFrame()
    }

    override def isLastFrame() : Boolean = {
        return this.animation.isLastFrame()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
        this.animation.setSequence(sequence)
    }

    override def getSequence() : Array[Int] = {
        return this.animation.getSequence()
    }

    override def getWidth() : Int = {
        return this.animation.getWidth()
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        try {
            this.animation.paintXY(graphics, x, y)
        } catch {
            case e : Exception => {
                this.logUtil_LazyImageRotationAnimation.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
            }
        }
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        try {
            this.animation.paintThreedXYZ(graphics, x, y, z)
        } catch {
            case e : Exception => {
                this.logUtil_LazyImageRotationAnimation.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
            }
        }
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val image : Image = this.animationInterfaceFactoryInterface.getImage()
        return new StringMaker().append(super.toString()).append(commonSeps.SPACE).append(image.getName()).append(commonSeps.SPACE).appendint(image.getWidth()).append(commonSeps.SPACE).appendint(image.getHeight()).toString()
    }

}

object LazyImageRotationAnimation {
    private val SET_REAL_ANIMATION : String = "setRealAnimation"

}


