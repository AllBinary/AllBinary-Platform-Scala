/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input


class GameInputProcessorUtil {
    import _root_.org.allbinary.game.input.GameInputProcessorUtil.{*}

}

object GameInputProcessorUtil {
    def init(inputProcessorArray : Array[GameInputProcessor]) : Unit = {
        val noInputProcessor : GameInputProcessor = GameInputProcessor.getInstance()
        val total : Int = InputFactory.getInstance().MAX

        {
            var index : Int = 0
            while (index < total) {
                var inputProcessorCanBeNull : GameInputProcessor = inputProcessorArray(index)
                if (inputProcessorCanBeNull == null) {
                    inputProcessorArray(index) = noInputProcessor
                }
                index += 1
            }
        }
    }

}


