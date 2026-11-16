/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.android

import _root_.android.os.Parcelable
import _root_.android.os.Parcel

/**  *  * @author User  */
class NullParcelable extends Parcelable {
    import _root_.org.allbinary.android.NullParcelable.{NULL_PARCELABLE as _, *}
    def NULL_PARCELABLE : NullParcelable = _root_.org.allbinary.android.NullParcelable.NULL_PARCELABLE

    override def describeContents() : Int = {
        throw new RuntimeException()
    }

    override def writeToParcel(dest : Parcel, flags : Int) : Unit = {
    }

}

object NullParcelable {
    val NULL_PARCELABLE : NullParcelable = new NullParcelable()

}


