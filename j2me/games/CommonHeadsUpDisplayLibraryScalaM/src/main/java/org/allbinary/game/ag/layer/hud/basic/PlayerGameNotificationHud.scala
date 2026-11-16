/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.business.advertisement.GameAdStateFactory
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotification
import _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotificationHud
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.graphics.CustomGPoint
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.CircularIndexUtil

class PlayerGameNotificationHud(param_location : Int, param_direction : Int, param_bufferZone : Int, param_basicColor : BasicColor) extends GameNotificationHud(param_location, param_direction, param_bufferZone, param_basicColor) with UpdateMyFontInterface {

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    private val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private var circularIndexUtil : CircularIndexUtil = null

    private val gameNotification : GameNotification = new GameNotification()

    private val permanentGameNotification : GameNotification = new GameNotification()

    private val setAndRemoveProcessor : Processor = new SetAndRemoveProcessor(this)

    private val nextUnremoveableProcessor : Processor = new NextUnremoveableProcessor(this)

    private var processor : Processor = Processor.getInstance()

    private val PERMANENT_GAME_NOTIFICATION : String = "Permanent Game Notification: "

    //private final String TEMP_GAME_NOTIFICATION = "Temp Game Notification: ";
    private var lastString : String = StringUtil.getInstance().EMPTY_STRING

    private var string : String = this.EMPTY_STRING

    private var point : CustomGPoint = CustomGPoint.NULL_CUSTOM_POINT

    private var width : Int = 0

    //Constructor
    {
        val location : Int = param_location
        val direction : Int = param_direction
        val bufferZone : Int = param_bufferZone
        val basicColor : BasicColor = param_basicColor
        this.circularIndexUtil = CircularIndexUtil.createInstance(0)
        val gameNotificationEventHandler : GameNotificationEventHandler = GameNotificationEventHandler.getInstance()
        gameNotificationEventHandler.removeAllListeners()
        gameNotificationEventHandler.addListenerInterface(this)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        try {
            super.updateMeasurement(graphics)
            val font : Font = graphics.getFont()
            this.width = font.stringWidth(this.string)
            this.processor.process()
            this.processor = Processor.getInstance()
        } catch {
            case e : Exception => {
                val logUtil : LogUtil = LogUtil.getInstance()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, this, commonStrings.UPDATE, e)
            }
        }
    }

    override def getPoint(x : Int, y : Int) : GPoint = {
        this.point = CustomGPoint.getInstance3(0, 0)
        this.point.setX(x)
        this.point.setY(y)
        return this.point
    }

    //Add event if it is not already there
    override def add(string : String, seconds : Integer, basicColor : BasicColor, permanent : _root_.java.lang.Boolean) : Unit = {
        if (permanent.booleanValue()) {
            if (this.lastString ne string) {
                this.lastString = string
                this.logUtil.putF(new StringMaker().append(this.PERMANENT_GAME_NOTIFICATION).append(string).toString(), this, this.commonStrings.ADD)
            }
            this.permanentGameNotification.add(string, seconds, basicColor)
            this.circularIndexUtil.setSize(this.permanentGameNotification.getSize())
        } else {
            //}
            this.gameNotification.add(string, seconds, basicColor)
        }
    }

    override def processTick() : Unit = {
        if (this.timeDelayHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            val gameAdState : GameAdState = GameAdStateFactory.getInstance().getCurrentInstance()
            if (gameAdState.isShowingAtLocation(this.getLocation())) {
                //PreLogUtil.put("Y: ").append(this.getY(), this, GameStrings.getInstance().PROCESS_TICK);
                this.offsetY = -54
            } else {
                this.offsetY = 0
            }
            if (this.gameNotification.getSize() > 0) {
                this.setAndRemove()
            } else if (this.permanentGameNotification.getSize() > 0) {
                this.setNextUnremoveable()
            } else {
                this.string = this.EMPTY_STRING
            }
        }
    }

    private def setAndRemove() : Unit = {
        this.string = this.gameNotification.stringList.removeAt(0).asInstanceOf[String]
        this.processor = this.setAndRemoveProcessor
    }

    def setAndRemoveProcess() : Unit = {
        this.setX((this.displayInfo.getLastWidth() - this.width) >> 1)
        //
        this.point.setX(this.getX())
        this.point.setY(this.getY())
        val time : Integer = this.gameNotification.timeList.removeAt(0).asInstanceOf[Integer]
        var iTime : Int = time.intValue() * 1000
        if (iTime == 0) {
            iTime = 500
        }
        this.timeDelayHelper.delay = iTime
        this.setBasicColorP(this.gameNotification.colorList.removeAt(0).asInstanceOf[BasicColor])
    }

    private def setNextUnremoveable() : Unit = {
        val index : Int = this.circularIndexUtil.getIndex()
        this.string = this.permanentGameNotification.stringList.objectArray(index).asInstanceOf[String]
        this.processor = this.nextUnremoveableProcessor
    }

    def setNextUnremoveableProcess() : Unit = {
        val index : Int = this.circularIndexUtil.getIndex()
        this.setX((this.displayInfo.getLastWidth() - this.width) >> 1)
        //
        this.point.setX(this.getX())
        this.point.setY(this.getY())
        var time : Integer = this.permanentGameNotification.timeList.objectArray(index).asInstanceOf[Integer]
        this.timeDelayHelper.delay = time.intValue() * 1000
        this.setBasicColorP(this.permanentGameNotification.colorList.objectArray(index).asInstanceOf[BasicColor])
        this.circularIndexUtil.next()
    }

    override def clear() : Unit = {
        this.gameNotification.clear()
        this.permanentGameNotification.clear()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        //this.getMaxWidth()
        super.paintString(graphics, this.string)
    }

}


