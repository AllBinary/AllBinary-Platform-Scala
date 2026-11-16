/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.game.combat.destroy.DestroyedLayerProcessor
import _root_.org.allbinary.game.combat.destroy.event.DestroyEventCircularStaticPool
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventHandler
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.init.BasicBuildGameInitializerFactory
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.drop.DropLayerProcessor
import _root_.org.allbinary.game.layer.identification.GroupLayerManagerListener
import _root_.org.allbinary.game.score.HighScoresFactoryInterface
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.layer.BasicLayerProcessor
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class CombatGameCanvas(param_cmdListener : CommandListener, param_gameLayerManager : AllBinaryGameLayerManager, param_highScoresFactoryInterface : HighScoresFactoryInterface, param_gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory, param_buffered : Boolean) extends AllBinaryGameCanvas(param_cmdListener, param_gameLayerManager, param_highScoresFactoryInterface, param_gameInitializationInterfaceFactoryInterface, param_buffered) {
    import _root_.org.allbinary.game.combat.canvas.CombatGameCanvas.{*}

    //Constructor
    {
        val cmdListener : CommandListener = param_cmdListener
        val gameLayerManager : AllBinaryGameLayerManager = param_gameLayerManager
        val highScoresFactoryInterface : HighScoresFactoryInterface = param_highScoresFactoryInterface
        val gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory = param_gameInitializationInterfaceFactoryInterface
        val buffered : Boolean = param_buffered
    }

    private def CombatGameCanvas_init() : Unit = {
        DestroyEventCircularStaticPool.getInstance().init(this)
        ProgressCanvasFactory.getInstance().addNormalPortion(50, "Destroy Events")
    }

    override def initApp(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.CombatGameCanvas_init()
        super.initApp(abeClientInformation)
    }

    def initConfigurablePortion(portion : Int) : Unit = {
        DestroyedLayerProcessor.init()
        ProgressCanvasFactory.getInstance().addNormalPortion(portion, "Basic Processors")
        val features : Features = Features.getInstance()
        val gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()
        if (features.isFeature(gameFeatureFactory.DROPPED_ITEMS) && features.isFeature(gameFeatureFactory.DROPPED_ITEMS_FROM_DEATH)) {
            CombatGameCanvas.basicLayerProcessor = new Array[BasicLayerProcessor](2)
            CombatGameCanvas.basicLayerProcessor(0) = DestroyedLayerProcessor.getInstance()
            CombatGameCanvas.basicLayerProcessor(1) = DropLayerProcessor.getInstance()
        } else {
            CombatGameCanvas.basicLayerProcessor = new Array[BasicLayerProcessor](1)
            CombatGameCanvas.basicLayerProcessor(0) = DestroyedLayerProcessor.getInstance()
        }
    }

    override def processPlayingGame() : Unit = {
        super.processPlayingGame()

        {
            var index : Int = CombatGameCanvas.basicLayerProcessor.length
            while ({ index -= 1; index } >= 0) {
                CombatGameCanvas.basicLayerProcessor(index).process(this.gameLayerManager)
            }
        }
    }

    override def cleanupGame() : Unit = {
        super.cleanupGame()

        {
            var index : Int = CombatGameCanvas.basicLayerProcessor.length
            while ({ index -= 1; index } >= 0) {
                CombatGameCanvas.basicLayerProcessor(index).getList().clear()
            }
        }
        GroupLayerManagerListener.getInstance().clear()
        GroupLayerManagerListener.getInstance().log()
        // doing it outside the object like this        
        DestroyedEventHandler.getInstance().removeAllListeners()
        this.cleanupManager()
    }

    def cleanupManager() : Unit = {
        this.gameLayerManager.cleanup()
    }

}

object CombatGameCanvas {
    var basicLayerProcessor : Array[BasicLayerProcessor] = new Array[BasicLayerProcessor](0)

}


