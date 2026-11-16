/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.animation.image.LazyImageRotationAnimation
import _root_.org.allbinary.canvas.GameGlobalsFactory
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.game.canvas.ABToGBUtil
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.gd.resource.GDLazyResources
import _root_.org.allbinary.game.gd.resource.GDResources
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.system.Memory
import _root_.org.allbinary.thread.BaseImageLoadingProcessor
import _root_.org.allbinary.thread.ConcurrentImageLoadingProcessor
import _root_.org.allbinary.thread.SynchObject
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.ABSystemWrapper

class ImageCache() extends ImageCacheBase {
    import _root_.org.allbinary.image.ImageCache.{NULL_IMAGE_CACHE as _, *}
    def NULL_IMAGE_CACHE : ImageCache = _root_.org.allbinary.image.ImageCache.NULL_IMAGE_CACHE

    //private final ABSystemWrapper systemWrapper = ABSystemWrapper.getInstance();
    private val tsUtil : TsUtil = TsUtil.getInstance()

    private val concurrentImageLoadingProcessor : BaseImageLoadingProcessor = new ConcurrentImageLoadingProcessor(this)

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val resourceUtil : ResourceUtil = ResourceUtil.getInstance()

    private val gameGlobalsFactory : GameGlobalsFactory = GameGlobalsFactory.getInstance()

    private val gdResources : GDResources = GDResources.getInstance()

    val loadNowList : BasicArrayList = new BasicArrayListD()

    val loadSoonList : BasicArrayList = new BasicArrayListD()

    val loadList : BasicArrayList = new BasicArrayListD()

    //public final BasicArrayList loadImageAfterList = new BasicArrayListD();
    val loadAfterList : BasicArrayList = new BasicArrayListD()

    private val lock : SynchObject = new SynchObject()

    private var firstTime : Boolean = true

    private var totalLoaded : Int = 0

    var progressEnded_ImageCache : Boolean = false

    var hasAnyLazyAnimationFactories : Boolean = false

    private var processor : Processor = new FirstProcessor()

    private var endProcessor : Processor = Processor.getInstance()

    //private final String LOAD_IMAGE_FOR_ANIMATION = "loadImageForAnimation";
    private val LOAD_IMAGE_FOR_ANIMATION : String = "Load Image Animation"

    class NotHTMLProcessor extends Processor {

        override def process() : Unit = {
            concurrentImageLoadingProcessor.runTask()
        }

    }

    class NotHTMLEndProcessor extends Processor {

        override def process() : Unit = {
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            progressCanvas.endIfPaintedSinceStart()
        }

    }

    class HTMLEndProcessor extends Processor {

        override def process() : Unit = {
            val size : Int = gdResources.currentLayoutRequiredTotal

            //if(size != 0) this.logUtil.putF("totalLoaded: " + totalLoaded, this, this.commonStrings.RUN);
            if (size == 0) {
                //this.logUtil.putF(new StringMaker().append("end with totalLoaded loaded: ").append(totalLoaded).append(" i:").append(size).toString(), this, this.commonStrings.RUN);
                val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
                progressCanvas.endIfPaintedSinceStart()
            } else if (totalLoaded > (size / 12)) {
                //this.logUtil.putF(new StringMaker().append("end with totalLoaded loaded: ").append(totalLoaded).append(" i:").append(size).toString(), this, this.commonStrings.RUN);
                val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
                progressCanvas.endIfPaintedSinceStart()
                endProcessor = new NotHTMLEndProcessor()
            }
        }

    }

    class FirstProcessor extends Processor {

        override def process() : Unit = {
            ImageCache.this.firstProcess()
        }

    }

    def firstProcess() : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val isHTML : Boolean = J2MEUtil.isHTML()
        //logUtil.putF(new StringMaker().append("isHTML: ").append(isHTML).toString(), this, this.commonStrings.RUN);
        if (isHTML) {
            this.processor = Processor.getInstance()
            this.endProcessor = new HTMLEndProcessor()
        } else {
            //logUtil.putF("Setting processor", this, this.commonStrings.RUN);
            this.processor = new NotHTMLProcessor()
            this.endProcessor = new NotHTMLEndProcessor()
            try {
                this.runTask()
            } catch {
                case e : Exception => {
                    logUtil.putF(this.commonStrings.EXCEPTION, this, this.commonStrings.END_METHOD_NAME)
                }
            }
        }
    }

    //AllBinaryRendererBase3
    def addListener(renderer : Object) : Unit = {
    }

    def waitForLoadNow() : Unit = {
        if (this.firstTime) {
            //this.logUtil.putF(this.commonStrings.START, this, "waitForLoadNow");
            val abToGBUtil : ABToGBUtil = ABToGBUtil.getInstance()
            val abCanvas : AllBinaryGameCanvas = abToGBUtil.abCanvas.asInstanceOf[AllBinaryGameCanvas]

            {
                while ((this.loadNowList.isEmpty() && (!abCanvas.isInitialized() || (abCanvas.isInitialized() && this.hasAnyLazyAnimationFactories))) && !this.progressEnded_ImageCache) {
                    //this.logUtil.putF(new StringMaker().append("Still Empty: ").append(this.loadNowList.size()).append(" after: ").append(this.loadAfterList.size()).append(" all: ").append(this.loadList.size()).toString(), this, "waitForLoadNow");
                    Thread.sleep(120)
                }
            }
            this.firstTime = false
        }
    }

    def loadImageForAnimation() : Unit = {
        var lazyImageRotationAnimation : LazyImageRotationAnimation = null
        this.lock.synchronized {
            if (this.loadNowList.isEmpty()) {
                this.endProcessor.process()
                if (this.loadSoonList.isEmpty()) {
                    if (this.loadAfterList.isEmpty()) {
                        if (this.firstTime) {
                        } else if (this.gameGlobalsFactory.newCanvas) {
                        } else {
                            this.loadNextImage()
                        }
                        return
                    } else {
                        lazyImageRotationAnimation = this.loadAfterList.get(0).asInstanceOf[LazyImageRotationAnimation]
                        //this.logUtil.putF("loadAfterList: " + lazyImageRotationAnimation, this, this.commonStrings.RUN);
                        if (this.loadImageForLazyAnimation(lazyImageRotationAnimation)) {
                            //this.logUtil.putF("Loaded associated Animation for Game Layer that is painted", this, this.commonStrings.RUN);
                            this.loadAfterList.remove(lazyImageRotationAnimation)
                        }
                    }
                } else {
                    lazyImageRotationAnimation = this.loadSoonList.get(0).asInstanceOf[LazyImageRotationAnimation]
                    //this.logUtil.putF("loadSoonList: " + lazyImageRotationAnimation, this, this.commonStrings.RUN);
                    if (this.loadImageForLazyAnimation(lazyImageRotationAnimation)) {
                        //this.logUtil.putF("Loaded associated Animation for Game Layer that is painted", this, this.commonStrings.RUN);
                        this.loadSoonList.remove(lazyImageRotationAnimation)
                    }
                }
                return
            }
            lazyImageRotationAnimation = this.loadNowList.get(0).asInstanceOf[LazyImageRotationAnimation]
        }
        if (this.loadImageForLazyAnimation(lazyImageRotationAnimation)) {
            //this.logUtil.putF("loadNowList loaded: " + image.getName(), this, this.commonStrings.RUN);
            this.lock.synchronized {
                this.loadNowList.remove(lazyImageRotationAnimation)
            }
            if (lazyImageRotationAnimation.layoutIndex != 0) {
                val list : BasicArrayList = this.getAssociated(lazyImageRotationAnimation)
                //this.logUtil.putF("loadNowList list: " + list, this, this.commonStrings.RUN);
                this.lock.synchronized {
                    val size : Int = list.size()
                    if (size > 0) {
                        //this.logUtil.putF("addAssociated: " + size, this, this.commonStrings.RUN);
                        this.loadSoonList.addAllList(list)
                    }
                }
            }
            //this.logUtil.putF("should end progress? " + this.loadNowList.size(), this, this.commonStrings.RUN);
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            val isHTML : Boolean = J2MEUtil.isHTML()
            if (this.loadNowList.isEmpty() && (!isHTML || this.firstTime)) {
                //this.logUtil.putF("end progress", this, this.commonStrings.RUN);
                progressCanvas.endFromInitialLazyLoadingComplete()
            } else {
                if ((this.totalLoaded % 10) == 0) {
                    progressCanvas.addNormalPortion(1, this.LOAD_IMAGE_FOR_ANIMATION)
                }
            }
        }
    }

    //    }
    def loadImages() : Unit = {

        {
            while (!this.loadList.isEmpty() || !this.loadNowList.isEmpty()) {
                this.loadImageForAnimations()
                //this.logUtil.putF("load image", this, this.commonStrings.RUN);
                this.loadNextImage()
            }
        }
    }

    def loadImageForAnimations() : Unit = {

        {
            while (!this.loadNowList.isEmpty()) {
                //this.logUtil.putF("load lazy animation image", this, this.commonStrings.RUN);
                this.loadImageForAnimation()
            }
        }
    }

    def loadRemainingAnimations() : Unit = {
        //this.logUtil.putF("load remaining lazy animations", this, this.commonStrings.RUN);

        {
            while (!this.loadAfterList.isEmpty() || !this.loadNowList.isEmpty()) {

                {
                    while (!this.loadNowList.isEmpty()) {
                        //this.logUtil.putF("load lazy animation image", this, this.commonStrings.RUN);
                        this.loadImageForAnimation()
                    }
                }
                var lazyImageRotationAnimation : LazyImageRotationAnimation = null
                this.lock.synchronized {
                    if (!this.loadAfterList.isEmpty()) {
                        //this.loadImageAfterList.removeAt(0);
                        lazyImageRotationAnimation = this.loadAfterList.removeAt(0).asInstanceOf[LazyImageRotationAnimation]
                    }
                }
                if (lazyImageRotationAnimation != null) {
                    this.loadImageForLazyAnimation(lazyImageRotationAnimation)
                }
            }
        }
    }

    private def loadImageForLazyAnimation(lazyImageRotationAnimation : LazyImageRotationAnimation) : Boolean = {
        val image : Image = lazyImageRotationAnimation.animationInterfaceFactoryInterface.getImage()
        if (this.loadImage(image)) {
            //this.logUtil.putF(new StringMaker().append("processing loaded resource: ").append(lazyImageRotationAnimation).toString(), this, this.commonStrings.RUN);
            lazyImageRotationAnimation.setRealAnimation()
            return true
        }
        return false
    }

    private def loadNextImage() : Unit = {
        var image : Image = null
        this.lock.synchronized {
            if (this.loadList.size() == 0) {
                return
            }
            image = this.loadList.removeAt(0).asInstanceOf[Image]
        }
        this.loadImage(image)
    }

    private def loadImage(image : Image) : Boolean = {
        if (image.isReady()) {
            //this.logUtil.putF(new StringMaker().append("already loaded resource image: ").append(image.toString()).append(image.getName()).toString(), this, this.commonStrings.RUN);
            return true
        } else {
            if (image.getImage() != null) {
                //HTML only
                if (image.setReady()) {
                    if (image.isReady()) {
                        this.totalLoaded += 1
                        //this.logUtil.putF(new StringMaker().append("setReady resource HTML5 image: ").append(image.toString()).append(image.getName()).toString(), this, this.commonStrings.RUN);
                        return true
                    }
                }
            } else {
                //this.logUtil.putF(new StringMaker().append("attempt loading resource image: ").append(image).append(image.getName()).toString(), this, this.commonStrings.RUN);
                val key : String = image.getName()
                val image2 : Image = this.creatImage(key)
                if (image2.isReady()) {
                    //this.logUtil.putF(new StringMaker().append("setImage resource Now image: ").append(image.toString()).append(image.getName()).toString(), this, this.commonStrings.RUN);
                    this.init(image, image2)
                    return true
                } else {
                    //this.logUtil.putF(new StringMaker().append("setImage resource HTML5 image: ").append(image).append(image.getName()).toString(), this, this.commonStrings.RUN);
                    image.setImage(image2.getImage())
                }
            }
        }
        return false
    }

    def init(image : Image, image2 : Image) : Unit = {
        //this.logUtil.putF(new StringMaker().append("loading resource: ").append(image).append(image.getName()).append(commonSeps.SPACE).append(image.getWidth()).append(commonSeps.SPACE).append(image.getHeight()).toString(), this, this.commonStrings.RUN);
        image.init(image2.getImage())
    }

    def creatImage(key : String) : Image = {
        val inputStream : InputStream = this.resourceUtil.getResourceAsStream(key)
        val image : Image = ImageFactory.getInstance().createImageFromInputStream(inputStream)
        image.setName(key)
        return image
    }

    override def get(caller : String, width : Int, height : Int) : Image = {
        var foundIndex : Int = this.getIndexWH(width, height)
        var image : Image = this.getFromAvailable(foundIndex, width, height)
        if (image eq NullImage.NULL_IMAGE) {
            this.volume += width * height
            if (this.volume > 32000) {
                //this.logUtil.putF(new StringMaker().append("Image for: ").append(caller).toString(), this, this.commonStrings.GET);
                this.tsUtil.gc()
                //System.gc();
                this.volume = 0
            }
            image = this.createImage(caller, width, height)
            //this.logUtil.putF(new StringMaker().append("Image: ").append(image.getName()).toString(), this, this.commonStrings.GET);
            if (this.nextIndex > (this.widths.length - 1)) {
                if (foundIndex == -1) {
                    foundIndex = this.nextIndex
                    this.widths(this.nextIndex) = width
                    this.heights(this.nextIndex) = height
                    this.nextIndex += 1
                }
                this.listOfList(foundIndex).add(image)
            }
        }
        return image
    }

    override def getWithKey(key : Object) : Image = {
        var image : Image = this.getImage(key)
        if (image eq NullImage.NULL_IMAGE) {
            //final InputStream inputStream = resourceUtil.getResourceAsStream((String) key);
            val inputStream : InputStream = null
            //}
            try {
                //this.logUtil.putF(Memory.getInfo(), this, this.commonStrings.GET);
                image = this.createImageFromInputStream(key, inputStream)
            } catch {
                case e : Exception => {
                    this.logUtil.put("Exception: Trying Again After GC", this, this.commonStrings.GET, e)
                    this.logUtil.putF(new StringMaker().append("InputStream: ").append(StringUtil.getInstance().toString(inputStream)).toString(), this, this.commonStrings.GET)
                    this.tsUtil.gc()
                    this.tsUtil.gc()
                    this.logUtil.putF(Memory.getInfo(), this, this.commonStrings.GET)
                    Thread.sleep(100)
                    image = this.createImageFromInputStream(key, inputStream)
                }
            }
            //            }
            this.hashtable.put(key, image)
        }
        //        this.logUtil.putF(key + " = " + image.toString(), this, this.commonStrings.CONSTRUCTOR);
        return image
    }

    def getIndex(key : Object) : Int = {
        val gdResources : GDResources = GDResources.getInstance()
        val resourceStringArray : Array[String] = gdResources.resourceStringArray
        val size : Int = resourceStringArray.length

        {
            var index : Int = 0
            while (index < size) {
                if (resourceStringArray(index) eq key) {
                    return index
                }
                index += 1
            }
        }
        this.logUtil.putF(new StringMaker().append("unable to find key: ").append(StringUtil.getInstance().toString(key)).toString(), this, this.commonStrings.RUN)
        throw new RuntimeException()
    }

    override def createImageFromInputStream(key : Object, inputStream : InputStream) : Image = {
        val gdLazyResources : GDLazyResources = GDLazyResources.getInstance()
        var resourceStringArray : Array[String] = gdLazyResources.requiredResourcesBeforeLoadingArray
        val size : Int = resourceStringArray.length

        {
            var index : Int = 0
            while (index < size) {
                //if(((String) key).compareTo(resourceStringArray[index]) == 0) {
                if (key eq resourceStringArray(index)) {
                    //this.logUtil.putF(new StringMaker().append("create now: ").append(key).toString(), this, this.commonStrings.RUN);
                    return this.creatImage(key.asInstanceOf[String])
                }
                index += 1
            }
        }
        this.runTask()
        val index : Int = this.getIndex(key)
        val width : Int = gdLazyResources.imageResourceWidthArray(index)
        val height : Int = gdLazyResources.imageResourceHeightArray(index)
        val image : Image = this.createImageLater(key.asInstanceOf[String], width, height)
        this.lock.synchronized {
            //this.logUtil.putF(new StringMaker().append("add: ").append(image.getName()).append(index).toString(), this, this.commonStrings.RUN);
            this.loadList.add(image)
        }
        return image
    }

    def createImageLater(key : String, width : Int, height : Int) : Image = {
        return Image.createImageLater(key, width, height)
    }

    def getAssociated(lazyImageRotationAnimation : LazyImageRotationAnimation) : BasicArrayList = {
        val list : BasicArrayList = new BasicArrayListD()
        this.lock.synchronized {
            var lazyImageRotationAnimation2 : LazyImageRotationAnimation = null
            val size : Int = this.loadAfterList.size()

            {
                var index : Int = 0
                while (index < size) {
                    lazyImageRotationAnimation2 = this.loadAfterList.get(index).asInstanceOf[LazyImageRotationAnimation]
                    if (lazyImageRotationAnimation2.instanceId == lazyImageRotationAnimation.instanceId) {
                        list.add(lazyImageRotationAnimation2)
                    }
                    index += 1
                }
            }
            val size2 : Int = list.size()

            {
                var index : Int = 0
                while (index < size2) {
                    this.loadAfterList.remove(list.get(index))
                    index += 1
                }
            }
        }
        return list
    }

    def add(lazyImageRotationAnimation : LazyImageRotationAnimation) : Unit = {
        this.lock.synchronized {
            //this.loadImageAfterList.add(lazyImageRotationAnimation.animationInterfaceFactoryInterface.getImage());
            this.loadAfterList.add(lazyImageRotationAnimation)
        }
    }

    def insertFirst(lazyImageRotationAnimation : LazyImageRotationAnimation) : Unit = {
        //            } else {
        if (this.loadNowList.contains(lazyImageRotationAnimation)) {
        } else {
            //this.logUtil.putF(new StringMaker().append("loadNowList insert: ").append(image).append(image.getName()).toString(), this, this.commonStrings.RUN);
            this.lock.synchronized {
                this.loadNowList.add(lazyImageRotationAnimation)
                this.loadAfterList.remove(lazyImageRotationAnimation)
            }
        }
        this.runTask()
    }

    def progressEnded() : Unit = {
        this.progressEnded_ImageCache = true
    }

    def runTask() : Unit = {
        //this.logUtil.putF(this.commonStrings.START + this.processor, this, "runTask");
        this.processor.process()
    }

    override def initProgress() : Unit = {
        //this.logUtil.putF("reset totalFrames", this, this.commonStrings.RUN);
        if (this.firstTime) {
            this.firstTime = false
        }
    }

    def isLazy() : Boolean = {
        return true
    }

}

object ImageCache {
    val NULL_IMAGE_CACHE : ImageCache = new ImageCache()

}


