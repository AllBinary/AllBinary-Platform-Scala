/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item.validation

import _root_.org.allbinary.game.input.TextNotificationUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.string.CommonStrings

class TextItemNumberVisitor() extends Visitor {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def visit(anyType : Object) : Object = {
        var value : String = anyType.asInstanceOf[String]
        if (value.length() < 2) {
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            if (stringValidationUtil.isNumber(value)) {
                return BooleanFactory.getInstance().TRUE
            } else {
                try {
                    TextNotificationUtil.getInstance().fireError("Numbers Only")
                } catch {
                    case e : Exception => {
                        val commonStrings : CommonStrings = CommonStrings.getInstance()
                        this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.VISIT, e)
                    }
                }
                return BooleanFactory.getInstance().FALSE
            }
        } else {
            return BooleanFactory.getInstance().FALSE
        }
        throw new IllegalStateException()
    }

}


