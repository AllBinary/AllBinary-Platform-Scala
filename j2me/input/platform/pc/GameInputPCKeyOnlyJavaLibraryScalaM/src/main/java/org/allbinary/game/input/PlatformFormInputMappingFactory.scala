/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class PlatformFormInputMappingFactory {
    import _root_.org.allbinary.game.input.PlatformFormInputMappingFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var inputToGameKeyMapping : InputToGameKeyMapping = InputToGameKeyMapping.getNullInstance()

    def getOrCreate() : InputToGameKeyMapping = {
        try {
            if (this.inputToGameKeyMapping eq InputToGameKeyMapping.getNullInstance()) {
                var pcKeyFactory : PCKeyFactory = PCKeyFactory.getInstance()
                val inputToGameKeyMapping : InputToGameKeyMapping = new InputToGameKeyMapping()
                val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()
                inputToGameKeyMapping.add(gameKeyFactory.UP, pcKeyFactory.DPAD_UP)
                inputToGameKeyMapping.add(gameKeyFactory.DOWN, pcKeyFactory.DPAD_DOWN)
                inputToGameKeyMapping.add(gameKeyFactory.LEFT, pcKeyFactory.DPAD_LEFT)
                inputToGameKeyMapping.add(gameKeyFactory.RIGHT, pcKeyFactory.DPAD_RIGHT)
                inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM1, pcKeyFactory.ENTER)
                //inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM1, androidKeyFactory.DPAD_CENTER);
                this.inputToGameKeyMapping = inputToGameKeyMapping
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
            }
        }
        return this.inputToGameKeyMapping
    }

}

object PlatformFormInputMappingFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : PlatformFormInputMappingFactory = {
        if (PlatformFormInputMappingFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            PlatformFormInputMappingFactory.instance = new PlatformFormInputMappingFactory()
        }
        return PlatformFormInputMappingFactory.instance.asInstanceOf[PlatformFormInputMappingFactory]
    }

}


