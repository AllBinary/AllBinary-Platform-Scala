/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.form.item.CommandTextItemArrayFactory
import _root_.org.allbinary.graphics.form.item.LimitCommandsVisitor

class DemoLimitedCommandTextItemArrayFactory {
    import _root_.org.allbinary.game.displayable.canvas.DemoLimitedCommandTextItemArrayFactory.{*}

    private val commandTextItemArrayFactory : CommandTextItemArrayFactory = new CommandTextItemArrayFactory(new LimitCommandsVisitor())

    def getCommandTextItemArrayFactory() : CommandTextItemArrayFactory = {
        return this.commandTextItemArrayFactory
    }

}

object DemoLimitedCommandTextItemArrayFactory {
    private val instance : DemoLimitedCommandTextItemArrayFactory = new DemoLimitedCommandTextItemArrayFactory()

    def getInstance() : DemoLimitedCommandTextItemArrayFactory = {
        return DemoLimitedCommandTextItemArrayFactory.instance
    }

}


