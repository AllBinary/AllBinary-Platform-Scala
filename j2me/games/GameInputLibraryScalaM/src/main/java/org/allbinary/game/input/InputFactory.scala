/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class InputFactory private() {
    import _root_.org.allbinary.game.input.InputFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    val KEY_CODE_LABEL : String = "KeyCode: "

    val DEVICE_ID_LABEL : String = "DeviceId: "

    //VK_CONTEXT_MENU
    val MAX : Int = SmallIntegerSingletonFactory.getInstance().getMin()

    //protected final Input[] negativeInputIntegerArray = new Input[6];
    val inputIntegerArray : Array[Input] = new Array[Input](this.MAX)

    val NO_INPUT : Input = new Input(0, this.commonStrings.UNKNOWN)

    //Constructor
    {
        val size : Int = this.inputIntegerArray.length
        //this.logUtil.putF(new StringMaker().append("size: ").append(size).toString(), this, this.commonStrings.CONSTRUCTOR);

        {
            var index : Int = 0
            while (index < size) {
                this.inputIntegerArray(index) = this.NO_INPUT
                index += 1
            }
        }
    }

    def add(id : Int, input : Input) : Unit = {
        this.inputIntegerArray(id) = input
    }

    def getInstanceById(param_id : Int) : Input = {
        var id : Int = param_id
        if (id < 0) {
            id = -id
        }
        if (id > this.inputIntegerArray.length) {
            //this.logUtil.put(new StringMaker().append("id: ").append(id).toString(), this, this.commonStrings.GET_INSTANCE, new Exception());
            this.logUtil.putF(new StringMaker().append("Warning id: ").appendint(id).toString(), this, this.commonStrings.GET_INSTANCE)
            return this.NO_INPUT
        }
        return this.inputIntegerArray(id)
    }

}

object InputFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : InputFactory = {
        if (InputFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            InputFactory.instance = new InputFactory()
        }
        return InputFactory.instance.asInstanceOf[InputFactory]
    }

}


