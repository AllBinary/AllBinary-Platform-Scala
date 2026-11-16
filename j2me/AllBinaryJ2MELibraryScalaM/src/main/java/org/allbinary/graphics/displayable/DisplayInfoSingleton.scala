/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable

import _root_.javax.microedition.lcdui.Displayable
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventHandler
import _root_.org.allbinary.graphics.displayable.event.LastDisplayChangeEventHandler
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.threed.SWTJOGLProcessor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class DisplayInfoSingleton private() {
    import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonLabels : CommonLabels = CommonLabels.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    val ORIENTATION : String = "ORIENTATION"

    val ADJUSTING_FOR_SCALING_IN_PORTRAIT : String = "Adjusting for Scaling in portrait display ratio: "

    val ADJUSTING_FOR_SCALING_IN_LANDSCAPE : String = "Adjusting for Scaling in landscape display ratio: "

    private var last : Array[Int] = new Array[Int](4)

    private var lastHalf : Array[Int] = new Array[Int](4)

    private var full : Array[Int] = new Array[Int](4)

    private var top : Int = 0

    private var left : Int = 0

    private var xOffset : Int = 0

    private var yOffset : Int = 0

    private var scaleLargestTo : Float = 0.0f

    /*     Test Android Scaling resolutions         284         320         480         720         1024         1920         2550         3000         4000     */
    val WIDTH : Int = 0

    val HEIGHT : Int = 1

    val CUSTOM_WIDTH : Int = 2

    val CUSTOM_HEIGHT : Int = 3

    private var scalableListener : BaseScalable = new BaseScalable()

    private var displayRatio : Float = 0.0f

    private var ratio : Float = 1.0f

    private val SET_LAST_SIZE_METHOD_NAME : String = "setLastSize"

    private val FULL_WIDTH : String = " FullWidth: "

    private val FULL_HEIGHT : String = " FullHeight: "

    private val LAST_WIDTH : String = "LastWidth: "

    private val LAST_HEIGHT : String = " LastHeight: "

    private val PORTRAIT : String = "Portrait"

    private val LANDSCAPE : String = "Landscape"

    val displayChangeEvent : DisplayChangeEvent = new DisplayChangeEvent(this)

    private val FIRE_METHOD_NAME : String = "fire"

    private val REASON : String = "reason: "

    private val UPDATE_FROM_ORIENTATION_CHANGE : String = "Updating from Orientation Change "

    private val list : BasicArrayList = new BasicArrayListD()

    private val DISPLAY_INFO : String = "Display Info: "

    private val FULL : String = "full"

    private val LAST : String = "last"

    private val LAST_HALF : String = "lastHalf"

    //Constructor
    {
        //TsUtil only
        val size : Int = this.last.length

        {
            var index : Int = 0
            while (index < size) {
                this.last(index) = 0
                this.lastHalf(index) = 0
                this.full(index) = 0
                index += 1
            }
        }
        if (AndroidUtil.isAndroid()) {
            this.scaleLargestTo = (640).toFloat
        } else {
            this.scaleLargestTo = (1080).toFloat
        }
    }

    def getLastHalf() : Array[Int] = {
        return this.lastHalf
    }

    def getLast() : Array[Int] = {
        return this.last
    }

    /**      * @return the fullWidth      */
    def getFull() : Array[Int] = {
        return this.full
    }

    /**      * @return the scaleLargestTo      */
    def getScaleLargestTo() : Float = {
        return this.scaleLargestTo
    }

    /**      * @param scaleLargestTo the scaleLargestTo to set      */
    def setScaleLargestTo(scaleLargestTo : Int) : Unit = {
        this.scaleLargestTo = scaleLargestTo.toFloat
    }

    def setLastSize(aLastWidth : Int, aLastHeight : Int, reason : String) : Unit = {
        if ((this.full(this.WIDTH) != aLastWidth) || (this.full(this.HEIGHT) != aLastHeight)) {
            this.setLastSizeForce(aLastWidth, aLastHeight, reason)
        }
    }

    private def setLastSizeForce(param_aLastWidth : Int, param_aLastHeight : Int, reason : String) : Unit = {
        var aLastWidth : Int = param_aLastWidth
        var aLastHeight : Int = param_aLastHeight
        val stringMaker : StringMaker = new StringMaker()
        this.logUtil.putF(stringMaker.append(CommonLabels.getInstance().START_LABEL).append(reason).toString(), this, this.SET_LAST_SIZE_METHOD_NAME)
        val aFullWidth : Int = aLastWidth
        val aFullHeight : Int = aLastHeight
        stringMaker.delete(0, stringMaker.length())
        this.logUtil.putF(stringMaker.append(this.FULL_WIDTH).appendint(aFullWidth).append(this.FULL_HEIGHT).appendint(aFullHeight).append(this.toString()).toString(), this, this.SET_LAST_SIZE_METHOD_NAME)
        //this.logUtil.putF("Changing", this, SET_LAST_SIZE_METHOD_NAME);
        val operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
        if (operatingSystemInterface.isOverScan()) {
            aLastWidth = (aLastWidth * operatingSystemInterface.getOverScanXPercent()) / 100
            aLastHeight = (aLastHeight * operatingSystemInterface.getOverScanYPercent()) / 100
        }
        if (operatingSystemInterface.isScalable()) {
            if (this.isPortraitWH(aLastWidth, aLastHeight)) {
                if (aLastHeight > this.scaleLargestTo) {
                    this.displayRatio = this.scaleLargestTo / aLastHeight
                    this.ratio = aLastHeight / this.scaleLargestTo
                    stringMaker.delete(0, stringMaker.length())
                    this.logUtil.putF(stringMaker.append(this.ADJUSTING_FOR_SCALING_IN_PORTRAIT).appendfloat(this.displayRatio).toString(), this, this.SET_LAST_SIZE_METHOD_NAME)
                    aLastWidth = (aLastWidth * this.displayRatio).toInt
                    aLastHeight = (aLastHeight * this.displayRatio).toInt
                    this.scalableListener.scale(this.ratio.toFloat)
                } else {
                    //this.logUtil.putF("Reset scaling", this, this.commonStrings.UPDATE);
                    this.ratio = 1.0f
                    this.scalableListener.scale(this.ratio.toFloat)
                }
            } else {
                if (aLastWidth > this.scaleLargestTo) {
                    this.displayRatio = this.scaleLargestTo / aLastWidth
                    this.ratio = aLastWidth / this.scaleLargestTo
                    stringMaker.delete(0, stringMaker.length())
                    this.logUtil.putF(stringMaker.append(this.ADJUSTING_FOR_SCALING_IN_LANDSCAPE).appendfloat(this.displayRatio).toString(), this, this.SET_LAST_SIZE_METHOD_NAME)
                    aLastWidth = (aLastWidth * this.displayRatio).toInt
                    aLastHeight = (aLastHeight * this.displayRatio).toInt
                    this.scalableListener.scale(this.ratio.toFloat)
                } else {
                    //this.logUtil.putF("Reset scaling", this, this.commonStrings.UPDATE);
                    this.ratio = 1.0f
                    this.scalableListener.scale(this.ratio.toFloat)
                }
            }
        }
        stringMaker.delete(0, stringMaker.length())
        this.logUtil.putF(stringMaker.append(this.LAST_WIDTH).appendint(aLastWidth).append(this.LAST_HEIGHT).appendint(aLastHeight).toString(), this, this.SET_LAST_SIZE_METHOD_NAME)
        this.xOffset = aFullWidth - aLastWidth
        this.yOffset = aFullHeight - aLastHeight
        //                    .toString(), this, SET_LAST_SIZE_METHOD_NAME);
        this.left = this.scalableListener.getLeft(this.xOffset)
        this.top = this.scalableListener.getTop(this.yOffset)
        //                    .toString(), this, SET_LAST_SIZE_METHOD_NAME);
        this.full(this.WIDTH) = aFullWidth
        this.full(this.HEIGHT) = aFullHeight
        this.last(this.WIDTH) = aLastWidth
        this.lastHalf(this.WIDTH) = (this.last(this.WIDTH) >> 1)
        this.last(this.HEIGHT) = aLastHeight
        this.lastHalf(this.HEIGHT) = (this.last(this.HEIGHT) >> 1)
        SWTJOGLProcessor.getInstance().setCustom(aLastWidth, aLastHeight, this.ratio)
        this.add(this.SET_LAST_SIZE_METHOD_NAME)
    }

    def isPortraitWH(lastWidth : Int, lastHeight : Int) : Boolean = {
        if (lastHeight > lastWidth) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isPortrait() : Boolean = {
        return this.isPortraitWH(this.last(this.WIDTH), this.last(this.HEIGHT))
    }

    def add(reason : String) : Unit = {
        //PreLogUtil.putF("Display Change Event").append(this.toString(), this, this.commonStrings.UPDATE);
        val stringMaker : StringMaker = new StringMaker()
        this.logUtil.putF(stringMaker.append(this.REASON).append(reason).toString(), this, this.FIRE_METHOD_NAME)
        stringMaker.delete(0, stringMaker.length())
        this.logUtil.putF(this.toStringAppend(stringMaker), this, this.FIRE_METHOD_NAME)
        this.list.add(reason)
    }

    def process() : Unit = {
        try {
            if (this.list.size() > 0) {
                this.processForced()
            }
            this.list.clear()
        } catch {
            case e : Exception => {
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, this.FIRE_METHOD_NAME, e)
            }
        }
    }

    def processForced() : Unit = {
        try {
            val swtJOGLProcessor : SWTJOGLProcessor = SWTJOGLProcessor.getInstance()
            swtJOGLProcessor.clear()
            DisplayChangeEventHandler.getInstance().fireEvent(this.displayChangeEvent)
            LastDisplayChangeEventHandler.getInstance().fireEvent(this.displayChangeEvent)
            swtJOGLProcessor.onSurfaceChanged()
        } catch {
            case e : Exception => {
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, this.FIRE_METHOD_NAME, e)
            }
        }
    }

    def update(displayable : Displayable, reason : String) : Unit = {
        var aLastWidth : Int = displayable.getWidth()
        var aLastHeight : Int = displayable.getHeight()
        val aFullWidth : Int = aLastWidth
        val aFullHeight : Int = aLastHeight
        val stringMaker : StringMaker = new StringMaker()
        this.logUtil.putF(stringMaker.append(CommonLabels.getInstance().START_LABEL).append(reason).append(this.LAST_WIDTH).appendint(aLastWidth).append(this.LAST_HEIGHT).appendint(aLastHeight).append(this.commonSeps.SPACE).append(this.toString()).toString(), this, this.commonStrings.UPDATE)
        if ((aLastWidth > 0) && (aLastHeight > 0)) {
            val features : Features = Features.getInstance()
            val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
            //This does not actually get called often as the displayable width and height are usually the last value
            if ((!features.isDefault(openGLFeatureFactory.OPENGL) || (this.last(this.WIDTH) != aLastWidth)) || (this.last(this.HEIGHT) != aLastHeight)) {
                stringMaker.delete(0, stringMaker.length())
                this.logUtil.putF(stringMaker.append(this.UPDATE_FROM_ORIENTATION_CHANGE).toString(), this, this.commonStrings.UPDATE)
                val operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
                if (operatingSystemInterface.isOverScan()) {
                    aLastWidth = (aLastWidth * operatingSystemInterface.getOverScanXPercent()) / 100
                    aLastHeight = (aLastHeight * operatingSystemInterface.getOverScanYPercent()) / 100
                }
                if (operatingSystemInterface.isScalable()) {
                    //this.logUtil.putF("Found Scalable OS", this, this.commonStrings.UPDATE);
                    if (this.isPortraitWH(aLastWidth, aLastHeight)) {
                        //this.logUtil.putF("Found Orientation: " + this.PORTRAIT, this, this.commonStrings.UPDATE);
                        if (aLastHeight > this.scaleLargestTo) {
                            this.displayRatio = this.scaleLargestTo / aLastHeight
                            this.ratio = aLastHeight / this.scaleLargestTo
                            stringMaker.delete(0, stringMaker.length())
                            this.logUtil.putF(stringMaker.append(this.ADJUSTING_FOR_SCALING_IN_PORTRAIT).appendfloat(this.displayRatio).toString(), this, this.commonStrings.UPDATE)
                            aLastWidth = (aLastWidth * this.displayRatio).toInt
                            aLastHeight = (aLastHeight * this.displayRatio).toInt
                            this.scalableListener.scale(this.ratio.toFloat)
                        } else {
                            //this.logUtil.putF("Reset scaling", this, this.commonStrings.UPDATE);
                            this.ratio = 1.0f
                            this.scalableListener.scale(this.ratio.toFloat)
                        }
                    } else {
                        //this.logUtil.putF("Found Orientation: " + this.LANDSCAPE, this, this.commonStrings.UPDATE);
                        if (aLastWidth > this.scaleLargestTo) {
                            this.displayRatio = this.scaleLargestTo / aLastWidth
                            this.ratio = aLastWidth / this.scaleLargestTo
                            stringMaker.delete(0, stringMaker.length())
                            this.logUtil.putF(stringMaker.append(this.ADJUSTING_FOR_SCALING_IN_LANDSCAPE).appendfloat(this.displayRatio).toString(), this, this.commonStrings.UPDATE)
                            aLastWidth = (aLastWidth * this.displayRatio).toInt
                            aLastHeight = (aLastHeight * this.displayRatio).toInt
                            this.scalableListener.scale(this.ratio.toFloat)
                        } else {
                            //this.logUtil.putF("Reset scaling", this, this.commonStrings.UPDATE);
                            this.ratio = 1.0f
                            this.scalableListener.scale(this.ratio.toFloat)
                        }
                    }
                }
                stringMaker.delete(0, stringMaker.length())
                this.logUtil.putF(stringMaker.append(this.UPDATE_FROM_ORIENTATION_CHANGE).append(this.LAST_WIDTH).appendint(aLastWidth).append(this.LAST_HEIGHT).appendint(aLastHeight).toString(), this, this.commonStrings.UPDATE)
                this.xOffset = aFullWidth - aLastWidth
                this.yOffset = aFullHeight - aLastHeight
                //                    .toString(), this, SET_LAST_SIZE_METHOD_NAME);
                this.left = this.scalableListener.getLeft(this.xOffset)
                this.top = this.scalableListener.getTop(this.yOffset)
                //                    .toString(), this, SET_LAST_SIZE_METHOD_NAME);
                this.full(this.WIDTH) = aFullWidth
                this.full(this.HEIGHT) = aFullHeight
                this.last(this.WIDTH) = aLastWidth
                this.lastHalf(this.WIDTH) = (this.last(this.WIDTH) >> 1)
                this.last(this.HEIGHT) = aLastHeight
                this.lastHalf(this.HEIGHT) = (this.last(this.HEIGHT) >> 1)
                SWTJOGLProcessor.getInstance().setCustom(aLastWidth, aLastHeight, this.ratio)
                this.add(this.commonStrings.UPDATE)
            }
        }
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        return this.toStringAppend(stringBuffer)
    }

    def toStringAppend(stringBuffer : StringMaker) : String = {
        stringBuffer.append(this.DISPLAY_INFO)
        stringBuffer.append(this.FULL)
        stringBuffer.append(this.commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(this.full(this.WIDTH))
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.FULL)
        stringBuffer.append(this.commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.full(this.HEIGHT))
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.LAST)
        stringBuffer.append(this.commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(this.last(this.WIDTH))
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.LAST)
        stringBuffer.append(this.commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.last(this.HEIGHT))
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.LAST_HALF)
        stringBuffer.append(this.commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(this.lastHalf(this.WIDTH))
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.LAST_HALF)
        stringBuffer.append(this.commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.lastHalf(this.HEIGHT))
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append((if (this.isPortrait()) this.PORTRAIT else this.LANDSCAPE))
        return stringBuffer.toString()
    }

    /**      * @return the top      */
    def getTop() : Int = {
        return this.top
    }

    /**      * @return the left      */
    def getLeft() : Int = {
        return this.left
    }

    def getLastWidth() : Int = {
        return this.last(this.WIDTH)
    }

    def getLastHeight() : Int = {
        return this.last(this.HEIGHT)
    }

    def getLastHalfWidth() : Int = {
        return this.lastHalf(this.WIDTH)
    }

    def getLastHalfHeight() : Int = {
        return this.lastHalf(this.HEIGHT)
    }

    def getCustomLastWidth() : Int = {
        return this.last(this.CUSTOM_WIDTH)
    }

    def getCustomLastHeight() : Int = {
        return this.last(this.CUSTOM_HEIGHT)
    }

    def getRawLastWidth() : Int = {
        return this.last(this.WIDTH)
    }

    def getRawLastHeight() : Int = {
        return this.last(this.HEIGHT)
    }

    def setCustom(width : Int, height : Int) : Unit = {
        //this.logUtil.put(new StringMaker().append(" w: ").appendint(width).append(" h: ").appendint(height).append(" ratio: ").appendfloat(ratio).toString(), this, "setCustom", new Exception());
        this.last(this.CUSTOM_WIDTH) = width
        this.lastHalf(this.CUSTOM_WIDTH) = (this.last(this.CUSTOM_WIDTH) >> 1)
        this.last(this.CUSTOM_HEIGHT) = height
        this.lastHalf(this.CUSTOM_HEIGHT) = (this.last(this.CUSTOM_HEIGHT) >> 1)
    }

    def setScalableListener(scalableListener : BaseScalable) : Unit = {
        this.scalableListener = scalableListener
    }

    def getScalableListener() : ScalableListener = {
        return this.scalableListener
    }

    /**      * @return the ratio      */
    def getRatio() : Float = {
        return this.ratio
    }

    /**      * @return the displayRatio      */
    def getDisplayRatio() : Float = {
        return this.displayRatio
    }

    def setOffset(left : Int, top : Int) : Unit = {
        this.left = left
    }

    /**      * @return the xOffset      */
    def getxOffset() : Int = {
        return this.xOffset
    }

    /**      * @return the yOffset      */
    def getyOffset() : Int = {
        return this.yOffset
    }

}

object DisplayInfoSingleton {
    private val SINGLETON : DisplayInfoSingleton = new DisplayInfoSingleton()

    def getInstance() : DisplayInfoSingleton = {
        return DisplayInfoSingleton.SINGLETON
    }

}


