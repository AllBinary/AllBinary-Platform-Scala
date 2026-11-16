/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.GameType
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author user  */
trait AdvancedRTSPlayerLayerInterface extends RTSPlayerLayerInterface {

    def getAdvancedPlayerOwnedRTSLayers() : AdvancedPlayerOwnedRTSLayers

    def isLocalPlayer() : Boolean

    //Not really a local player but all should show
    def getGameType() : GameType

    def getDecalBasicColor() : BasicColor

}


