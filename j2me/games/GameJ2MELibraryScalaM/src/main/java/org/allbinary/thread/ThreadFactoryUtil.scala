/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.canvas.RunnableCanvas
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.displayable.canvas.DemoCanvas
import _root_.org.allbinary.game.displayable.canvas.GameCanvasRunnableInterface
import _root_.org.allbinary.game.displayable.canvas.RunnableCanvasSingleThreadStartRunnable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class ThreadFactoryUtil {
    import _root_.org.allbinary.thread.ThreadFactoryUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstanceGameCanvasRunnable(runnable : GameCanvasRunnableInterface) : Thread = {
        return this.getInstanceType(runnable, runnable.getType())
    }

    def getInstanceForRunnable(runnable : ABRunnable) : Thread = {
        return this.getInstanceType(runnable, runnable.getType())
    }

    private def getInstanceType(runnable : Runnable, `type` : Int) : Thread = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        if (J2MEUtil.isHTML()) {
            if ((`type` == DemoCanvas.TYPE) || (`type` == AllBinaryGameCanvas.TYPE)) {
                //GameCanvasRunnableInterface gameCanvasRunnableInterface = this.demoGameMidlet.getGameCanvasRunnableInterface();
                val demoGameSingleThreadStartRunnable : RunnableCanvasSingleThreadStartRunnable = new RunnableCanvasSingleThreadStartRunnable(runnable.asInstanceOf[RunnableCanvas])
                PreLogUtil.put(new StringMaker().append("Using Pseudo Thread for DemoCanvas/AllBinaryGameCanvas under PlayN/HTML5: ").append(StringUtil.getInstance().toString(runnable)).toString(), this, commonStrings.CONSTRUCTOR)
                val primaryThreadPool : ThreadPool = PrimaryThreadPool.getInstance()
                primaryThreadPool.runTask(demoGameSingleThreadStartRunnable)
            } else {
                PreLogUtil.put(new StringMaker().append("Using Pseudo Thread for Runnable under PlayN/HTML5: ").append(StringUtil.getInstance().toString(runnable)).toString(), this, commonStrings.CONSTRUCTOR)
                var primaryThreadPool : ThreadPool = PrimaryThreadPool.getInstance()
                primaryThreadPool.runTask(runnable)
            }
        }
        val thread : Thread = new Thread(runnable, runnable.toString())
        this.logUtil.putF(thread.toString(), this, commonStrings.CONSTRUCTOR)
        return thread
    }

    def start(thread : Thread) : Unit = {
        thread.start()
    }

}

object ThreadFactoryUtil {
    private val instance : ThreadFactoryUtil = new ThreadFactoryUtil()

    def getInstance() : ThreadFactoryUtil = {
        return ThreadFactoryUtil.instance
    }

}


