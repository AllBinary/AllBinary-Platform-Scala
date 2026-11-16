/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.NullCanvas
import _root_.javax.microedition.lcdui.NullCommandListener
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.canvas.RunnableCanvas
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.form.item.ABCustomGaugeItem
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.midlet.AllBinaryMidlet
import _root_.org.allbinary.thread.PathFindingThreadPool
import _root_.org.allbinary.thread.ThreadPool

class ProgressCanvas(param_title : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends RunnableCanvas(NullCommandListener.NULL_COMMAND_LISTENER, CanvasStrings.getInstance().EMPTY_CHILD_NAME_LIST, false) with PaintableInterface with UpdateMyFontInterface {

    //protected static final String END_FROM_INITIAL_LAZY_LOADING_COMPLETE = "endFromInitialLazyLoadingComplete";
    var hasPainted : Boolean = false

    private var backgroundBasicColor : BasicColor = null

    val GAUGE_PAINTABLE : Paintable = new ProgressPaintable(this)

    private val maxValue : Float = 100.0f

    var gauge : ABCustomGaugeItem = null

    private val TEXT : String = this.commonStrings.LOADING

    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    var allbinaryMidlet : AllBinaryMidlet = AllBinaryMidlet.getNullInstance()

    private var value : Float = 0.0f

    private var text : String = this.TEXT

    private var background : Boolean = true

    var paintable : PaintableInterface = this.GAUGE_PAINTABLE

    var inProgress : Boolean = false

    private val IN_GAME_PROCESSOR : Processor = new Processor {
            private val pathFindingThreadPool : ThreadPool = PathFindingThreadPool.getInstance()

            override def process() : Unit = {
                this.pathFindingThreadPool.runAPriorityTask()
            }

        }

    var inGameProcessor : Processor = Processor.getInstance()

    var progressEndListener : ProgressEndListener = ProgressEndListener.instance

    private val backgroundLabel : String = "Background AI Game Loading..."

    private val START_BACKGROUND : String = "startBackground"

    val ADD_PORTION : String = "addPortion"

    val ADD_EARLY_PORTION : String = "addEarlyPortion"

    //    }
    //Constructor
    {
        val title : String = param_title
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.backgroundBasicColor = backgroundBasicColor
        this.gauge = new ABCustomGaugeItem(StringUtil.getInstance().EMPTY_STRING, this.maxValue.toInt, 0, backgroundBasicColor, foregroundBasicColor)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.gauge.setHeight(font.getHeight() + 2)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def init(gameMidlet : AllBinaryMidlet) : Unit = {
        this.allbinaryMidlet = gameMidlet
    }

    def update(graphics : Graphics) : Unit = {
    }

    /*     public boolean isInitialized()     {         if (this.allbinaryMidlet != null)             return true;         else             return false;     }     */
    override def initCommands(cmdListener : CommandListener) : Unit = {
    }

    /*      * public boolean isDone() { if (this.PROGRESS_SCREEN.getValue() <      * this.PROGRESS_SCREEN .getMaxValue()) { return false; } else { return      * true; } }      */
    final def getMaxValue() : Float = {
        return this.maxValue
    }

    def start() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.START_METHOD_NAME)
        this.setBackground(true)
        this.gauge.setHeight(30)
        this.gauge.setLabel(this.commonStrings.PLEASE_WAIT)
        this.setText(this.TEXT)
        this.setValue(0)
        //this.setDisplayed(false);
        this.inGameProcessor = Processor.getInstance()
        this.paintable = this.GAUGE_PAINTABLE
        this.inProgress = true
    }

    def startBackground(background : Boolean) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.START_BACKGROUND)
        this.setBackground(background)
        this.myFontProcessor = this.updateMyFontProcessor
        this.gauge.setLabel(this.backgroundLabel)
        this.setText(this.TEXT)
        this.setValue(0)
        this.inGameProcessor = Processor.getInstance()
        this.paintable = this.GAUGE_PAINTABLE
    }

    def endActual() : Unit = {
        //getCommandListener()
        this.allbinaryMidlet.commandAction(GameCommandsFactory.getInstance().SHOW_GAME_CANVAS, NullCanvas.NULL_CANVAS)
        this.inProgress = false
        this.inGame()
    }

    def inGame() : Unit = {
        this.progressEndListener.onEndEvent()
        this.inGameProcessor = this.IN_GAME_PROCESSOR
    }

    def end() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.END_METHOD_NAME)
        this.gauge.setValue(this.getMaxValue())
        this.endActual()
        this.paintable = NullPaintable.getInstance()
    }

    def endFromInitialLazyLoadingComplete() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, END_FROM_INITIAL_LAZY_LOADING_COMPLETE);
        this.progressEndListener.onEndEvent()
        this.gauge.setValue(this.getMaxValue())
        this.inGameProcessor = this.IN_GAME_PROCESSOR
    }

    def isInGame() : Boolean = {
        if (this.inGameProcessor eq this.IN_GAME_PROCESSOR) {
            return true
        }
        return false
    }

    def endIfPaintedSinceStart() : Unit = {
    }

    def addEarlyPortion(value : Int, text : String, index : Int) : Unit = {
        //PreLogUtil.put(this.text, this, ADD_PORTION);
        this.setText(new StringMaker().append(text).append(SmallIntegerSingletonFactory.getInstance().getAt(index).toString()).toString())
        this.gauge.setValue(this.gauge.getValue() + (this.getMaxValue() / value))
    }

    def addPortion(value : Int, text : String, index : Int) : Unit = {
        this.setText(new StringMaker().append(text).append(SmallIntegerSingletonFactory.getInstance().getAt(index).toString()).toString())
        //this.logUtil.putF(this.text, this, ADD_PORTION);
        PreLogUtil.put(this.text, this, this.ADD_PORTION)
        this.gauge.setValue(this.gauge.getValue() + (this.getMaxValue() / value))
    }

    def addNormalPortion(value : Int, text : String) : Unit = {
        //this.logUtil.putF(text, this, ADD_PORTION);
        if (this.text ne text) {
            PreLogUtil.put(text, this, this.ADD_PORTION)
        }
        this.setText(text)
        this.gauge.setValue(this.gauge.getValue() + (this.getMaxValue() / value))
    }

    def setValue(value : Int) : Unit = {
        this.value = value.toFloat
        this.gauge.setValue(value.toFloat)
    }

    override def paint(graphics : Graphics) : Unit = {
        this.paintable.paint(graphics)
    }

    def paint2(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        graphics.setColor(this.backgroundBasicColor.intValue())
        graphics.fillRect(0, 0, this.displayInfo.getLastWidth(), this.displayInfo.getLastHeight())
        this.gauge.paintXY(graphics, 0, 0)
        this.hasPainted = true
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    /*     public void waitUntilDisplayed()     {         try         {             int index = 0;             while ((!this.isDisplayed()) && index < 50)             {                 this.logUtil.putF(                         "Waiting for it to be displayed", this, "waitUntilDisplayed");                 Thread.sleep(200);                 index++;             }             this.logUtil.putF("Displayed", this, "waitUntilDisplayed");          }         catch (Exception e)         {             this.logUtil.put(this.commonStrings.EXCEPTION, this,                     "waitUntilDisplayed", e);         }     }     */
    def getValue() : Float = {
        return this.value
    }

    def setText(text : String) : Unit = {
        this.text = text
    }

    def getText() : String = {
        return this.text
    }

    def setBackground(background : Boolean) : Unit = {
        this.background = background
    }

    def isBackground() : Boolean = {
        return this.background
    }

}


