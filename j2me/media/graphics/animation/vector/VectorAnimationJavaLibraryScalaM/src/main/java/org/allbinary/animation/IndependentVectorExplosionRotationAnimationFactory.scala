/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.vector.VectorInfo

class IndependentVectorExplosionRotationAnimationFactory(param_vectorInfo : VectorInfo, param_basicColor : BasicColor, param_vectorAnimationFactoryInterface : VectorAnimationFactoryInterface) extends ProceduralAnimationInterfaceFactoryInterface {

    private var framePoints : Array[Array[Array[Int]]] = NullUtil.getInstance().NULL_INT_ARRAY_ARRAY_ARRAY

    private var vectorInfo : VectorInfo = null

    private var basicColor : BasicColor = null

    private var vectorAnimationFactoryInterface : VectorAnimationFactoryInterface = null

    private val vectorExplosionGenerator : VectorExplosionGenerator = VectorExplosionGenerator.getInstance()

    //Constructor
    {
        val vectorInfo : VectorInfo = param_vectorInfo
        val basicColor : BasicColor = param_basicColor
        val vectorAnimationFactoryInterface : VectorAnimationFactoryInterface = param_vectorAnimationFactoryInterface
        this.vectorInfo = vectorInfo
        this.basicColor = basicColor
        this.vectorAnimationFactoryInterface = vectorAnimationFactoryInterface
        this.init()
    }

    def init() : Unit = {
        this.framePoints = VectorRotationGenerator.getInstance().getInstance(this.vectorInfo)
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        var frame : Int = 0
        if (animationInterface != null) {
            var rotationAnimationInterface : IndexedAnimation = animationInterface.asInstanceOf[IndexedAnimation]
            frame = rotationAnimationInterface.getFrame()
        }
        var points : Array[Array[Array[Int]]] = this.vectorExplosionGenerator.getInstance(this.framePoints(frame), 6, this.vectorExplosionGenerator.ROTATION)
        return this.vectorAnimationFactoryInterface.getInstance(points, this.basicColor)
    }

}


