package com.alibou.websocket.chat;

public enum MessageType {

    // MESSAGE TYPE FOR A REGULAR CHAT MESSAGE.
    CHAT,
    // MESSAGE WHEN FOR A USER JOINING THE CHAT ROOM.
    JOIN,
    // MESSAGE WHEN FOR A USER LEAVING THE CHAT ROOM.
    LEAVE
}