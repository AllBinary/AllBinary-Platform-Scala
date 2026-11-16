/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.ChoiceGroup
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Item
import _root_.javax.microedition.lcdui.NullCommandListener
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.business.advertisement.GameAdStateFactory
import _root_.org.allbinary.canvas.BaseGameStatistics
import _root_.org.allbinary.canvas.GameStatisticsFactory
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.canvas.RunnableCanvas
import _root_.org.allbinary.debug.DebugFactory
import _root_.org.allbinary.debug.NoDebug
import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.GameStrings
import _root_.org.allbinary.game.GameTypeFactory
import _root_.org.allbinary.game.Intermission
import _root_.org.allbinary.game.IntermissionCompositeInterface
import _root_.org.allbinary.game.IntermissionEnableListenerInterface
import _root_.org.allbinary.game.IntermissionInterface
import _root_.org.allbinary.game.PlayerTypesFactory
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.InGameFeatures
import _root_.org.allbinary.game.configuration.InGameOptionsForm
import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.event.GameInitializedEvent
import _root_.org.allbinary.game.configuration.event.GameInitializedEventHandler
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.game.configuration.feature.GameFeatureUtil
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory
import _root_.org.allbinary.game.configuration.feature.TouchFeatureFactory
import _root_.org.allbinary.game.displayable.GameLevelDisplayChangeEventListenersFactory
import _root_.org.allbinary.game.init.BasicBuildGameInitializerFactory
import _root_.org.allbinary.game.init.GameInitializationUtil
import _root_.org.allbinary.game.input.GameInputStrings
import _root_.org.allbinary.game.input.InputProcessor
import _root_.org.allbinary.game.input.NoPlayerGameInput
import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.game.input.event.GameKeyEventHandler
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.SWTUtil
import _root_.org.allbinary.game.paint.ColorFillBasePaintable
import _root_.org.allbinary.game.paint.ColorFillPaintableFactory
import _root_.org.allbinary.game.resource.ResourceLoadingLevel
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.game.score.HighScore
import _root_.org.allbinary.game.score.HighScoresHelperBaseInterface
import _root_.org.allbinary.game.score.HighScoresFactoryInterface
import _root_.org.allbinary.game.score.HighScoresPaintable
import _root_.org.allbinary.game.score.NullHighScoresSingletonFactory
import _root_.org.allbinary.game.score.displayable.HighScoreTextBox
import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.game.state.GameStateFactory
import _root_.org.allbinary.graphics.GraphicsStrings
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.ScreenCapture
import _root_.org.allbinary.graphics.ScreenCaptureFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.GameTickDisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventHandler
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventListener
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.form.CommandCurrentSelectionFormFactory
import _root_.org.allbinary.graphics.form.FormPaintable
import _root_.org.allbinary.graphics.form.FormType
import _root_.org.allbinary.graphics.form.FormTypeFactory
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.form.ScrollSelectionFormNoneFactory
import _root_.org.allbinary.graphics.form.item.CommandTextItemArrayFactory
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.opengles.CurrentDisplayableFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.graphics.opengles.OpenGLThreadUtil
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable
import _root_.org.allbinary.graphics.paint.NullInitUpdatePaintable
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.image.opengles.OpenGLImageSpecificFactory
import _root_.org.allbinary.input.gyro.SensorGameUpdateProcessor
import _root_.org.allbinary.input.gyro.SingleSensorGameUpdateProcessor
import _root_.org.allbinary.input.motion.button.BaseTouchInput
import _root_.org.allbinary.input.motion.button.NoButtonsTouchInputFactory
import _root_.org.allbinary.input.motion.button.TouchButtonFactory
import _root_.org.allbinary.input.motion.button.TouchButtonsPaintableFactory
import _root_.org.allbinary.input.motion.button.TouchScreenFactory
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.audio.AllBinaryMediaManager
import _root_.org.allbinary.media.audio.PlayerQueue
import _root_.org.allbinary.media.audio.PrimaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.SecondaryThreadPool
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class AllBinaryGameCanvas(param_commandListener : CommandListener, param_gameLayerManager : AllBinaryGameLayerManager, param_highScoresFactoryInterface : HighScoresFactoryInterface, param_gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory, param_buffered : Boolean) extends RunnableCanvas(param_commandListener, CanvasStrings.getInstance().EMPTY_CHILD_NAME_LIST, true) with AllBinaryGameCanvasInterface with GameCanvasRunnableInterface with MenuListener with IntermissionCompositeInterface with IntermissionEnableListenerInterface with PopupMenuInterface with DisplayChangeEventListener with UpdateMyFontInterface {
    import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas.{TYPE as _, *}
    def TYPE : Int = _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas.TYPE

    val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    val touchFeatureFactory : TouchFeatureFactory = TouchFeatureFactory.getInstance()

    val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()

    val touchButtonFactory : TouchButtonFactory = TouchButtonFactory.getInstance()

    val gameAdStateFactory : GameAdStateFactory = GameAdStateFactory.getInstance()

    val gameStrings : GameStrings = GameStrings.getInstance()

    val gameInputStrings : GameInputStrings = GameInputStrings.getInstance()

    val gameStateFactory : GameStateFactory = GameStateFactory.getInstance()

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private val gameTickDisplayInfoSingleton : GameTickDisplayInfoSingleton = GameTickDisplayInfoSingleton.getInstance()

    val gameRunnable : GameCanvasRunnable = new GameCanvasRunnable(this)

    val gamePauseRunnable : GameCanvasPauseRunnable = new GameCanvasPauseRunnable(this)

    val formUtil : FormUtil = FormUtil.getInstance()

    val myFormUtil : MyFormUtil = MyFormUtil.getInstance()

    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    var gameSpecificPaintable : Paintable = NullPaintable.getInstance()

    private val sensorGameUpdateProcessor : SensorGameUpdateProcessor = new SingleSensorGameUpdateProcessor()

    var endGameInfo : EndGameInfo = new EndGameInfo()

    private val startIntermissionInterface : IntermissionInterface = new Intermission()

    private val endLevelIntermissionInterface : IntermissionInterface = new Intermission()

    var gameLayerManager : AllBinaryGameLayerManager = AllBinaryGameLayerManager.getNullInstance()

    private var gameState : GameState = this.gameStateFactory.NO_GAME_STATE

    private var gameOver : Boolean = false

    private var initialized : Boolean = false

    // Time Delayed repsonse times
    private val gameStateTimeHelper : TimeDelayHelper = new TimeDelayHelper(0)

    // high score vars
    var highScoresHelper : HighScoresHelperBaseInterface = null

    private var highScoreSubmitted : Boolean = false

    private val realHighScoresPaintable : HighScoresPaintable = new HighScoresPaintable()

    private var highScoresPaintable : Paintable = NullPaintable.getInstance()

    // TODO TWB hack around key event handling performance
    private var localPlayerGameInputList : BasicArrayList = new BasicArrayListD()

    //NoPlayerGameInput.getInstance();
    private var isCheating : Boolean = false

    private var hashtable : ABHashtable[Object, Object] = this.stdUtil.NULL_TABLE

    private var isSingleKeyRepeatableProcessing : Boolean = false

    private var gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory = BasicBuildGameInitializerFactory.NULL_BASE_BUILD_GMAE_INITIALIZER_FACTORY

    private var touchButtonsPaintable : Paintable = NullPaintable.getInstance()

    var touchPaintable : Paintable = NullPaintable.getInstance()

    private var cheatProcessor : PlayerGameInput = NoPlayerGameInput.getInstance()

    private var gameInputProcessor : Processor = Processor.getInstance()

    private var endGameProcessor : Processor = Processor.getInstance()

    private var realEndGameProcessor : Processor = Processor.getInstance()

    private var startIntermissionProcessor : Processor = Processor.getInstance()

    private var realStartIntermissionProcessor : Processor = Processor.getInstance()

    private var endGamePaintable : Paintable = NullPaintable.getInstance()

    private var endGameStatePaintable : Paintable = NullPaintable.getInstance()

    var nonBotPaintable : Paintable = NullPaintable.getInstance()

    private var intermissionPaintable : Paintable = NullPaintable.getInstance()

    // protected Paintable startIntermissionPaintable;
    private var startIntermissionPaintable : InitUpdatePaintable = NullInitUpdatePaintable.getInstance()

    private var mainStateProcessor : Processor = Processor.getInstance()

    private var processGameProcessor : Processor = Processor.getInstance()

    private var highScoresFactoryInterface : HighScoresFactoryInterface = null

    private var startLevel : Int = 0

    // Menu
    private var mainMenuInputProcessor : BasicMenuInputProcessor = NoMenuInputProcessor.getInstance()

    private var popupMenuInputProcessor : BasicMenuInputProcessor = NoMenuInputProcessor.getInstance()

    private var menuInputProcessor : BasicMenuInputProcessor = NoMenuInputProcessor.getInstance()

    private var menuForm : ScrollSelectionForm = ScrollSelectionForm.getNullScrollSelectionForm()

    private var formPaintable : Paintable = NullPaintable.getInstance()

    private var openMenuPaintable : Paintable = NullPaintable.getInstance()

    private var menuPaintable : Paintable = NullPaintable.getInstance()

    private var currentTouchInputFactory : BaseTouchInput = NoButtonsTouchInputFactory.getInstance()

    var colorFillPaintable : ColorFillBasePaintable = ColorFillPaintableFactory.getInstance().getInstance(this.basicColorFactory.BLACK, true)

    private val baseGameStatistics : BaseGameStatistics = GameStatisticsFactory.getInstance()

    private val primaryPlayerQueue : PlayerQueue = PrimaryPlayerQueueFactory.getInstance()

    private val secondaryPlayerQueue : PlayerQueue = SecondaryPlayerQueueFactory.getInstance()

    val BUILD_GAME : String = "buildGame"

    val gameTypeFactory : GameTypeFactory = GameTypeFactory.getInstance()

    val screenCapture : ScreenCapture = ScreenCaptureFactory.getInstance()

    private val basicMotionGesturesHandler : BasicMotionGesturesHandler = BasicMotionGesturesHandler.getInstance()

    private val gameKeyEventHandler : GameKeyEventHandler = GameKeyEventHandler.getInstance()

    private var gameBehavior : DemoGameBehavior = null

    private var menuBehavior : BaseMenuBehavior = null

    private var progressPaintable : PaintableInterface = ProgressCanvasFactory.getLazyInstance()

    var fontHeightP : Int = 0

    private var gameCanvasStartListener : DemoPaintableInterface = NullDemoPaintable.NULL_DEMO_PAINTABLE

    private val rawGameInputProcessor : InputProcessor = new GameCanvasInputProcessor(this)

    private val rawInputProcessor : InputProcessor = new FormInputProcessor(this)

    private var inputProcessor : InputProcessor = this.getRawGameInputProcessor()

    private val YIELD_SLEEP : Long = 100

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val gameLayerManager : AllBinaryGameLayerManager = param_gameLayerManager
        val highScoresFactoryInterface : HighScoresFactoryInterface = param_highScoresFactoryInterface
        val gameInitializationInterfaceFactoryInterface : BasicBuildGameInitializerFactory = param_gameInitializationInterfaceFactoryInterface
        val buffered : Boolean = param_buffered
        this.highScoresHelper = highScoresFactoryInterface.createHighScoresHelper()
        this.gameInitializationInterfaceFactoryInterface = gameInitializationInterfaceFactoryInterface
        this.init(gameLayerManager, buffered)
        this.highScoresFactoryInterface = highScoresFactoryInterface
        if ((this.gameLayerManager.getGameInfo().getGameType() eq this.gameTypeFactory.BOT) || (this.gameLayerManager.getGameInfo().getGameType() eq this.gameTypeFactory.NONE)) {
            this.gameBehavior = DemoGameBehavior.getInstance()
            this.menuBehavior = BaseMenuBehavior.getInstance()
        } else {
            this.gameBehavior = BaseGameBehavior.getInstance()
            this.menuBehavior = this.getInGameMenuBehavior()
        }
        this.initPopupMenu()
        this.initMenu()
        this.initSpecialPaint()
        DisplayChangeEventHandler.getInstance().addListenerInterface(this)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        try {
            val font : Font = graphics.getFont()
            this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(this.canvasStrings.FD_WIDTH).appendint(MyFontProcessor.defaultCharWidth(font)).append(this.canvasStrings.FD_HEIGHT).appendint(font.getHeight()).toString(), this, this.canvasStrings.UPDATE_MEASUREMENT)
            this.fontHeightP = font.getHeight()
            this.myFormUtil.updateMeasurement(graphics)
            val popupMenuRectangle : Rectangle = this.myFormUtil.getPopupMenuRectangle()
            val basicPopupMenuPaintable : BasicPopupMenuPaintable = (this.getOpenMenuPaintable().asInstanceOf[BasicPopupMenuPaintable])
            basicPopupMenuPaintable.init(popupMenuRectangle)
            if (this.getPopupMenuInputProcessor() ne NoMenuInputProcessor.getInstance()) {
                val popupMenuInputProcessor : PopupMenuInputProcessor = (this.getPopupMenuInputProcessor().asInstanceOf[PopupMenuInputProcessor])
                //this.logUtil.putF("PopupMenuInputProcessor init: " + popupMenuInputProcessor, this, this.commonStrings.PROCESS);
                popupMenuInputProcessor.init(popupMenuRectangle)
            }
            this.myFontProcessor = MyFontProcessor.getInstance()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT, e)
            }
        }
    }

    def getInGameMenuBehavior() : BaseMenuBehavior = {
        return InGameMenuBehavior.getInstance()
    }

    override def setCurrentThread() : Unit = {
        if (J2MEUtil.isHTML()) {
            super.setCurrentThreadFake()
        } else {
            super.setCurrentThread()
        }
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        try {
            this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(DisplayInfoSingleton.getInstance().toString()).toString(), this, this.canvasStrings.UPDATE_MEASUREMENT)
            this.myFontProcessor = this.updateMyFontProcessor
            this.menuBehavior.onDisplayChangeEvent(this, displayChangeEvent)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT, e)
            }
        }
    }

    def updateMenuFromEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        //this.logUtil.putF(new StringMaker().append(commonLabels.START_LABEL).append(displayInfoSingleton.toString()).append(MyFont.getInstance().toString()).toString(), this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT);
        val formType : FormType = FormTypeFactory.getInstance().getFormType()
        val rectangle : Rectangle = this.formUtil.createFormRectangle()
        this.menuForm.init(rectangle, formType)
        // touchButtonFactory.toggle(this.isPaused(),
        if (this.currentTouchInputFactory ne NoButtonsTouchInputFactory.getInstance()) {
            this.touchButtonFactory.toggle(this.isPaused(), this.currentTouchInputFactory.getList())
        }
        // PreLogUtil.put(TouchButtonLocationHelper.getInstance().toString(), this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT);
        this.myFontProcessor = this.updateMyFontProcessor
    }

    //private final String PROCESS_SLEEP = "processSleep";
    override def processSleep() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, PROCESS_SLEEP);
        super.processSleep()
        if (AllBinaryMediaManager.update()) {
            if (!this.primaryPlayerQueue.process()) {
                this.secondaryPlayerQueue.process()
            }
        }
        if (this.menuInputProcessor.processInputList() != -1) {
            // this.processPaintable.process();
            this.runnableCanvasRefreshHelper.process()
        }
    }

    def initPopupMenu() : Unit = {
        //this.logUtil.putF("initPopupMenu", this, this.commonStrings.PROCESS);
        if (this.popupMenuInputProcessor eq NoMenuInputProcessor.getInstance()) {
            val features : Features = Features.getInstance()
            // Popup Menu Tab Init
            val popupMenuRectangle : Rectangle = this.myFormUtil.getPopupMenuRectangle()
            if (features.isFeature(this.touchFeatureFactory.TOUCH_ENABLED)) {
                //this.logUtil.putF("initPopupMenu - touch", this, this.commonStrings.PROCESS);
                this.setOpenMenuPaintable(new BasicPopupMenuPaintable(popupMenuRectangle, this.gameLayerManager.getBackgroundBasicColor(), this.gameLayerManager.getForegroundBasicColor()))
                this.setPopupMenuInputProcessor(new PopupMenuInputProcessor(new BasicArrayListD(), -1, this, popupMenuRectangle))
            }
        } else {
        }
    }

    def initMenu() : Unit = {
        try {
            //this.logUtil.putF("initMenu", this, this.commonStrings.PROCESS);
            this.menuBehavior.initMenu(this)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "initMenu", e)
            }
        }
    }

    def initMenu2() : Unit = {
        //this.logUtil.putF("initMenu - not bot", this, this.commonStrings.PROCESS);
        this.closeMenu()
        val formType : FormType = FormTypeFactory.getInstance().getFormType()
        val gameLimitedCommandTextItemArrayFactory : GameLimitedCommandTextItemArrayFactory = GameLimitedCommandTextItemArrayFactory.getInstance()
        val commandTextItemArrayFactory : CommandTextItemArrayFactory = gameLimitedCommandTextItemArrayFactory.getCommandTextItemArrayFactory()
        val items : Array[ABCustomItem] = commandTextItemArrayFactory.getInstance(this.getCommandStack(), this.gameLayerManager.getBackgroundBasicColor(), this.gameLayerManager.getForegroundBasicColor())
        val rectangle : Rectangle = this.formUtil.createFormRectangle()
        this.setMenuForm(CommandCurrentSelectionFormFactory.getInstance(StringUtil.getInstance().EMPTY_STRING, items, rectangle, formType, 25, false, this.gameLayerManager.getBackgroundBasicColor(), this.gameLayerManager.getForegroundBasicColor()))
        //this.setMenuInputProcessor( new DemoCanvasBasicStartInputProcessor( new BasicArrayListD(), this));
        val scrollSelectionForm : ScrollSelectionForm = this.getMenuForm()
        val features : Features = Features.getInstance()
        if (features.isFeature(this.touchFeatureFactory.TOUCH_ENABLED)) {
            //this.logUtil.putF("initMenu - touch", this, this.commonStrings.PROCESS);
            this.mainMenuInputProcessor = new PopupCommandFormInputProcessor(new BasicArrayListD(), -1, this, scrollSelectionForm, this.getPopupMenuInputProcessor().asInstanceOf[PopupMenuInputProcessor])
        } else {
        }
        this.setMenuInputProcessor(this.getPopupMenuInputProcessor())
        if (scrollSelectionForm ne ScrollSelectionFormNoneFactory.getInstance()) {
            //this.logUtil.putF("initMenu - scroll", this, this.commonStrings.PROCESS);
            this.setFormPaintable(new FormPaintable(scrollSelectionForm))
        } else {
        }
        this.closeMenu()
    }

    def updateMenu() : Unit = {
        try {
            this.menuBehavior.updateMenu(this)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "initMenu", e)
            }
        }
    }

    def updateMenu2() : Unit = {
        val scrollSelectionForm : ScrollSelectionForm = this.getMenuForm()
        scrollSelectionForm.deleteAll()
        val gameLimitedCommandTextItemArrayFactory : GameLimitedCommandTextItemArrayFactory = GameLimitedCommandTextItemArrayFactory.getInstance()
        val commandTextItemArrayFactory : CommandTextItemArrayFactory = gameLimitedCommandTextItemArrayFactory.getCommandTextItemArrayFactory()
        val items : Array[ABCustomItem] = commandTextItemArrayFactory.getInstance(this.getCommandStack(), this.gameLayerManager.getBackgroundBasicColor(), this.gameLayerManager.getForegroundBasicColor())
        val size : Int = items.length

        {
            var index : Int = 0
            while (index < size) {
                scrollSelectionForm.append(items(index))
                index += 1
            }
        }
        val formType : FormType = FormTypeFactory.getInstance().getFormType()
        val rectangle : Rectangle = this.formUtil.createFormRectangle()
        scrollSelectionForm.init(rectangle, formType)
    }

    override def pause() : Unit = this.synchronized {
        // PreLogUtil.put(commonStrings.START, this, METHOD_NAME);
        this.gameBehavior.pause(this)
        this.closeMenu()
        super.pause()
        this.touchButtonFactory.toggle(this.isPaused(), BasicArrayListUtil.getInstance().getImmutableInstance())
        this.tsUtil.gc()
    }

    override def unPause() : Unit = this.synchronized {
        this.logUtil.putF(this.commonStrings.START, this, this.gameStrings.UNPAUSE)
        // PreLogUtil.put(commonStrings.START, this, gameStrings.UNPAUSE);
        this.closeMenu()
        this.tsUtil.gc()
        super.unPause()
        this.touchButtonFactory.toggle(this.isPaused(), BasicArrayListUtil.getInstance().getImmutableInstance())
        this.gameBehavior.unPause(this)
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

    override def popupMenu() : Unit = {
        this.menuBehavior.popupMenu(this)
    }

    def popupMenu2() : Unit = {
        //this.logUtil.putF(this.commonStrings.START + this.mainMenuInputProcessor, this, "popupMenu2");
        this.primaryPlayerQueue.add(SelectSound.getInstance())
        this.setMenuPaintable(this.getFormPaintable())
        this.setMenuInputProcessor(this.mainMenuInputProcessor)
        this.basicMotionGesturesHandler.addListenerInterface(this.mainMenuInputProcessor)
        this.gameKeyEventHandler.addListener(this.mainMenuInputProcessor)
    }

    override def toggleMenu() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.gameStrings.TOGGLE_MENU)
        if (this.getMenuPaintable() eq this.getOpenMenuPaintable()) {
            this.pause()
            this.updateMenu()
            this.popupMenu()
        } else if (this.getMenuPaintable() eq this.getFormPaintable()) {
            this.primaryPlayerQueue.add(SelectSound.getInstance())
            this.unPause()
        }
    }

    override def closeMenu() : Unit = {
        this.menuBehavior.closeMenu(this)
    }

    def closeMenu2() : Unit = {
        //this.logUtil.putF(this.commonStrings.START + this.mainMenuInputProcessor, this, "closeMenu");
        this.setMenuPaintable(this.getOpenMenuPaintable())
        this.basicMotionGesturesHandler.removeListener(this.mainMenuInputProcessor)
        this.gameKeyEventHandler.removeListener(this.mainMenuInputProcessor)
        this.setMenuInputProcessor(this.getPopupMenuInputProcessor())
    }

    override def open() : Unit = {
        //this.logUtil.putF(this.commonStrings.START + this.mainMenuInputProcessor, this, "openMenu");
        this.basicMotionGesturesHandler.addListenerInterface(this.menuInputProcessor)
        this.gameKeyEventHandler.addListener(this.menuInputProcessor)
    }

    override def close() : Unit = {
        //this.logUtil.putF(this.commonStrings.START + this.mainMenuInputProcessor, this, "close");
        this.basicMotionGesturesHandler.removeListener(this.menuInputProcessor)
        this.gameKeyEventHandler.removeListener(this.menuInputProcessor)
        this.primaryPlayerQueue.clear()
        this.secondaryPlayerQueue.clear()
    }

    def processorInit() : Unit = {
        this.setMainStateProcessor(Processor.getInstance())
        this.setProcessGameProcessorInit()
    }

    def setProcessGameProcessorInit() : Unit = {
        this.setProcessGameProcessor(new GameProcessor(this))
    }

    def initSpecialPaint() : Unit = {
        this.menuBehavior.initSpecialPaint(this)
    }

    private def init(gameLayerManager : AllBinaryGameLayerManager, buffered : Boolean) : Unit = {
        this.gameStateTimeHelper.setStartTimeTNT()
        this.setHighScoreSubmitted(false)
        this.setLayerManager(gameLayerManager)
        // TWB - Custom image release was here
        if (!buffered) {
            val BUFF_MESSAGE : String = "XXX Not Buffering Causes Concurrency Issues XXX"
            this.logUtil.putF(BUFF_MESSAGE, this, this.commonStrings.CONSTRUCTOR)
        } else {
            // this.processPaintable = new BufferedGameCanvasPaintHelper(this);
            throw new Exception("Buffering is disabled")
        }
        //"isDoubleBuffered: ").append(this.isBuffered()).append("isDoubleBuffered: ").append(this.isDoubleBuffered(), //this, this.commonStrings.CONSTRUCTOR);
        this.setGameInputProcessor(Processor.getInstance())
        val features : Features = Features.getInstance()
        if (features.isFeature(GameFeatureFactory.getInstance().CHEATING)) {
            this.isCheating = true
            this.cheatProcessor = new CheatGameInputProcessor(this)
            this.gameKeyEventHandler.addListener(this.cheatProcessor)
        } else {
            this.isCheating = false
            this.cheatProcessor = NoPlayerGameInput.getInstance()
        }
        this.realEndGameProcessor = new EndGameProcessor(this)
        this.setEndGameProcessor(Processor.getInstance())
        this.realStartIntermissionProcessor = new StartIntermissionProcessor(this)
        this.startIntermissionProcessor = Processor.getInstance()
        this.setEndGameStatePaintable(new EndGamePaintable(this))
        this.setEndGamePaintable(NullPaintable.getInstance())
        this.setIntermissionPaintable(NullPaintable.getInstance())
        this.getStartIntermissionInterface().setListener(this)
    }

    override def notifyIntermission(enable : Boolean) : Unit = {
        if (enable) {
            this.startIntermissionProcessor = this.realStartIntermissionProcessor
        } else {
            this.startIntermissionProcessor = Processor.getInstance()
        }
        if (enable) {
            this.setIntermissionPaintable(this.getStartIntermissionPaintable())
        } else {
            this.setIntermissionPaintable(NullPaintable.getInstance())
        }
    }

    def mediaInit() : Unit = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
    }

    def initConfigurable(abeClientInformation : AbeClientInformationInterface) : Unit = this.synchronized {
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.addNormalPortion(50, "Setting Configurables")
        GameInitializationUtil.getInstance().initGame(abeClientInformation, this, this.gameInitializationInterfaceFactoryInterface)
        val gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()
        val changedGameFeatureListener : ChangedGameFeatureListener = ChangedGameFeatureListener.getInstance()
        if (changedGameFeatureListener.isChangedFeature(gameFeatureFactory.SOUND)) {
            val features : Features = Features.getInstance()
            this.logUtil.putF(new StringMaker().append("Sound Changing To: ").appendboolean(features.isFeature(gameFeatureFactory.SOUND)).toString(), this, "initConfigurable")
            this.mediaInit()
            changedGameFeatureListener.remove(gameFeatureFactory.SOUND)
        }
        val sensorFeatureFactory : SensorFeatureFactory = SensorFeatureFactory.getInstance()
        if ((changedGameFeatureListener.isChangedFeature(sensorFeatureFactory.ORIENTATION_SENSORS) || changedGameFeatureListener.isChangedFeature(sensorFeatureFactory.NO_ORIENTATION)) || changedGameFeatureListener.isChangedFeature(sensorFeatureFactory.SIMULATED_ORIENTATION_SENSORS)) {
            // AllBinarySensor[1];
            changedGameFeatureListener.remove(sensorFeatureFactory.NO_ORIENTATION)
            changedGameFeatureListener.remove(sensorFeatureFactory.ORIENTATION_SENSORS)
            changedGameFeatureListener.remove(sensorFeatureFactory.SIMULATED_ORIENTATION_SENSORS)
        }
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        this.loadResourceLoadingLevel(resourceLoadingLevelFactory.LOAD_GAME)
    }

    def initApp(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.initConfigurable(abeClientInformation)
        this.processorInit()
        // Since touch button selection is based on sensors this must come first
        this.sensorGameUpdateProcessor.process(this.gameLayerManager)
        this.sensorGameUpdateProcessor.sendNotifications(this.gameLayerManager)
        this.initTouch()
    }

    def initTouch() : Unit = {
        val gameInitializedEvent : GameInitializedEvent = GameInitializationUtil.getInstance().EVENT
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        gameInitializedEvent.setResourceLoadingLevel(resourceLoadingLevelFactory.LOAD_TOUCH)
        GameInitializedEventHandler.getInstance().fireEvent(gameInitializedEvent)
        this.touchButtonFactory.defaultList()
        this.updateTouch()
        this.postInitTouch()
    }

    def updateCurrentTouchInputFactory(nextTouchInput : BaseTouchInput) : Unit = {
        if (nextTouchInput ne this.currentTouchInputFactory) {
            this.currentTouchInputFactory = nextTouchInput
            // this.logUtil.putF(this.currentTouchInputFactory, this, this.gameInputStrings.UDPATE_CURRENT_TOUCH_INPUT_FACTORY);
            PreLogUtil.put(this.currentTouchInputFactory.toString(), this, this.gameInputStrings.UDPATE_CURRENT_TOUCH_INPUT_FACTORY)
            this.touchButtonFactory.toggle(this.isPaused(), this.currentTouchInputFactory.getList())
        }
    }

    def updateTouch() : Unit = {
        this.gameBehavior.updateTouch(this)
    }

    def updateTouch2() : Unit = {
        val features : Features = Features.getInstance()
        if (features.isFeature(this.touchFeatureFactory.AUTO_HIDE_SHOW_SCREEN_BUTTONS)) {
            if ((this.gameLayerManager.getGameInfo().getCurrentLevel() - this.getStartLevel()) == 1) {
                this.setTouchPaintableP(NullPaintable.getInstance())
            }
        }
    }

    def postInitTouch() : Unit = {
        this.setTouchButtonsPaintable(TouchButtonsPaintableFactory.getInstance(this.gameLayerManager.getForegroundBasicColor()))
        this.updateScreenButtonPaintable()
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommands()
        this.setCommandListener(cmdListener)
    }

    def addCommands() : Unit = {
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        val myCommandsFactory : MyCommandsFactory = MyCommandsFactory.getInstance()
        if (DebugFactory.getInstance() ne NoDebug.getInstance()) {
            this.addCommand(gameCommandsFactory.START_TRACE)
        }
        this.addCommand(gameCommandsFactory.RESTART_COMMAND)
        this.addCommand(myCommandsFactory.PAUSE_COMMAND)
        this.addCommand(gameCommandsFactory.QUIT_COMMAND)
        val isOverScan : Boolean = OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan()
        if (J2MEUtil.isHTML()) {
        } else if (SWTUtil.isSWT) {
        } else if (!isOverScan) {
            if (TouchScreenFactory.getInstance().isTouch() && new InGameFeatures().isAny()) {
                // System.out.println("InGameOptions");
                this.addCommand(InGameOptionsForm.DISPLAY)
            }
            // this.addCommand(GameCommands.DISPLAY_SAVE_FORM);
            this.addCommand(gameCommandsFactory.SAVE)
            this.addCommand(gameCommandsFactory.DISPLAY_LOAD_FORM)
        }
    }

    override def itemStateChanged(item : Item) : Unit = {
        try {
            val itemLabel : String = item.getLabel()
            this.logUtil.putF(new StringMaker().append(this.commonLabels.ITEM_LABEL).append(itemLabel).toString(), this, "itemStateChanged")
            if (item.isInstanceOf[ChoiceGroup]) {
                val gameFeatureUtil : GameFeatureUtil = GameFeatureUtil.getInstance()
                if (gameFeatureUtil.isExclusive(itemLabel)) {
                    gameFeatureUtil.updateExclusiveForChoiceGroup(item.asInstanceOf[ChoiceGroup])
                } else {
                    gameFeatureUtil.updateMultiple(item.asInstanceOf[ChoiceGroup])
                }
            }
            // first
            this.sensorGameUpdateProcessor.process(this.gameLayerManager)
            // Swap between different touch button setups
            this.updateTouch()
            // Update whether they should be displayed or not
            this.updateScreenButtonPaintable()
            this.sensorGameUpdateProcessor.sendNotifications(this.gameLayerManager)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "itemStateChanged", e)
            }
        }
    }

    def updateScreenButtonPaintable() : Unit = {
        this.gameBehavior.updateScreenButtonPaintable(this)
    }

    def updateScreenButtonPaintable2() : Unit = {
        val features : Features = Features.getInstance()
        if (features.isFeature(this.touchFeatureFactory.AUTO_HIDE_SHOW_SCREEN_BUTTONS)) {
            // If touch buttons are visible
            this.setTouchPaintableP(this.getTouchButtonsPaintable())
            this.setStartLevel(this.gameLayerManager.getGameInfo().getCurrentLevel())
        } else if (features.isFeature(this.touchFeatureFactory.SHOW_SCREEN_BUTTONS)) {
            // If touch buttons are visible
            this.setTouchPaintableP(this.getTouchButtonsPaintable())
        } else if (features.isFeature(this.touchFeatureFactory.HIDE_SCREEN_BUTTONS)) {
            this.setTouchPaintableP(NullPaintable.getInstance())
        } else {
            this.setTouchPaintableP(NullPaintable.getInstance())
        }
    }

    override def getLayerManager() : AllBinaryGameLayerManager = {
        return this.gameLayerManager
    }

    def setLayerManager(layerManager : AllBinaryGameLayerManager) : Unit = {
        this.gameLayerManager = layerManager
    }

    override def isGameOver() : Boolean = this.synchronized {
        return this.gameOver
    }

    def setGameOver(gameOver : Boolean) : Unit = this.synchronized {
        this.gameOver = gameOver
    }

    override def processGameOver() : Unit = {
        PreLogUtil.put(this.commonStrings.START, this, this.gameStrings.SET_GAME_OVER)
        // this.logUtil.putF(this.commonStrings.START, this, this.gameStrings.SET_GAME_OVER);
        this.setGameOver(true)
        this.removePauseCommand()
        this.setGameState(this.gameStateFactory.SHOW_END_RESULT_GAME_STATE)
        this.setEndGamePaintable(this.getEndGameStatePaintable())
    }

    /*      * protected boolean isRepeated() { return repeated; } protected void      * setRepeated(boolean repeated) { this.repeated = repeated; }      */
    override def isHighScoreSubmitted() : Boolean = {
        return this.highScoreSubmitted
    }

    override def setHighScoreSubmitted(highScoreSubmitted : Boolean) : Unit = {
        this.highScoreSubmitted = highScoreSubmitted
        if (highScoreSubmitted) {
            this.highScoresHelper.setSelectedHighScores(NullHighScoresSingletonFactory.getInstance())
        }
        this.logUtil.putF(new StringMaker().append("isHighScoreSubmitted: ").appendboolean(highScoreSubmitted).toString(), this, "setHighScoreSubmitted")
    }

    override def getGameState() : GameState = {
        return this.gameState
    }

    override def setGameState(gameState : GameState) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.gameStrings.GAME_STATE).append(this.stringUtil.toString(gameState)).toString(), this, this.gameStrings.SET_GAME_STATE)
        // PreLogUtil.put("Game State: ").append(gameState, this, this.gameStrings.SET_GAME_STATE);
        this.gameState = gameState
        this.gameStateTimeHelper.setStartTimeTNT()
        this.updateEndGameProcessor()
        this.updateGameKeyEventProcessor()
        this.gameBehavior.setGameState(this)
    }

    def updateGameState() : Unit = {
        val gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
        gameAdState.processAdState(this.gameState, this.gameLayerManager.getGameInfo().getGameType())
        if (this.gameState ne this.gameStateFactory.PLAYING_GAME_STATE) {
            gameAdState.processPageAdState()
        }
    }

    private def updateGameKeyEventProcessor() : Unit = {
        if ((this.getGameState() ne this.gameStateFactory.PLAYING_GAME_STATE) || this.isCheating) {
        } else {
        }
    }

    def removeAllGameKeyInputListenersOnBuild() : Unit = {
        this.removeAllGameKeyInputListeners()
    }

    def removeAllGameKeyInputListeners() : Unit = {
        this.gameBehavior.removeAllGameKeyInputListeners(this)
    }

    def removeAllGameKeyInputListeners2() : Unit = {
        // System.out.println("Clearing Keys From Last Level");
        this.logUtil.putF("Remove PlayerInput Listeners", this, "removeAllGameKeyInputListeners")

        {
            var index : Int = this.localPlayerGameInputList.size() - 1
            while (index >= 0) {
                var playerGameInput : PlayerGameInput = this.localPlayerGameInputList.get(index).asInstanceOf[PlayerGameInput]
                this.removeKeyInputListener(playerGameInput)
                playerGameInput.removeNonAIInputGameKeyEvents()
                index -= 1
            }
        }
    }

    def removeKeyInputListener(playerGameInput : PlayerGameInput) : Unit = {
        this.gameKeyEventHandler.removeListener(playerGameInput)
    }

    /*      * private void removeGameKeyInputListeners() { //for cheating      * UpGameKeyEventHandler.getInstance().removeListener(this);      * DownGameKeyEventHandler.getInstance().removeListener(this); }      */
    def updateEndGameProcessor() : Unit = {
        this.gameBehavior.updateEndGameProcessor(this)
    }

    def updateEndGameProcessor2() : Unit = {
        if ((this.getGameState() eq this.gameStateFactory.SHOW_END_RESULT_GAME_STATE) || (this.getGameState() eq this.gameStateFactory.SHOW_HIGH_SCORE_GAME_STATE)) {
            this.setEndGameProcessor(this.realEndGameProcessor)
        } else {
            this.setEndGameProcessor(Processor.getInstance())
        }
    }

    def buildGameInit(isPortion : Boolean) : Unit = {
    }

    def cleanupGame() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CLEANUP)
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.addNormalPortion(10, "Cleaning Up")
        this.primaryPlayerQueue.clear()
        this.secondaryPlayerQueue.clear()
        GameLevelDisplayChangeEventListenersFactory.getInstance().clear()
    }

    def loadResourceLoadingLevel(resourceLoadingLevel : ResourceLoadingLevel) : Unit = {
        val gameInitializedEvent : GameInitializedEvent = GameInitializationUtil.getInstance().EVENT
        gameInitializedEvent.setResourceLoadingLevel(resourceLoadingLevel)
        GameInitializedEventHandler.getInstance().fireEvent(gameInitializedEvent)
    }

    def loadResources(level : Int) : Unit = {
        val gameInitializedEvent : GameInitializedEvent = GameInitializationUtil.getInstance().EVENT
        gameInitializedEvent.setLevel(level)
        GameInitializedEventHandler.getInstance().fireEvent(gameInitializedEvent)
    }

    def updateColor() : Unit = {
    }

    def buildGame(portion : Int) : Unit = {
        this.screenCapture.endRecording()
        this.screenCapture.startRecording()
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        val features : Features = Features.getInstance()
        progressCanvas.addNormalPortion(portion, "Generic Build")
        this.removeAllGameKeyInputListenersOnBuild()
        this.updateTouch()
        progressCanvas.addNormalPortion(portion, "High Scores")
        this.highScoresFactoryInterface.fetchHighScores(this.gameLayerManager.getGameInfo(), this.highScoresHelper)
        this.setHighScoresPaintable(NullPaintable.getInstance())
        progressCanvas.addNormalPortion(portion, "Finishing.")
        this.getEndGameInfoP().update(this.getLayerManager().getGameInfo(), this)
        this.isSingleKeyRepeatableProcessing = features.isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_REPEAT_PRESS)
        this.setGameOver(false)
        progressCanvas.addNormalPortion(portion, "Finishing..")
        // this.logUtil.putF("Game Color Change", this, BUILD_GAME);
        this.updateColor()
        this.getStartIntermissionPaintable().update()
        if (!this.isRunningInAnotherThread()) {
            return
        }
        progressCanvas.addNormalPortion(portion, "Finishing...")
        if (this.isMainCanvas() || !this.isInitialized()) {
            // debugging mode
            if (features.isFeature(MainFeatureFactory.getInstance().LOAD_ONDEMAND)) {
                if (this.getCustomCommandListener() != null) {
                    progressCanvas.end()
                }
            } else {
                progressCanvas.end()
            }
            this.setInitialized(true)
        }
        //if (this.gameCanvasStartListener != null)
        if (this.getCustomCommandListener() eq NullCommandListener.NULL_COMMAND_LISTENER) {
            this.logUtil.putF("Show Game Paintable in DemoCanvas Thread", this, this.BUILD_GAME)
            this.gameCanvasStartListener.showGamePaintable()
        } else {
            this.logUtil.putF("No GameCanvasStartListener", this, this.BUILD_GAME)
        }
        this.colorFillPaintable.setBasicColorP(this.gameLayerManager.getBackgroundBasicColor())
        this.gameBehavior.buildGame(this)
    }

    def buildGame2() : Unit = {
        //this.logUtil.putF("Clearing Keys From Last Level", this, BUILD_GAME);
        PreLogUtil.put(new StringMaker().append(this.gameInputStrings.ENABLE_PLAYER_GAME_INPUTS).appendint(this.localPlayerGameInputList.size()).toString(), this, this.BUILD_GAME)
        var playerGameInput : PlayerGameInput = null

        {
            var index : Int = this.localPlayerGameInputList.size() - 1
            while (index >= 0) {
                playerGameInput = this.localPlayerGameInputList.get(index).asInstanceOf[PlayerGameInput]
                PreLogUtil.put(new StringMaker().append(this.gameInputStrings.ENABLE_PLAYER_GAME_INPUT).append(playerGameInput.toString()).toString(), this, this.BUILD_GAME)
                playerGameInput.removeNonAIInputGameKeyEvents()
                this.addKeyInputListener(playerGameInput)
                index -= 1
            }
        }
    }

    def addKeyInputListener(playerGameInput : PlayerGameInput) : Unit = {
        GameKeyEventHandler.getInstance().addListenerForPlayer(playerGameInput, playerGameInput.getPlayerInputId())
    }

    def setGameCanvasStartListener(gameCanvasStartListener : DemoPaintableInterface) : Unit = {
        this.gameCanvasStartListener = gameCanvasStartListener
    }

    def loadState() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.LOAD)
        var hashtable : ABHashtable[Object, Object] = this.getLoadStateHashtable()
        if ((hashtable != null) && (hashtable.size() > 0)) {
            val levelAsString : String = hashtable.get(GameInfo.LEVEL_NAME.asInstanceOf[Object]).asInstanceOf[String]
            val level : Int = Integer.valueOf(levelAsString).intValue()
            val gameInfo : GameInfo = this.gameLayerManager.getGameInfo()
            gameInfo.setCurrentLevel(level)
        }
    }

    override def getLoadStateHashtable() : ABHashtable[Object, Object] = {
        this.logUtil.putF(new StringMaker().append(this.commonLabels.START_LABEL).append(this.stringUtil.toString(this.hashtable)).toString(), this, "getLoadStateHashtable")
        return this.hashtable
    }

    override def setLoadStateHashtable(hashtable : ABHashtable[Object, Object]) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.commonLabels.START_LABEL).append(this.stringUtil.toString(hashtable)).toString(), this, "setLoadStateHashtable")
        this.hashtable = hashtable
    }

    override def getCurrentStateHashtable() : ABHashtable[Object, Object] = {
        val hashtable : ABHashtable[Object, Object] = this.stdUtil.createHashtable()
        val level : Int = this.gameLayerManager.getGameInfo().getCurrentLevel()
        hashtable.put(GameInfo.LEVEL_NAME.toString(), Integer.toString(level))
        this.logUtil.putF(new StringMaker().append("End: ").append(this.stringUtil.toString(hashtable)).toString(), this, "getCurrentStateHashtable")
        return hashtable
    }

    def paintGameOver(graphics : Graphics) : Unit = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
    }

    override def draw(graphics : Graphics) : Unit = {
        this.colorFillPaintable.paint(graphics)
        this.basicSetColorUtil.setBasicColorP(graphics, this.gameLayerManager.getForegroundBasicColor())
        this.gameSpecificPaintable.paint(graphics)
    }

    def clear(graphics : Graphics) : Unit = {
        this.colorFillPaintable.paint(graphics)
    }

    override def paint(graphics : Graphics) : Unit = {
        //PreLogUtil.put("AllBinaryGameCanvas", this, canvasStrings.PAINT);
        this.myFontProcessor.process(graphics)
        //TWB - was in MyCanvas paint -- super.paint(graphics);
        this.baseGameStatistics.nextRefresh()
        //// This is what is called without buffering
        this.draw(graphics)
        //// End - This is what is called without buffering
        this.menuPaintable.paint(graphics)
        this.progressPaintable.paint(graphics)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    // be removed
    def processEndLevelIntermissionGameState() : Unit = {
    }

    def nonBotPaint(graphics : Graphics) : Unit = {
        this.endGamePaintable.paint(graphics)
        this.intermissionPaintable.paint(graphics)
        this.paintIntermission(graphics)
        this.touchPaintable.paint(graphics)
    }

    // be removed
    def paintIntermission(graphics : Graphics) : Unit = {
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
        // this.addGameKeyEvent(keyCode, false);
        this.inputProcessor.keyPressedByDevice(keyCode, deviceId)
    }

    override def keyRepeatedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        // Integer.toHexString(keyCode), // this, gameInputStrings.KEY_REPEATED);
        if (this.isSingleKeyRepeatableProcessing) {
            // this.addGameKeyEvent(keyCode, true);
            this.inputProcessor.keyPressedByDevice(keyCode, deviceId)
        }
    }

    override def keyReleasedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        //this.logUtil.putF(new StringMaker().append(this.commonLabels.START_LABEL).append(this.inputProcessor.toString()).append(CommonSeps.getInstance().SPACE).append(keyCode).toString(), this, gameInputStrings.KEY_RELEASED);
        this.inputProcessor.keyReleasedByDevice(this, keyCode, deviceId)
    }

    // }
    def handleRawKey(keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
    }

    def endProgress(isProgress : Boolean) : Int = {
        var portion : Int = 30
        if (isProgress && this.isMainCanvas()) {
            val myCommandsFactory : MyCommandsFactory = MyCommandsFactory.getInstance()
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            progressCanvas.start()
            this.getCustomCommandListener().commandAction(myCommandsFactory.SET_DISPLAYABLE, progressCanvas)
            // progressCanvas.waitUntilDisplayed();
            portion = 4
        }
        return portion
    }

    def processPlayingGame() : Unit = {
        /*          * if(this.hasRepeatEvents()) { this.setRepeated(true); }          */
        this.cheatProcessor.update()
        this.sensorGameUpdateProcessor.getInputSensor().update()
        this.gameInputProcessor.process()
        // layerProcessor.track(layer);
        this.gameLayerManager.process()
        this.startIntermissionProcessor.process()
    }

    def threadInit() : Unit = {
    }

    def processGame() : Unit = {
        super.process()
        if (AllBinaryMediaManager.update()) {
            if (!this.primaryPlayerQueue.process()) {
                this.secondaryPlayerQueue.process()
            }
        }
        this.mainStateProcessor.process()
        this.menuInputProcessor.processInputList()
        this.endGameProcessor.process()
        this.baseGameStatistics.nextFrame()
    }

    def notifyDonePainting() : Unit = {
        this.synchronized {
            //TWB - Playn Testing - was remarked for GameFrameRunnable but I guess I don't need that runnable?
            this.threadObjectUtil.notifyObject(this)
        }
    }

    def shouldWait() : Unit = {
        val features : Features = Features.getInstance()
        if (AndroidUtil.isAndroid()) {
        } else if (features.isFeature(this.openGLFeatureFactory.OPENGL_2D)) {
        } else {
            if (features.isDefault(this.openGLFeatureFactory.OPENGL)) {
                val openGLImageSpecificFactory : OpenGLImageSpecificFactory = OpenGLImageSpecificFactory.getInstance()
                //this.logUtil.putF("waiting for OpenGL to update:" + openGLImageSpecificFactory.updating, this, this.commonStrings.RUN);

                {
                    while (openGLImageSpecificFactory.updating) {
                        Thread.sleep(this.YIELD_SLEEP)
                    }
                }
            }
        }
    }

    override def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START_RUNNABLE, this, this.commonStrings.RUN)
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            progressCanvas.addNormalPortion(50, "Game Thread")
            this.setCurrentThread()
            this.setRunning(true)
            if (this.getCustomCommandListener() eq NullCommandListener.NULL_COMMAND_LISTENER) {
                Thread.sleep(this.YIELD_SLEEP)
            }
            this.shouldWait()
            this.threadInit()
            if (this.getCustomCommandListener() eq NullCommandListener.NULL_COMMAND_LISTENER) {
                Thread.sleep(this.YIELD_SLEEP)
            }
            this.open()
            val gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
            gameAdState.init()
            gameAdState.setGameIsReady(true)
            this.gameBehavior.run(this)
            this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

    def run2() : Unit = {
        val features : Features = Features.getInstance()
        //        } else 
        if (features.isDefault(this.openGLFeatureFactory.OPENGL_AS_GAME_THREAD) || J2MEUtil.isHTML()) {
            if (features.isDefault(this.openGLFeatureFactory.OPENGL_AS_GAME_THREAD)) {
                this.logUtil.putF(this.openGLFeatureFactory.OPENGL_AS_GAME_THREAD.getName(), this, this.commonStrings.RUN)
            }
            if (J2MEUtil.isHTML()) {
                this.logUtil.putF(GraphicsStrings.getInstance().HTML, this, this.commonStrings.RUN)
            }
            val currentDisplayableFactory : CurrentDisplayableFactory = CurrentDisplayableFactory.getInstance()
            currentDisplayableFactory.setRunnable(this.gameRunnable)
            currentDisplayableFactory.setDisplayable(this)
            OpenGLThreadUtil.getInstance().onResume()
        } else if (features.isDefault(this.openGLFeatureFactory.OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS)) {
            this.logUtil.putF(this.openGLFeatureFactory.OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS.getName(), this, this.commonStrings.RUN)
            OpenGLThreadUtil.getInstance().onResume()

            {
                while (this.isRunning()) {
                    this.run3()
                }
            }
            this.end()
        } else {
            this.logUtil.putF("this thread", this, this.commonStrings.RUN)

            {
                while (this.isRunning()) {
                    this.run3()
                }
            }
            this.end()
        }
    }

    def run3() : Unit = {
        this.loopTimeHelper.setStartTime(this.gameTickTimeDelayHelper.setStartTime())
        this.gameTickDisplayInfoSingleton.update()
        this.processGame()
        this.processLoopSleep()
    }

    override def setRunning(running : Boolean) : Unit = {
        super.setRunning(running)
        try {
            val features : Features = Features.getInstance()
            if (running) {
            } else {
                //If game thread is not actually running                
                if (features.isDefault(this.openGLFeatureFactory.OPENGL) || SWTUtil.isSWT) {
                    if (this.gameLayerManager.getGameInfo().getGameType() ne this.gameTypeFactory.BOT) {
                        //                        }
                        val currentDisplayableFactory : CurrentDisplayableFactory = CurrentDisplayableFactory.getInstance()
                        currentDisplayableFactory.clearRunnable()
                    }
                    this.end()
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.SET_RUNNING, e)
            }
        }
    }

    def end() : Unit = {
        this.screenCapture.endRecording()
        this.baseGameStatistics.add(new StringMaker().append(this.baseGameStatistics.toString()).append(CommonSeps.getInstance().NEW_LINE).toString())
        this.baseGameStatistics.init()
        this.gameKeyEventHandler.removeListener(this.cheatProcessor)
        this.close()
        this.removeAllGameKeyInputListeners()
        this.endGameThread()
    }

    def endGameThread() : Unit = {
        DisplayChangeEventHandler.getInstance().removeListener(this)
        GameLevelDisplayChangeEventListenersFactory.getInstance().clear()
        var gameAdState : GameAdState = this.gameAdStateFactory.getCurrentInstance()
        gameAdState.notPlayingAdState()
    }

    // specify level info
    def createHighScore(score : Long) : HighScore = {
        val gameInfo : GameInfo = this.gameLayerManager.getGameInfo()
        return new HighScore(0, "NONE", new GameInfo(gameInfo.getGameType(), gameInfo.getGameMode(), PlayerTypesFactory.getInstance().PLAYER_TYPE_ONE, 0, 0), score)
    }

    /*      * public boolean isLevelComplete() { return this.isLevelComplete; } public      * void levelComplete() { this.isLevelComplete = true; }      */
    def setHighScore(abeClientInformation : AbeClientInformationInterface, name : String, score : Long, autoSubmit : Boolean, isLast : Boolean) : Unit = {
        this.gameBehavior.setHighScore(abeClientInformation, this, name, score, autoSubmit, isLast)
    }

    def setHighScore2(abeClientInformation : AbeClientInformationInterface, name : String, score : Long, autoSubmit : Boolean, isLast : Boolean) : Unit = {
        val highScore : HighScore = this.createHighScore(score)
        //{
        val textBox : HighScoreTextBox = new HighScoreTextBox(this.highScoresFactoryInterface, this.highScoresHelper, abeClientInformation, this.gameLayerManager.getGameInfo(), this.getCustomCommandListener(), name, highScore, this.gameLayerManager.getBackgroundBasicColor(), this.gameLayerManager.getForegroundBasicColor())
        if (isLast) {
            this.getCustomCommandListener().commandAction(GameCommandsFactory.getInstance().SET_MENU_DISPLAYABLE, textBox)
        }
        if (autoSubmit) {
            SecondaryThreadPool.getInstance().runTask(new SaveHighScoreRunnable(isLast, textBox))
        }
    }

    def getGameStateTimeHelper() : TimeDelayHelper = {
        return this.gameStateTimeHelper
    }

    def setInitialized(initialized : Boolean) : Unit = {
        this.initialized = initialized
    }

    override def isInitialized() : Boolean = {
        return this.initialized
    }

    override def getSourceId() : Int = {
        return AllBinaryGameCanvas.id
    }

    def setProgressPaintable(paintable : PaintableInterface) : Unit = {
        this.progressPaintable = paintable
    }

    override def getStartIntermissionInterface() : IntermissionInterface = {
        return this.startIntermissionInterface
    }

    override def getEndLevelIntermissionInterface() : IntermissionInterface = {
        return this.endLevelIntermissionInterface
    }

    def setTouchPaintableP(paintable : Paintable) : Unit = {
        //ForcedLogUtil.log("Touch Paintable: ").append(paintable, this);
        this.touchPaintable = paintable
    }

    def getTouchPaintableP() : Paintable = {
        return this.touchPaintable
    }

    def setEndGamePaintable(endGamePaintable : Paintable) : Unit = {
        this.endGamePaintable = endGamePaintable
    }

    def getEndGamePaintable() : Paintable = {
        return this.endGamePaintable
    }

    def setIntermissionPaintable(intermissionPaintable : Paintable) : Unit = {
        this.intermissionPaintable = intermissionPaintable
    }

    def getIntermissionPaintable() : Paintable = {
        return this.intermissionPaintable
    }

    /**      * @return the endGameInfo      */
    def getEndGameInfoP() : EndGameInfo = {
        return this.endGameInfo
    }

    def setHighScoresPaintable(highScoresPaintable : Paintable) : Unit = {
        this.highScoresPaintable = highScoresPaintable
    }

    def getHighScoresPaintable() : Paintable = {
        return this.highScoresPaintable
    }

    def getRealHighScoresPaintable() : HighScoresPaintable = {
        return this.realHighScoresPaintable
    }

    def clearPlayerGameInputList() : Unit = {
        var playerGameInput : PlayerGameInput = null

        {
            var index : Int = this.localPlayerGameInputList.size() - 1
            while (index >= 0) {
                playerGameInput = this.localPlayerGameInputList.get(index).asInstanceOf[PlayerGameInput]
                this.gameKeyEventHandler.removeListener(playerGameInput)
                index -= 1
            }
        }
        this.localPlayerGameInputList.clear()
    }

    def addPlayerGameInput(playerGameInput : PlayerGameInput) : Unit = {
        //PreLogUtil.put("Setting Player Input: ").append(playerGameInput, this, "setPlayerGameInput");
        this.localPlayerGameInputList.add(playerGameInput)
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

    /**      * @param menuForm      *            the menuForm to set      */
    def setMenuForm(menuForm : ScrollSelectionForm) : Unit = {
        this.menuForm = menuForm
    }

    /**      * @return the startLevel      */
    def getStartLevel() : Int = {
        return this.startLevel
    }

    /**      * @param startLevel      *            the startLevel to set      */
    def setStartLevel(startLevel : Int) : Unit = {
        this.startLevel = startLevel
    }

    def setTouchButtonsPaintable(touchButtonsPaintable : Paintable) : Unit = {
        this.touchButtonsPaintable = touchButtonsPaintable
    }

    def getTouchButtonsPaintable() : Paintable = {
        return this.touchButtonsPaintable
    }

    //TWB - multiplayer needed it to be public
    def setGameInputProcessor(gameInputProcessor : Processor) : Unit = {
        this.gameInputProcessor = gameInputProcessor
    }

    def getGameInputProcessor() : Processor = {
        return this.gameInputProcessor
    }

    def setEndGameProcessor(endGameProcessor : Processor) : Unit = {
        this.endGameProcessor = endGameProcessor
    }

    def getEndGameProcessor() : Processor = {
        return this.endGameProcessor
    }

    def setEndGameStatePaintable(endGameStatePaintable : Paintable) : Unit = {
        this.endGameStatePaintable = endGameStatePaintable
    }

    def getEndGameStatePaintable() : Paintable = {
        return this.endGameStatePaintable
    }

    def setNonBotPaintableP(nonBotPaintable : Paintable) : Unit = {
        this.nonBotPaintable = nonBotPaintable
    }

    def getNonBotPaintableP() : Paintable = {
        return this.nonBotPaintable
    }

    def setStartIntermissionPaintable(startIntermissionPaintable : InitUpdatePaintable) : Unit = {
        this.startIntermissionPaintable = startIntermissionPaintable
    }

    def getStartIntermissionPaintable() : InitUpdatePaintable = {
        return this.startIntermissionPaintable
    }

    //TWB - multiplayer needed it to be public
    def setMainStateProcessor(mainStateProcessor : Processor) : Unit = {
        this.mainStateProcessor = mainStateProcessor
    }

    def getMainStateProcessor() : Processor = {
        return this.mainStateProcessor
    }

    def setProcessGameProcessor(processGameProcessor : Processor) : Unit = {
        this.processGameProcessor = processGameProcessor
    }

    //TWB - multiplayer needed it to be public
    def getProcessGameProcessor() : Processor = {
        return this.processGameProcessor
    }

    def setOpenMenuPaintable(openMenuPaintable : Paintable) : Unit = {
        this.openMenuPaintable = openMenuPaintable
    }

    def getOpenMenuPaintable() : Paintable = {
        return this.openMenuPaintable
    }

    def setPopupMenuInputProcessor(popupMenuInputProcessor : BasicMenuInputProcessor) : Unit = {
        //this.logUtil.putF("setPopupMenuInputProcessor: " + popupMenuInputProcessor, this, this.commonStrings.PROCESS);
        this.popupMenuInputProcessor = popupMenuInputProcessor
    }

    def getPopupMenuInputProcessor() : BasicMenuInputProcessor = {
        //this.logUtil.putF("getPopupMenuInputProcessor: " + popupMenuInputProcessor, this, this.commonStrings.PROCESS);
        return this.popupMenuInputProcessor
    }

    def getSensorGameUpdateProcessor() : SensorGameUpdateProcessor = {
        return this.sensorGameUpdateProcessor
    }

    //TWB - multiplayer needed it to be public
    def getRawGameInputProcessor() : InputProcessor = {
        return this.rawGameInputProcessor
    }

    //TWB - multiplayer needed it to be public
    def getRawInputProcessor() : InputProcessor = {
        return this.rawInputProcessor
    }

    //TWB - multiplayer needed it to be public
    def setInputProcessor(inputProcessor : InputProcessor) : Unit = {
        // inputProcessor.toString(), this, "setInputProcessor");
        this.inputProcessor = inputProcessor
    }

    def getInputProcessor() : InputProcessor = {
        return this.inputProcessor
    }

    def setMenuPaintable(menuPaintable : Paintable) : Unit = {
        this.menuPaintable = menuPaintable
    }

    def getMenuPaintable() : Paintable = {
        return this.menuPaintable
    }

    private def setFormPaintable(formPaintable : Paintable) : Unit = {
        this.formPaintable = formPaintable
    }

    def getFormPaintable() : Paintable = {
        return this.formPaintable
    }

    //TWB - multiplayer needed it to be public
    def setGameSpecificPaintableP(gameSpecificPaintable : Paintable) : Unit = {
        this.gameSpecificPaintable = gameSpecificPaintable
    }

    def getGameSpecificPaintableP() : Paintable = {
        return this.gameSpecificPaintable
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

    override def getType() : Int = {
        return AllBinaryGameCanvas.TYPE
    }

    //Needed for polyglot do not remove
    override def getTitle() : String = {
        return super.getTitle()
    }

    //Needed for polyglot do not remove
    override def isPaused() : Boolean = {
        return super.isPaused()
    }

}

object AllBinaryGameCanvas {
    private val id : Int = 0

    val TYPE : Int = 2

}


