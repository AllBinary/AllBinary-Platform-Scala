/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.debug


class DebugFactory {
    import _root_.org.allbinary.debug.DebugFactory.{*}

}

object DebugFactory {
    //private static DebugInterface SINGLETON = new AndroidDebug();
    def getInstance() : DebugInterface = {
        //return SINGLETON;
        return NoDebug.getInstance()
    }

}


