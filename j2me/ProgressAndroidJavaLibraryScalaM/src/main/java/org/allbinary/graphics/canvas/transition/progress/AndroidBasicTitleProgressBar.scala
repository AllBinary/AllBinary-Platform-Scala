/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.android.app.Activity
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.image.PreResourceImageUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.java.exception.ExceptionUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventHandler
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventListener
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.media.image.ImageScaleUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.image.ImageAnimation
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.thread.ARunnable
import _root_.org.allbinary.thread.NullRunnable

class AndroidBasicTitleProgressBar(param_title : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ProgressCanvas(param_title, param_backgroundBasicColor, param_foregroundBasicColor) with DisplayChangeEventListener {
    import _root_.org.allbinary.graphics.canvas.transition.progress.AndroidBasicTitleProgressBar.{RESOURCE as _, *}
    def RESOURCE : String = _root_.org.allbinary.graphics.canvas.transition.progress.AndroidBasicTitleProgressBar.RESOURCE

    private var showTitleProgressBarRunnable : ARunnable = NullRunnable.getInstance()

    private var dismissTitleProgressBarRunnable : ARunnable = NullRunnable.getInstance()

    private var titleProgressDialogPortionSetProgressRunnable : ARunnable = NullRunnable.getInstance()

    private var titleProgressDialogSetProgressRunnable : ARunnable = NullRunnable.getInstance()

    //SimpleProgressActivityInterface
    private var midletActivity : Activity = AndroidUtil.NULL_ACTIVITY

    private var portion : Int = 0

    private val IMAGE : Array[Image] = new Array[Image](4)

    private var image : Image = NullImage.NULL_IMAGE

    private var animation : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    // private boolean painted = false;;
    //Constructor
    {
        val title : String = param_title
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.init()
        DisplayChangeEventHandler.getInstance().addListenerInterface(this)
        val size : Int = this.IMAGE.length

        {
            var index : Int = 0
            while (index < size) {
                this.IMAGE(index) = NullImage.NULL_IMAGE
                index += 1
            }
        }
    }

    private def init() : Unit = {
        try {
            if (AndroidBasicTitleProgressBar.background != 0) {
                ResourceUtil.getInstance().addResource(AndroidBasicTitleProgressBar.RESOURCE, new Integer(AndroidBasicTitleProgressBar.background))
                GameFeatureImageCacheFactory.init()
                this.image = ImageCacheFactory.getInstance().getWithKey(AndroidBasicTitleProgressBar.RESOURCE)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        }
    }

    def initActivity(activity : Activity) : Unit = {
        try {
            if (this.midletActivity ne activity) {
                this.midletActivity = activity
                this.showTitleProgressBarRunnable = new ShowTitleProgressBarRunnable(this.midletActivity, this)
                this.dismissTitleProgressBarRunnable = new DismissTitleProgressBarRunnable(this.midletActivity, this)
                this.titleProgressDialogSetProgressRunnable = new TitleProgressBarSetProgressRunnable(this.midletActivity, this)
                this.titleProgressDialogPortionSetProgressRunnable = new TitleProgressBarPortionSetProgressRunnable(this.midletActivity, this)
                this.loadProgressImages()
            }
            this.updateCurrent()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        }
    }

    private def updateCurrent() : Unit = {
        try {
            if (!this.isBackground()) {
                this.animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
            } else if (AndroidBasicTitleProgressBar.background != 0) {
                var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
                var currentImage : Image = null
                if (displayInfo.isPortrait()) {
                    currentImage = this.getImage(0)
                } else {
                    currentImage = this.getImage(2)
                }
                if (currentImage == null) {
                    this.animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
                } else {
                    this.animation = new ImageAnimation(currentImage, AnimationBehavior.getInstance())
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e)
            }
        }
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        try {
            this.loadProgressImages()
            this.updateCurrent()
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION_LABEL + ExceptionUtil.getInstance().getStackTrace(e), this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT)
                this.animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
            }
        }
    }

    private def loadProgressImages() : Unit = {
        try {
            var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
            var lastWidth : Int = displayInfo.getLastWidth()
            var lastHeight : Int = displayInfo.getLastHeight()
            if (displayInfo.isPortraitWH(lastWidth, lastHeight)) {
                this.setImages(0, lastWidth, lastHeight)
            } else {
                this.setImages(2, lastWidth, lastHeight)
            }
        } catch {
            case e : IllegalArgumentException => {
                this.logUtil.putF("IllegalArgumentException " + ExceptionUtil.getInstance().getStackTrace(e), this, "loadProgressImages")
                this.animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
            }
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION_LABEL + ExceptionUtil.getInstance().getStackTrace(e), this, "loadProgressImages")
                this.animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
            }
        }
    }

    def isInitialized() : Boolean = {
        if (this.midletActivity ne AndroidUtil.NULL_ACTIVITY) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def start() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.START_METHOD_NAME)
            super.start()
            this.midletActivity.runOnUiThread(this.showTitleProgressBarRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.START_METHOD_NAME, e)
            }
        }
    }

    override def end() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.END_METHOD_NAME)
            this.midletActivity.runOnUiThread(this.dismissTitleProgressBarRunnable)
            super.end()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.END_METHOD_NAME, e)
            }
        }
    }

    override def addEarlyPortion(value : Int, text : String, index : Int) : Unit = {
        try {
            // this.logUtil.putF(this.commonStrings.START, this, ADD_PORTION);
            this.portion = value
            super.addEarlyPortion(value, text, index)
            if (this.midletActivity ne AndroidUtil.NULL_ACTIVITY) {
                this.midletActivity.runOnUiThread(this.titleProgressDialogPortionSetProgressRunnable)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.ADD_PORTION, e)
            }
        }
    }

    override def addPortion(value : Int, text : String, index : Int) : Unit = {
        try {
            // this.logUtil.putF(this.commonStrings.START, this, ADD_PORTION);
            this.portion = value
            super.addPortion(value, text, index)
            this.midletActivity.runOnUiThread(this.titleProgressDialogPortionSetProgressRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.ADD_PORTION, e)
            }
        }
    }

    override def addNormalPortion(value : Int, text : String) : Unit = {
        try {
            // this.logUtil.putF(this.commonStrings.START, this, ADD_PORTION);
            this.portion = value
            super.addNormalPortion(value, text)
            this.midletActivity.runOnUiThread(this.titleProgressDialogPortionSetProgressRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.ADD_PORTION, e)
            }
        }
    }

    override def setValue(value : Int) : Unit = {
        try {
            super.setValue(value)
            this.midletActivity.runOnUiThread(this.titleProgressDialogSetProgressRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "setValue", e)
            }
        }
    }

    def waitUntilDisplayed() : Unit = {
    }

    //I made added the dimension as params it could throw and IllegalArgument Exceptoin
    private def setImages(index : Int, lastWidth : Int, lastHeight : Int) : Unit = {
        val image : Image = this.image
        if (image ne NullImage.NULL_IMAGE) {
            if (Features.getInstance().isFeature(MainFeatureFactory.getInstance().FULL_SCREEN)) {
                if (this.IMAGE(index) eq NullImage.NULL_IMAGE) {
                    this.IMAGE(index) = ImageScaleUtil.getInstance().createImage2(ImageCacheFactory.getInstance(), image, lastWidth.toFloat, image.getWidth().toFloat, lastHeight.toFloat - 20, image.getHeight().toFloat, false)
                }
            } else {
                var nextIndex : Int = index + 1
                if (this.IMAGE(nextIndex) eq NullImage.NULL_IMAGE) {
                    this.IMAGE(nextIndex) = ImageScaleUtil.getInstance().createImage2(ImageCacheFactory.getInstance(), image, lastWidth.toFloat, image.getWidth().toFloat, lastHeight.toFloat - 28, image.getHeight().toFloat, false)
                }
            }
        }
    }

    def initOpenGL(graphics : Graphics) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.INIT)
        this.image = GameFeatureImageCacheFactory.getInstance().getWithKey(AndroidBasicTitleProgressBar.RESOURCE)
        var preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()
        var size : Int = this.IMAGE.length

        {
            var index : Int = 0
            while (index < size) {
                if (this.IMAGE(index) ne NullImage.NULL_IMAGE) {
                    this.IMAGE(index) = preResourceImageUtil.encapsulate(this.IMAGE(index))
                }
                index += 1
            }
        }
        this.updateCurrent()
    }

    override def update(graphics : Graphics) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.UPDATE)
        this.initOpenGL(graphics)
        this.image = GameFeatureImageCacheFactory.getInstance().getWithKey(AndroidBasicTitleProgressBar.RESOURCE)
        var preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()
        var size : Int = this.IMAGE.length

        {
            var index : Int = 0
            while (index < size) {
                if (this.IMAGE(index) ne NullImage.NULL_IMAGE) {
                    preResourceImageUtil.update(graphics, this.IMAGE(index))
                }
                index += 1
            }
        }
    }

    private def getImage(index : Int) : Image = {
        var image : Image = NullImage.NULL_IMAGE
        if (Features.getInstance().isFeature(MainFeatureFactory.getInstance().FULL_SCREEN)) {
            image = this.IMAGE(index)
        } else {
            image = this.IMAGE(index + 1)
        }
        return image
    }

    override def paint2(graphics : Graphics) : Unit = {
        try {
            // Only show background when not loading in the background
            this.animation.paintXY(graphics, 0, 20)
            super.paint2(graphics)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.PAINT, e)
            }
        }
    }

    override def setBackground(background : Boolean) : Unit = {
        super.setBackground(background)
        this.updateCurrent()
    }

    def setPortion(portion : Int) : Unit = {
        this.portion = portion
    }

    def getPortion() : Int = {
        return this.portion
    }

}

object AndroidBasicTitleProgressBar {
    val RESOURCE : String = "ProgressImage"

    private var background : Int = 0

    def setBackgroundResource(background : Int) : Unit = {
        AndroidBasicTitleProgressBar.background = background
    }

}


