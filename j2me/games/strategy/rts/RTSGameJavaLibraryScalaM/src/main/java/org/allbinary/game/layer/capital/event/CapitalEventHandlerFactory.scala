/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.capital.event

import _root_.org.allbinary.game.identification.Group

/**  *  * @author user  */
class CapitalEventHandlerFactory {
    import _root_.org.allbinary.game.layer.capital.event.CapitalEventHandlerFactory.{*}

}

object CapitalEventHandlerFactory {
    //One for each Group
    private val capitalEventHandlerArray : Array[CapitalEventHandler] = new Array[CapitalEventHandler](10)

    {

        {
            var index : Int = CapitalEventHandlerFactory.capitalEventHandlerArray.length - 1
            while (index >= 0) {
                CapitalEventHandlerFactory.capitalEventHandlerArray(index) = new CapitalEventHandler()
                index -= 1
            }
        }
    }

    def getInstance(groupInterface : Group) : CapitalEventHandler = {
        val groupId : Int = groupInterface.getGroupId().toInt
        return CapitalEventHandlerFactory.capitalEventHandlerArray(groupId)
    }

    def removeAll() : Unit = {

        {
            var index : Int = CapitalEventHandlerFactory.capitalEventHandlerArray.length - 1
            while (index >= 0) {
                CapitalEventHandlerFactory.capitalEventHandlerArray(index).removeAllListeners()
                index -= 1
            }
        }
    }

}


