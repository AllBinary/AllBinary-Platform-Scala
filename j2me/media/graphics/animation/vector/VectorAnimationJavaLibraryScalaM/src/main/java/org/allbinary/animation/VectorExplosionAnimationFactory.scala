/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory

class VectorExplosionAnimationFactory(param_basicColor : BasicColor, param_animationBehaviorFactory : AnimationBehaviorFactory) extends ProceduralAnimationInterfaceFactoryInterface {

    private val vectorExplosionGenerator : VectorExplosionGenerator = VectorExplosionGenerator.getInstance()

    private var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.animationBehaviorFactory = animationBehaviorFactory
        this.setBasicColorP(basicColor)
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        val vectorRotationAnimationInterface : VectorAnimationInterface = animationInterface.asInstanceOf[VectorAnimationInterface]
        val frame : Int = vectorRotationAnimationInterface.getFrame()
        val framePoints : Array[Array[Int]] = vectorRotationAnimationInterface.getPoints(frame)
        val points : Array[Array[Array[Int]]] = this.vectorExplosionGenerator.getInstance(framePoints, 6, this.vectorExplosionGenerator.ROTATION)
        return new VectorRotationAnimation(points, this.getBasicColorP(), this.animationBehaviorFactory.getOrCreateInstance())
    }

    private def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    private def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

}


