/*  * To change this license header, choose License Headers in Project Properties.  * To change this template file, choose Tools | Templates  * and open the template in the editor.  */
/* Generated Code Do Not Modify */
package org.allbinary.game.multiplayer.layer

import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author user  */
class RemoteInfo(param_username : String, param_actorSessionId : Int, param_playerInputId : Int, param_id : Int) {
    import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo.{NEW_PLAYER_ID as _, REMOTE_INFO as _, *}
    def NEW_PLAYER_ID : Int = _root_.org.allbinary.game.multiplayer.layer.RemoteInfo.NEW_PLAYER_ID
    def REMOTE_INFO : RemoteInfo = _root_.org.allbinary.game.multiplayer.layer.RemoteInfo.REMOTE_INFO

    //Constructor
    {
        val username : String = param_username
        val actorSessionId : Int = param_actorSessionId
        val playerInputId : Int = param_playerInputId
        val id : Int = param_id
    }

}

object RemoteInfo {
    val NEW_PLAYER_ID : Int = 0

    val REMOTE_INFO : RemoteInfo = new RemoteInfo(StringUtil.getInstance().EMPTY_STRING, -1, -1, RemoteInfo.NEW_PLAYER_ID)

}


