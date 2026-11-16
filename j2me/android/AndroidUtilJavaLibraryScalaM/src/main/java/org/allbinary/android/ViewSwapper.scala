/* Generated Code Do Not Modify */
package org.allbinary.android

import _root_.android.app.Activity
import _root_.android.view.View
import _root_.android.view.ViewGroup

class ViewSwapper(param_activity : Activity, param_rootViewId : Int) {
    import _root_.org.allbinary.android.ViewSwapper.{NULL_VIEW_ARRAY as _, *}
    def NULL_VIEW_ARRAY : Array[View] = _root_.org.allbinary.android.ViewSwapper.NULL_VIEW_ARRAY

    private var rootViewId : Int = 0

    private var activity : Activity = null

    private var currentMainViewId : Int = -1

    private var mainViewArray : Array[View] = ViewSwapper.NULL_VIEW_ARRAY

    private var topViewArray : Array[View] = ViewSwapper.NULL_VIEW_ARRAY

    //Constructor
    {
        val activity : Activity = param_activity
        val rootViewId : Int = param_rootViewId
        this.activity = activity
        this.rootViewId = rootViewId
    }

    def setMainViews(viewArray : Array[View]) : Unit = {
        this.mainViewArray = viewArray
    }

    /**      * @param topViewArray the topViewArray to set      */
    def setTopViewArray(topViewArray : Array[View]) : Unit = {
        this.topViewArray = topViewArray
    }

    def setMainView(id : Int) : Unit = {
        val viewGroup : ViewGroup = this.activity.findViewById(this.rootViewId).asInstanceOf[ViewGroup]
        if (id != this.currentMainViewId) {

            {
                var index : Int = 0
                while (index < this.topViewArray.length) {
                    viewGroup.removeView(this.topViewArray(index))
                    index += 1
                }
            }

            {
                var index : Int = 0
                while (index < this.mainViewArray.length) {
                    if (id != this.mainViewArray(index).getId()) {
                        viewGroup.removeView(this.mainViewArray(index))
                    }
                    index += 1
                }
            }

            {
                var index : Int = 0
                while (index < this.mainViewArray.length) {
                    if (id == this.mainViewArray(index).getId()) {
                        viewGroup.addView(this.mainViewArray(index))
                        this.currentMainViewId = id
                    }
                    index += 1
                }
            }

            {
                var index : Int = 0
                while (index < this.topViewArray.length) {
                    viewGroup.addView(this.topViewArray(index))
                    index += 1
                }
            }
        }
    }

}

object ViewSwapper {
    val NULL_VIEW_ARRAY : Array[View] = new Array[View](0)

}


