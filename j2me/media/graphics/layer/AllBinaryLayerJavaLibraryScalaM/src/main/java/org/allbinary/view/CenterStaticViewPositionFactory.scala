/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.view

import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton

class CenterStaticViewPositionFactory() {

    def getInstance(z : Int) : ViewPositionBase = {
        var displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        //return new StaticViewPosition((displayInfoSingleton.getLastWidth() >> 1) + this.xOffset, (displayInfoSingleton.getLastHeight() >> 1) + this.yOffset);
        return new StaticViewPosition((displayInfoSingleton.getLastWidth() >> 1), (displayInfoSingleton.getLastHeight() >> 1), z)
    }

}


