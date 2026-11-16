/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.java.util.Enumeration
import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Displayable
import _root_.javax.microedition.lcdui.NullCanvas
import _root_.javax.microedition.midlet.MIDletStateChangeException
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.business.advertisement.GameAdStateFactory
import _root_.org.allbinary.canvas.FullScreenUtil
import _root_.org.allbinary.canvas.GameStatisticsFactory
import _root_.org.allbinary.debug.DebugFactory
import _root_.org.allbinary.debug.DebugInterface
import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.GameMode
import _root_.org.allbinary.game.GameStrings
import _root_.org.allbinary.game.GameTypeFactory
import _root_.org.allbinary.game.PlayerTypesFactory
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.GameOptionsForm
import _root_.org.allbinary.game.configuration.GameOptionsFormFactory
import _root_.org.allbinary.game.configuration.InGameFeatures
import _root_.org.allbinary.game.configuration.InGameOptionsForm
import _root_.org.allbinary.game.configuration.InGameOptionsFormFactory
import _root_.org.allbinary.game.configuration.LoadGameForm
import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.event.GameFeatureEventHandler
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFormUtil
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.game.configuration.persistance.GamePersistanceSingleton
import _root_.org.allbinary.game.configuration.persistance.KeyValuePersistance
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.displayable.canvas.BasicPaintablesCanvas
import _root_.org.allbinary.game.displayable.canvas.DemoCanvas
import _root_.org.allbinary.game.displayable.canvas.GameCanvasRunnableInterface
import _root_.org.allbinary.game.displayable.canvas.GameEventHandlerUtil
import _root_.org.allbinary.game.displayable.canvas.GameInputMappingCanvas
import _root_.org.allbinary.game.displayable.canvas.GameInputMappingInstructionsCanvas
import _root_.org.allbinary.game.displayable.canvas.MenuListener
import _root_.org.allbinary.game.displayable.canvas.NullGameCanvasRunnable
import _root_.org.allbinary.game.input.TextNotificationUtil
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.paint.help.HelpPaintable
import _root_.org.allbinary.game.score.HighScoreCommands
import _root_.org.allbinary.game.score.HighScoreCommandsFactory
import _root_.org.allbinary.game.score.displayable.HighScoreTextBox
import _root_.org.allbinary.game.score.displayable.HighScoreUtil
import _root_.org.allbinary.game.score.displayable.HighScoresCanvas
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.graphics.ResizableListenerHandler
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.ColorChangeEventHandler
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.graphics.displayable.screen.AboutCommandProcessor
import _root_.org.allbinary.graphics.displayable.screen.AboutPaintableFactory
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.graphics.displayable.screen.WebCommandProcessor
import _root_.org.allbinary.input.AllBinarySensorManager
import _root_.org.allbinary.input.event.VirtualKeyboardEventHandler
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.ClientInformationFactory
import _root_.org.allbinary.logic.system.security.licensing.InApplicationPurchaseFactory
import _root_.org.allbinary.logic.system.security.licensing.LockableFeature
import _root_.org.allbinary.logic.system.security.licensing.LockableFeatureFactory
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.audio.AllBinaryMediaManager
import _root_.org.allbinary.midlet.MidletStrings
import _root_.org.allbinary.midlet.ProgressMidlet
import _root_.org.allbinary.thread.NullThread
import _root_.org.allbinary.thread.ThreadFactoryUtil
import _root_.org.allbinary.thread.ThreadUtil
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.EnumerationUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

/**  *Detailed description This class is the main MIDlet for all GameMidlets  *it sets the main canvas and starts a thread for the specified canvas.  *  *@author Travis Berthelot  *Date: 11/19/02  *  */
class GameMidlet(param_clientInformationFactory : ClientInformationFactory) extends ProgressMidlet(param_clientInformationFactory) with CommandListener {

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    val features : Features = Features.getInstance()

    val midletStrings : MidletStrings = MidletStrings.getInstance()

    val myCommandsFactory : MyCommandsFactory = MyCommandsFactory.getInstance()

    val gameStrings : GameStrings = GameStrings.getInstance()

    val gameAdStateFactory : GameAdStateFactory = GameAdStateFactory.getInstance()

    val gameStateFactory : GameStateFactory = GameStateFactory.getInstance()

    val tsUtil : TsUtil = TsUtil.getInstance()

    private val DISPLAYABLE : String = " Displayable: "

    private val COMMAND_NAME : String = "command Name/Label: "

    private val NO_COMMAND : String = "No Command"

    private val NO_DISPLAYABLE : String = "No Displayable"

    private val COMMAND_ACTION : String = new StringMaker().append("GameMidlet::").append(this.midletStrings.COMMAND_ACTION).toString()

    private val PAUSE_APP_BACKGROUND : String = "pauseAppBackground"

    private val UN_PAUSE_APP_BACKGROUND : String = "unPauseAppBackground"

    private val aboutCommandProcessor : AboutCommandProcessor = AboutCommandProcessor.getInstance()

    private val webCommandProcessor : WebCommandProcessor = WebCommandProcessor.getInstance()

    private val gameMidletStateFactory : GameMidletStateFactory = GameMidletStateFactory.getInstance()

    val gameStartTimeHelper : TimeDelayHelper = new TimeDelayHelper(240)

    private val fullScreenUtil : FullScreenUtil = FullScreenUtil.getInstance()

    private var debugInterface : DebugInterface = null

    private var allbinaryGameCanvasRunnableInterface : GameCanvasRunnableInterface = NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE

    private var thread : Thread = NullThread.NULL_THREAD

    //private CommandForm saveGameForm;
    private var loadGameForm : CommandForm = null

    private var isFullScreen : Boolean = false

    private var resized : Boolean = false

    private var startedBefore : Boolean = false

    //private GameOptionsForm gameOptionsForm;
    //Constructor
    {
        val clientInformationFactory : ClientInformationFactory = param_clientInformationFactory
        //For BB can be used for J2ME as well
        SmallIntegerSingletonFactory.getInstance().initWithRange(0x291, 6)
        //This must load after SmallIntegerSingletonFactory init for InputFactory
        this.loadGameForm = CommandForm.getNullCommandForm()
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.init(this)
        GameFeatureEventHandler.getInstance().addListenerInterface(ChangedGameFeatureListener.getInstance())
        GamePersistanceSingleton.getInstance().clear()
        this.debugInterface = DebugFactory.getInstance()
        this.init()
    }

    def init() : Unit = {
    }

    def setDemo() : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def createGame() : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def mediaShutdown() : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def stopAll() : Unit = {
    }

    override def pauseApp() : Unit = {
        this.pauseAppBackground(true)
        val gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
        gameAdState.getAdvertisements().stopAll()
    }

    def pauseAppBackground(background : Boolean) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.PAUSE_APP_BACKGROUND)
        //PreLogUtil.put(commonStrings.START, this, PAUSE_APP_BACKGROUND);
        if (this.allbinaryGameCanvasRunnableInterface ne NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE) {
            this.allbinaryGameCanvasRunnableInterface.pause()
        } else {
            this.logUtil.putF("<<<<<< Null", this, this.PAUSE_APP_BACKGROUND)
        }
        AllBinarySensorManager.getInstance().shutdown()
    }

    def unPauseApp() : Unit = {
        this.unPauseAppBackground(true)
        val gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
        gameAdState.getAdvertisements().startAll()
    }

    def unPauseAppBackground(background : Boolean) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.UN_PAUSE_APP_BACKGROUND)
        //PreLogUtil.put(commonStrings.START, this, UN_PAUSE_APP_BACKGROUND);
        AllBinarySensorManager.getInstance().init()
        val gameCanvasRunnableInterface : GameCanvasRunnableInterface = this.allbinaryGameCanvasRunnableInterface
        if (gameCanvasRunnableInterface ne NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE) {
            gameCanvasRunnableInterface.unPause()
        } else {
            this.logUtil.putF("<<<<<< Null", this, this.UN_PAUSE_APP_BACKGROUND)
        }
    }

    override def destroyAppInRunnable(unconditional : Boolean, isProgress : Boolean) : Unit = {
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        if (isProgress) {
            progressCanvas.start()
            this.commandAction(this.myCommandsFactory.SET_DISPLAYABLE, progressCanvas)
        }
        this.destroyApp(unconditional)
        if (isProgress) {
            progressCanvas.end()
        }
    }

    override def destroyApp(unconditional : Boolean) : Unit = {
        val METHOD_NAME : String = "GameMidlet::destroyApp"
        try {
            PreLogUtil.put(GameStatisticsFactory.getInstance().toString(), this, METHOD_NAME)
            //this.logUtil.putF(this.commonStrings.START, this, METHOD_NAME);
            val gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
            gameAdState.getAdvertisements().stopAll()
            if (!this.isDestroyed()) {
                this.stopGameCanvasRunnableInterface()
                this.setGameCanvasRunnableInterface(NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE)
                //{
                this.mediaShutdown()
            } else {
                this.logUtil.putF("Midlet Managment Error: Midlet Should Only Be Destroyed Once", this, METHOD_NAME)
            }
            super.destroyApp(true)
            //this.logUtil.putF(this.commonStrings.END, this, METHOD_NAME);
            PreLogUtil.put(this.commonStrings.END, this, METHOD_NAME)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, METHOD_NAME, e)
            }
        }
        this.logUtil.putF(this.commonStrings.END, this, METHOD_NAME)
    }

    override def startApp() : Unit = {
        try {
            val gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
            gameAdState.getAdvertisements().startAll()
            val START_APP : String = "startApp"
            this.logUtil.putF(this.commonStrings.START, this, START_APP)
            //PreLogUtil.put(commonStrings.START, this, START_APP);
            val gameCanvasRunnableInterface : Object = this.allbinaryGameCanvasRunnableInterface
            //thus start up only occurs one time ever otherwise this is just unpause
            if (gameCanvasRunnableInterface eq NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE) {
                this.gameMidletStateFactory.setCurrentGameState(this.gameStateFactory.NO_GAME_STATE)
                this.setDemo()
            } else {
                this.logUtil.putF("GameCanvasRunnableInterface is available", this, START_APP)
                //GameCanvasRunnableInterface if it is currently displayed
                if (gameCanvasRunnableInterface eq this.getCurrentDisplayable()) {
                    this.unPauseAppBackground(false)
                } else {
                    this.logUtil.putF("GameCanvasRunnableInterface is not current displayable", this, START_APP)
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "startApp", e)
                this.destroyApp(false)
                //TWB - Only remove from context when multiple midlets share the same emulator
                this.notifyDestroyed()
            }
        }
    }

    override def commandAction(command : Command, displayable : Displayable) : Unit = this.synchronized {
        try {
            var displayableAsString : String = this.NO_DISPLAYABLE
            if (displayable != null) {
                displayableAsString = displayable.toString()
            }
            var label : String = this.NO_COMMAND
            if (command != null) {
                label = command.getLabel()
            }
            PreLogUtil.put(new StringMaker().append(this.COMMAND_NAME).append(label).append(this.DISPLAYABLE).append(displayableAsString).toString(), this, this.COMMAND_ACTION)
            val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
            val allbinaryGameCanvasRunnableInterface : GameCanvasRunnableInterface = this.allbinaryGameCanvasRunnableInterface
            val gameCanvasRunnableInterface : Object = allbinaryGameCanvasRunnableInterface
            if (command eq gameCommandsFactory.SHOW_GAME_CANVAS) {
                //TWB - If progress concurrency is a problem then this is probably the cause
                if ((this.getDisplay().getCurrent() ne gameCanvasRunnableInterface) && (allbinaryGameCanvasRunnableInterface.getType() != NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE.getType())) {
                    this.setDisplay(gameCanvasRunnableInterface.asInstanceOf[Displayable])
                }
                this.unPauseAppBackground(false)
            } else if (command eq gameCommandsFactory.CLOSE_AND_SHOW_GAME_CANVAS) {
                //this.closeMenuListener();
                val menuListener : MenuListener = displayable.asInstanceOf[MenuListener]
                menuListener.close()
                this.setDisplay(gameCanvasRunnableInterface.asInstanceOf[Displayable])
                this.unPauseAppBackground(false)
            } else if (command eq gameCommandsFactory.EXIT_COMMAND) {
                //TWB - Handle exit for android differently
                if (GameMidletEventHandler.getInstance().getEventListenerInterfaceListP().size() == 0) {
                    this.exitProgress(true)
                }
                GameMidletEventHandler.getInstance().fireEvent(new DemoGameMidletEvent(this, DemoGameMidletStateFactory.getInstance().NONE))
            } else if (command eq gameCommandsFactory.EXIT_WITHOUT_PROGRESS_COMMAND) {
                this.exitProgress(false)
            } else if (((command eq gameCommandsFactory.START_COMMAND) || (command eq gameCommandsFactory.RESTART_COMMAND)) || (command eq gameCommandsFactory.CONTINUE_COMMAND)) {
                // GameState gameState = GameStateFactory.getInstance(command);
                if ((this.gameMidletStateFactory.getCurrentGameState() ne this.gameStateFactory.PLAYING_GAME_STATE) || (command eq gameCommandsFactory.RESTART_COMMAND)) {
                    if (this.gameStartTimeHelper.isTimeTNT()) {
                        if ((command eq gameCommandsFactory.START_COMMAND) && this.isDemoLoading()) {
                            this.logUtil.putF("Trying to Start Game Before Loading Complete", this, this.midletStrings.COMMAND_ACTION)
                        } else {
                            this.startedBefore = true
                            this.createGame()
                            this.gameMidletStateFactory.setCurrentGameState(this.gameStateFactory.PLAYING_GAME_STATE)
                        }
                    } else {
                        this.logUtil.putF("Starting Game Too Often", this, this.midletStrings.COMMAND_ACTION)
                    }
                } else {
                    this.logUtil.putF("Already in playing state", this, this.COMMAND_ACTION)
                }
            } else if (command eq gameCommandsFactory.BUY_COMMAND) {
                var inApplicationPurchaseFactory : InApplicationPurchaseFactory = InApplicationPurchaseFactory.getInstance()
                val list : BasicArrayList = LockableFeatureFactory.getInstance().getList()
                val lockableFeature : LockableFeature = list.get(0).asInstanceOf[LockableFeature]
                if ((list.size() > 0) && !inApplicationPurchaseFactory.isPurchased(lockableFeature)) {
                    inApplicationPurchaseFactory.purchase(lockableFeature)
                } else {
                    TextNotificationUtil.getInstance().fireSuccess("Already Purchased")
                }
            } else if (command eq gameCommandsFactory.QUIT_COMMAND) {
                if (this.gameStartTimeHelper.isTimeTNT()) {
                    //Close on quit for HighScoresTextBox.
                    if (displayable.isInstanceOf[HighScoreTextBox]) {
                        val menuListener : MenuListener = displayable.asInstanceOf[MenuListener]
                        menuListener.close()
                    }
                    this.stopGameCanvasRunnableInterface()
                    this.gameMidletStateFactory.setCurrentGameState(this.gameStateFactory.NO_GAME_STATE)
                    this.setDemo()
                }
            } else if (command eq this.myCommandsFactory.RESUME_COMMAND) {
                this.unPauseAppBackground(false)
            } else if (command eq this.myCommandsFactory.PAUSE_COMMAND) {
                this.pauseAppBackground(false)
            } else if (command eq this.myCommandsFactory.SET_DISPLAYABLE) {
                this.pauseAppBackground(false)
                this.setDisplay(displayable)
            } else if (command eq gameCommandsFactory.SET_MENU_DISPLAYABLE) {
                this.pauseAppBackground(false)
                val menuListener : MenuListener = displayable.asInstanceOf[MenuListener]
                menuListener.open()
                this.setDisplay(displayable)
            } else if (command eq gameCommandsFactory.START_TRACE) {
                this.debugInterface.start()
                val gameCanvas : AllBinaryGameCanvas = allbinaryGameCanvasRunnableInterface.asInstanceOf[AllBinaryGameCanvas]
                gameCanvas.addCommand(gameCommandsFactory.STOP_TRACE)
                gameCanvas.removeCommand(gameCommandsFactory.START_TRACE)
            } else if (command eq gameCommandsFactory.STOP_TRACE) {
                this.pauseAppBackground(false)
                this.debugInterface.stop()
                this.unPauseAppBackground(false)
                val gameCanvas : AllBinaryGameCanvas = allbinaryGameCanvasRunnableInterface.asInstanceOf[AllBinaryGameCanvas]
                gameCanvas.addCommand(gameCommandsFactory.START_TRACE)
                gameCanvas.removeCommand(gameCommandsFactory.STOP_TRACE)
            } else if (command eq gameCommandsFactory.DEFAULT_OPTIONS) {
                val tempDisplayable : Displayable = displayable
                if (tempDisplayable.isInstanceOf[GameOptionsForm]) {
                    GameFeatureFormUtil.getInstance().setDefault(tempDisplayable.asInstanceOf[CommandForm])
                }
            } else if (command eq GameInputMappingInstructionsCanvas.DISPLAY) {
                val tempDisplayable : Displayable = displayable
                if (tempDisplayable.isInstanceOf[GameInputMappingCanvas]) {
                    var gameInputMappingCanvas : GameInputMappingCanvas = tempDisplayable.asInstanceOf[GameInputMappingCanvas]
                    gameInputMappingCanvas.update()
                }
                this.commandAction(gameCommandsFactory.SET_MENU_DISPLAYABLE, this.getInputMappingInstructionsCanvas())
            } else if (HighScoreCommandsFactory.getInstance().isHighScoreCommand(command)) {
                val tempDisplayable : Displayable = displayable
                if (tempDisplayable.isInstanceOf[HighScoresCanvas]) {
                    val highScoresCanvas : HighScoresCanvas = tempDisplayable.asInstanceOf[HighScoresCanvas]
                    highScoresCanvas.updateCommand(command)
                }
            } else if (command eq HighScoreCommands.getInstance().DISPLAY) {
                this.commandAction(gameCommandsFactory.SET_MENU_DISPLAYABLE, this.createHighScoresCanvas())
            } else if (command eq GameInputMappingInstructionsCanvas.CLOSE) {
                val menuListener : MenuListener = displayable.asInstanceOf[MenuListener]
                menuListener.close()
                this.commandAction(GameInputMappingCanvas.DISPLAY, NullCanvas.NULL_CANVAS)
            } else if (command eq GameInputMappingCanvas.DISPLAY) {
                //TWB - Called for HTML5 but not others?
                if (J2MEUtil.isHTML()) {
                    this.pauseAppBackground(false)
                }
                this.commandAction(gameCommandsFactory.SET_MENU_DISPLAYABLE, this.getInputMappingCanvas())
            } else if (command eq GameInputMappingCanvas.DEFAULT) {
                val tempDisplayable : Displayable = displayable
                if (tempDisplayable.isInstanceOf[GameInputMappingCanvas]) {
                    var gameInputMappingCanvas : GameInputMappingCanvas = tempDisplayable.asInstanceOf[GameInputMappingCanvas]
                    gameInputMappingCanvas.setDefault()
                }
            } else if (command eq InGameOptionsForm.DISPLAY) {
                this.pauseAppBackground(false)
                val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
                progressCanvas.addNormalPortion(50, "In Game Options")
                val layerManager : AllBinaryGameLayerManager = this.createGameLayerManager()
                val inGameOptionsFormFactory : InGameOptionsFormFactory = InGameOptionsFormFactory.getInstance()
                inGameOptionsFormFactory.init(this, new InGameFeatures(), "Options In Game", layerManager.getBackgroundBasicColor(), layerManager.getForegroundBasicColor())
                val inGameOptionsForm : CommandForm = inGameOptionsFormFactory.get()
                inGameOptionsForm.setItemStateListener(allbinaryGameCanvasRunnableInterface)
                this.commandAction(gameCommandsFactory.SET_MENU_DISPLAYABLE, inGameOptionsForm)
            } else if (command eq InGameOptionsForm.DEFAULT) {
                val inGameOptionsForm : InGameOptionsForm = InGameOptionsFormFactory.getInstance().get().asInstanceOf[InGameOptionsForm]
                GameFeatureFormUtil.getInstance().setDefault(inGameOptionsForm)
            } else if (command eq gameCommandsFactory.DISPLAY_OPTIONS) {
                AllBinaryMediaManager.setMuted(true)
                this.stopAll()
                val mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
                this.isFullScreen = this.features.isFeature(mainFeatureFactory.FULL_SCREEN)
                //PreLogUtil.put("Open isFullScreen: ").append(isFullScreen, this, midletStrings.COMMAND_ACTION);
                ResizableListenerHandler.getInstance().fireEvent(true)
                this.setResized(false)
                this.commandAction(gameCommandsFactory.SET_MENU_DISPLAYABLE, this.getGameOptionsForm())
            } else if (command eq gameCommandsFactory.CLOSE_OPTIONS) {
                //PreLogUtil.put("Close", this, midletStrings.COMMAND_ACTION);
                ResizableListenerHandler.getInstance().fireEvent(false)
                this.commandAction(gameCommandsFactory.CLOSE_AND_SHOW_GAME_CANVAS, displayable)
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Close isFullScreen/change: ")
                stringBuffer.appendboolean(this.isFullScreen)
                stringBuffer.appendboolean(this.fullScreenUtil.isScreenChange(this.isFullScreen))
                stringBuffer.append(" isResized: ")
                stringBuffer.appendboolean(this.isResized())
                PreLogUtil.put(stringBuffer.toString(), this, this.COMMAND_ACTION)
                //Restart canvas if screen change
                if (this.isResized() || this.fullScreenUtil.isScreenChange(this.isFullScreen)) {
                    //PreLogUtil.put("Resized/Changed", this, midletStrings.COMMAND_ACTION);
                    this.updateFullScreen()
                }
                AllBinaryMediaManager.setMuted(false)
            } else if (command eq gameCommandsFactory.DISPLAY_LOAD_FORM) {
                this.pauseAppBackground(false)
                val keyValuePersistance : KeyValuePersistance = GamePersistanceSingleton.getInstance()
                keyValuePersistance.clear()
                keyValuePersistance.loadAll(this.abeClientInformation)
                if (this.getLoadGameForm() eq CommandForm.getNullCommandForm()) {
                    val layerManager : AllBinaryGameLayerManager = this.createGameLayerManager()
                    this.setLoadGameForm(new LoadGameForm(this, "Load Game", layerManager.getBackgroundBasicColor(), layerManager.getForegroundBasicColor()))
                } else {
                    this.getLoadGameForm().update()
                }
                this.commandAction(gameCommandsFactory.SET_MENU_DISPLAYABLE, this.getLoadGameForm())
            } else if (command eq gameCommandsFactory.LOAD_FILE) {
                val loadGameForm : LoadGameForm = this.getLoadGameForm().asInstanceOf[LoadGameForm]
                val index : Int = loadGameForm.getSelectedId()
                if (index != -1) {
                    val keyValuePersistance : KeyValuePersistance = GamePersistanceSingleton.getInstance()
                    this.setStartStateHashtable(keyValuePersistance.get(index))
                    val menuListener : MenuListener = this.getLoadGameForm()
                    menuListener.close()
                    PreLogUtil.put(BasicMotionGesturesHandler.getInstance().toString(), this, this.COMMAND_ACTION)
                    this.commandAction(gameCommandsFactory.START_COMMAND, NullCanvas.NULL_CANVAS)
                    PreLogUtil.put(BasicMotionGesturesHandler.getInstance().toString(), this, this.COMMAND_ACTION)
                }
            } else if (command eq gameCommandsFactory.DELETE_FILE) {
                val loadGameForm : LoadGameForm = this.getLoadGameForm().asInstanceOf[LoadGameForm]
                val index : Int = loadGameForm.getSelectedText()
                if (index != -1) {
                    val keyValuePersistance : KeyValuePersistance = GamePersistanceSingleton.getInstance()
                    keyValuePersistance.delete(this.abeClientInformation, index)
                    keyValuePersistance.clear()
                    keyValuePersistance.loadAllSize(this.abeClientInformation, 1)
                    this.getLoadGameForm().update()
                }
            } else if (command eq gameCommandsFactory.SAVE) {
                val keyValuePersistance : KeyValuePersistance = GamePersistanceSingleton.getInstance()
                this.pauseAppBackground(false)
                //String name = ((SaveGameForm) this.getSaveGameForm()).getText();
                keyValuePersistance.save(this.abeClientInformation, this.getCurrentStateHashtable())
                //this.setDisplay((Displayable) allbinaryGameCanvasRunnableInterface);
                this.unPauseAppBackground(false)
            } else if (command eq HighScoreUtil.SUBMIT_TEXTBOX_COMMAND) {
                this.logUtil.putF("Submitted Score", this, this.COMMAND_ACTION)
                if (displayable.isInstanceOf[HighScoreTextBox]) {
                    val highScoreTextBox : HighScoreTextBox = displayable.asInstanceOf[HighScoreTextBox]
                    highScoreTextBox.submitted = true
                }
                allbinaryGameCanvasRunnableInterface.setHighScoreSubmitted(true)
                this.commandAction(gameCommandsFactory.CLOSE_AND_SHOW_GAME_CANVAS, displayable)
            } else if (command eq gameCommandsFactory.DISPLAY_ABOUT) {
                this.aboutCommandProcessor.process(this, gameCommandsFactory.SET_MENU_DISPLAYABLE, this.getAboutCanvas())
            } else if (command eq gameCommandsFactory.OPEN_WEB_URL) {
                this.webCommandProcessor.process(this, gameCommandsFactory.OPEN_WEB_URL, NullCanvas.NULL_CANVAS)
            } else if (command eq gameCommandsFactory.TOGGLE_KEYBOARD) {
                val virtualKeyboardEventHandler : VirtualKeyboardEventHandler = VirtualKeyboardEventHandler.getInstance()
                virtualKeyboardEventHandler.fireEvent(virtualKeyboardEventHandler.SHOW_EVENT)
            } else if (this.tsUtil.compareTo(command.getLabel(), gameCommandsFactory.TOGGLE_FULLSCREEN.getLabel()) == 0) {
                val mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
                val isFullScreen : Boolean = this.features.isFeature(mainFeatureFactory.FULL_SCREEN)
                if (isFullScreen) {
                    this.features.removeDefault(mainFeatureFactory.FULL_SCREEN)
                } else {
                    this.features.addDefault(mainFeatureFactory.FULL_SCREEN)
                }
                this.updateFullScreen()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(new StringMaker().append(this.commonStrings.EXCEPTION_LABEL).append(command.getLabel()).toString(), this, this.midletStrings.COMMAND_ACTION, e)
                if (command ne GameCommandsFactory.getInstance().EXIT_COMMAND) {
                    this.exitProgress(false)
                }
            }
        }
    }

    private def updateFullScreen() : Unit = {
        val mainFeatureFactory : MainFeatureFactory = MainFeatureFactory.getInstance()
        val isFullScreen : Boolean = this.features.isFeature(mainFeatureFactory.FULL_SCREEN)
        //ScreenListenerHandler.getInstance().fire(isFullScreen);
        val displayable : Displayable = this.getDisplay().getCurrent()
        if (displayable.isInstanceOf[Canvas]) {
            val canvas : Canvas = displayable.asInstanceOf[Canvas]
            canvas.setFullScreenMode(isFullScreen)
        }
    }

    /*     private void closeMenuListener() throws Exception     {     Display display = this.getDisplay();     if(display != null)     {     Displayable displayable = display.getCurrent();     if(displayable != null)     {     if(displayable instanceof GameCommandCanvas)     {     MenuListener menuListener = (MenuListener) displayable;     menuListener.close();     }     }     }     }      */
    def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def getInputMappingInstructionsCanvas() : MyCanvas = {
        return new GameInputMappingInstructionsCanvas(this, this.createGameLayerManager())
    }

    def getInputMappingCanvas() : MyCanvas = {
        //return new BasicPaintablesCanvas(this, this.createGameLayerManager(), paintableArray);
        return new GameInputMappingCanvas(this.abeClientInformation, this, this.createGameLayerManager(), this.getHelpPaintable())
    }

    //You can override this with your own Canvas
    def getAboutCanvas() : MyCanvas = {
        return new BasicPaintablesCanvas(this, CanvasStrings.getInstance().ABOUT, this.createGameLayerManager(), AboutPaintableFactory.getInstance().paintableArray)
    }

    def getHelpPaintable() : HelpPaintable = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def createHighScoresCanvas() : HighScoresCanvas = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def startGameCanvasRunnableInterface() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "startGameCanvasRunnableInterface");
        val threadFactoryUtil : ThreadFactoryUtil = ThreadFactoryUtil.getInstance()
        //thread = 
        this.thread = threadFactoryUtil.getInstanceGameCanvasRunnable(this.allbinaryGameCanvasRunnableInterface)
        this.logUtil.putF(new StringMaker().append("Thread Priority: ").appendint(this.thread.getPriority()).toString(), this, "startGameCanvasRunnableInterface")
        //thread.setPriority(Thread.MAX_PRIORITY);
        this.allbinaryGameCanvasRunnableInterface.setThread(this.thread)
        threadFactoryUtil.start(this.thread)
    }

    def stopGameCanvasRunnableInterface() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.gameStrings.STOP_GAME_CANVAS_RUNNABLE_INTERFACE)
        GameNotificationEventHandler.getInstance().removeAllListeners()
        ColorChangeEventHandler.getInstance().removeAllListeners()
        GameEventHandlerUtil.removeAllListeners()
        // this.setDisplay((Displayable) new ProgressCanvas(this));
        val gameCanvasRunnableInterface : GameCanvasRunnableInterface = this.allbinaryGameCanvasRunnableInterface
        if (gameCanvasRunnableInterface ne NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE) {
            this.logUtil.putF(new StringMaker().append("Set Running False: ").append(gameCanvasRunnableInterface.toString()).toString(), this, this.gameStrings.STOP_GAME_CANVAS_RUNNABLE_INTERFACE)
            gameCanvasRunnableInterface.setRunning(false)
        } else {
            this.logUtil.putF("StopGame - Could Not Stop", this, this.gameStrings.STOP_GAME_CANVAS_RUNNABLE_INTERFACE)
        }
        // Wait for the thread to end then continue
        ThreadUtil.getInstance().join(this.thread)
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        if (this.features.isFeature(MainFeatureFactory.getInstance().LOAD_ALL)) {
            progressCanvas.addNormalPortion(50, "Stopped Game Runnable")
        } else {
            progressCanvas.addNormalPortion(50, "Stopped Main Runnable")
        }
        this.logUtil.putF(this.commonStrings.END, this, this.gameStrings.STOP_GAME_CANVAS_RUNNABLE_INTERFACE)
    }

    def getGameCanvasRunnableInterface() : GameCanvasRunnableInterface = {
        return this.allbinaryGameCanvasRunnableInterface
    }

    def setGameCanvasRunnableInterface(gameCanvasRunnableInterface : GameCanvasRunnableInterface) : Unit = {
        //this.logUtil.putF("Set Runnable: " + gameCanvasRunnableInterface, this, this.gameStrings.STOP_GAME_CANVAS_RUNNABLE_INTERFACE);
        this.allbinaryGameCanvasRunnableInterface = gameCanvasRunnableInterface
    }

    def createGameLayerManager() : AllBinaryGameLayerManager = {
        val gameInfo : GameInfo = new GameInfo(GameTypeFactory.getInstance().SINGLE_PLAYER, GameMode.SERVER, PlayerTypesFactory.getInstance().PLAYER_TYPE_ONE, 1, 1)
        return new AllBinaryGameLayerManager(this.basicColorFactory.BLACK, this.basicColorFactory.WHITE, gameInfo)
    }

    //}
    def getGameOptionsForm() : CommandForm = {
        val layerManager : AllBinaryGameLayerManager = this.createGameLayerManager()
        return GameOptionsFormFactory.getInstance().init(this, "Game Options", layerManager.getBackgroundBasicColor(), layerManager.getForegroundBasicColor())
    }

    def save() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.SAVE)
        val hashtable : ABHashtable[Object, Object] = this.getCurrentStateHashtable()
        GamePersistanceSingleton.getInstance().save(this.abeClientInformation, hashtable)
    }

    override def getCurrentStateHashtable() : ABHashtable[Object, Object] = {
        this.logUtil.putF(this.commonStrings.START, this, "getCurrentStateHashtable")
        val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        if (this.allbinaryGameCanvasRunnableInterface ne NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE) {
            val currentHashtable : ABHashtable[Object, Object] = this.allbinaryGameCanvasRunnableInterface.getCurrentStateHashtable()
            val enumeration : Enumeration[? <: Object] = currentHashtable.keys().asInstanceOf[Enumeration[? <: Object]]
            var key : Object = null

            {
                while (this.enumerationUtil.hasMoreElements(enumeration)) {
                    key = this.enumerationUtil.nextElement(enumeration)
                    hashtable.put(key, currentHashtable.get(key))
                }
            }
        }
        return hashtable
    }

    def setLoadGameForm(loadGameForm : LoadGameForm) : Unit = {
        this.loadGameForm = loadGameForm
    }

    def getLoadGameForm() : CommandForm = {
        return this.loadGameForm
    }

    def setResized(resized : Boolean) : Unit = {
        this.resized = resized
    }

    def isResized() : Boolean = {
        return this.resized
    }

    def isDemoLoading() : Boolean = {
        if (this.startedBefore) {
            return false
        }
        val displayable : Displayable = this.getDisplay().getCurrent()
        if (displayable.isInstanceOf[DemoCanvas]) {
            val demoCanvas : DemoCanvas = displayable.asInstanceOf[DemoCanvas]
            if (demoCanvas.isDemoLoading()) {
                return true
            }
        }
        return false
    }

}


