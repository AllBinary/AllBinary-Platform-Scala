/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureChoiceGroups
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class OpenGLOptions {

    def init() : Unit = {
        var openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        if (Features.getInstance().isFeature(openGLFeatureFactory.OPENGL_OPTIONS)) {
            var openGLMultipleList : BasicArrayList = new BasicArrayListD()
            openGLMultipleList.add(openGLFeatureFactory.OPENGL)
            GameFeatureChoiceGroups.getMultipleInstance().add("OpenGL (Complete Restart)", openGLMultipleList)
            var openGLVersionSelectorMultipleList : BasicArrayList = new BasicArrayListD()
            openGLVersionSelectorMultipleList.add(openGLFeatureFactory.OPENGL_AUTO_SELECT)
            openGLVersionSelectorMultipleList.add(openGLFeatureFactory.OPENGL_MINIMUM)
            GameFeatureChoiceGroups.getExclusiveInstance().add("OpenGL Version Selector", openGLVersionSelectorMultipleList)
            /*              * BasicArrayList openGLTypeMultipleList = new BasicArrayListD();              *               * openGLTypeMultipleList.add(OpenGLFeature.OPENGL_AS_GAME_THREAD);              * openGLMultipleList              * .add(OpenGLFeature.OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS);              *               * GameFeatureChoiceGroups.getExclusiveInstance().add( "Type",              * openGLTypeMultipleList);              */
            var openGLImageColorMultipleList : BasicArrayList = new BasicArrayListD()
            openGLImageColorMultipleList.add(openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444)
            // openGLImageColorMultipleList.add(OpenGLFeature.IMAGE_COLOR_DEPTH_565);
            openGLImageColorMultipleList.add(openGLFeatureFactory.IMAGE_COLOR_DEPTH_8888)
            GameFeatureChoiceGroups.getExclusiveInstance().add("OpenGL Image Color RGBA", openGLImageColorMultipleList)
        }
    }

}


