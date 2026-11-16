/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.init

import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.event.GameInitializedEvent
import _root_.org.allbinary.game.configuration.event.GameInitializedEventHandler
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class GameInitializationUtil {
    import _root_.org.allbinary.game.init.GameInitializationUtil.{*}

    val EVENT : GameInitializedEvent = new GameInitializedEvent(this)

    final def initDemo(abeClientInformation : AbeClientInformationInterface, canvas : MyCanvas, gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory) : Unit = {
        val mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(mainFeatureFactory.STATIC)) {
            var gameInitializationInterface : GameInitializationInterface = gameInitializationInterfaceFactoryInterface.getInstance()
            var features : Features = Features.getInstance()
            //When debugging is on go ahead and load all resources
            if (features.isFeature(mainFeatureFactory.LOAD_ALL)) {
                this.initGame(abeClientInformation, canvas, gameInitializationInterfaceFactoryInterface)
            } else if (features.isFeature(mainFeatureFactory.LOAD_ONDEMAND)) {
                var resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
                gameInitializationInterface.init(abeClientInformation, canvas.getCustomCommandListener(), resourceLoadingLevelFactory.LOAD_EARLY.getLevel())
                this.EVENT.setResourceLoadingLevel(resourceLoadingLevelFactory.LOAD_EARLY)
            } else {
                throw new Exception("No Loading Feature Available")
            }
            GameInitializedEventHandler.getInstance().fireEvent(this.EVENT)
        }
    }

    final def initGame(abeClientInformation : AbeClientInformationInterface, canvas : MyCanvas, gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory) : Unit = {
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(MainFeatureFactory.getInstance().STATIC)) {
            var gameInitializationInterface : GameInitializationInterface = gameInitializationInterfaceFactoryInterface.getInstance()
            var resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
            gameInitializationInterface.init(abeClientInformation, canvas.getCustomCommandListener(), resourceLoadingLevelFactory.LOAD_ALL.getLevel())
            this.EVENT.setResourceLoadingLevel(resourceLoadingLevelFactory.LOAD_ALL)
            GameInitializedEventHandler.getInstance().fireEvent(this.EVENT)
            ChangedGameFeatureListener.getInstance().remove(MainFeatureFactory.getInstance().STATIC)
        }
    }

}

object GameInitializationUtil {
    private val instance : GameInitializationUtil = new GameInitializationUtil()

    def getInstance() : GameInitializationUtil = {
        return GameInitializationUtil.instance
    }

}


