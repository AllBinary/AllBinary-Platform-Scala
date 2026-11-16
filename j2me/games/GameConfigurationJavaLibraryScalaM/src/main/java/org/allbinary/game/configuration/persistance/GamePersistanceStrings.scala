/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance


/**  *  * @author User  */
class GamePersistanceStrings {
    import _root_.org.allbinary.game.configuration.persistance.GamePersistanceStrings.{*}

    val SAVED_GAME_RECORD_ID : String = "_SG"

    val SAVED_GAME_CONFIGURATION_RECORD_ID : String = "_SGC"

    val DEFAULT_INPUT_MAPPING_RECORD_ID : String = "_DIM"

    val SAVED_INPUT_CONFIGURATION_RECORD_ID : String = "_SIC"

}

object GamePersistanceStrings {
    private val instance : GamePersistanceStrings = new GamePersistanceStrings()

    /**      * @return the instance      */
    def getInstance() : GamePersistanceStrings = {
        return GamePersistanceStrings.instance
    }

}


