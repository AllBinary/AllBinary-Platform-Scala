/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os

import _root_.org.allbinary.logic.java.character.CharacterSet

trait OperatingSystemInterface {

    def getName() : String

    def getVersion() : String

    def getArch() : String

    def getCharacterSet() : CharacterSet

    def isOverScan() : Boolean

    def getOverScanXPercent() : Int

    def getOverScanYPercent() : Int

    def isScalable() : Boolean

    def isAutoHide() : Boolean

    override def toString() : String

}


