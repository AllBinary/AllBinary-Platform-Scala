/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.emulator


class InitEmulatorFactory {
    import _root_.org.allbinary.emulator.InitEmulatorFactory.{*}

    private var initEmulator : Boolean = false

    def setInitEmulator(initEmulator : Boolean) : Unit = {
        this.initEmulator = initEmulator
    }

    def isInitEmulator() : Boolean = {
        return this.initEmulator
    }

}

object InitEmulatorFactory {
    private val instance : InitEmulatorFactory = new InitEmulatorFactory()

    def getInstance() : InitEmulatorFactory = {
        return InitEmulatorFactory.instance
    }

}


