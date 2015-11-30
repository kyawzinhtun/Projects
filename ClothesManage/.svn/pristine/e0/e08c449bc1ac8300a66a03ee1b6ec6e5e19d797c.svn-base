package org.amaris.util;

import java.util.HashMap;

import org.amaris.presentation.mainForm.MainFrame;

public class Conversation {
	
	public static void addConversation(String key, Object value) {
		MainFrame.conversation.put(key, value);
	}
	
	public static Object getConversationValue(String key) {
		return MainFrame.conversation.get(key);
	}
	
	public static void endConversation(String key) {
		MainFrame.conversation.remove(key);
	}

}
