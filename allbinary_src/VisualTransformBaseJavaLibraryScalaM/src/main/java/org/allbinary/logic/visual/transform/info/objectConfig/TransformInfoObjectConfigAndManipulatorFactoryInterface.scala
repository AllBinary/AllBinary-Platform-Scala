/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document

/**  *  * @author user  */
trait TransformInfoObjectConfigAndManipulatorFactoryInterface {

    def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, objectConfigFileAbPath : AbPath) : TransformInfoObjectConfigInterface

    def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) : TransformInfoObjectConfigInterface

    def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, document : Document) : TransformInfoObjectConfigInterface

}


