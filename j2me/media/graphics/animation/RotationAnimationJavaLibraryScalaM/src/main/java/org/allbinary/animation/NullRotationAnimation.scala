/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.util.CircularIndexUtil

class NullRotationAnimation(param_angleInfo : AngleInfo, param_circularIndexUtil : CircularIndexUtil, param_animationBehavior : AnimationBehavior) extends RotationAnimation(param_angleInfo, param_circularIndexUtil, param_animationBehavior) {
    import _root_.org.allbinary.animation.NullRotationAnimation.{*}

    //Constructor
    {
        val angleInfo : AngleInfo = param_angleInfo
        val circularIndexUtil : CircularIndexUtil = param_circularIndexUtil
        val animationBehavior : AnimationBehavior = param_animationBehavior
    }

    override def getAnimationSize() : Int = {
        return 0
    }

}

object NullRotationAnimation {
    def createTotalAngle(angleInfo : AngleInfo, totalAngle : Short, animationBehavior : AnimationBehavior) : NullRotationAnimation = {
        return new NullRotationAnimation(angleInfo, CircularIndexUtil.createInstance(totalAngle / angleInfo.getAngleIncrementInfo().getAngleIncrement()), animationBehavior)
    }

    def createQuarter(animationBehavior : AnimationBehavior) : NullRotationAnimation = {
        return new NullRotationAnimation(AngleInfo.getInstance(AngleFactory.getInstance().QUARTER_TOTAL_ANGLE), CircularIndexUtil.createInstance(4), animationBehavior)
    }

}


