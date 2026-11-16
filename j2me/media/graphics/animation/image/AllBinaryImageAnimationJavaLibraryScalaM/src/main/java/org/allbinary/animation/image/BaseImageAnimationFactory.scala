/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.image.AnimationFactoryImageScaleUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.ScaleProperties
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps

class BaseImageAnimationFactory(param_image : Image, param_sequenceArray : Array[Int], param_width : Int, param_height : Int, param_dx : Int, param_dy : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.image.BaseImageAnimationFactory.{*}

    val animationFactoryImageScaleUtil : AnimationFactoryImageScaleUtil = AnimationFactoryImageScaleUtil.getInstance()

    private var image : Image = null

    var animationBehaviorFactory : AnimationBehaviorFactory = null

    private var sequenceArray : Array[Int] = null

    var animationFactoryInitializationVisitor : AnimationFactoryInitializationVisitor = null

    var scaleProperties : ScaleProperties = ScaleProperties.instance

    //Constructor
    {
        val image : Image = param_image
        val sequenceArray : Array[Int] = param_sequenceArray
        val width : Int = param_width
        val height : Int = param_height
        val dx : Int = param_dx
        val dy : Int = param_dy
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.animationFactoryInitializationVisitor = new AnimationFactoryInitializationVisitor()
        this.image = image
        this.animationFactoryInitializationVisitor.width = width
        this.animationFactoryInitializationVisitor.height = height
        this.animationBehaviorFactory = animationBehaviorFactory
        this.sequenceArray = sequenceArray
        this.animationFactoryInitializationVisitor.dx = dx
        this.animationFactoryInitializationVisitor.dy = dy
    }

    override def getInstance(instanceId : Int) : Animation = {
        return NullAnimationFactory.getFactoryInstance().getInstance(instanceId)
    }

    /**      * @return the image      */
    def getImage() : Image = {
        return this.image
    }

    /**      * @return the sequenceArray      */
    def getSequenceArray() : Array[Int] = {
        return this.sequenceArray
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
        this.scaleProperties = scaleProperties
        //Temp hack
        if (this.scaleProperties.shouldScale) {
            this.scaleProperties.scaleWidth = (this.animationFactoryInitializationVisitor.width * this.scaleProperties.scaleX).toInt
            this.scaleProperties.scaleHeight = (this.animationFactoryInitializationVisitor.height * this.scaleProperties.scaleY).toInt
        } else {
        }
    }

    /**      * @return the animationFactoryInitializationVisitor      */
    def getAnimationFactoryInitializationVisitorP() : AnimationFactoryInitializationVisitor = {
        return this.animationFactoryInitializationVisitor
    }

    /**      * @return the scaleProperties      */
    def getScalePropertiesP() : ScaleProperties = {
        return this.scaleProperties
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.image.getHeight())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(this.animationFactoryInitializationVisitor.toString())
        return stringBuffer.toString()
    }

}

object BaseImageAnimationFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    def createFactoryBase(image : Image, sequenceArray : Array[Int], width : Int, height : Int, animationBehaviorFactory : AnimationBehaviorFactory) : BaseImageAnimationFactory = {
        return new BaseImageAnimationFactory(image, sequenceArray, width, height, 0, 0, animationBehaviorFactory)
    }

}


