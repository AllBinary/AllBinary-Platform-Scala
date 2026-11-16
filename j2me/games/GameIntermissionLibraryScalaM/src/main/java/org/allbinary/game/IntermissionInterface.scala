/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.time.TimeDelayHelper

/**  *   * @author Admin  */
trait IntermissionInterface {

    def getTimeDelayHelper() : TimeDelayHelper

    def isEnabled() : Boolean

    def setEnabled(value : Boolean) : Unit

    def setListener(enableListener : IntermissionEnableListenerInterface) : Unit

}


