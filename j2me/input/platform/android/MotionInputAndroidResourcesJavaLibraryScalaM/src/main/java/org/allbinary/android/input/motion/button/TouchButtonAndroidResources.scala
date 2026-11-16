/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion.button

import _root_.org.allbinary.AndroidResources
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.init.Init
import _root_.org.allbinary.input.motion.button.CommonButtons
import _root_.org.allbinary.input.motion.button.TouchButtonBlankResource
import _root_.org.allbinary.input.motion.button.TouchButtonDownResource
import _root_.org.allbinary.input.motion.button.TouchButtonGenericActionResource
import _root_.org.allbinary.input.motion.button.TouchButtonResource
import _root_.org.allbinary.input.motion.button.TouchButtonStartResource
import _root_.org.allbinary.input.motion.button.TouchButtonStrafeLeftResource
import _root_.org.allbinary.input.motion.button.TouchButtonStrafeRightResource
import _root_.org.allbinary.input.motion.button.TouchButtonTurnLeftResource
import _root_.org.allbinary.input.motion.button.TouchButtonTurnRightResource
import _root_.org.allbinary.input.motion.button.TouchButtonUpResource
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory

class TouchButtonAndroidResources extends Init {

    override def init() : Unit = {
        val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
        val androidResources : AndroidResources = AndroidResources.getInstance()
        val RESOURCE_STRING_ARRAY : Array[TouchButtonResource] = Array[TouchButtonResource](TouchButtonBlankResource.getInstance(), TouchButtonGenericActionResource.getInstance(), TouchButtonStartResource.getInstance(), TouchButtonUpResource.getInstance(), TouchButtonDownResource.getInstance(), TouchButtonTurnLeftResource.getInstance(), TouchButtonTurnRightResource.getInstance(), TouchButtonStrafeLeftResource.getInstance(), TouchButtonStrafeRightResource.getInstance())
        val RESOURCE_ARRAY : Array[Int] = new Array[Int](RESOURCE_STRING_ARRAY.length)
        if (CommonButtons.getInstance().STANDARD_BUTTON_SIZE == 128) {
            RESOURCE_ARRAY(0) = androidResources.raw.touch_button_128_by_128
            RESOURCE_ARRAY(1) = androidResources.raw.touch_button_generic_action_128_by_128
            RESOURCE_ARRAY(2) = androidResources.raw.touch_button_start_128_by_128
            RESOURCE_ARRAY(3) = androidResources.raw.touch_button_up_arrow_128_by_128
            RESOURCE_ARRAY(4) = androidResources.raw.touch_button_down_arrow_128_by_128
            RESOURCE_ARRAY(5) = androidResources.raw.touch_button_turn_left_arrow_128_by_128
            RESOURCE_ARRAY(6) = androidResources.raw.touch_button_turn_right_arrow_128_by_128
            RESOURCE_ARRAY(7) = androidResources.raw.touch_button_strafe_left_arrow_128_by_128
            RESOURCE_ARRAY(8) = androidResources.raw.touch_button_strafe_right_arrow_128_by_128
            if (OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan()) {
                //final int[] HINT_RESOURCE_ARRAY = new int[RESOURCE_STRING_ARRAY.length];
                resourceUtil.addResource(RESOURCE_STRING_ARRAY(2).HINT, Integer.valueOf(androidResources.raw.ouya_o))
            }
        } else {
            RESOURCE_ARRAY(0) = androidResources.raw.touch_button_64_by_64
            RESOURCE_ARRAY(1) = androidResources.raw.touch_button_generic_action_64_by_64
            RESOURCE_ARRAY(2) = androidResources.raw.touch_button_start_64_by_64
            RESOURCE_ARRAY(3) = androidResources.raw.touch_button_up_arrow_64_by_64
            RESOURCE_ARRAY(4) = androidResources.raw.touch_button_down_arrow_64_by_64
            RESOURCE_ARRAY(5) = androidResources.raw.touch_button_turn_left_arrow_64_by_64
            RESOURCE_ARRAY(6) = androidResources.raw.touch_button_turn_right_arrow_64_by_64
            RESOURCE_ARRAY(7) = androidResources.raw.touch_button_strafe_left_arrow_64_by_64
            RESOURCE_ARRAY(8) = androidResources.raw.touch_button_strafe_right_arrow_64_by_64
        }

        {
            var index : Int = 0
            while (index < RESOURCE_ARRAY.length) {
                resourceUtil.addResource(RESOURCE_STRING_ARRAY(index).RESOURCE, Integer.valueOf(RESOURCE_ARRAY(index)))
                index += 1
            }
        }
    }

}


