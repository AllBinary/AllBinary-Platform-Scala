/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot.osgi

import _root_.bundle.input.automation.robot.InputAutomationRobotServiceInterface
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.osgi.OSGIServiceInterface
import _root_.org.allbinary.osgi.OSGIServiceVisitorInterface
import _root_.org.allbinary.string.CommonStrings

class InputAutomationRobotOSGIServiceVisitor() extends OSGIServiceVisitorInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def visit(anyType : Object) : Object = {
        return this.visit(anyType.asInstanceOf[OSGIServiceInterface])
    }

    def visit(osgiServiceInterface : OSGIServiceInterface) : _root_.java.lang.Boolean = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "visit")
            val inputAutomationRobotServiceInterface : InputAutomationRobotServiceInterface = osgiServiceInterface.asInstanceOf[InputAutomationRobotServiceInterface]
            val inputRobotInterfaceArray : Array[InputRobotInterface] = inputAutomationRobotServiceInterface.getInputRobotInterfaceArray()

            {
                var index : Int = 0
                while (index < inputRobotInterfaceArray.length) {
                    this.logUtil.putF("Adding: " + inputRobotInterfaceArray(index).getName(), this, "visit")
                    InputRobotFactory.getInstance().add(inputRobotInterfaceArray(index))
                    index += 1
                }
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "visit", e)
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

}


