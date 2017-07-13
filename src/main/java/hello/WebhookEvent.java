package hello;

import java.io.Serializable;

public class WebhookEvent implements Serializable{
	private String webhookEvent;

	public String getWebhookEvent() {
		return webhookEvent;
	}

	public void setWebhookEvent(String webhookEvent) {
		this.webhookEvent = webhookEvent;
	}

	@Override
	public String toString() {
		return "WebhookEvent [webhookEvent=" + webhookEvent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((webhookEvent == null) ? 0 : webhookEvent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebhookEvent other = (WebhookEvent) obj;
		if (webhookEvent == null) {
			if (other.webhookEvent != null)
				return false;
		} else if (!webhookEvent.equals(other.webhookEvent))
			return false;
		return true;
	}
	
	
}
