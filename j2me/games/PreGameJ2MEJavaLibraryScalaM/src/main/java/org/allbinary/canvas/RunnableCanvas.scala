/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.game.displayable.canvas.NullWaitGameRunnable
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.NullThread
import _root_.org.allbinary.thread.RunnableInterface
import _root_.org.allbinary.thread.ThreadObjectUtil
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList

class RunnableCanvas(param_commandListener : CommandListener, param_childNameList : BasicArrayList, param_hasParam : Boolean) extends MyCanvas(CommonStrings.getInstance().UNKNOWN, param_childNameList) with RunnableInterface {

    val nullUtil : NullUtil = NullUtil.getInstance()

    val stdUtil : StdUtil = StdUtil.getInstance()

    val systemWrapper : ABSystemWrapper = ABSystemWrapper.getInstance()

    val tsUtil : TsUtil = TsUtil.getInstance()

    private var thread : Thread = NullThread.NULL_THREAD

    private var currentThread : Thread = NullThread.NULL_THREAD

    private var running : Boolean = false

    // private int wait;
    val loopTimeHelper : TimeDelayHelper = new TimeDelayHelper(NullWaitGameRunnable.getInstance().WAIT)

    //protected ProcessPaintable processPaintable;
    var runnableCanvasRefreshHelper : Processor = Processor.getInstance()

    val commonLabels : CommonLabels = CommonLabels.getInstance()

    val threadObjectUtil : ThreadObjectUtil = ThreadObjectUtil.getInstance()

    val SET_RUNNING : String = "setRunning"

    private val IS_RUNNING : String = "isRunning"

    private val THREAD : String = "Thread: "

    private val NOT_EQUAL : String = " != "

    // private final String NOT_RUNNING = "Not Running";
    private val PAUSE_SLEEP : String = "pause sleep"

    //private final String GAME_SLEEP = "game sleep";
    private val START_PAUSE : String = "start pause - game thread sleep at: "

    private val END_PAUSE : String = "end pause - game thread sleep at: "

    private val PROCESS_LOOP_SLEEP : String = "processLoopSleep"

    private var pauseWait : Long = 0

    private var notified : Boolean = false

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val childNameList : BasicArrayList = param_childNameList
        val hasParam : Boolean = param_hasParam
        this.logUtil.putF(new StringMaker().append("RunnableCanvas delay: ").appendint(this.loopTimeHelper.delay).toString(), this, this.commonStrings.CONSTRUCTOR)
        //this.processPaintable = ProcessPaintableSingletonFactory.getInstance();
        this.runnableCanvasRefreshHelper = new RunnableCanvasRefreshHelper(this)
        if (commandListener != null) {
            this.initCommands(commandListener)
        } else if (hasParam) {
            this.logUtil.putF("commandListener was null", this, "initCommands")
        }
    }

    //Empty method for overriding 
    def initCommands(cmdListener : CommandListener) : Unit = {
        this.logUtil.putF(this.commonStrings.NOT_IMPLEMENTED, this, "initCommands")
    }

    def isMainCanvas() : Boolean = {
        if (this.getCustomCommandListener() != null) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    /*      * public CommandListener getCommandListener() { return commandListener; }      */
    override def setThread(thread : Thread) : Unit = {
        this.thread = thread
    }

    override def setRunning(running : Boolean) : Unit = {
        this.running = running
        if (!this.running) {
            this.thread = NullThread.NULL_THREAD
            this.synchronized {
                this.threadObjectUtil.notifyObject(this)
            }
        }
        this.logUtil.putF(new StringMaker().append(this.IS_RUNNING).appendboolean(this.running).toString(), this, this.SET_RUNNING)
    }

    override def isRunning() : Boolean = this.synchronized {
        if (this.thread eq this.currentThread) {
            /*              * if (!running) { this.logUtil.putF(NOT_RUNNING, * this, IS_RUNNING); }              */
            return this.running
        } else {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.THREAD)
            if (this.thread != null) {
                stringBuffer.append(this.thread.toString())
            }
            stringBuffer.append(this.NOT_EQUAL)
            if (this.currentThread != null) {
                stringBuffer.append(StringUtil.getInstance().toString(this.currentThread))
            }
            this.logUtil.putF(stringBuffer.toString(), this, this.IS_RUNNING)
            return false
        }
        throw new IllegalStateException()
    }

    def getLoopTimeHelperP() : TimeDelayHelper = {
        return this.loopTimeHelper
    }

    def setWait(wait : Int) : Unit = {
        this.loopTimeHelper.delay = wait
        // this.wait = wait;
        this.pauseWait = wait.toLong * 3
        this.logUtil.putF(new StringMaker().append("setWait - delay: ").appendint(this.loopTimeHelper.delay).toString(), this, this.commonStrings.CONSTRUCTOR)
    }

    def getWait() : Int = {
        return this.loopTimeHelper.delay
    }

    def setCurrentThread() : Unit = {
        this.currentThread = Thread.currentThread()
    }

    def setCurrentThreadFake() : Unit = {
        this.currentThread = this.thread
    }

    override def showNotify() : Unit = {
        try {
            this.stopWaiting()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "showNotify", e)
            }
        }
    }

    private def stopWaiting() : Unit = {
        this.notified = true
        this.synchronized {
            this.threadObjectUtil.notifyObject(this)
        }
        //System.out.println("TWB:RunnableCanvas:stopWaiting:repaint");
        this.repaint()
    }

    def waitOnNotify(wait : Long) : Unit = this.synchronized {
        if (!this.notified) {
            if (wait > 0) {
                this.threadObjectUtil.waitObjectFor(this, wait.toLong)
            } else {
                this.threadObjectUtil.waitObject(this)
            }
        }
    }

    /*     private final int preferredFrameRate = 12;     private final int preferredFrameTime = 1000 / preferredFrameRate;     private int attemptFrameRate = preferredFrameRate;     private int attemptFrameTime = preferredFrameTime;     */
    def processSleep() : Unit = {
        //this.logUtil.putF(PAUSE_SLEEP + System.currentTimeMillis(), this, this.commonStrings.PROCESS);
        Thread.sleep(this.pauseWait)
    }

    def isPausable() : Boolean = {
        return false
    }

    def processGameSleep(sleep : Long) : Unit = {
        //this.logUtil.putF(GAME_SLEEP + sleep, this, this.commonStrings.PROCESS);
        Thread.sleep(sleep)
    }

    def processLoopSleep() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, PROCESS_LOOP_SLEEP);
        this.runnableCanvasRefreshHelper.process()
        //this.processPaintable.process();
        if (this.isPaused()) {
            val stringMaker : StringMaker = new StringMaker()
            //this.logUtil.putF(stringMaker.append(this.IS_RUNNING).appendboolean(this.isRunning()).append(" isSingleThread: ").appendboolean(this.isSingleThread()).toString(), this, this.PROCESS_LOOP_SLEEP);
            if (this.isRunning() && !this.isSingleThread()) {
                stringMaker.delete(0, stringMaker.length())
                val currentTimeMillis : Long = this.systemWrapper.currentTimeMillis()
                this.logUtil.putF(stringMaker.append(this.START_PAUSE).appendlong(currentTimeMillis).append(this.PAUSE_SLEEP).appendlong(this.pauseWait).toString(), this, this.PROCESS_LOOP_SLEEP)

                {
                    while ((this.isPaused() && this.isRunning()) && !this.isSingleThread()) {
                        this.processSleep()
                        if (!this.isPausable()) {
                            stringMaker.delete(0, stringMaker.length())
                            this.logUtil.putF(stringMaker.append(this.END_PAUSE).appendlong(currentTimeMillis).toString(), this, this.PROCESS_LOOP_SLEEP)
                            return
                        }
                    }
                }
            }
        }
        //Note that if you used the game timer then elapsed would always be 0 so don't change
        var elapsedTime : Long = this.loopTimeHelper.getElapsedTNT()
        /*         long refreshRate = GameStatisticsFactory.getInstance().getRefreshRate();          if (refreshRate != this.attemptFrameRate)         {             if (refreshRate > this.attemptFrameRate)             {                 attemptFrameTime++;                 if(this.attemptFrameRate <= this.preferredFrameRate)                 {                     attemptFrameRate++;                 }             } else                 if(this.attemptFrameTime > 10)             {                 attemptFrameTime--;             }                 else                     if(this.attemptFrameRate > 4)                 {                         attemptFrameRate--;                 }         }          if (elapsedTime > this.attemptFrameTime)         {             elapsedTime = this.attemptFrameTime;         }                  Thread.sleep(this.attemptFrameTime - elapsedTime);         */
        val wait : Long = this.loopTimeHelper.delay.toLong
        if (elapsedTime > wait) {
            elapsedTime = wait
        } else {
            this.processGameSleep(wait - elapsedTime)
        }
    }

    def isSingleThread() : Boolean = {
        return false
    }

    override def run() : Unit = {
        this.setCurrentThread()
    }

    //Hack for GD
    def end2() : Unit = {
    }

    def getType() : Int = {
        return -1
    }

}


