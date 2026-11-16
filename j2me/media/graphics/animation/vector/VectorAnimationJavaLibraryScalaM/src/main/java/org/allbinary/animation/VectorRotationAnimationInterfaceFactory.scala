/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.media.ScaleProperties

class VectorRotationAnimationInterfaceFactory(param_currentPoints : Array[Array[Array[Int]]], param_basicColor : BasicColor, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {

    private var currentPoints : Array[Array[Array[Int]]] = NullUtil.getInstance().NULL_INT_ARRAY_ARRAY_ARRAY

    private var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val currentPoints : Array[Array[Array[Int]]] = param_currentPoints
        val basicColor : BasicColor = param_basicColor
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.currentPoints = currentPoints
        this.setBasicColorP(basicColor)
        this.animationBehaviorFactory = animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        return new VectorRotationAnimation(this.currentPoints, this.getBasicColorP(), this.animationBehaviorFactory.getOrCreateInstance())
    }

    def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


