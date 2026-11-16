/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.string.CommonStrings

class ThrustAIVisitor() extends Visitor {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val TRUE : _root_.java.lang.Boolean = BooleanFactory.getInstance().TRUE

    override def visit(anyType : Object) : Object = {
        try {
            var basicAI : BasicAI = anyType.asInstanceOf[BasicAI]
            basicAI.processKeyAI(Canvas.UP)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.VISIT, e)
            }
        }
        return this.TRUE
    }

}


