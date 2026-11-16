/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.modules.User
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

class NewUserFactory private() {
    import _root_.org.allbinary.business.user.NewUserFactory.{*}

}

object NewUserFactory {
    def getInstance() : UserInterface = {
        return new User()
    }

    //For adding new users use role property   
    def getInstance(transformInfoInterface : TransformInfoInterface) : UserInterface = {
        var httpTransformInfoInterface : TransformInfoHttpInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
        var httpServletRequest : HttpServletRequest = httpTransformInfoInterface.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        var hashMap : HashMap[Object, Object] = new RequestParams(httpServletRequest).toHashMap().asInstanceOf[HashMap[Object, Object]]
        var role : String = httpTransformInfoInterface.getPropertiesHashMap().get(UserRoleData.NAME.toString()).asInstanceOf[String]
        hashMap.put(UserRoleData.NAME.toString(), role)
        return CreateUserFactory.getInstance(hashMap)
    }

    //Process a new user request where role is a tag property
    def getInstance(httpServletRequest : HttpServletRequest, propertiesHashMap : HashMap[Object, Object]) : UserInterface = {
        if (propertiesHashMap != null) {
            var requestHashMap : HashMap[Object, Object] = new RequestParams(httpServletRequest).toHashMap().asInstanceOf[HashMap[Object, Object]]
            var roleString : String = propertiesHashMap.get(UserRoleData.NAME.toString()).asInstanceOf[String]
            requestHashMap.put(UserRoleData.NAME.toString(), roleString)
            return CreateUserFactory.getInstance(requestHashMap)
        } else {
            throw new Exception("Null HashMap")
        }
        throw new IllegalStateException()
    }

}


