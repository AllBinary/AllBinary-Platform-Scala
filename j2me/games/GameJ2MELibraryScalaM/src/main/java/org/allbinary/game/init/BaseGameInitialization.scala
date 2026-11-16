/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.init

import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.resource.FeaturedResourceRelativeRelationshipFactory
import _root_.org.allbinary.game.resource.ResourceInitialization
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.input.motion.CompleteMotionGestureInputToGameMotionGestureInput
import _root_.org.allbinary.input.motion.button.BasicTouchInputFactory
import _root_.org.allbinary.input.motion.button.CancelTouchButtonInputFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class BaseGameInitialization(param_resourceInitializationArray : Array[ResourceInitialization], param_portion : Int) extends GameInitializationInterface {
    import _root_.org.allbinary.game.init.BaseGameInitialization.{NULL_BASE_GAME_INITIALIZATION as _, *}
    def NULL_BASE_GAME_INITIALIZATION : BaseGameInitialization = _root_.org.allbinary.game.init.BaseGameInitialization.NULL_BASE_GAME_INITIALIZATION

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var resourceInitializationArray : Array[ResourceInitialization] = null

    private var portion : Int = 0

    private var initialized : Boolean = false

    val EARLY_RESOURCES : Int = 0

    val GAME_RESOURCES : Int = 1

    val EARLY_CHANGABLE_RESOURCES : Int = 2

    val GAME_CHANGABLE_RESOURCES : Int = 3

    //    
    private var gameInitialized : Boolean = false

    private var allLoaded : Boolean = false

    //Constructor
    {
        val resourceInitializationArray : Array[ResourceInitialization] = param_resourceInitializationArray
        val portion : Int = param_portion
        this.resourceInitializationArray = resourceInitializationArray
        this.portion = portion
    }

    def initKey(portion : Int) : Unit = {
    }

    def initKeyMapping(abeClientInformation : AbeClientInformationInterface, portion : Int) : Unit = {
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(InputFeatureFactory.getInstance().INPUT_MAPPING)) {
            PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance().init(abeClientInformation)
            ProgressCanvasFactory.getInstance().addNormalPortion(50, "Game Keys")
            ChangedGameFeatureListener.getInstance().remove(InputFeatureFactory.getInstance().INPUT_MAPPING)
        }
    }

    override def init(abeClientInformation : AbeClientInformationInterface, commandListener : CommandListener, level : Int) : Unit = {
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (!this.isInitialized() && ((level == resourceLoadingLevelFactory.LOAD_ALL.getLevel()) || (level == resourceLoadingLevelFactory.LOAD_EARLY.getLevel()))) {
            //PreLogUtil.put("Early Game Init", this, this.commonStrings.INIT);
            var localPortion : Int = 40
            if (level == resourceLoadingLevelFactory.LOAD_EARLY.getLevel()) {
                localPortion = 8
            }
            this.setInitialized(true)
            this.initKey(this.getPortion())
            this.initKeyMapping(abeClientInformation, this.getPortion())
            GameKeyEventFactory.getInstance().init()
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            progressCanvas.addNormalPortion(localPortion, "Game Key Events")
            // after canvas start
            BasicTouchInputFactory.getInstance().init(PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance().getInputMapping())
            //TWB - do not remove and must be after BasicTouchInputFactory init
            CancelTouchButtonInputFactory.getInstance()
            progressCanvas.addNormalPortion(localPortion, "Touch Input")
            CompleteMotionGestureInputToGameMotionGestureInput.getInstance().init()
            progressCanvas.addNormalPortion(localPortion, "Motion Input")
            GameFeatureImageCacheFactory.init()
            progressCanvas.addNormalPortion(localPortion, "Image Cache")
            //PreLogUtil.put("Early Resources", this, this.commonStrings.INIT);
            this.resourceInitializationArray(this.EARLY_RESOURCES).init()
        }
    }

    def resourceInitialization(level : Int) : Unit = {
        var resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (this.resourceAnimationChange() && (level == resourceLoadingLevelFactory.LOAD_EARLY.getLevel())) {
            this.clearResources()
            this.resourceInitializationArray(this.EARLY_CHANGABLE_RESOURCES).init()
        }
        if (this.resourceAnimationChange() && (level == resourceLoadingLevelFactory.LOAD_ALL.getLevel())) {
            if (this.allLoaded) {
                this.clearResources()
            }
            //If LOAD_EARLY/(new DemoCanvas) never occured but static or size did change
            if (FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().getList().size() == 0) {
                this.resourceInitializationArray(this.EARLY_CHANGABLE_RESOURCES).init()
            }
            this.resourceInitializationArray(this.GAME_CHANGABLE_RESOURCES).init()
            this.allLoaded = true
        }
    }

    def resourceAnimationChange() : Boolean = {
        var changedGameFeatureListener : ChangedGameFeatureListener = ChangedGameFeatureListener.getInstance()
        var gameConfigurationCentral : GameConfigurationCentral = GameConfigurationCentral.getInstance()
        if (changedGameFeatureListener.isChangedGameConfiguration(gameConfigurationCentral.SCALE)) {
            return true
        }
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(MainFeatureFactory.getInstance().STATIC)) {
            return true
        }
        return false
    }

    private def clearResources() : Unit = {
        this.allLoaded = false
        //Release scaled/rotated and other non resource images for reuse
        GameFeatureImageCacheFactory.releaseAll()
        var featuredAnimationInterfaceFactoryInterfaceFactory : FeaturedAnimationInterfaceFactoryInterfaceFactory = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance()
        featuredAnimationInterfaceFactoryInterfaceFactory.clear()
        FeaturedResourceRelativeRelationshipFactory.getInstance().clear()
    }

    def setGameInitialized(gameInitialized : Boolean) : Unit = {
        this.gameInitialized = gameInitialized
    }

    def isGameInitialized() : Boolean = {
        return this.gameInitialized
    }

    //
    def getPortion() : Int = {
        return this.portion
    }

    def setInitialized(initialized : Boolean) : Unit = {
        this.initialized = initialized
    }

    def isInitialized() : Boolean = {
        return this.initialized
    }

}

object BaseGameInitialization {
    val NULL_BASE_GAME_INITIALIZATION : BaseGameInitialization = new BaseGameInitialization(new Array[ResourceInitialization](0), 0)

}


