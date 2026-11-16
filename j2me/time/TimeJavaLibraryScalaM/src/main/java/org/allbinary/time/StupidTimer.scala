/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.ThreadObjectUtil

class StupidTimer {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val nullUtil : NullUtil = NullUtil.getInstance()

    private val threadObjectUtil : ThreadObjectUtil = ThreadObjectUtil.getInstance()

    private def visitBool(visitorInterface : Visitor) : Boolean = {
        val result : _root_.java.lang.Boolean = visitorInterface.visit(this.nullUtil.NULL_OBJECT).asInstanceOf[_root_.java.lang.Boolean]
        val result2 : Boolean = result.booleanValue()
        return result2
    }

    final def visit(visitorInterface : Visitor, timeDelayHelper : TimeDelayHelper) : Unit = {
        var tookTooLong : Boolean = false
        val WAITING_FOR : String = "Waiting for: "
        //this.logUtil.putF(WAITING_FOR).append(visitorInterface, this, this.commonStrings.VISIT);
        PreLogUtil.put(new StringMaker().append(WAITING_FOR).append(StringUtil.getInstance().toString(visitorInterface)).toString(), this, this.commonStrings.VISIT)
        var index : Int = 0

        {
            scala.util.boundary { (break_N68786 : scala.util.boundary.Label[Unit]) ?=>
                while (this.visitBool(visitorInterface)) {
                    if ((index % 10) == 0) {
                        PreLogUtil.put(new StringMaker().append(WAITING_FOR).appendint(index).toString(), this, this.commonStrings.VISIT)
                    }
                    index += 1
                    this.synchronized {
                        this.threadObjectUtil.waitObjectFor(this, 1800)
                    }
                    if (timeDelayHelper.isTimeTNT()) {
                        tookTooLong = true
                        scala.util.boundary.break()(using break_N68786)
                    }
                }
            }
        }
        if (tookTooLong) {
            this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.VISIT, new Exception(new StringMaker().append("Took Too Long: ").append(StringUtil.getInstance().toString(visitorInterface)).toString()))
        } else {
            PreLogUtil.put(timeDelayHelper.toString(), this, this.commonStrings.VISIT)
        }
    }

    def stopWaiting() : Unit = {
        this.synchronized {
            this.threadObjectUtil.notifyObject(this)
        }
    }

}


