/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.android.view

import _root_.android.view.View

/**  *  * @author User  */
class ViewWrapper(param_view : View) extends BaseViewWrapper {

    private var view : View = null

    //Constructor
    {
        val view : View = param_view
        this.view = view
    }

    override def invalidate() : Unit = {
        this.view.invalidate()
    }

    override def postInvalidate() : Unit = {
        this.view.postInvalidate()
    }

}


