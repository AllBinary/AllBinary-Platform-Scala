/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.image.sprite.OneRowSpriteIndexedAnimationFactory
import _root_.org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.media.image.ImageCompleteUtil

class TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory(param_name : String) extends BaseResourceAnimationInterfaceFactoryInterfaceFactory(param_name, StdUtil.getInstance().createHashtable(), StdUtil.getInstance().createHashtable(), StdUtil.getInstance().createHashtable()) {
    import _root_.org.allbinary.input.motion.button.TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory.{*}

    //Constructor
    {
        val name : String = param_name
    }

    override def init(level : Int) : Unit = {
        this.initImageCache(ImageCacheFactory.getInstance(), level)
    }

    override def initImageCache(imageCache : ImageCache, level : Int) : Unit = {
        if (this.isInitialized()) {
            return
        }
        // throws Exception
        val portion : Int = 140
        // " Loading: ";
        val loadingString : String = new StringMaker().append(this.toString()).append(" Loading: ").toString()
        var index : Int = 0
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.addPortion(portion, loadingString, { val value_N75967 = index; index += 1; value_N75967 })
        val touchButtonBlankResource : TouchButtonResource = TouchButtonBlankResource.getInstance()
        val touchButtonGenericActionResource : TouchButtonResource = TouchButtonGenericActionResource.getInstance()
        val touchButtonStartResource : TouchButtonResource = TouchButtonStartResource.getInstance()
        val touchButtonUpResource : TouchButtonResource = TouchButtonUpResource.getInstance()
        val touchButtonDownResource : TouchButtonResource = TouchButtonDownResource.getInstance()
        val touchButtonTurnLeftResource : TouchButtonResource = TouchButtonTurnLeftResource.getInstance()
        val touchButtonTurnRightResource : TouchButtonResource = TouchButtonTurnRightResource.getInstance()
        val touchButtonStrafeLeftResource : TouchButtonResource = TouchButtonStrafeLeftResource.getInstance()
        val touchButtonStrafeRightResource : TouchButtonResource = TouchButtonStrafeRightResource.getInstance()
        val touchButtonBlankResourceImage : Image = imageCache.getWithKey(touchButtonBlankResource.RESOURCE)
        val touchButtonGenericActionResourceImage : Image = imageCache.getWithKey(touchButtonGenericActionResource.RESOURCE)
        val touchButtonStartResourceImage : Image = imageCache.getWithKey(touchButtonStartResource.RESOURCE)
        val touchButtonUpResourceImage : Image = imageCache.getWithKey(touchButtonUpResource.RESOURCE)
        val touchButtonDownResourceImage : Image = imageCache.getWithKey(touchButtonDownResource.RESOURCE)
        val touchButtonTurnLeftResourceImage : Image = imageCache.getWithKey(touchButtonTurnLeftResource.RESOURCE)
        val touchButtonTurnRightResourceImage : Image = imageCache.getWithKey(touchButtonTurnRightResource.RESOURCE)
        val touchButtonStrafeLeftResourceImage : Image = imageCache.getWithKey(touchButtonStrafeLeftResource.RESOURCE)
        val touchButtonStrafeRightResourceImage : Image = imageCache.getWithKey(touchButtonStrafeRightResource.RESOURCE)
        val nullAnimationFactory : NullAnimationFactory = NullAnimationFactory.getFactoryInstance()
        if (OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan()) {
            imageCache.getWithKey(TouchButtonStartResource.getInstance().HINT)
        }
        progressCanvas.addPortion(portion, loadingString, { val value_N77230 = index; index += 1; value_N77230 })
        val imageCompleteUtil : ImageCompleteUtil = ImageCompleteUtil.getInstance()
        progressCanvas.addPortion(portion, loadingString, { val value_N77332 = index; index += 1; value_N77332 })
        imageCompleteUtil.waitForImage(touchButtonBlankResourceImage, touchButtonBlankResource.RESOURCE)
        this.add(touchButtonBlankResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonBlankResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonBlankResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N77550 = index; index += 1; value_N77550 })
        imageCompleteUtil.waitForImage(touchButtonGenericActionResourceImage, touchButtonGenericActionResource.RESOURCE)
        this.add(touchButtonGenericActionResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonGenericActionResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonGenericActionResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N77768 = index; index += 1; value_N77768 })
        imageCompleteUtil.waitForImage(touchButtonStartResourceImage, touchButtonStartResource.RESOURCE)
        this.add(touchButtonStartResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonStartResourceImage, AnimationBehaviorFactory.getInstance()))
        progressCanvas.addPortion(portion, loadingString, { val value_N77944 = index; index += 1; value_N77944 })
        imageCompleteUtil.waitForImage(touchButtonUpResourceImage, touchButtonUpResource.RESOURCE)
        this.add(touchButtonUpResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonUpResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonUpResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N78162 = index; index += 1; value_N78162 })
        imageCompleteUtil.waitForImage(touchButtonDownResourceImage, touchButtonDownResource.RESOURCE)
        this.add(touchButtonDownResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonDownResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonDownResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N78380 = index; index += 1; value_N78380 })
        imageCompleteUtil.waitForImage(touchButtonTurnLeftResourceImage, touchButtonTurnLeftResource.RESOURCE)
        this.add(touchButtonTurnLeftResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonTurnLeftResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonTurnLeftResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N78598 = index; index += 1; value_N78598 })
        imageCompleteUtil.waitForImage(touchButtonTurnRightResourceImage, touchButtonTurnRightResource.RESOURCE)
        this.add(touchButtonTurnRightResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonTurnRightResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonTurnRightResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N78816 = index; index += 1; value_N78816 })
        imageCompleteUtil.waitForImage(touchButtonStrafeLeftResourceImage, touchButtonStrafeLeftResource.RESOURCE)
        this.add(touchButtonStrafeLeftResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonStrafeLeftResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonStrafeLeftResource.HINT, nullAnimationFactory)
        progressCanvas.addPortion(portion, loadingString, { val value_N79034 = index; index += 1; value_N79034 })
        imageCompleteUtil.waitForImage(touchButtonStrafeRightResourceImage, touchButtonStrafeRightResource.RESOURCE)
        this.add(touchButtonStrafeRightResource.RESOURCE, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonStrafeRightResourceImage, AnimationBehaviorFactory.getInstance()))
        this.add(touchButtonStrafeRightResource.HINT, nullAnimationFactory)
        if (OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan()) {
            val touchButtonStartHintResource : Image = imageCache.getWithKey(TouchButtonStartResource.getInstance().HINT)
            this.add(touchButtonStartResource.HINT, OneRowSpriteIndexedAnimationFactory.createFactory(touchButtonStartHintResource, AnimationBehaviorFactory.getInstance()))
        } else {
            this.add(touchButtonStartResource.HINT, nullAnimationFactory)
        }
        super.init(level)
    }

    override def isLoadingLevel(level : Int) : Boolean = {
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (level == resourceLoadingLevelFactory.LOAD_TOUCH.getLevel()) {
            return true
        } else {
            return super.isLoadingLevel(level)
        }
        throw new IllegalStateException()
    }

    override def isFeature() : Boolean = {
        if (!Features.getInstance().isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory {
    def createFactory() : TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory = {
        return new TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory("TouchButton Animations")
    }

}


