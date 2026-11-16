/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.resource

import _root_.org.allbinary.input.motion.button.TouchButtonResource

/**  *  * @author user  */
class TouchButtonUpgradeResource private() extends TouchButtonResource("/touch_button_upgrade_64_by_64.png", "/touch_button_upgrade_hint_64_by_64.png") {
    import _root_.org.allbinary.game.input.resource.TouchButtonUpgradeResource.{*}

}

object TouchButtonUpgradeResource {
    private val instance : TouchButtonResource = new TouchButtonUpgradeResource()

    /**      * @return the instance      */
    def getInstance() : TouchButtonResource = {
        return TouchButtonUpgradeResource.instance
    }

}


