/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.NullCommandListener
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.displayable.RepaintBehavior
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
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventHandler
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventListener
import _root_.org.allbinary.graphics.displayable.screen.ScreenRepaintProcessorFactory
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.form.CommandCurrentSelectionFormFactory
import _root_.org.allbinary.graphics.form.FormPaintable
import _root_.org.allbinary.graphics.form.FormTypeFactory
import _root_.org.allbinary.graphics.form.PaintableForm
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.form.ScrollSelectionFormNoneFactory
import _root_.org.allbinary.graphics.form.item.CommandTextItemArrayFactory
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.form.item.validation.AllCommandsVisitor
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayListD

class GameCommandCanvas(param_cmdListener : CommandListener, param_name : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends MyCanvas(param_name, CanvasStrings.getInstance().EMPTY_CHILD_NAME_LIST) with MenuListener with DisplayChangeEventListener with UpdateMyFontInterface {
    import _root_.org.allbinary.game.displayable.canvas.GameCommandCanvas.{*}

    private val repaintProcessor : Processor = ScreenRepaintProcessorFactory.getInstance().create(this)

    val gameInputStrings : GameInputStrings = GameInputStrings.getInstance()

    var foregroundBasicColor : BasicColor = null

    var backgroundBasicColor : BasicColor = null

    val inputToGameKeyMapping : InputToGameKeyMapping = PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance().getInputMapping()

    val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()

    private val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    private val downGameKeyEventHandler : DownGameKeyEventHandler = DownGameKeyEventHandler.getInstance()

    private val upGameKeyEventHandler : UpGameKeyEventHandler = UpGameKeyEventHandler.getInstance()

    var repaintBehavior : RepaintBehavior = null

    val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    var foregroundColor : Int = 0

    var backgroundColor : Int = 0

    private var menuInputProcessor : BasicMenuInputProcessor = NoMenuInputProcessor.getInstance()

    private var menuPaintable : Paintable = NullPaintable.getInstance()

    private var menuForm : PaintableForm = PaintableForm.getNullPaintableForm()

    private var isSingleKeyRepeatableProcessing : Boolean = Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_REPEAT_PRESS)

    var fontHeight : Int = 0

    //Constructor
    {
        val cmdListener : CommandListener = param_cmdListener
        val name : String = param_name
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        //        } else {
        this.repaintBehavior = RepaintBehavior.getInstance()
        //        }
        this.foregroundBasicColor = foregroundBasicColor
        this.backgroundBasicColor = backgroundBasicColor
        this.foregroundColor = this.foregroundBasicColor.intValue()
        this.backgroundColor = this.backgroundBasicColor.intValue()
        this.initCommands(cmdListener)
        if (cmdListener ne NullCommandListener.NULL_COMMAND_LISTENER) {
            try {
                this.initMenu()
                this.repaintProcessor.process()
            } catch {
                case e : Exception => {
                    throw new RuntimeException()
                }
            }
        }
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        try {
            val font : Font = graphics.getFont()
            this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(this.canvasStrings.FD_WIDTH).appendint(MyFontProcessor.defaultCharWidth(font)).append(this.canvasStrings.FD_HEIGHT).appendint(font.getHeight()).toString(), this, this.canvasStrings.UPDATE_MEASUREMENT)
            this.fontHeight = font.getHeight()
            val rectangle : Rectangle = this.createRectangle(this.menuForm.size())
            this.menuForm.init(rectangle, FormTypeFactory.getInstance().VERTICAL_CENTER_FORM)
            //this.repaintBehavior.onChangeRepaint(this);
            this.update()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT, e)
            }
        }
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT);
        this.logUtil.putF(new StringMaker().append(this.commonStrings.START).append(DisplayInfoSingleton.getInstance().toString()).toString(), this, this.canvasStrings.ON_DISPLAY_CHANGE_EVENT)
        this.myFontProcessor = this.updateMyFontProcessor
    }

    /*     public synchronized void pause()     {         this.setPaused(true);     }      public synchronized void unPause()     {         this.setPaused(false);     }     */
    def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommand(GameCommandsFactory.getInstance().CLOSE_AND_SHOW_GAME_CANVAS)
        this.setCommandListener(cmdListener)
    }

    def initMenu() : Unit = {
        val form : ScrollSelectionForm = this.createForm()
        this.menuForm = form
        if (form ne ScrollSelectionFormNoneFactory.getInstance()) {
            this.setMenuInputProcessor(new ImmediateCommandFormInputProcessor(new BasicArrayListD(), -1, this, form))
            this.menuPaintable = new FormPaintable(form)
        }
        this.repaintBehavior.onChangeRepaint(this)
    }

    def createForm() : ScrollSelectionForm = {
        val items : Array[ABCustomItem] = new CommandTextItemArrayFactory(new AllCommandsVisitor()).getInstance(this.getCommandStack(), this.backgroundBasicColor, this.foregroundBasicColor)
        val rectangle : Rectangle = this.createRectangle(items.length)
        return CommandCurrentSelectionFormFactory.getInstance(StringUtil.getInstance().EMPTY_STRING, items, rectangle, FormTypeFactory.getInstance().VERTICAL_CENTER_FORM, 15, false, this.backgroundBasicColor, this.foregroundBasicColor)
    }

    def createRectangle(size : Int) : Rectangle = {
        val height : Int = size * this.fontHeight
        val startY : Int = ((this.displayInfo.getLastHeight() * 2) / 3) - height
        val pointFactory : PointFactory = PointFactory.getInstance()
        val rectangle : Rectangle = new Rectangle(pointFactory.createXY(30, startY), this.displayInfo.getLastWidth() - 30, startY)
        //this.logUtil.putF(rectangle.toString(), this, "createRectangle");
        return rectangle
    }

    override def open() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "open")
        BasicMotionGesturesHandler.getInstance().addListenerInterface(this.getMenuInputProcessor())
        GameKeyEventHandler.getInstance().addListener(this.getMenuInputProcessor())
        DisplayChangeEventHandler.getInstance().addListenerInterface(this)
    }

    override def close() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CLOSE)
        BasicMotionGesturesHandler.getInstance().removeListener(this.getMenuInputProcessor())
        GameKeyEventHandler.getInstance().removeListener(this.getMenuInputProcessor())
        DisplayChangeEventHandler.getInstance().removeListener(this)
    }

    def update() : Unit = {
        this.repaintProcessor.process()
    }

    override def getSourceId() : Int = {
        return GameCommandCanvas.id
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
        this.logUtil.putF(new StringMaker().append(CommonSeps.getInstance().SPACE).appendint(keyCode).toString(), this, this.gameInputStrings.KEY_PRESSED)
        this.addGameKeyEvent(keyCode, 0, false)
    }

    override def keyReleasedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, gameInputStrings.KEY_RELEASED);
        this.removeGameKeyEvent(keyCode, deviceId, false)
    }

    override def keyRepeatedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        // this.logUtil.putF("Key Repeated: ").append(Integer.toHexString(keyCode), this, gameInputStrings.KEY_REPEATED);
        if (this.isSingleKeyRepeatableProcessing) {
            this.addGameKeyEvent(keyCode, deviceId, true)
        }
    }

    private def addGameKeyEvent(keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
        try {
            //this.logUtil.putF(new StringMaker().append("Key Code (Hex): ").append(Integer.toHexString(keyCode)).toString(), this, this.gameInputStrings.ADD_KEY_EVENT);
            val gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(this, keyCode)
            //this.logUtil.putF(new StringMaker().append("GameKey: ").append(gameKey).toString(), this, this.gameInputStrings.ADD_KEY_EVENT);
            if (gameKey ne this.gameKeyFactory.NONE) {
                val gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this, gameKey)
                /*                  * //This is for key input debugging only GameKeyEvent                  * gameKeyEvent = GameKeyEventFactory.getInstance(this, keyCode, gameActionKeyCode, gameKey.getKey(), repeated);                  * this.logUtil.putF(gameKeyEvent.toString(), this, this.gameInputStrings.ADD_KEY_EVENT);                  */
                this.downGameKeyEventHandler.fireEvent(gameKeyEvent)
                this.downGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
            } else {
                this.logUtil.putF(new StringMaker().append(this.gameInputStrings.NO_KEY).appendint(keyCode).toString(), this, this.gameInputStrings.ADD_KEY_EVENT)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.ADD_KEY_EVENT, e)
            }
        }
    }

    private def removeGameKeyEvent(keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
        try {
            //this.logUtil.putF(new StringMaker().append("Key Code: " + Integer.toHexString(keyCode), this, this.gameInputStrings.REMOVE_KEY_EVENT);
            val gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(this, keyCode)
            //this.logUtil.putF(new StringMaker().append("GameKey: ").append(gameKey, this, this.gameInputStrings.REMOVE_KEY_EVENT);
            if (gameKey ne this.gameKeyFactory.NONE) {
                val gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this, gameKey)
                // TODO TWB - Remove or improve key input event handling
                this.upGameKeyEventHandler.fireEvent(gameKeyEvent)
                this.upGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
            } else {
                this.logUtil.putF(new StringMaker().append(this.gameInputStrings.NO_KEY).appendint(keyCode).toString(), this, this.gameInputStrings.REMOVE_KEY_EVENT)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.REMOVE_KEY_EVENT, e)
            }
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        this.menuPaintable.paint(graphics)
        this.repaintBehavior.repaint(this)
    }

    private def setMenuInputProcessor(menuInputProcessor : BasicMenuInputProcessor) : Unit = {
        this.menuInputProcessor = menuInputProcessor
    }

    def getMenuInputProcessor() : BasicMenuInputProcessor = {
        return this.menuInputProcessor
    }

}

object GameCommandCanvas {
    private val id : Int = 0

}


