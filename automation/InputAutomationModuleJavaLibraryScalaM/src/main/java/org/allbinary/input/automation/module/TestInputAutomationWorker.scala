/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.org.allbinary.input.media.image.capture.ScreenCaptureImagesWorker
import _root_.org.allbinary.media.image.comparison.ImageComparisonWorker
import _root_.org.allbinary.media.image.comparison.SaveImageComparisonWorker
import _root_.org.allbinary.media.image.comparison.motion.MotionRectanglesWorker
import _root_.org.allbinary.media.image.comparison.motion.SaveMotionRectanglesResultsWorker
import _root_.org.allbinary.media.image.comparison.motion.TestInputForMotionRectanglesResultsWorker

class TestInputAutomationWorker() {

    private var captureWorker : ScreenCaptureImagesWorker = null

    private var imageComparisonWorker : ImageComparisonWorker = null

    private var motionRectanglesWorker : MotionRectanglesWorker = null

    private var changedPixelsImageComparisonResultsWorker : SaveImageComparisonWorker = null

    private var saveMotionRectanglesAsImagesWorker : SaveMotionRectanglesResultsWorker = null

    private var moveMouseToFirstMotionRectanglesResultsWorker : TestInputForMotionRectanglesResultsWorker = null

    //Constructor
    {
        this.captureWorker = new ScreenCaptureImagesWorker()
        //this.motionRectanglesWorker = new MotionRectanglesWorker();
        this.changedPixelsImageComparisonResultsWorker = new SaveImageComparisonWorker()
        this.saveMotionRectanglesAsImagesWorker = new SaveMotionRectanglesResultsWorker()
        this.moveMouseToFirstMotionRectanglesResultsWorker = new TestInputForMotionRectanglesResultsWorker()
        this.motionRectanglesWorker.addListenerInterface(this.saveMotionRectanglesAsImagesWorker)
        this.motionRectanglesWorker.addListenerInterface(this.moveMouseToFirstMotionRectanglesResultsWorker)
        this.imageComparisonWorker.addListenerInterface(this.changedPixelsImageComparisonResultsWorker)
        this.imageComparisonWorker.addListenerInterface(this.motionRectanglesWorker)
        this.captureWorker.addListenerInterface(this.imageComparisonWorker)
    }

}


