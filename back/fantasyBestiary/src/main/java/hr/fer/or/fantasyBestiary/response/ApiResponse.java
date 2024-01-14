package hr.fer.or.fantasyBestiary.response;

import java.time.LocalDateTime;

public class ApiResponse<T> {
	private String status;
	private LocalDateTime timestamp;
	private Object monkeyContext;
	private T data;

	public ApiResponse(String status, T data, String contextId) {
		this.status = status;
		this.data = data;
		this.timestamp = LocalDateTime.now();

		if (contextId.equals("null")) {
			this.monkeyContext = "null";
		} else if(contextId.equals("treasure")){
			this.monkeyContext = new TreasureContext();
		} else {
			this.monkeyContext = new MonsterContext();
		}
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public T getData() {
		return data;
	}

	public Object getMonkeyContext() {
		return monkeyContext;
	}

	class MonsterContext {
		private String monkeyVocab;
		private String name;
		private String frequency;

		public MonsterContext() {
			this.monkeyVocab = "https://schema.org";
			this.name = "https://schema.org/name";
			this.frequency = "https://schema.org/frequency";
		}

		public String getName() {
			return name;
		}

		public String getMonkeyVocab() {
			return monkeyVocab;
		}

		public String getFrequency() {
			return frequency;
		}
	}

	class TreasureContext {
		private String monkeyVocab;
		private String name;

		public TreasureContext() {
			this.monkeyVocab = "https://schema.org";
			this.name = "https://schema.org/name";
		}

		public String getName() {
			return name;
		}

		public String getMonkeyVocab() {
			return monkeyVocab;
		}
	}
}
