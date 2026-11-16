/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document

class OverrideStoreTransformInfoObjectConfig private (super_1 : AbeClientInformationInterface, super_2 : TransformInfoInterface, super_3 : String, super_4 : String, constructor_ : Unit) extends GenericStoreTransformInfoObjectConfig(super_1, super_2, super_3, super_4) {

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, name : String, `type` : String) = {
        this(abeClientInformation, transformInfoInterface, name, type, ())
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, document : Document) = {
        this(abeClientInformation, transformInfoInterface, document, null, ())
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) = {
        this(abeClientInformation, transformInfoInterface, null, null, ())
    }

    override def generate(objectConfigDocument : Document) : Document = {
        var newObjectConfigDocument : Document = super.generate(objectConfigDocument)
        return newObjectConfigDocument
    }

}


