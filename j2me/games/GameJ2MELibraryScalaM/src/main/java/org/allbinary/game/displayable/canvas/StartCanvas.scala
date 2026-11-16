/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Item
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.IndexedAnimationBehavior
import _root_.org.allbinary.animation.special.SpecialAnimation
import _root_.org.allbinary.business.advertisement.GameAdStateFactory
import _root_.org.allbinary.canvas.BaseGameStatistics
import _root_.org.allbinary.canvas.CustomGameMenuUtil
import _root_.org.allbinary.canvas.FullScreenUtil
import _root_.org.allbinary.canvas.GameStatisticsFactory
import _root_.org.allbinary.canvas.RunnableCanvas
import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.game.init.BasicBuildGameInitializerFactory
import _root_.org.allbinary.game.init.GameInitializationUtil
import _root_.org.allbinary.game.input.GameInputStrings
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.event.DownGameKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.event.GameKeyEventHandler
import _root_.org.allbinary.game.input.event.UpGameKeyEventHandler
import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.SWTUtil
import _root_.org.allbinary.game.midlet.DemoGameMidlet
import _root_.org.allbinary.game.score.HighScoreCommands
import _root_.org.allbinary.game.score.HighScores
import _root_.org.allbinary.game.score.HighScoresFactoryInterface
import _root_.org.allbinary.game.score.HighScoresHelper
import _root_.org.allbinary.game.score.HighScoresPaintable
import _root_.org.allbinary.game.score.NullHighScoresSingletonFactory
import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.ResizableListenerHandler
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventHandler
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventListener
import _root_.org.allbinary.graphics.form.FormType
import _root_.org.allbinary.graphics.form.FormTypeFactory
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.opengles.CurrentDisplayableFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.graphics.opengles.OpenGLThreadUtil
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.graphics.paint.StatePaintable
import _root_.org.allbinary.graphics.paint.StatePaintableFactory
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.InApplicationPurchaseFactory
import _root_.org.allbinary.logic.system.security.licensing.LockableFeature
import _root_.org.allbinary.logic.system.security.licensing.LockableFeatureFactory
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.audio.AllBinaryMediaManager
import _root_.org.allbinary.media.audio.EarlySoundsFactory
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class StartCanvas(param_abeClientInformation : AbeClientInformationInterface, param_commandListener : CommandListener, param_highScoresFactoryInterface : HighScoresFactoryInterface, param_paintable : Paintable, param_overlayPaintable : InitUpdatePaintable, param_gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory, param_isContinue : Boolean) extends RunnableCanvas(param_commandListener, CurrentDisplayableFactory.getInstance().DEFAULT_CHILD_NAME_LIST, true) with GameCanvasRunnableInterface with MenuListener with DisplayChangeEventListener {
    import _root_.org.allbinary.game.displayable.canvas.StartCanvas.{*}

    val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    val features : Features = Features.getInstance()

    val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()

    val myCommandsFactory : MyCommandsFactory = MyCommandsFactory.getInstance()

    val gameAdStateFactory : GameAdStateFactory = GameAdStateFactory.getInstance()

    val gameStateFactory : GameStateFactory = GameStateFactory.getInstance()

    val gameInputStrings : GameInputStrings = GameInputStrings.getInstance()

    //private final ThreadFactoryUtil threadFactoryUtil = ThreadFactoryUtil.getInstance();
    val formUtil : FormUtil = FormUtil.getInstance()

    private var basicGameDemoPaintable : StatePaintable = StatePaintableFactory.getInstance()

    private var specialAnimationInterface : SpecialAnimation = SpecialAnimation.getInstance()

    var paintedSpecialAnimationInterface : Animation = SpecialAnimation.getInstance()

    private val fullScreenUtil : FullScreenUtil = FullScreenUtil.getInstance()

    //private AllBinaryGameCanvas gameCanvas = NullGameCanvas.getInstance();
    private val highScoresHelper : HighScoresHelper = new HighScoresHelper()

    private val realHighScoresPaintable : HighScoresPaintable = new HighScoresPaintable()

    private var highScoresPaintable : Paintable = NullPaintable.getInstance()

    private var state : Int = 0

    //private Thread canvasThread;
    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(6000)

    //private BasicColor basicColor = basicColorFactory.RED;
    private var highScoresFactoryInterface : HighScoresFactoryInterface = null

    //Menu
    private var menuInputProcessor : BasicMenuInputProcessor = NoMenuInputProcessor.getInstance()

    private var menuForm : ScrollSelectionForm = ScrollSelectionForm.getNullScrollSelectionForm()

    private var gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory = null

    private var initialized : Boolean = false

    //private final DemoGameStartupRunnable demoGameRunnable;
    private var defaultPaintableInterface : Paintable = NullPaintable.getInstance()

    private var paintableInterface : PaintableInterface = NullPaintable.getInstance()

    private var overlayPaintable : InitUpdatePaintable = null

    private var tempWait : Int = NullWaitGameRunnable.getInstance().WAIT

    private val inputToGameKeyMapping : InputToGameKeyMapping = PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance().getInputMapping()

    var gameRunnable : GameRunnable = NullWaitGameRunnable.getInstance()

    private var progressPaintable : PaintableInterface = ProgressCanvasFactory.getLazyInstance()

    private var isSingleKeyRepeatableProcessing : Boolean = this.features.isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_REPEAT_PRESS)

    private val NONE : GameKey = GameKeyFactory.getInstance().NONE

    private val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    private val SET_STATE : String = "setState"

    private val baseGameStatistics : BaseGameStatistics = GameStatisticsFactory.getInstance()

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val commandListener : CommandListener = param_commandListener
        val highScoresFactoryInterface : HighScoresFactoryInterface = param_highScoresFactoryInterface
        val paintable : Paintable = param_paintable
        val overlayPaintable : InitUpdatePaintable = param_overlayPaintable
        val gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory = param_gameInitializationInterfaceFactoryInterface
        val isContinue : Boolean = param_isContinue
        //Give time for initialization of demogame by default
        this.setWait(NullWaitGameRunnable.getInstance().WAIT)
        this.gameInitializationInterfaceFactoryInterface = gameInitializationInterfaceFactoryInterface
        GameInitializationUtil.getInstance().initDemo(abeClientInformation, this, gameInitializationInterfaceFactoryInterface)
        ResizableListenerHandler.getInstance().fireEvent(false)
        this.overlayPaintable = overlayPaintable
        //PreLogUtil.put("New Demo Canvas", this, this.commonStrings.CONSTRUCTOR);
        this.highScoresFactoryInterface = highScoresFactoryInterface
        this.setDefaultPaintableInterface(paintable)
        this.setPaintableInterface(this.getDefaultPaintableInterface())
        if (isContinue) {
            this.addCommand(GameCommandsFactory.getInstance().CONTINUE_COMMAND)
        }
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(GameFeatureFactory.getInstance().SOUND)) {
            this.mediaInit()
        }
        //this.demoGameRunnable = new DemoGameStartupRunnable(this);
        DisplayChangeEventHandler.getInstance().addListenerInterface(this)
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        try {
            //this.logUtil.putF(new StringMaker().append(commonLabels.START_LABEL).append(displayInfoSingleton.toString()).append(MyFont.getInstance().toString()).toString(), this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT);
            var scrollSelectionForm : ScrollSelectionForm = this.getMenuForm()
            if (scrollSelectionForm != null) {
                var formType : FormType = FormTypeFactory.getInstance().getFormType()
                var rectangle : Rectangle = this.formUtil.createFormRectangle()
                scrollSelectionForm.init(rectangle, formType)
            }
            this.overlayPaintable.init()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT, e)
            }
        }
    }

    def getCustomCommands() : Array[Object] = {
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        if (J2MEUtil.isHTML()) {
            //TWB - Removed Options that are not HTML5 capable yet
            val commandArray : Array[Object] = Array[Object](gameCommandsFactory.START_COMMAND, HighScoreCommands.getInstance().DISPLAY, GameInputMappingCanvas.DISPLAY, gameCommandsFactory.DISPLAY_ABOUT)
            return commandArray
        } else {
            val commandList : BasicArrayList = new BasicArrayListD()
            commandList.add(gameCommandsFactory.START_COMMAND)
            val inApplicationPurchaseFactory : InApplicationPurchaseFactory = InApplicationPurchaseFactory.getInstance()
            if (inApplicationPurchaseFactory.isEnabled()) {
                val list : BasicArrayList = LockableFeatureFactory.getInstance().getList()
                if ((list.size() > 0) && !inApplicationPurchaseFactory.isPurchased(list.get(0).asInstanceOf[LockableFeature])) {
                    commandList.add(gameCommandsFactory.BUY_COMMAND)
                }
            }
            commandList.add(HighScoreCommands.getInstance().DISPLAY)
            //Has nothing to do with overscan/ouya just hiding issues with the UI
            try {
                val isOverScan : Boolean = OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan()
                if (SWTUtil.isSWT) {
                    commandList.add(GameInputMappingCanvas.DISPLAY)
                } else if (!isOverScan) {
                    commandList.add(gameCommandsFactory.DISPLAY_OPTIONS)
                    commandList.add(gameCommandsFactory.DISPLAY_LOAD_FORM)
                    commandList.add(GameInputMappingCanvas.DISPLAY)
                }
            } catch {
                case e : Exception => {
                }
            }
            commandList.add(gameCommandsFactory.DISPLAY_ABOUT)
            val commandArray : Array[Object] = commandList.toArray()
            return commandArray
        }
        throw new IllegalStateException()
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        val commandArray : Array[Object] = this.getCustomCommands()
        val size : Int = commandArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.addCommand(commandArray(index).asInstanceOf[Command])
                index += 1
            }
        }
        // this.addCommand(GameCommands.SELECTCOMMAND);
        CustomGameMenuUtil.add(this)
        this.setCommandListener(cmdListener)
    }

    def initPostPaint() : Unit = {
    }

    def mediaInit() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "mediaInit");
        AllBinaryMediaManager.init(EarlySoundsFactory.getInstance())
    }

    override def itemStateChanged(item : Item) : Unit = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
    }

    def initMenu() : Unit = {
        this.close()
        //        }
        this.open()
    }

    override def open() : Unit = {
        BasicMotionGesturesHandler.getInstance().addListenerInterface(this.getMenuInputProcessor())
        GameKeyEventHandler.getInstance().addListener(this.getMenuInputProcessor())
    }

    override def close() : Unit = {
        BasicMotionGesturesHandler.getInstance().removeListener(this.getMenuInputProcessor())
        GameKeyEventHandler.getInstance().removeListener(this.getMenuInputProcessor())
    }

    override def getSourceId() : Int = {
        return StartCanvas.id
    }

    override def keyPressed(keyCode : Int) : Unit = {
        this.keyPressedByDevice(keyCode, 0)
    }

    override def keyReleased(keyCode : Int) : Unit = {
        this.keyReleasedByDevice(keyCode, 0)
    }

    override def keyRepeated(keyCode : Int) : Unit = {
        this.keyRepeatedByDevice(keyCode, 0)
    }

    override def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        // this.logUtil.putF(this.commonStrings.START, this, gameInputStrings.KEY_PRESSED);
        this.addGameKeyEvent(keyCode, false)
    }

    override def keyReleasedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        // this.logUtil.putF(this.commonStrings.START, this, gameInputStrings.KEY_RELEASED);
        this.removeGameKeyEvent(keyCode, false)
    }

    override def keyRepeatedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        // Integer.toHexString(keyCode), // this, gameInputStrings.KEY_REPEATED);
        if (this.isSingleKeyRepeatableProcessing) {
            this.addGameKeyEvent(keyCode, true)
        }
    }

    private def addGameKeyEvent(keyCode : Int, repeated : Boolean) : Unit = {
        try {
            //this.logUtil.putF(new StringMaker().append("Key Code (Hex): ").append(Integer.toHexString(keyCode)).toString(), this, this.gameInputStrings.ADD_KEY_EVENT);
            var gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(this, keyCode)
            //this.logUtil.putF(new StringMaker().append("GameKey: ").append(gameKey).toString(), this, this.gameInputStrings.ADD_KEY_EVENT);
            if (gameKey ne this.NONE) {
                var gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this, gameKey)
                /*                  * //This is for key input debugging only GameKeyEvent                  * gameKeyEvent = GameKeyEventFactory.getInstance(this, keyCode,                  * gameActionKeyCode, gameKey.getKey(), repeated);                  * this.logUtil.putF(gameKeyEvent.toString(), this, this.gameInputStrings.ADD_KEY_EVENT);                  */
                DownGameKeyEventHandler.getInstance().fireEvent(gameKeyEvent)
            } else {
                this.logUtil.putF(new StringMaker().append(this.gameInputStrings.NO_KEY).appendint(keyCode).toString(), this, this.gameInputStrings.ADD_KEY_EVENT)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.ADD_KEY_EVENT, e)
            }
        }
    }

    private def removeGameKeyEvent(keyCode : Int, repeated : Boolean) : Unit = {
        try {
            // this.logUtil.putF(new StringMaker().append("Key Code: " + Integer.toHexString(keyCode), this, this.gameInputStrings.REMOVE_KEY_EVENT);
            var gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(this, keyCode)
            //this.logUtil.putF("GameKey: ").append(gameKey, this, this.gameInputStrings.REMOVE_KEY_EVENT);
            if (gameKey ne this.NONE) {
                var gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this, gameKey)
                // TODO TWB - Remove or improve key input event handling
                UpGameKeyEventHandler.getInstance().fireEvent(gameKeyEvent)
            } else {
                this.logUtil.putF(new StringMaker().append(this.gameInputStrings.NO_KEY).appendint(keyCode).toString(), this, this.gameInputStrings.REMOVE_KEY_EVENT)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.REMOVE_KEY_EVENT, e)
            }
        }
    }

    override def pause() : Unit = this.synchronized {
        this.close()
        this.setPaused(true)
    }

    override def unPause() : Unit = this.synchronized {
        this.open()
        this.setPaused(false)
    }

    override def isPausable() : Boolean = {
        //TWB - Game is paused but UsedRunnable was set after the old runnable was called
        if (CurrentDisplayableFactory.getInstance().getUsedRunnable() eq NullWaitGameRunnable.getInstance()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def isGameOver() : Boolean = {
        this.logUtil.putF(new StringMaker().append(this.commonStrings.NOT_IMPLEMENTED).append(" since not a game").toString(), this, "isGameOver")
        return false
    }

    override def setLoadStateHashtable(hashtable : ABHashtable[Object, Object]) : Unit = {
        this.logUtil.putF("Trying to continue a demo lol - only continue a game canvas not the demo", this, "setLoadStateHashtable")
    }

    override def getLoadStateHashtable() : ABHashtable[Object, Object] = {
        this.logUtil.putF("Trying to continue a demo lol - only continue a game canvas not the demo", this, "getLoadStateHashtable")
        return this.stdUtil.NULL_TABLE
    }

    override def getCurrentStateHashtable() : ABHashtable[Object, Object] = {
        this.logUtil.putF("Trying to save the AI lol", this, "getCurrentStateHashtable")
        return this.stdUtil.NULL_TABLE
    }

    override def setHighScoreSubmitted(isNotUsed : Boolean) : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
        // Draw Game
        this.paintableInterface.paint(graphics)
        // Draw title animation
        this.paintedSpecialAnimationInterface.paintXY(graphics, 0, 0)
        //paints the high scores when in that state
        this.highScoresPaintable.paint(graphics)
        //usually the game menu
        this.getBasicGameDemoPaintable().paint(graphics)
        this.overlayPaintable.paint(graphics)
        this.progressPaintable.paint(graphics)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        this.paintableInterface.paintThreed(graphics)
        // Draw title animation
        this.paintedSpecialAnimationInterface.paintThreedXYZ(graphics, 0, 0, 0)
    }

    override def processGameOver() : Unit = this.synchronized {
        this.logUtil.putF("Not Implemented since not a game", this, "setGameOver")
    }

    def demoStateChange() : Unit = {
        var newState : Int = this.state + 1
        if (newState > 2) {
            newState = 0
        } else if (newState == 2) {
            //skip HighScores State it none exists
            if (!this.highScoresHelper.isAnyHighScores()) {
                newState = 0
            } else {
                val highScores : HighScores = this.highScoresHelper.getNextHighScores()
                if (highScores eq NullHighScoresSingletonFactory.getInstance()) {
                    newState = 0
                } else {
                    this.getRealHighScoresPaintable().setHighScores(highScores)
                }
            }
        }
        this.setState(newState)
        this.updateDemoState()
    }

    def updateDemoState() : Unit = {
        PreLogUtil.put(SmallIntegerSingletonFactory.getInstance().createInstance(this.state).toString(), this, this.SET_STATE)
        //this.logUtil.putF(CommonLabels.getInstance().CURRENT + " Demo State: ").append(this.getState(), this, SET_STATE);
        this.getBasicGameDemoPaintable().setState(this.state)
        if (this.state == 0) {
            // Title and menu
            this.highScoresPaintable = NullPaintable.getInstance()
            this.paintedSpecialAnimationInterface = this.getSpecialAnimationInterface()
            //PreLogUtil.put("Reset", this, this.commonStrings.RUN);
            this.getSpecialAnimationInterface().reset()
        } else if (this.state == 1) {
            // Help
            this.paintedSpecialAnimationInterface = SpecialAnimation.getInstance()
        } else if (this.state == 2) {
            this.highScoresPaintable = this.getRealHighScoresPaintable()
        }
        var gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
        gameAdState.processPageAdState()
    }

    def getNextRandom() : Int = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def createGameLayerManager(randomValue : Int) : AllBinaryGameLayerManager = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def createRunnable(randomLevel : Int) : GameCanvasRunnableInterface = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def createCanvas() : Unit = {
        //PreLogUtil.put(commonStrings.START, this, "create");
        this.highScoresPaintable = NullPaintable.getInstance()
        var randomLevel : Int = this.getNextRandom()
    }

    def start() : Unit = {
    }

    def preDemoProcess() : Unit = {
        /*         if (!gameCanvas.isInitialized() ||                 gameCanvas.getTitle() == NullGameCanvas.NO_GAME)         {             if (AllBinaryMediaManager.update())             {                 if (!PrimaryPlayerQueueFactory.getInstance().process())                 {                     SecondaryPlayerQueueFactory.getInstance().process();                 }             }         }         */
        this.overlayPaintable.update()
    }

    override def process() : Unit = {
        this.getMenuInputProcessor().processInputList()
        this.preDemoProcess()
        if (this.state == 0) {
            //Don't allow the time of the animation to count towards the state time.
            val indexedAnimationBehavior : IndexedAnimationBehavior = this.getSpecialAnimationInterface().getAnimationBehavior().asInstanceOf[IndexedAnimationBehavior]
            if (indexedAnimationBehavior.loopIndex < 1) {
                this.timeDelayHelper.setStartTimeTNT()
            }
            var demoGameMidlet : DemoGameMidlet = this.getCustomCommandListener().asInstanceOf[DemoGameMidlet]
        }
    }

    //Override to Show Background progress when demogame is loading
    final def startDemoGame() : Unit = {
    }

    //    }
    def processGame() : Unit = {
        //PreLogUtil.put(commonStrings.START, this, "processGame");
        this.gameRunnable.run()
        //PreLogUtil.put("nextFrame", this, "processGame");
        this.specialAnimationInterface.nextFrame()
        // next screen and starting a new demo game
        this.process()
    }

    override def run() : Unit = {
        this.logUtil.putF(this.commonStrings.START_RUNNABLE, this, this.commonStrings.RUN)
        try {
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            progressCanvas.addNormalPortion(50, "Demo Thread")
            this.setCurrentThread()
            this.setRunning(true)
            //this.process();
            if (this.features.isFeature(MainFeatureFactory.getInstance().LOAD_ONDEMAND)) {
                progressCanvas.end()
            } else {
                progressCanvas.addNormalPortion(50, "Demo Thread Running")
            }
            this.fullScreenUtil.initOnRun(this, this.getCustomCommandListener())
            this.initMenu()
            this.initPostPaint()
            this.updateDemoState()
            //final TimeDelayHelper runningTimeDelayHelper = new TimeDelayHelper(12000);
            if (this.features.isDefault(this.openGLFeatureFactory.OPENGL_AS_GAME_THREAD)) {
                //Only needed is not really using a real gamecanvas
                OpenGLThreadUtil.getInstance().onResume()
            }
            if (this.features.isDefault(this.openGLFeatureFactory.OPENGL_AS_GAME_THREAD) || J2MEUtil.isHTML()) {
            } else {
                //PreLogUtil.put(commonStrings.START, this, "Starting Run Loop");

                {
                    while (this.isRunning()) {
                        this.loopTimeHelper.setStartTimeTNT()
                        this.processGame()
                        this.processLoopSleep()
                    }
                }
                this.end()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
        this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
    }

    override def setRunning(running : Boolean) : Unit = {
        super.setRunning(running)
        try {
            //If game thread is not actually running
            if ((this.features.isDefault(this.openGLFeatureFactory.OPENGL) || J2MEUtil.isHTML()) && !running) {
                val currentDisplayableFactory : CurrentDisplayableFactory = CurrentDisplayableFactory.getInstance()
                currentDisplayableFactory.clearRunnable()
                this.end()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.SET_RUNNING, e)
            }
        }
    }

    def end() : Unit = {
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        this.baseGameStatistics.add(new StringMaker().append(StartCanvas.BOT_GAME_STATS).append(this.baseGameStatistics.toString()).append(CommonSeps.getInstance().NEW_LINE).toString())
        this.baseGameStatistics.init()
        if (this.features.isFeature(MainFeatureFactory.getInstance().LOAD_ONDEMAND)) {
            progressCanvas.start()
        }
        this.logUtil.putF("Demo End", this, this.commonStrings.RUN)
        this.close()
        DisplayChangeEventHandler.getInstance().removeListener(this)
    }

    override def setGameState(gameState : GameState) : Unit = {
    }

    override def getGameState() : GameState = {
        return this.gameStateFactory.PLAYING_GAME_STATE
    }

    //    }
    def getState() : Int = {
        return this.state
    }

    def setState(state : Int) : Unit = {
        this.state = state
    }

    override def isHighScoreSubmitted() : Boolean = {
        // Don't Submit AI Score Since That Is Stupidy
        this.logUtil.putF("Wow the AI got a high score!", this, "isHighScoreSubmitted")
        return false
    }

    /*     public void setRealHighScoresPaintable(HighScoresPaintable realHighScoresPaintable)     {     this.realHighScoresPaintable = realHighScoresPaintable;     }      */
    def getRealHighScoresPaintable() : HighScoresPaintable = {
        return this.realHighScoresPaintable
    }

    def setSpecialAnimationInterface(specialAnimationInterface : SpecialAnimation) : Unit = {
        //this.logUtil.putF("specialAnimationInterface: " + specialAnimationInterface, this, "setSpecialAnimationInterface");
        specialAnimationInterface.setFrame(0)
        this.specialAnimationInterface = specialAnimationInterface
    }

    def getSpecialAnimationInterface() : SpecialAnimation = {
        return this.specialAnimationInterface
    }

    def setPaintableInterface(paintableInterface : PaintableInterface) : Unit = {
        this.paintableInterface = paintableInterface
    }

    def getPaintableInterface() : PaintableInterface = {
        return this.paintableInterface
    }

    def setDefaultPaintableInterface(defaultPaintableInterface : Paintable) : Unit = {
        this.defaultPaintableInterface = defaultPaintableInterface
    }

    def getDefaultPaintableInterface() : Paintable = {
        return this.defaultPaintableInterface
    }

    def getHighScoresFactoryInterface() : HighScoresFactoryInterface = {
        return this.highScoresFactoryInterface
    }

    def setMenuInputProcessor(menuInputProcessor : BasicMenuInputProcessor) : Unit = {
        this.menuInputProcessor = menuInputProcessor
    }

    def getMenuInputProcessor() : BasicMenuInputProcessor = {
        return this.menuInputProcessor
    }

    /**      * @return the menuForm      */
    def getMenuForm() : ScrollSelectionForm = {
        return this.menuForm
    }

    /**      * @param menuForm the menuForm to set      */
    def setMenuForm(menuForm : ScrollSelectionForm) : Unit = {
        this.menuForm = menuForm
    }

    /*     private void setInitialized(boolean initialized)     {     this.initialized = initialized;     }      */
    override def isInitialized() : Boolean = {
        return this.initialized
    }

    def getOverlayPaintable() : Paintable = {
        return this.overlayPaintable
    }

    def setBasicGameDemoPaintable(basicGameDemoPaintable : StatePaintable) : Unit = {
        this.basicGameDemoPaintable = basicGameDemoPaintable
    }

    def getBasicGameDemoPaintable() : StatePaintable = {
        return this.basicGameDemoPaintable
    }

    def setTempWait(tempWait : Int) : Unit = {
        this.tempWait = tempWait
    }

    def getTempWait() : Int = {
        return this.tempWait
    }

    override def isSingleThread() : Boolean = {
        return OpenGLFeatureUtil.getInstance().isAnyThreed() || SWTUtil.isSWT
    }

    def isRunningInAnotherThread() : Boolean = {
        val features : Features = Features.getInstance()
        val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        if (features.isDefault(openGLFeatureFactory.OPENGL_AS_GAME_THREAD)) {
            return true
        } else {
            return this.isRunning()
        }
        throw new IllegalStateException()
    }

    /**     * @return the gameInitializationInterfaceFactoryInterface     */
    def getGameInitializationInterfaceFactoryInterface() : BasicBuildGameInitializerFactory = {
        return this.gameInitializationInterfaceFactoryInterface
    }

    //Needed for polyglot do not remove
    override def getTitle() : String = {
        return super.getTitle()
    }

    //Needed for polyglot do not remove
    override def isPaused() : Boolean = {
        return super.isPaused()
    }

    //Needed for polyglot do not remove
    override def getType() : Int = {
        return super.getType()
    }

}

object StartCanvas {
    private val id : Int = 0

    private val BOT_GAME_STATS : String = "Bot Game Statistics: "

}


