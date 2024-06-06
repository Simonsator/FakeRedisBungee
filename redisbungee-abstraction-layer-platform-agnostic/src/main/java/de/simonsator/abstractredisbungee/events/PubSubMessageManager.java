package de.simonsator.abstractredisbungee.events;

public class PubSubMessageManager extends GenericListenerManager<PubSubMessageListener> {
	private static PubSubMessageManager instance;

	public PubSubMessageManager() {
		instance = this;
	}

	public static PubSubMessageManager getInstance() {
		return instance;
	}

	public void registerPubSubMessageEvent(PubSubMessageListener pReceiver) {
		registerEventListener(pReceiver);
	}

	public void unregisterPubSubMessageEvent(PubSubMessageListener pReceiver) {
		unregisterEventListener(pReceiver);
	}

	public void invokePubSubMessageEvent(String pChannel, String message) {
		LISTENERS.forEach(listener -> listener.onMessageReceived(pChannel, message));
	}
}
