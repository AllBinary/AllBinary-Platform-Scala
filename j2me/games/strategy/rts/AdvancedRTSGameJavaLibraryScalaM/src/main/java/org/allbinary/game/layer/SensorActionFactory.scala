/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer


/**  *  * @author user  */
class SensorActionFactory private() {
    import _root_.org.allbinary.game.layer.SensorActionFactory.{*}

    val ATTACK : SensorAction = new SensorAction("Attack")

    val EVADE : SensorAction = new SensorAction("Evade")

}

object SensorActionFactory {
    private val instance : SensorActionFactory = new SensorActionFactory()

    /**      * @return the instance      */
    def getInstance() : SensorActionFactory = {
        return SensorActionFactory.instance
    }

}


