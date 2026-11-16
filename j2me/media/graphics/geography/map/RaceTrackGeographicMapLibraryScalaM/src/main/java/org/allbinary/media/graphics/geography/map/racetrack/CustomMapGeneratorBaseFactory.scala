/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack


/**  *  * @author User  */
class CustomMapGeneratorBaseFactory() {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.CustomMapGeneratorBaseFactory.{*}

    def create(raceTrackGeographicMap : RaceTrackGeographicMap) : CustomMapGeneratorBase = {
        return new CustomMapGeneratorBase()
    }

}

object CustomMapGeneratorBaseFactory {
    private val instance : CustomMapGeneratorBaseFactory = new CustomMapGeneratorBaseFactory()

    /**      * @return the instance      */
    def getInstance() : CustomMapGeneratorBaseFactory = {
        return CustomMapGeneratorBaseFactory.instance
    }

}


