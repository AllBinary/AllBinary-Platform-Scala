/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.logic.system.security.licensing.LockedUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class Advertisements {

    private val bannerList : BasicArrayList = new BasicArrayListD()

    private val pageList : BasicArrayList = new BasicArrayListD()

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    def addPage(advertisementProcessorInterface : AdvertisementProcessorInterface) : Unit = {
        if (!this.pageList.contains(advertisementProcessorInterface)) {
            this.pageList.add(advertisementProcessorInterface)
        }
    }

    def startRandomPage() : Unit = {
        var size : Int = this.pageList.size()
        if (size > 0) {
            var random : Int = this.myRandomFactory.getAbsoluteNextInt(size)
            var advertisementProcessorInterface : AdvertisementProcessorInterface = this.pageList.objectArray(random).asInstanceOf[AdvertisementProcessorInterface]
            advertisementProcessorInterface.start()
        }
    }

    def processRandomPage() : Unit = {
        if (LockedUtil.getInstance().isLocked()) {
            var size : Int = this.pageList.size()
            if (size > 0) {
                var random : Int = this.myRandomFactory.getAbsoluteNextInt(size)
                var advertisementProcessorInterface : AdvertisementProcessorInterface = this.pageList.objectArray(random).asInstanceOf[AdvertisementProcessorInterface]
                advertisementProcessorInterface.process()
            }
        }
    }

    def stopAllPage() : Unit = {

        {
            var index : Int = this.pageList.size()
            while ({ index -= 1; index } >= 0) {
                var advertisementProcessorInterface : AdvertisementProcessorInterface = this.pageList.objectArray(index).asInstanceOf[AdvertisementProcessorInterface]
                advertisementProcessorInterface.stop()
            }
        }
    }

    def addBanner(advertisementProcessorInterface : AdvertisementProcessorInterface) : Unit = {
        if (!this.bannerList.contains(advertisementProcessorInterface)) {
            this.bannerList.add(advertisementProcessorInterface)
        }
    }

    def startAll() : Unit = {

        {
            var index : Int = this.bannerList.size()
            while ({ index -= 1; index } >= 0) {
                var advertisementProcessorInterface : AdvertisementProcessorInterface = this.bannerList.objectArray(index).asInstanceOf[AdvertisementProcessorInterface]
                advertisementProcessorInterface.start()
            }
        }
    }

    def stopAllBanner() : Unit = {

        {
            var index : Int = this.bannerList.size()
            while ({ index -= 1; index } >= 0) {
                var advertisementProcessorInterface : AdvertisementProcessorInterface = this.bannerList.objectArray(index).asInstanceOf[AdvertisementProcessorInterface]
                advertisementProcessorInterface.stop()
            }
        }
    }

    def getBanner(index : Int) : AdvertisementProcessorInterface = {
        var advertisementProcessorInterface : AdvertisementProcessorInterface = this.bannerList.objectArray(index).asInstanceOf[AdvertisementProcessorInterface]
        return advertisementProcessorInterface
    }

    def stopAll() : Unit = {
        this.stopAllBanner()
        this.stopAllPage()
    }

}


