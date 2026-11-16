/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping

class NormalJ2MEGameInputMapping extends J2MEGameInputMapping {

    override def getDefault() : InputToGameKeyMapping = {
        //this.logUtil.putF("Use Default GameKey Mappings", this, "addDefault");
        return new NormalJ2MEDefaultGameInputMapping().getInputMapping()
    }

}


